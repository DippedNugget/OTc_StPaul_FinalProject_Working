-- everyone worked on

-- CREATE database IF NOT EXISTS otc_stpaul_blockbuster;

-- USE otc_stpaul_blockbuster;

DROP TABLE IF EXISTS transaction_concessions;
DROP TABLE IF EXISTS transaction_movies;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS user_validation;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS stores;
DROP TABLE IF EXISTS concessions;
DROP TABLE IF EXISTS movies;

CREATE TABLE movies(
	movie_id int NOT NULL auto_increment PRIMARY KEY,
	title varchar(60) NOT NULL,
	director varchar(60) NOT NULL,
	genre varchar(255) NOT NULL,
	rating varchar(30) NOT NULL,
	in_stock bool NOT NULL,
	store_location int NOT NULL
);

CREATE TABLE concessions(
	concessions_id int NOT NULL auto_increment PRIMARY KEY,
	full_name varchar(60) NOT NULL,
	price decimal(5, 2) NOT NULL,
	quantity int NOT NULL
);

CREATE TABLE stores(
	store_idPK int NOT NULL auto_increment PRIMARY KEY,
	address varchar(60) NOT NULL,
	phone varchar(14) NOT NULL
);

CREATE TABLE employees(
	employee_idPK int NOT NULL auto_increment PRIMARY KEY,
	first_name varchar(60) NOT NULL,
	last_name varchar(60) NOT NULL,
	address varchar(60) NOT NULL,
	phone varchar(14) NOT NULL DEFAULT 5559999999,
    store_idFK int NOT NULL,
    FOREIGN KEY (store_idFK) REFERENCES stores (store_idPK)
);

CREATE TABLE user_validation(
	validation_id int NOT NULL auto_increment PRIMARY KEY,
	emp_idFK int NOT NULL,
	emp_username varchar(60),
	emp_validator varchar(60),
	ENABLED smallint not null DEFAULT 1,
	FOREIGN KEY (emp_idFK) REFERENCES employees (employee_idPK)
);

CREATE TABLE user_roles(
	role_id int NOT NULL auto_increment PRIMARY KEY,
	emp_username varchar(60) NOT NULL,
	user_role enum('ADMIN', 'USER') NOT NULL
);

CREATE TABLE customers(
	customer_idPK int NOT NULL auto_increment PRIMARY KEY,
	first_name varchar(60) NOT NULL,
	last_name varchar(60) NOT NULL,
	address varchar(60),
	phone varchar(14),
	join_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE transactions(
	transaction_id int NOT NULL auto_increment PRIMARY KEY,
	customer_idFK int NOT NULL,
	store_idFK int NOT NULL,
	total decimal(5, 2) NOT NULL,
	FOREIGN KEY (customer_idFK) REFERENCES customers (customer_idPK) ON DELETE CASCADE,
	FOREIGN KEY (store_idFK) REFERENCES stores (store_idPK) ON DELETE CASCADE
);

CREATE TABLE transaction_movies(
	movie_idFK int NOT NULL,
    transaction_idFK int NOT NULL,
    FOREIGN KEY (movie_idFK) REFERENCES movies (movie_id) ON DELETE CASCADE,
    FOREIGN KEY (transaction_idFK) REFERENCES transactions (transaction_id) ON DELETE CASCADE
);

CREATE TABLE transaction_concessions(
	concessions_idFK int NOT NULL,
    transaction_idFK int NOT NULL,
    FOREIGN KEY (concessions_idFK) REFERENCES concessions (concessions_id) ON DELETE CASCADE,
    FOREIGN KEY (transaction_idFK) references transactions (transaction_id) ON DELETE CASCADE
);