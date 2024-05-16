-- populate data to work
CREATE SCHEMA IF NOT EXISTS mydb;
SET SCHEMA mydb;
CREATE TABLE users (id int NOT NULL AUTO_INCREMENT, name varchar(12), role varchar(10));
INSERT INTO users(name, role) VALUES ('Usr 1', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 2', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 3', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 4', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 5', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 6', 'ADMIN');