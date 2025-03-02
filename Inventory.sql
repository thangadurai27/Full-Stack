drop database InvantryDB;
create database InvantryDB;
use InvantryDB;

create table User(
id int primary key auto_increment,
name varchar(50) not null,
password varchar(50) not null,
mobileNumber varchar(15) not null,
role enum('Admin','Agent') not null);

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    minSellQuantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantityAvailable INT NOT NULL
);


create table Transaction(
transactionId int  primary key auto_increment,
userId int not null,
productId int not null,
productName varchar(100) not null,
transactionType ENUM ('Buy','SELL') not null,
quantity int not null,
cost decimal(10,2) not null,
totalcost decimal(10,2),
foreign key (userId) references user(id),
foreign key(productId) references product(productId));

INSERT INTO user (name, password, mobileNumber, role)
VALUES ('John Doe', 'securepassword', '1234567890', 'Admin');

INSERT INTO user (name, password, mobileNumber, role)
VALUES ('Jane Smith', 'anotherpassword', '0987654321', 'Agent');
-- Assuming that Product table has some products already added
-- Inserting sample data into Product table
INSERT INTO Product (productId, productName, minselQuantity, price, quantityAvailable)
VALUES (1, 'Laptop', 1, 500.00, 10),
       (2, 'Mouse', 5, 10.00, 100);

-- Inserting a transaction record
INSERT INTO Transaction (userId, productId, productName, transactionType, quantity, cost, totalcost)
VALUES (1, 1, 'Laptop', 'Buy', 2, 500.00, 1000.00),
       (2, 2, 'Mouse', 'SELL', 5, 10.00, 50.00);

-- Select to confirm data
SELECT * FROM Transaction;
select*from products;





