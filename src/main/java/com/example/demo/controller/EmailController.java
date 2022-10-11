package com.example.demo.controller;


import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Mail;
import com.example.demo.model.entity.Teacher;
import com.example.demo.service.mail.MailService;
import com.example.demo.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {
    @Autowired
    private MailService mailService;
    @Autowired
    private TeacherService teacherService;


    @PostMapping("/donghocphi")
    public ResponseEntity<Mail> fogotPass(){
//        Teacher teacher1 = teacherService.findByMail(teacher.getEmail());
        Mail mail = new Mail();
        mail.setMailFrom("phuonglf98@gmail.com");
        mail.setMailTo("maianhlf95@gmail.com");
        mail.setMailSubject("NHOM 1 Sje^u c4p' Vjp pr0 n0 1");
        mail.setMailContent(" Đóng học phí đeeee ");

        mailService.sendEmail(mail);
        return new ResponseEntity<>(mail, HttpStatus.OK);
    }
}
