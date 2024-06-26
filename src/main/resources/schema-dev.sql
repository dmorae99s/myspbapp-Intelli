-- populate data to work
CREATE SCHEMA IF NOT EXISTS mydb;
SET SCHEMA mydb;

CREATE TABLE users(user_id int NOT NULL AUTO_INCREMENT, name varchar(12), role varchar(10));
CREATE TABLE addresses(id int NOT NULL AUTO_INCREMENT, user_id int, street varchar(50), city varchar(15));
CREATE TABLE departments(id int NOT NULL AUTO_INCREMENT, department_name varchar(50), manager varchar(15));
CREATE TABLE employees(id int NOT NULL AUTO_INCREMENT, dep_id int, emp_name varchar(30), user_id int);

INSERT INTO users(name, role) VALUES ('Usr 1', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 2', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 3', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 4', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 5', 'USER');
INSERT INTO users(name, role) VALUES ('Usr 6', 'ADMIN');

INSERT INTO addresses(user_id, street, city) VALUES (1, 'First Av. usr1', 'LA');
INSERT INTO addresses(user_id, street, city) VALUES (1, 'Second Av. usr1', 'LA');
INSERT INTO addresses(user_id, street, city) VALUES (2, 'Street usr 2', 'ciudad 2');
INSERT INTO addresses(user_id, street, city) VALUES (3, '1st street usr 3', 'city00');
INSERT INTO addresses(user_id, street, city) VALUES (3, '2nd street usr 3', 'city01');
INSERT INTO addresses(user_id, street, city) VALUES (3, '3th street usr 3', 'city02');
INSERT INTO addresses(user_id, street, city) VALUES (6, 'one street usr 6', 'city03');

INSERT INTO departments(department_name, manager) VALUES('IT', 'IT mng');
INSERT INTO departments(department_name, manager) VALUES('depto2', 'dpto2 mng');
INSERT INTO departments(department_name, manager) VALUES('Accounting', 'Acc mng');
INSERT INTO departments(department_name, manager) VALUES('sales', 'sales mng1');
INSERT INTO departments(department_name, manager) VALUES('marketing', 'mark mng1');

INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(1, 'Emp1', 1);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(1, 'Emp2', 2);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(1, 'Emp3', 3);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(3, 'Emp4', 4);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(4, 'Emp5', 5);