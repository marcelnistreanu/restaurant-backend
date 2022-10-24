CREATE TABLE CUSTOMERS(
CUSTOMER_ID BIGINT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
LAST_NAME VARCHAR(255) NOT NULL,
PHONE VARCHAR(255) NOT NULL UNIQUE,
EMAIL VARCHAR(255) NOT NULL UNIQUE,
PRIMARY KEY (CUSTOMER_ID));

CREATE TABLE ADDRESSES(
CUSTOMER_ID BIGINT NOT NULL,
ADDRESS_LINE1 VARCHAR(255) NOT NULL,
ADDRESS_LINE2 VARCHAR(255),
ZIP_CODE VARCHAR(6) NOT NULL,
CITY VARCHAR(255) NOT NULL,
COUNTRY VARCHAR(255) NOT NULL,
PRIMARY KEY (CUSTOMER_ID),
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID));

CREATE TABLE WALLET(
WALLET_ID BIGINT NOT NULL,
CUSTOMER_ID BIGINT NOT NULL,
BALANCE DOUBLE NOT NULL,
PRIMARY KEY (WALLET_ID),
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID));

CREATE TABLE COUPONS(
COUPON_ID VARCHAR(50) NOT NULL,
CUSTOMER_ID BIGINT,
DISCOUNT INT NOT NULL,
DISCOUNT_TYPE VARCHAR(10)  NOT NULL,
ACTIVE TINYINT(1) DEFAULT 1,
PRIMARY KEY (COUPON_ID),
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID));
