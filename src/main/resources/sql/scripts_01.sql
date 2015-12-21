ALTER TABLE IF EXISTS Payments DROP CONSTRAINT IF EXISTS fk_CustomerPayment;
DROP TABLE IF EXISTS Customers CASCADE;
DROP TABLE IF EXISTS Payments CASCADE;


-- Business entities

CREATE TABLE IF NOT EXISTS Customers (
  id        SERIAL PRIMARY KEY CHECK (id >= 0),
  firstname VARCHAR(100),
  lastname  VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Payments (
  id          SERIAL PRIMARY KEY CHECK (id >= 0),
  amount      INT,
  customer_id INT,
  CONSTRAINT fk_customer_payment
  FOREIGN KEY (customer_id)
  REFERENCES Customers (id)
);

-- CREATE INDEX idx_customer_id ON Payments (customer_id);

-- Data

INSERT INTO Customers (firstname, lastname) VALUES ('Mark',    'Fisher');
INSERT INTO Customers (firstname, lastname) VALUES ('Bob',     'Finkelson');
INSERT INTO Customers (firstname, lastname) VALUES ('Abraham', 'Tony');
INSERT INTO Customers (firstname, lastname) VALUES ('Luca',    'Castelani');
INSERT INTO Customers (firstname, lastname) VALUES ('Fima',    'Aisberg');

INSERT INTO Payments (amount, customer_id) VALUES (5000,  1);
INSERT INTO Payments (amount, customer_id) VALUES (700,   2);
INSERT INTO Payments (amount, customer_id) VALUES (50,    3);
INSERT INTO Payments (amount, customer_id) VALUES (120,   4);
INSERT INTO Payments (amount, customer_id) VALUES (10000, 5);
INSERT INTO Payments (amount, customer_id) VALUES (777,   3);
INSERT INTO Payments (amount, customer_id) VALUES (10,    4);

-- INSERT INTO Payments (amount) VALUES (100); -- cus_id is [null]