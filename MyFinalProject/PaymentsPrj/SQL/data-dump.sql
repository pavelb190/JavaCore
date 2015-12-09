
USE DB_Payments;

INSERT INTO User_roles (role) VALUES ('Admin');
INSERT INTO User_roles (role) VALUES ('User');

INSERT INTO Users VALUES (123, 'Ivan', 'IVANOV', '111', 'ivan.ivanov@example.com', 2);
INSERT INTO Users VALUES (456, 'Alex', 'ALEXANDROV', '222', 'alex.alexov@example.com', 2);
INSERT INTO Users VALUES (789, 'Petr', 'PETROV', '333', 'petr.petrov@example.com', 2);
INSERT INTO Users VALUES (1, 'Sergey', 'SERGEEV', '123', 'sergey.sergeev@example.com', 1);
INSERT INTO Users VALUES (2, 'Anatoliy', 'ANATOLIEV', '456', 'anatoliy.anatoliev@example.com', 1);

INSERT INTO BankAccounts VALUES (123000001, 123, 1500, false);
INSERT INTO BankAccounts VALUES (456000002, 456, 2650, true);
INSERT INTO BankAccounts VALUES (789000003, 789, 0, true);

INSERT INTO CreditCards VALUES (1230000001, 123000001);
INSERT INTO CreditCards VALUES (1230000002, 123000001);
INSERT INTO CreditCards VALUES (1230000003, 123000001);
INSERT INTO CreditCards VALUES (4560000001, 456000002);
INSERT INTO CreditCards VALUES (7890000001, 789000003);