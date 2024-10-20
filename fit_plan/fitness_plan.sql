CREATE TABLE IF NOT EXISTS user (
user_id INT PRIMARY KEY AUTO_INCREMENT,
user_email VARCHAR(100) NOT NULL UNIQUE,
username VARCHAR(60) NOT NULL UNIQUE,
user_password VARCHAR(50) NOT NULL 
);

CREATE TABLE IF NOT EXISTS diet(
diet_id INT PRIMARY KEY AUTO_INCREMENT,
diet_name VARCHAR(50) NOT NULL,
diet_description TEXT NOT NULL,
allowed_food VARCHAR(200),
forbidden_food VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS user_account(
user_id INT UNIQUE NOT NULL,
gender VARCHAR(20) NOT NULL,
height DOUBLE NOT NULL,
weight DOUBLE NOT NULL,
diet_id INT,
FOREIGN KEY (user_id) REFERENCES user (user_id),
FOREIGN KEY (diet_id) REFERENCES diet (diet_id)
);


CREATE TABLE IF NOT EXISTS exercise(
exercise_id INT PRIMARY KEY AUTO_INCREMENT,
exercise_name VARCHAR(50) NOT NULL,
exercise_description TEXT,
muscle_category VARCHAR(100) NOT NULL,
media LONGBLOB,
sets VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS dish(
dish_id INT PRIMARY KEY AUTO_INCREMENT,
dish_name VARCHAR(80) NOT NULL,
calories DOUBLE NOT NULL,
nutrients VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS user_account_exercises(
user_id INT,
exercise_id INT,
CONSTRAINT user_account_exercise_pk PRIMARY KEY (user_id, exercise_id),
CONSTRAINT user_account_fk FOREIGN KEY (user_id) REFERENCES user_account(user_id),
CONSTRAINT exercise_fk FOREIGN KEY (exercise_id) REFERENCES exercise(exercise_id)
);

CREATE TABLE IF NOT EXISTS user_account_dishes(
user_id INT,
dish_id INT,
CONSTRAINT user_account_dishes_pk PRIMARY KEY(user_id, dish_id),
CONSTRAINT user_acc_fk FOREIGN KEY (user_id) REFERENCES user_account(user_id),
CONSTRAINT dish_fk FOREIGN KEY (dish_id) REFERENCES dish (dish_id)
);


drop table diet;
drop table user_account;
drop table user_account_dishes;
drop table user_account_exercises;
