-- Switch to the bankingdatabase
create database bank;
USE bank;

-- Create the customer table
CREATE TABLE IF NOT EXISTS customer 
(
    customer_id INT PRIMARY KEY AUTO_INCREMENT, -- Auto Increment for customer ID
    customer_name VARCHAR(30),
    age INT,
    dateofbirth DATE,
    aadharnumber BIGINT,
    nomineename VARCHAR(30)
);

-- Create the bank table
CREATE TABLE IF NOT EXISTS bank
(
    bank_id INT PRIMARY KEY AUTO_INCREMENT,
    bank_name VARCHAR(100) NOT NULL,
    bank_branch VARCHAR(100) NOT NULL
);

-- Create the account table
CREATE TABLE IF NOT EXISTS account
(
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    account_type VARCHAR(50) NOT NULL,
    balance DECIMAL(15,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

-- Create the savingsaccount table
CREATE TABLE IF NOT EXISTS savingsaccount
(
    account_id INT PRIMARY KEY,
    interest_rate DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- Create the currentaccount table
CREATE TABLE IF NOT EXISTS currentaccount
(
    account_id INT PRIMARY KEY,
    overdraft_limit DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- Create the transaction table
CREATE TABLE IF NOT EXISTS transaction
(
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    transaction_type VARCHAR(50) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);

-- Create the deposittransaction table
CREATE TABLE IF NOT EXISTS deposittransaction
(
    transaction_id INT PRIMARY KEY,
    deposit_method VARCHAR(50) NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES transaction(transaction_id)
);

-- Create the withdrawaltransaction table (corrected spelling)
CREATE TABLE IF NOT EXISTS withdrawaltransaction
(
    transaction_id INT PRIMARY KEY,
    withdrawal_method VARCHAR(50) NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES transaction(transaction_id)
);

-- Show all tables
SHOW TABLES;

-- Select all from account
SELECT * FROM customer;


