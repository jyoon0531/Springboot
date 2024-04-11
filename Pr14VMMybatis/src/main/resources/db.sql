USE mydb;

DESC PRODUCT;

CREATE TABLE PRODUCT(
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(255) NOT NULL,
                        price INT NOT NULL,
                        limit_date DATE DEFAULT (CURRENT_DATE)
);

INSERT INTO PRODUCT (name, price, limit_date) VALUES ('상추버거', 3000, '2024-04-08');
INSERT INTO PRODUCT (name, price, limit_date) VALUES ('치즈버거', 2000, '2024-04-30');
INSERT INTO PRODUCT (name, price, limit_date) VALUES ('베이컨버거', 1000, '2024-05-31');

SELECT * FROM PRODUCT;