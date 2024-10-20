INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp HTML', 'https://www.nibs.in/wp-content/uploads/2020/12/ss1.jpg', 'https://static.vecteezy.com/system/resources/previews/023/450/641/non_2x/education-line-icon-college-illustration-sign-study-symbol-university-logo-student-mark-vector.jpg');

INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2024-11-24T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2025-11-24T20:50:07.12345Z', 1 );
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2024-12-24T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2025-12-24T20:50:07.12345Z', 1 );

INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://www.nibs.in/wp-content/uploads/2020/12/ss1.jpg', 1, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Forum', 'Tire suas dúvidas', 2, 'https://www.nibs.in/wp-content/uploads/2020/12/ss1.jpg', 2, 1);
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas para a turma', 3, 'https://www.nibs.in/wp-content/uploads/2020/12/ss1.jpg', 0, 1);

INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capítulo 1', 'Neste capítulo vamos começar', 1, 'https://www.nibs.in/wp-content/uploads/2020/12/ss1.jpg', 1, null);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capítulo 2', 'Neste capítulo vamos continuar', 2, 'https://www.nibs.in/wp-content/uploads/2020/12/ss1.jpg', 1, 1);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capítulo 3', 'Neste capítulo vamos finalizar', 3, 'https://www.nibs.in/wp-content/uploads/2020/12/ss1.jpg', 1, 2);

INSERT INTO tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2024-11-24T10:50:07.12345Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2024-11-24T10:50:07.12345Z', null, true, false);

/*tb_lesson insere dado baseado na tb_section*/
INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 1 do capitulo 1', 1, 1);
/*tb_content insere dado baseado na tb_lesson ^ */
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (1,'Material de Apoio: abc', 'https://www.youtube.com/watch?v=TgfdjuEGY1Y');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 2 do capitulo 2', 2, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (2,'', 'https://www.youtube.com/watch?v=TgfdjuEGY1Y');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 3 do capitulo 3', 3, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (3,'Material de Apoio: abc', 'https://www.youtube.com/watch?v=TgfdjuEGY1Y');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Tarefa Capitulo 1', 4, 1);
INSERT INTO tb_task (id, description, question_Count, approval_Count, weight, dueDate) VALUES (4, 'Fazer um trabalho', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2024-12-24T20:50:07.12345Z');

/*o mesmo usuário terminou a lesson 1 e 2,
mas não a lesson 3 e a tarefa*/
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1);

INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Primeiro feedback de tarefa: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Segundo feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Terceiro feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', true, '/offers/1/resource/1/sections/1', 1);