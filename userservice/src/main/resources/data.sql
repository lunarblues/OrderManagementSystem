INSERT INTO Roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO Roles (id, name) VALUES (2, 'USER');

INSERT INTO Users (id, username, password, email, role_id)
VALUES (1, 'admin', '$2y$10$S8uWzpgvYlUULNuuWFvph.Pe/kRs7zwxd8cqa.LNtlcfxhguP9siW', 'ddads', 1);