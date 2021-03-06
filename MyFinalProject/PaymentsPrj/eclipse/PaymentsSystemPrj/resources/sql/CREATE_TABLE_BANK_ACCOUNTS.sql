
USE DB_Payments;

CREATE TABLE BankAccounts (
	id BIGINT NOT NULL PRIMARY KEY,
	user_id INT NOT NULL,
	balance NUMERIC(16,6) NOT NULL DEFAULT 0,
	is_available BOOLEAN NOT NULL DEFAULT true,
	FOREIGN KEY (user_id) REFERENCES Users(id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);