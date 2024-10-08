drop database if exists fbs;
create database fbs;
use fbs;

CREATE TABLE IF NOT EXISTS users (
users_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
role VARCHAR (50) NOT NULL,
phone_number VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS airlines (
airline_id INT PRIMARY KEY AUTO_INCREMENT,
airline_name VARCHAR(40) NOT NULL
);


CREATE TABLE IF NOT EXISTS airports (
airport_id INT PRIMARY KEY AUTO_INCREMENT,
airport_name VARCHAR(50) NOT NULL,
country VARCHAR(50) NOT NULL,
city VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS flight (
flight_id INT PRIMARY KEY AUTO_INCREMENT,
airline_id INT NOT NULL,
seat_class VARCHAR(30) NOT NULL,
departure_airport_id INT NOT NULL,
destination_airport_id INT NOT NULL,
time_start DATETIME NOT NULL,
time_end DATETIME NOT NULL,
FOREIGN KEY (airline_id) REFERENCES airlines(airline_id),
FOREIGN KEY (departure_airport_id) REFERENCES airports(airport_id),
FOREIGN KEY (destination_airport_id) REFERENCES airports(airport_id)
);

CREATE TABLE users_flight (
users_id INT,
flight_id INT,
CONSTRAINT users_flight_pk PRIMARY KEY (users_id, flight_id),
CONSTRAINT users_fk FOREIGN KEY (users_id) REFERENCES users(users_id),
CONSTRAINT flight_fk FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
);


SELECT * FROM airlines;
select * from airports;
select * from users;
select * from users_flight;


SELECT flight.flight_id, flight.airline_id,flight.seat_class,flight.departure_airport_id, flight.destination_airport_id,flight.time_start,flight.time_end,users.users_id, users.first_name,users.last_name FROM flight JOIN users_flight ON users_flight.flight_id = flight.flight_id JOIN users ON users_flight.users_id = users.users_id WHERE flight.flight_id = 74;

DELETE FROM flight users_flight WHERE flight_id = 74;

Insert into users(first_name,last_name,email,role,phone_number) values ("first","last","email","role","phone_number");
DROP TABLE flight;

drop table users_flight;

drop table users; 

DELETE FROM users;
Delete from flight;
Delete from users_flight;


Insert into airlines(airline_name) Values ("name");
insert into airports(airport_name, country,city) values ("name", "country","city");
INSERT INTO flight(airline_id, seat_class, departure_airport_id, destination_airport_id, time_start, time_end) VALUES(38,"Economy",1,2,'2023-10-20 3:00:00','2023-10-20 6:00:00');