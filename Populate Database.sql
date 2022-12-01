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

SELECT * FROM SHOWING;

INSERT INTO SEATS 
VALUES ('Pink Panther', 3, '2022-12-01', '1:15', 7, FALSE);

SELECT * FROM SEATS;