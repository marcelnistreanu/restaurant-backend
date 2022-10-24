CREATE TABLE DELIVERY_MEN(
DELIVERY_MAN_ID BIGINT NOT NULL AUTO_INCREMENT,
AVAILABILITY VARCHAR(20),
PHONE VARCHAR(50),
LAST_NAME VARCHAR(50),
NAME VARCHAR(50),
PRIMARY KEY (DELIVERY_MAN_ID)
);

CREATE TABLE ONLINE_ORDERS(
ORDER_ID BIGINT NOT NULL AUTO_INCREMENT,
CUSTOMER_ID BIGINT NOT NULL,
DELIVERY_STATUS VARCHAR(20) NOT NULL,
DELIVERY_MAN BIGINT NOT NULL,
ORDER_DATE TIMESTAMP NOT NULL,
PRIMARY KEY (ORDER_ID),
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID),
FOREIGN KEY(DELIVERY_MAN) REFERENCES DELIVERY_MEN(DELIVERY_MAN_ID));
