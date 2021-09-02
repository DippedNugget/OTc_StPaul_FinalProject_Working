INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Spider-Man 2", "Sam Raimi", "Comic Book", "PG-13", true, 01);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Back to the Future 3", "Robert Zemeckis", "Sci-Fi", "PG", true, 01);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Robinson Crusoe on Mars", "Byron Haskins", "Sci-Fi", "PG", true, 01);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Ghostbusters", "Ivan Reitman", "Comedy", "PG", true, 01);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Krampus", "Micheal Daugherty", "Christmas", "PG-13", true, 01);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Lawless", "John Hillcoat", "Drama", "R", true, 01);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Monty Python and the Holy Grail", "Terry Gilliam & Terry Jones", "Comedy", "PG", true, 02);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Pacific Rim", "Guillermo del Toro", "Sci-Fi", "PG-13", true, 02);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Lion King", "Roger Allers & Rob Minkoff", "Animation", "G", true, 02);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Mortdecai", "David Koepp", "Comedy", "R", true, 02);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Red Tails", "Anthony Hemingway", "History", "PG-13", true, 02);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Scott Pilgrim vs. the World", "Edgar Wright", "Comedy", "PG-13", true, 02);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Tombstone", "George P. Cosmatos & Kevin Jarre", "Western", "R", true, 03);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Gremlins", "Joe Dante", "Horror", "PG", true, 03);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("The Lego Movie", "Christopher Miller & Phil Lord", "Animation", "PG", true, 03);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("The Monster Squad", "Fred Dekker", "Comedy", "PG-13", true, 03);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("Killer Klowns from Outer Space", "Stephen Chiodo", "Horror", "PG-13", true, 03);
INSERT INTO movies (title, director, genre, rating, in_stock, store_location) VALUES ("The Mask", "Chuck Russell", "Comedy", "PG-13", true, 03);

-- concessions
INSERT INTO concessions (full_name, price, quantity) VALUES ("REESES PIECES", 3.99, 12);
INSERT INTO concessions (full_name, price, quantity) VALUES ("JUNIOR MINTS", 4.89, 12);
INSERT INTO concessions (full_name, price, quantity) VALUES ("HOT TAMALES", 3.99, 12);
INSERT INTO concessions (full_name, price, quantity) VALUES ("Jiffy Pop Butter Popcorn", 3.64, 6);
INSERT INTO concessions (full_name, price, quantity) VALUES ("Twizzlers", 1.99, 18);
INSERT INTO concessions (full_name, price, quantity) VALUES ("Snow Caps", 2.99, 12);

-- stores
INSERT INTO stores (address, phone) VALUES ("123 North South Street", "555-880-1587"); 
INSERT INTO stores (address, phone) VALUES ("123 South West Street", "555-880-1568"); 
INSERT INTO stores (address, phone) VALUES ("123 East South Street", "555-880-1794"); 

-- employees
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Adam", "Fite", "123 Madison Street", "417-555-8891", 03);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Charlee", "Thao", "123 Madison Street", "417-555-8891", 02);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Andrew", "Cham", "123 Madison Street", "417-555-8891", 01);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Tony", "Stark", "2008 Malibu Rd", "417-555-7910", 03);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Frank", "Castle", "1989 Winchester Ln", "417-555-5710", 02);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Jean", "Grey", "2000 Marvel Rd", "417-555-8891", 01);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Jessica", "Jone", "2015 Investigation St", "417-791-4845", 03);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Ellie", "Sattler", "1995 Jurassic Parkway", "417-555-9306", 02);
INSERT INTO employees (first_name, last_name, address, phone, store_idFK) VALUES ("Wednesday", "Addams", "1938 New Yorker Place", "417-555-1991", 01);

-- user_validation
INSERT INTO user_validation (emp_idFK, emp_username, emp_validator) VALUES (01, "OSPBAF", "12345");
INSERT INTO user_validation (emp_idFK, emp_username, emp_validator) VALUES (02, "OSPBCT", "67890");
INSERT INTO user_validation (emp_idFK, emp_username, emp_validator) VALUES (03, "OSPBAC", "13579");

-- user_roles
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (01, "OSPBAF", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (02, "OSPBAF", "ADMIN");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (03, "OSPBCT", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (04, "OSPBCT", "ADMIN");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (05, "OSPBAC", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (06, "OSPBAC", "ADMIN");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (07, "OSPBTS", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (08, "OSPBFC", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (09, "OSPBJG", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (10, "OSPBJJ", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (11, "OSPBES", "USER");
INSERT INTO user_roles (role_id, emp_username, user_role) VALUES (12, "OSPBWA", "USER");

-- customers
INSERT INTO customers (first_name, last_name, address, phone) VALUES ("George", "Washington", "01 Virigina Street", "555-234-6897");
INSERT INTO customers (first_name, last_name, address, phone) VALUES ("Martha", "Washington", "01 Virigina Street", "555-234-6897");
INSERT INTO customers (first_name, last_name, address, phone) VALUES ("John", "Adams", "02 Massachusetts Street", "555-845-6487");
INSERT INTO customers (first_name, last_name, address, phone) VALUES ("Abigail", "Adams", "02 Massachusetts Street", "555-845-6487");
INSERT INTO customers (first_name, last_name, address, phone) VALUES ("Thomas", "Jefferson", "03 Virigina Street", "555-234-1478");
INSERT INTO customers (first_name, last_name, address, phone) VALUES ("Martha Wayles Skelton", "Jefferson", "03 Virigina Street", "555-234-1478");
