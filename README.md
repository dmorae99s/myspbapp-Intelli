Implemented method to get all at: http://localhost:8080/users/all
Method to get one (available users 1 to 6): http://localhost:8080/users/1 
Post and put implemented (I need finish those, something still missing but not sure what)
Delete need to be implemented
Exception management is in todo list as well as the swager
------------------------------------------------------------------------------
Implemented in EmployeeService
Map<Name. EmployeeResponse>
http://localhost:8080/employeesmap 

All implemented in mathservice
Factorial:
http://localhost:8080/factorial/{num} 

Count letters
http://localhost:8080/letters/{str} I.e. http://localhost:8080/letters/AAbBBBBz 

Fibonacci (Pending implementation)
http://localhost:8080/fibonacci/{num}

-------------------
MYSQL commands in prod profile

CREATE SCHEMA IF NOT EXISTS mydb;
use mydb;

CREATE TABLE users(user_id int AUTO_INCREMENT PRIMARY KEY, name varchar(12), role varchar(10));
CREATE TABLE addresses(id int AUTO_INCREMENT PRIMARY KEY, user_id int, street varchar(50), city varchar(15));
CREATE TABLE departments(id int AUTO_INCREMENT PRIMARY KEY, department_name varchar(50), manager varchar(15));
CREATE TABLE employees(id int AUTO_INCREMENT PRIMARY KEY, dep_id int, emp_name varchar(30), user_id int);

INSERT INTO users(name, role) VALUES ('MySQL Usr 1', 'USER');
INSERT INTO users(name, role) VALUES ('MySQL Usr 2', 'USER');
INSERT INTO users(name, role) VALUES ('MySQL Usr 3', 'USER');
INSERT INTO users(name, role) VALUES ('MySQL Usr 4', 'USER');
INSERT INTO users(name, role) VALUES ('MySQL Usr 5', 'USER');
INSERT INTO users(name, role) VALUES ('MySQL Usr 6', 'ADMIN');

INSERT INTO addresses(user_id, street, city) VALUES (1, 'First,MYSQL usr1', 'LA');
INSERT INTO addresses(user_id, street, city) VALUES (1, 'Second,MYSQL usr1', 'LA');
INSERT INTO addresses(user_id, street, city) VALUES (2, 'Street,MYSQL usr 2', 'ciudad 2');
INSERT INTO addresses(user_id, street, city) VALUES (3, '1st street,MYSQL 3', 'city00');
INSERT INTO addresses(user_id, street, city) VALUES (3, '2nd street,MYSQL 3', 'city01');
INSERT INTO addresses(user_id, street, city) VALUES (3, '3th street,MYSQL 3', 'city02');
INSERT INTO addresses(user_id, street, city) VALUES (6, 'one street,MYSQL 6', 'city03');

INSERT INTO departments(department_name, manager) VALUES('IT MYSQL', 'IT mng');
INSERT INTO departments(department_name, manager) VALUES('depto2MYSQL', 'dpto2 mng');
INSERT INTO departments(department_name, manager) VALUES('AccountingMYSQL', 'Acc mng');
INSERT INTO departments(department_name, manager) VALUES('salesMYSQL', 'sales mng1');
INSERT INTO departments(department_name, manager) VALUES('marketingMYSQL', 'mark mng1');

INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(1, 'Emp1MYSQL', 1);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(1, 'Emp2MYSQL', 2);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(1, 'Emp3MYSQL', 3);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(3, 'Emp4MYSQL', 4);
INSERT INTO  employees(dep_id, emp_name, user_id) VALUES(4, 'Emp5MYSQL', 5);

CREATE USER 'test'@'localhost' IDENTIFIED BY 'password';
GRANT ALL  PRIVILEGES ON *.* TO 'test'@'localhost' WITH GRANT OPTION;

--------------------------------

CREATE SCHEMA IF NOT EXISTS hrdb;
SET SCHEMA hrdb;

CREATE TABLE hr_payments(id int AUTO_INCREMENT PRIMARY KEY, emp_id int, concept varchar(30), amount int, transaction_date date);

INSERT into hr_payments(emp_id, concept, amount, transaction_date) values(1, 'PayMYSQL emp 1 - 31-12-22', 10, '2022-12-31');
INSERT into hr_payments(emp_id, concept, amount, transaction_date) values(1, 'PayMYSQL emp 1 - 15-02-23', 22, '2023-02-15');
INSERT into hr_payments(emp_id, concept, amount, transaction_date) values(1, 'PayMYSQL emp 1 - 22-11-23', 21, '2023-11-22');
INSERT into hr_payments(emp_id, concept, amount, transaction_date) values(2, 'PayMYSQL emp 2 - 01-02-22', 33, '2022-02-01');
INSERT into hr_payments(emp_id, concept, amount, transaction_date) values(2, 'PayMYSQL emp 2 - 03-03-22', 42, '2022-03-03');
INSERT into hr_payments(emp_id, concept, amount, transaction_date) values(3, 'PayMYSQL emp 3 - 07-12-22', 4, '2022-12-07');
INSERT into hr_payments(emp_id, concept, amount, transaction_date) values(4, 'PayMYSQL emp 4 - 04-12-20', 5, '2020-12-04');

CREATE USER 'test'@'localhost' IDENTIFIED BY 'password';
GRANT ALL  PRIVILEGES ON *.* TO 'test'@'localhost' WITH GRANT OPTION;
