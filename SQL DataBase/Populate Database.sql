INSERT INTO MOVIE
VALUES 	(120, 'Black Panther', '2022-11-10'), 
		(90, 'Finding Nemo', '2003-03-02'),
        (152, 'Violent Night', '2022-12-02'),
        (102, 'Puss in Boots', '2022-12-22');
        
INSERT INTO ADDRESS
VALUES	(24, 'University Dr.', 'Calgary', 'Canada', 'T2N4V4'), 
		(684, 'Collegiate Blvd.', 'Calgary', 'Canada', 'T6H7U5'),
        (10, '10 Street', 'Calgary', 'Canada', 'T1G9N0'),
        (90, 'Pink Panther Blvd.', 'Calgary', 'Canada', 'P2P2P2');

INSERT INTO LOCATION 
VALUES	('Pink Panther', 90, 'Pink Panther Blvd.'),
		('Golden Jubilee', 684, 'Collegiate Blvd.');

SELECT * FROM MOVIE;
SELECT * FROM ADDRESS;
SELECT * FROM LOCATION;
        
INSERT INTO SHOWING 
VALUES 	('Black Panther', '2022-12-01', '1:15', 3, 'Pink Panther');

INSERT INTO SHOWING 
VALUES 	('Black Panther', '2022-12-03', '1:15', 3, 'Pink Panther');

INSERT INTO SHOWING 
VALUES 	('Black Panther', '2022-12-05', '1:15', 3, 'Pink Panther');

INSERT INTO SHOWING 
VALUES 	('Black Panther', '2022-12-05', '7:15', 8, 'Golden Jubilee');

INSERT INTO SHOWING 
VALUES 	('Black Panther', '2022-12-07', '7:15', 8, 'Golden Jubilee');

INSERT INTO SHOWING 
VALUES 	('Black Panther', '2022-12-08', '7:15', 8, 'Golden Jubilee');

INSERT INTO SHOWING 
VALUES 	('Finding Nemo', '2022-12-05', '8:30', 1, 'Pink Panther'),
    ('Puss in Boots', '2022-12-06', '11:00', 5, 'Golden Jubilee'),
    ('Violent Night', '2022-12-23', '6:00', 2, 'Golden Jubilee'),
    ('Finding Nemo', '2022-12-05', '8:30', 1, 'Golden Jubilee'),
    ('Puss in Boots', '2022-12-08', '11:00', 5, 'Pink Panther'),
    ('Violent Night', '2022-12-25', '6:00', 2, 'Golden Jubilee'), 
    ('Finding Nemo', '2022-12-09', '8:30', 1, 'Pink Panther'),
    ('Puss in Boots', '2022-12-08', '11:00', 5, 'Golden Jubilee'),
    ('Violent Night', '2022-12-24', '6:00', 2, 'Pink Panther');

SELECT * FROM SHOWING;

INSERT INTO SEATS (email, theaterName, roomNum, d, t, seatNum) VALUES 	
		('tina@gmail.com', 'Pink Panther', 3, '2022-12-01', '1:15', 1),
		('maitry@gmail.com', 'Pink Panther', 3, '2022-12-01', '1:15', 2),
		('ana@gmail.com', 'Pink Panther', 3, '2022-12-01', '1:15', 3);
        
INSERT INTO CARD (email, expiry, num, cv, holderName)
VALUES ('tina@gmail.com', '2023-05-01', 1234567891234567, 123, 'tina'), 
('maitry@gmail.com', '2023-06-01', 1234567891234569, 123, 'maitry'), 
('ana@gmail.com', '2023-07-01', 1234567891234568, 123, 'ana');

INSERT INTO ADDRESS(num, streetName, city, country, postalCode)
VALUES (5, 'School DR', 'Calgary', 'Canada', 'T2N4V4'),
(6, 'School DR', 'Calgary', 'Canada', 'T2N4V6'),
(7, 'School DR', 'Calgary', 'Canada', 'T2N4V5');


INSERT INTO REGISTERED_USER (email, pass, buildNum, streetName, signupdate, cardNumber, cvv)
VALUES ('tina@gmail.com', 'password', 5, 'School DR', '2021-12-05', 1234567891234567, 123), 
('maitry@gmail.com', 'password', 6, 'School DR', '2021-12-05', 1234567891234569, 123), 
('ana@gmail.com', 'password', 7, 'School DR', '2021-12-05', 1234567891234568, 123);

INSERT INTO LOGIN
VALUES ('tina@gmail.com', 'password'),
		('maitry@gmail.com', 'password'),
        ('ana@gmail.com', 'password');

SELECT * FROM SEATS;

SELECT * FROM LOGIN;
-- SELECT * FROM REGISTERED_USER;
-- SELECT * FROM ADDRESS;
-- SELECT * FROM CARD;
-- SELECT * FROM SEATS;
-- SELECT * FROM SHOWING;