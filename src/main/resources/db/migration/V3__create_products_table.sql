CREATE TABLE products (
                          id UUID PRIMARY KEY,
                          code VARCHAR(50) NOT NULL UNIQUE,
                          name VARCHAR(100) NOT NULL,
                          description VARCHAR(255),
                          minimum_income NUMERIC(15,2),
                          active BOOLEAN NOT NULL
);