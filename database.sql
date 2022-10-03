

-- #student
INSERT INTO demo.student (account, active, address, birth, email, first_name, image, last_name, password, phone,
                          app_role_id)
VALUES ('hoangha', 'Đang học', 'alo12', '2022-10-05', 'hoanglf98@gmail.com', 'Alo', '123', 'So', '123', '0328885555',
        1);

INSERT INTO demo.student (account, active, address, birth, email, first_name, image, last_name, password, phone,
                          app_role_id)
VALUES ('hoang', 'Đang học', 'alo12', '2022-10-18', 'hoanlf98@gmail.com', 'Blo', '34', 'DO', '123', '0321111111', 2);

INSERT INTO demo.student (account, active, address, birth, email, first_name, image, last_name, password, phone,
                          app_role_id)
VALUES ('ha', 'Đang học', 'alo12', '2022-10-02', 'hanglf98@gmail.com', 'Clo', '534', 'TO', '123', '0328444666', 1);


-- #app_role
INSERT INTO demo.app_role (name)
VALUES ('ROLE_ADMIN');

INSERT INTO demo.app_role (name)
VALUES ('ROLE_USER');

-- #teacher
INSERT INTO demo.teacher (account, active, address, birth, email, first_name, image, last_name, password, phone,
                          app_role_id)
VALUES ('gv1', 'Đang lên lớp', 'ád', '2022-10-03', 'gv1@gmail.com', 'lo', '', 'xo', '123', '0322322332', 1);

INSERT INTO demo.teacher (account, active, address, birth, email, first_name, image, last_name, password, phone,
                          app_role_id)
VALUES ('gv2', 'Nghỉ ốm', 'ád', '2022-10-14', 'gv2@gmail.com', 'xo', '', 'lo', '123', '0312221112', 1);

-- #playment
INSERT INTO demo.payment (amount, payment_date, status, class_id)
VALUES (200, '2022-10-02', 'Đã đóng', 2);

INSERT INTO demo.payment (amount, payment_date, status, class_id)
VALUES (300, '2022-10-03', 'Đã đóng', 1);

INSERT INTO demo.payment (amount, payment_date, status, class_id)
VALUES (400, '2022-10-03', 'Đã đóng', 3);

-- #courser
INSERT INTO demo.course (id, description, lessons, price, term, category_id, student_id)
VALUES (null, 'aloo', 1, 200, 'qưe', 1, 1);

INSERT INTO demo.course (id, description, lessons, price, term, category_id, student_id)
VALUES (null, 'blo', 2, 300, 'qưe', 2, 2);

INSERT INTO demo.course (id, description, lessons, price, term, category_id, student_id)
VALUES (null, 'clo', 3, 400, null, 3, 3);


-- # category
INSERT INTO demo.category (id, name_category)
VALUES (1, 'category1');

INSERT INTO demo.category (id, name_category)
VALUES (2, 'cate2');

INSERT INTO demo.category (id, name_category)
VALUES (3, 'cate3');

