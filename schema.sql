/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  peani371
 * Created: 6/08/2018
 */

CREATE TABLE Product (
    PID varchar(20),
    Pname varchar(50) not null,
    Description varchar(150),
    Category varchar(50) not null,
    Price decimal(7,2) not null,
    Quantity integer not null,
    constraint Product_PK primary key (PID)
);

/*
CREATE SEQUENCE Customer_ID_Seq;
CustomerID bigint default Customer_ID_Seq.nextval,
*/

CREATE TABLE Customer (
    CustomerID bigint auto_increment(1300),
    Username varchar(25) not null unique,
    Password varchar(25) not null,
    Firstname varchar(20) not null,
    Surname varchar(20) not null,
    Address varchar(100) not null,
    Email varchar(50) not null unique,
    CreditCard varchar(40) not null,
    constraint Customer_PK primary key (CustomerID)
);

INSERT INTO CUSTOMER (username, password, firstname, surname, address, email, 
creditcard) VALUES ('nik','guest','Nikolah','Pearce',
'7A Grange Street, Dunedin Central','nikolahp13@gmail.com',
'1234-5678-1234-1234 09/21 344');

INSERT INTO CUSTOMER (username, password, firstname, surname, address, email, 
creditcard) VALUES ('billy','guest','Billy','Weeks',
'7A Grange Street, Dunedin Central','billy.weeks@gmail.com',
'1234-5678-999-1234 09/XX 994');

{"customerID":3,"username":"testDB","password":"dummy","firstName":"Test","surname":"McTested","address":"1 Test st, Dunedin.l","email":"test.test@gmail.com","creditCard":"1234-5678-999-1234 09/XX 994"}

CREATE SEQUENCE SaleID_Seq
    start with 400
    increment by 2
    maxvalue 8999;

CREATE TABLE Sale (
    SaleID bigint default SaleID_Seq.nextval,
    SaleDate Date not null,
    Status varchar(25),
    CustomerID bigint not null,
    constraint Sale_PK primary key (SaleID),
    constraint customer_sale_FK foreign key references customer(CustomerID)
);

CREATE SEQUENCE SaleItemID_Seq
    start with 9000
    increment by 5
    maxvalue 999999;

CREATE TABLE SaleTtem (
    Quantity integer not null,
    Price decimal(7,2) not null,
    ProductID varchar(20),
    SaleID bigint not null,
    constraint Saleitem_PK primary key (SaleID, ProductID),
    constraint SaleID_FK foreign key references sale(saleid),
    constraint ProductID_FK foreign key references product(pid)
);


