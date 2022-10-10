package com.example.demo.controller;


import com.example.demo.model.entity.Teacher;
import com.example.demo.service.account.AccountService;
import com.example.demo.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.CacheControl;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ServletContext servletContext;

//    @Value("${upload.path}")
//    private String upload_file_avatar;

    @Autowired
    TeacherService teacherService;

    @Autowired
    AccountService accountService;

//    @GetMapping
//    public ResponseEntity<Iterable<Teacher>> findAllTeacher(){
//        List<Teacher> teachers = (List<Teacher>)teacherService.findAll();
//        if (teachers.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(teachers,HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<Iterable<Teacher>> findAllTeacher(@RequestParam Optional<String> search, Pageable pageable) {
        Page<Teacher> teachers = teacherService.findAll(pageable);
        if (teachers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (search.isPresent()) {
            return new ResponseEntity<>(teacherService.findAllByFirstNameContaining(search.get(), pageable), HttpStatus.OK);
        }
        return new ResponseEntity<>(teachers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable Long id){
        Optional<Teacher> teachers =teacherService.findById(id);
        return teachers.map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Optional<Teacher> teachers = teacherService.findById(id);
        if (!teachers.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacher.setId(teachers.get().getId());
        return new ResponseEntity<>(teacherService.save(teacher),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Teacher> deleteStudent(@PathVariable Long id){
        Optional<Teacher> teachers = teacherService.findById(id);
        if (!teachers.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacherService.remove(id);
        return new ResponseEntity<>(teachers.get(),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllTeacher() {
        ModelAndView modelAndView = new ModelAndView("/ajaxTeacher");
        modelAndView.addObject("teachers", teacherService.findAll());
        return modelAndView;
    }


    //// Upload file

//    @PostMapping("/create")
//    public ResponseEntity<Teacher> addTeacher(@ModelAttribute("teacher") Teacher player, @ModelAttribute("avaFile") MultipartFile avaFile) {
//        String path = servletContext.getRealPath("/");
//        System.out.println("path: "+ path);
//        if (avaFile != null) {
//            String avaFileName = avaFile.getOriginalFilename();
//            try {
//                FileCopyUtils.copy(avaFile.getBytes(), new File(upload_file_avatar + avaFileName));
//                player.setImage("/image/" + avaFileName);
//            } catch (IOException ex) {
//                player.setImage("image/Error");
//                System.out.println("Loi khi upload File");
//                ex.printStackTrace();
//            }
//        }
//        teacherService.save(player);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

//    @RequestMapping(value = "/image/{path}", method = RequestMethod.GET)
//    public ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable String path) throws IOException {
//        HttpHeaders headers = new HttpHeaders();
//        InputStream in = servletContext.getResourceAsStream(upload_file_avatar + path);
//        byte[] media = IOUtils.toByteArray(in);
//        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
//        return responseEntity;
//    }
}
