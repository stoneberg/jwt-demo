INSERT INTO rt_roles (name) VALUES ('ROLE_USER');
INSERT INTO rt_roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO rt_users (username, password, email) VALUES ('alex', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', 'alex@gomail.com');
INSERT INTO rt_users (username, password, email) VALUES ('john', '$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea', 'john@gomail.com');
INSERT INTO rt_users (username, password, email) VALUES ('admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', 'admin@gomail.com');

INSERT INTO rt_user_roles (user_id, role_id) VALUES (1, 1); -- user alex has role USER
INSERT INTO rt_user_roles (user_id, role_id) VALUES (2, 1); -- user john has role USER
INSERT INTO rt_user_roles (user_id, role_id) VALUES (3, 3); -- user admin has role ADMIN