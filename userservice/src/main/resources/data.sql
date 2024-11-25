INSERT INTO Roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO Roles (id, name) VALUES (2, 'USER');
INSERT INTO Roles (id, name) VALUES (3, 'MANAGER');

INSERT INTO Users (id, username, password, email, role_id)
VALUES (5, 'admini', '$2y$10$S8uWzpgvYlUULNuuWFvph.Pe/kRs7zwxd8cqa.LNtlcfxhguP9siW', 'gsula19@freeuni.edu.ge', 1);

INSERT INTO Users (id, username, password, email, role_id)
VALUES (1, 'sulaka', '$2y$10$S8uWzpgvYlUULNuuWFvph.Pe/kRs7zwxd8cqa.LNtlcfxhguP9siW', 'giorgisulakvelidze22@gmail.com', 3);
-- If you want to get the mails you can adjust these queries to your mail.
