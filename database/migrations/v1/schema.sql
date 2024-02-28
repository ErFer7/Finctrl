-- Create a new database called 'DatabaseName'
CREATE TABLE TransactionType (
    Id INTEGER PRIMARY KEY,
    `Type` VARCHAR(255) NOT NULL
);

CREATE TABLE `Transaction` (
    Id INTEGER PRIMARY KEY,
    TypeId INT NOT NULL,
    `Date` DATE NOT NULL,
    `Description` VARCHAR(255),
    Amount INT NOT NULL,
    Installments INT,
    FOREIGN KEY (TypeId) REFERENCES TransactionType(Id)
);

CREATE TABLE Bank (
    Id INTEGER PRIMARY KEY,
    `Name` VARCHAR(255) NOT NULL
);

CREATE TABLE Account (
    Id INTEGER PRIMARY KEY,
    BankId INT NOT NULL,
    Amount INT NOT NULL,
    FOREIGN KEY (BankId) REFERENCES Bank(Id)
);
