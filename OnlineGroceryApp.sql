CREATE DATABASE OnlineGroceryApp;

USE OnlineGroceryApp;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE vendor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_name VARCHAR(100) NOT NULL UNIQUE,
    contact_email VARCHAR(100),
    contact_phone VARCHAR(20),
    address VARCHAR(255)
    -- Add other columns for vendor details as needed
);

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE
    -- Add other columns for category details as needed
);

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category_id INT,
    price DECIMAL(10, 2),
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
    -- Add other columns for product details as needed
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    total_amount DECIMAL(10, 2),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
    -- Add other columns for order details as needed
);

CREATE TABLE communications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT
);

CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    product_id INT,
    rating INT,
    comment TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
    -- Add other columns for review details as needed
);

ALTER TABLE users
ADD COLUMN historical_total_spent DECIMAL(10, 2),
ADD COLUMN wallet_amount DECIMAL(10, 2);

CREATE TABLE wallet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    purchase_amount DECIMAL(10, 2),
    discount_fraction DECIMAL(5, 4)
);


ALTER TABLE orders
ADD COLUMN product_id INT,
ADD CONSTRAINT fk_product_id
    FOREIGN KEY (product_id)
    REFERENCES products(id);

ALTER TABLE products
ADD COLUMN image VARCHAR(255); -- Adjust the VARCHAR length as needed

ALTER TABLE communications
ADD COLUMN user_id INT,
ADD CONSTRAINT fk_user_communication FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE users
DROP COLUMN password;

DROP TABLE vendor;

CREATE TABLE members (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);









