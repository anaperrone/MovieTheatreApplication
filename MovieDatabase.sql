DROP DATABASE IF EXISTS `MovieDatabase`;
CREATE DATABASE `MovieDatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `MovieDatabase`;

DROP TABLE IF EXISTS ADDRESS;
CREATE TABLE ADDRESS
(
    num			INT,
    streetName	VARCHAR(25),
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
    buildNum 	INT,
    streetName 	VARCHAR(25),

    PRIMARY KEY (theaterName),
    FOREIGN KEY (buildNum, streetName) REFERENCES ADDRESS(num, streetName)
);

DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE
(
	duration 		INT, 
    title			VARCHAR(100),
    releaseDate		DATE,
    
    PRIMARY KEY (title)
);

DROP TABLE IF EXISTS SHOWING;
CREATE TABLE SHOWING 
(
	title 		VARCHAR(100),
    movDate 	DATE,
    movTime 	TIME,
    roomNum		INT,
    loc			VARCHAR(100),
    
    PRIMARY KEY (loc, roomNum, movDate, movTime),
    FOREIGN KEY (title) REFERENCES MOVIE(title),
    FOREIGN KEY (loc) REFERENCES LOCATION(theaterName)
);

DROP TABLE IF EXISTS SEATS;
CREATE TABLE SEATS
(
    theaterName 	VARCHAR(100),
    roomNum			INT,
    d				DATE,
    t				TIME,
    seatNum			INT,
    available 		BOOLEAN,	
    
    FOREIGN KEY (theaterName, roomNum, d, t) REFERENCES SHOWING(loc, roomNum, movDate, movTime)
);

DROP TABLE IF EXISTS LOGIN;
CREATE TABLE LOGIN 
(
	username 	VARCHAR(50),
    pass		VARCHAR(25),
    
    FOREIGN KEY (username) REFERENCES REGISTERED_USER(email)
);
