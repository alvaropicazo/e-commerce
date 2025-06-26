CREATE DATABASE orders;
CREATE DATABASE products;
CREATE DATABASE users;

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Create the 'orders' table
CREATE TABLE orders (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_id UUID NOT NULL,
    quantity INTEGER NOT NULL,
    status VARCHAR(50) NOT NULL,
    user_id UUID NOT NULL
);

-- Create the 'products' table
CREATE TABLE products (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_name VARCHAR(100) NOT NULL,
    description TEXT,
    stock INTEGER NOT NULL,
    price DOUBLE PRECISION NOT NULL
);

-- Create the 'users' table
CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
);
