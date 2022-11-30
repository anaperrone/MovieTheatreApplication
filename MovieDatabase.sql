DROP DATABASE IF EXISTS `MovieDatabase`;
CREATE DATABASE `MovieDatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `MovieDatabase`;

DROP TABLE IF EXISTS SEATS;
CREATE TABLE SEATS
(
    rowNum 		CHAR,
    seatNum		INT,
    available 	BOOLEAN,
    
    PRIMARY KEY (rowNum, seatNum)
);

DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE
(
	duration 		INT, 
    title			VARCHAR(100),
    releaseDate		DATE,
    
    PRIMARY KEY (title)
);

DROP TABLE IF EXISTS ADDRESS;
CREATE TABLE ADDRESS
(
    streetName	VARCHAR(25),
    num			INT,
    city 		VARCHAR(25),
    country		VARCHAR(25),
    postalCode	VARCHAR(6),
    
    PRIMARY KEY(num, streetName)
);

DROP TABLE IF EXISTS ORDINARY_USER;
CREATE TABLE ORDINARY_USER 
(
	email 		VARCHAR(50),
    
    PRIMARY KEY (email)
);

DROP TABLE IF EXISTS REGISTERED_USER;
CREATE TABLE REGISTERED_USER
(
	email		VARCHAR(50),
    buildNum 	INT,
    streetName	VARCHAR(25),
    
    FOREIGN KEY (email)	REFERENCES ORDINARY_USER(email),
    FOREIGN KEY (buildNum, streetName) REFERENCES ADDRESS(num, streetName)
);

DROP TABLE IF EXISTS CARD;
CREATE TABLE CARD
(
	email 		VARCHAR(50),
    expiry 		DATE,
    num			VARCHAR(16),
    cv			INT,
    holderName	VARCHAR(25),
    
    FOREIGN KEY (email) REFERENCES ORDINARY_USER (email)
);

DROP TABLE IF EXISTS LOCATION;
CREATE TABLE LOCATION 
(
	theaterName	VARCHAR(100),
    streetName 	VARCHAR(25),
    buildNum 	INT,
    
    PRIMARY KEY (theaterName),
    FOREIGN KEY (buildNum, streetName) REFERENCES ADDRESS(num, streetName)
);

DROP TABLE IF EXISTS SHOWING;
CREATE TABLE SHOWING 
(
	movDate 	DATE,
    movTime 	TIME,
    title 		VARCHAR(100),
    loc			VARCHAR(100),
    
    FOREIGN KEY (title) REFERENCES MOVIE(title),
    FOREIGN KEY (loc) REFERENCES LOCATION(theaterName)
);

DROP TABLE IF EXISTS LOGIN;
CREATE TABLE LOGIN 
(
	username 	VARCHAR(50),
    pass		VARCHAR(25),
    
    FOREIGN KEY (username) REFERENCES REGISTERED_USER(email)
);
