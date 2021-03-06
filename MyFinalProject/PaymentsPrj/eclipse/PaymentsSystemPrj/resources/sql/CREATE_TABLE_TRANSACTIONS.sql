
USE DB_Payments;

CREATE TABLE Transactions (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	account_id BIGINT NOT NULL,
	money_amount NUMERIC(9,6) NOT NULL DEFAULT 0,
	is_payment BOOLEAN NOT NULL DEFAULT false,
	description VARCHAR(125),
	committed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (account_id) REFERENCES BankAccounts(id)
		ON UPDATE CASCADE ON DELETE CASCADE
);