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

CREATE SEQUENCE Customer_ID_Seq;

CREATE TABLE Customer (
    CustomerID bigint default Customer_ID_Seq.nextval,
    Username varchar(25),
    Password varchar(25) not null,
    Firstname varchar(20) not null,
    Surname varchar(20) not null,
    Address varchar(100) not null,
    Email varchar(50) not null unique,
    CreditCard varchar(40) not null
    constraint Customer_PK primary key (username)
);

