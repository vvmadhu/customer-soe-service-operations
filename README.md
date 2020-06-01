# customer-soe-service-operations:- #
The POC code is to showcase the CRUD operations on MySQL Server.

The sample URIs for the CRUD operation are,

create table customer (customerId varchar(10) not null primary key, customerName varchar(50), customerNumber varchar(10), customerEmail varchar(30), customerAddress varchar(200));

create table product (productId varchar(10) not null primary key, productName varchar(30), productSKU varchar(15), productCategoty varchar(20), customerId varchar(10), FOREIGN KEY (customerId) REFERENCES customer(customerId) ON DELETE CASCADE);

