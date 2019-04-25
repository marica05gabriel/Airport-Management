DROP TABLE Cupoane;
DROP TABLE Zboruri;
DROP TABLE Bilete;
DROP TABLE Clienti;


CREATE TABLE Clienti 
(
idclient 	SMALLINT  	NOT NULL,

nume 		VARCHAR(40) 	 NOT NULL,

statut 		VARCHAR(3) 	 NOT NULL 
);

ALTER TABLE Clienti ADD CONSTRAINT Clienti_idclient_pk 	PRIMARY KEY(idclient);

ALTER TABLE Clienti ADD CONSTRAINT lienti_statut_ck 	
CHECK (statut = 'VIP' OR statut = 'C') ;

-- BEGIN 
INSERT INTO Clienti	VALUES (1, 'ION'	, 'VIP'	); 

INSERT INTO Clienti	VALUES (2, 'Popescu Paul', 'C'	); 

INSERT INTO Clienti	VALUES (3, 'Mihai'	, 'VIP'	); 

INSERT INTO Clienti	VALUES (4, 'ION'	, 'C'	); 

INSERT INTO Clienti	VALUES (5, 'Andrei'	, 'VIP'	); 

INSERT INTO Clienti	VALUES (6, 'Florin'	, 'VIP'	); 

INSERT INTO Clienti	VALUES (7, 'Florina'	, 'C'	); 

INSERT INTO Clienti	VALUES (8, 'Maria'	, 'C'	); 

INSERT INTO Clienti	VALUES (9, 'Ioana'	, 'C'	); 

INSERT INTO Clienti	VALUES (10, 'Cristina'	, 'VIP'	);  


-- END; 



-- INSERT INTO Clienti (idclient, nume, statut)	VALUES (11, '', 'VIP'); 



-- INSERT INTO Clienti (idclient, nume, statut)	VALUES (11, 'Ana', 'ASA'); 



CREATE TABLE Bilete (
nrbilet 	SMALLINT  	NOT NULL,
clasa 		VARCHAR(8) 	NOT NULL,
valoare 	DECIMAL(6,2)  	NOT NULL,
sursa		VARCHAR(30) 	NOT NULL,
destinatia	VARCHAR(30) 	NOT NULL,
idclient	SMALLINT 	NOT NULL
); 

ALTER TABLE Bilete ADD CONSTRAINT Bilete_nrbilet_pk 	PRIMARY KEY(nrbilet);
ALTER TABLE Bilete ADD CONSTRAINT Bilete_idclient_fk  	FOREIGN KEY (idclient) 
			REFERENCES Clienti( idclient ) ;
-- ON DELETE CASCADE ;

ALTER TABLE Bilete ADD CONSTRAINT Bilete_clasa_ck 	
			CHECK ( clasa = 'Economic' OR clasa = 'Business' );
ALTER TABLE Bilete ADD CONSTRAINT Bilete_sursa_destinatia_ck CHECK (sursa != destinatia);

-- BEGIN
INSERT INTO Bilete	(nrbilet, clasa, valoare, sursa, destinatia, idclient) 
			VALUES (123,  'Economic'	, 490	, 'Cluj-Napoca'	, 'Madrid' , 1); 
INSERT INTO Bilete	VALUES (2,  'Business'	, 700	, 'Cluj-Napoca'	, 'Madrid'	, 2); 
INSERT INTO Bilete	VALUES (3,  'Economic'	, 420	, 'Cluj-Napoca'	, 'Madrid'	, 3); 
INSERT INTO Bilete	VALUES (4,  'Economic'	, 320	, 'Cluj-Napoca'	, 'Roma'	, 4); 
INSERT INTO Bilete	VALUES (5,  'Economic'	, 350	, 'Cluj-Napoca'	, 'Roma'	, 5); 
INSERT INTO Bilete	VALUES (6,  'Business'	, 650	, 'Cluj-Napoca'	, 'Madrid'	, 6); 
INSERT INTO Bilete	VALUES (7,  'Business'	, 799	, 'Cluj-Napoca'	, 'Roma'	, 7); 
INSERT INTO Bilete	VALUES (8,  'Economic'	, 200	, 'Madrid'	, 'Bucuresti'	, 1); 
INSERT INTO Bilete	VALUES (9,  'Business'	, 550	, 'Madrid'	, 'Bucuresti'	, 2); 
INSERT INTO Bilete	VALUES (10, 'Business'	, 450	, 'Madrid'	, 'Bucuresti'	, 3); 
INSERT INTO Bilete	VALUES (11, 'Business'	, 320	, 'Barcelona'	, 'Bucuresti'	, 6); 
INSERT INTO Bilete	VALUES (12, 'Economic'	, 490	, 'Bucuresti'	, 'Barcelona'	, 7); 
INSERT INTO Bilete	VALUES (13, 'Economic'	, 390	, 'Bucuresti'	, 'Barcelona'	, 8); 
INSERT INTO Bilete	VALUES (14, 'Economic'	, 399.99, 'Bucuresti'	, 'Barcelona'	, 9); 
INSERT INTO Bilete	VALUES (15, 'Business'	, 700	, 'Bucuresti'	, 'Barcelona'	, 10); 
INSERT INTO Bilete	VALUES (16, 'Business'	, 599.99, 'Bucuresti'	, 'Barcelona'	, 1); 
INSERT INTO Bilete	VALUES (17, 'Economic'	, 150	, 'Oradea'	, 'Madrid'	, 3); 
INSERT INTO Bilete	VALUES (18, 'Business'	, 450	, 'Oradea'	, 'Madrid'	, 6); 
INSERT INTO Bilete	VALUES (19, 'Business'	, 550	, 'Oradea'	, 'Madrid'	, 8); 
INSERT INTO Bilete	VALUES (20, 'Business'	, 550	, 'Oradea'	, 'Madrid'	, 9); 
INSERT INTO Bilete	VALUES (21, 'Business'	, 550	, 'Oradea'	, 'Madrid'	, 10); 
-- END;

-- INSERT INTO Bilete	VALUES (20,  'Business'	, 120	, 'Cluj-Napoca'	, 'Cluj-Napoca'	, 2); 



CREATE TABLE Zboruri (
linie_zbor	VARCHAR(3) 		NOT NULL,
ruta_zbor	SMALLINT   		NOT NULL,
de_la		VARCHAR(30) 		NOT NULL,
la		VARCHAR(30) 		NOT NULL,
aparat_zbor	VARCHAR(30) 	 	NOT NULL,
nr_locuri	SMALLINT   		NOT NULL,
plecare		DATETIME 		NOT NULL,
sosire		DATETIME 		NOT NULL ,
				CONSTRAINT Zboruri_nrzbor_pk 		PRIMARY KEY(linie_zbor, ruta_zbor),
				CONSTRAINT Zboruri_ruta_zbor_uq 	UNIQUE(ruta_zbor),
				CONSTRAINT Zboruri_ruta_zbor_ck 	CHECK (ruta_zbor >=100 AND ruta_zbor <=999),
				CONSTRAINT Zboruri_plecare_sosire_ck 	CHECK (plecare < sosire)
);

-- BEGIN
INSERT INTO Zboruri (linie_zbor, ruta_zbor, de_la, la, aparat_zbor, nr_locuri, plecare, sosire)
			VALUES ('ABC',  123, 'Cluj-Napoca'	, 'Bucuresti'	, 'TAROM 310-326'	,100, CONVERT('2018-01-03 14:00:00',DATETIME), CONVERT( '2018-01-03 16:00:00',DATETIME)); 
INSERT INTO Zboruri 	VALUES ('abc',  223, 'Bucuresti'	, 'Milan'	, 'WIZZAIR 310-327'	,120, CONVERT('2018-01-07 17:00:00',DATETIME), CONVERT( '2018-01-07 20:00:00',DATETIME)); 
INSERT INTO Zboruri 	VALUES ('abc',  323, 'Milan'		, 'Madrid'	, 'WIZZAIR 310-327'	,120, CONVERT('2018-01-15 17:00:00',DATETIME), CONVERT( '2018-01-15 20:00:00',DATETIME)); 

INSERT INTO Zboruri 	VALUES ('AIF',  215, 'A'	, 'B'	, 'AIRBUS 310-326'	,	100, CONVERT( '2018-09-15 10:45:00', DATETIME), CONVERT( '2018-09-15 13:05:00', DATETIME)); 

INSERT INTO Zboruri 	VALUES ('ABD',  124, 'Cluj-Napoca'	, 'Budapesta'	, 'TAROM 310-328'	,50,  CONVERT( '2018-02-03 10:00:00', DATETIME), CONVERT( '2018-02-03 12:00:00', DATETIME)); 
INSERT INTO Zboruri 	VALUES ('ABD',  224, 'Budapesta'	, 'Roma'	, 'Ryanair 310-326'	,70,  CONVERT( '2018-02-03 15:00:00', DATETIME), CONVERT( '2018-02-03 18:00:00', DATETIME)); 

INSERT INTO Zboruri 	VALUES ('AAC',  423, 'Madrid'		, 'Bucuresti'	, 'WIZZAIR 310-321'	,200, CONVERT( '2018-02-03 15:00:00', DATETIME), CONVERT( '2018-02-03 18:00:00', DATETIME)); 
INSERT INTO Zboruri 	VALUES ('aab',  443, 'Barcelona'	, 'Bucuresti'	, 'WIZZAIR 310-322'	,150, CONVERT( '2018-03-03 18:00:00', DATETIME), CONVERT( '2018-03-03 21:00:00', DATETIME)); 
INSERT INTO Zboruri 	VALUES ('abb',  523, 'Bucuresti'	, 'Barcelona'	, 'WIZZAIR 310-323'	,20,  CONVERT( '2018-03-03 14:00:00', DATETIME), CONVERT( '2018-03-03 21:30:00', DATETIME)); 
INSERT INTO Zboruri 	VALUES ('acc',  623, 'Oradea'		, 'Madrid'	, 'WIZZAIR 310-324'	,50,  CONVERT( '2018-12-03 15:00:00', DATETIME), CONVERT( '2018-12-03 22:30:00', DATETIME)); 
-- END;

UPDATE 	Zboruri 
SET 	linie_zbor = UPPER(linie_zbor); 

ALTER TABLE Zboruri
MODIFY linie_zbor  VARCHAR(6); 

UPDATE Zboruri
SET linie_zbor = CONCAT(linie_zbor, ruta_zbor); 

ALTER TABLE Zboruri
DROP PRIMARY KEY  ; 
 
ALTER TABLE Zboruri
DROP COLUMN ruta_zbor; 

ALTER TABLE Zboruri
CHANGE COLUMN linie_zbor nrzbor VARCHAR(6); 

ALTER TABLE Zboruri
ADD CONSTRAINT Zboruri_nrzbor_pk PRIMARY KEY(nrzbor); 


ALTER TABLE Zboruri

ADD CONSTRAINT bilete_nrzbor_ck CHECK (
	(SUBSTRING(nrzbor,1,1)>='A' 
AND 	SUBSTRING(nrzbor,1,1)<='Z')
AND	(SUBSTRING(nrzbor,2,1)>='A' 
AND 	SUBSTRING(nrzbor,2,1)<='Z')

AND	(SUBSTRING(nrzbor,3,1)>='A' 
AND 	SUBSTRING(nrzbor,3,1)<='Z')
AND	(SUBSTRING(nrzbor,4,1)>='0' 
AND 	SUBSTRING(nrzbor,4,1)<='9')

AND	(SUBSTRING(nrzbor,5,1)>='0' 
AND 	SUBSTRING(nrzbor,5,1)<='9')
AND	(SUBSTRING(nrzbor,6,1)>='0' 
AND 	SUBSTRING(nrzbor,6,1)<='9')); 



CREATE TABLE Cupoane(
nrbilet 	SMALLINT  	,
nrzbor 		VARCHAR(6)  	NOT NULL,
clasa		VARCHAR(8)  	NOT NULL,
loc		SMALLINT  	NOT NULL,
				CONSTRAINT Cupoane_clasa_ck     CHECK (clasa = 'Business' OR clasa='Economic'),
				CONSTRAINT Cupoane_loc_ck	CHECK (loc > 0)
); 


ALTER TABLE Cupoane
ADD CONSTRAINT Cupooane_pk PRIMARY KEY (nrzbor,nrbilet); 



ALTER TABLE Cupoane ADD CONSTRAINT Cupoane_nrbilet_fk FOREIGN KEY (nrbilet) REFERENCES Bilete(nrbilet) ON DELETE CASCADE;
ALTER TABLE Cupoane ADD CONSTRAINT Cupoane_nrzbor_fk 	FOREIGN KEY (nrzbor) REFERENCES Zboruri(nrzbor) ON DELETE CASCADE;


ALTER TABLE Cupoane
ADD CONSTRAINT Cupoane_uq UNIQUE (nrzbor,clasa,loc); 


-- BEGIN
INSERT INTO Cupoane(nrbilet, nrzbor, clasa, loc) 
			VALUES (123,  'ABC123'	, 'Economic',  	10);
INSERT INTO Cupoane 	VALUES (123,  'ABC223'	, 'Economic', 	20); 
INSERT INTO Cupoane 	VALUES (123,  'ABC323'	, 'Economic', 	30); 

INSERT INTO Cupoane 	VALUES (2,  'ABC123'	, 'Business', 	30); 
INSERT INTO Cupoane 	VALUES (2,  'ABC223'	, 'Business', 	15); 

INSERT INTO Cupoane 	VALUES (3,  'ABC123'	, 'Economic', 	11); 
INSERT INTO Cupoane 	VALUES (3,  'ABC223'	, 'Economic', 	21); 

INSERT INTO Cupoane 	VALUES (4,  'ABD124'	, 'Economic', 	11); 
INSERT INTO Cupoane 	VALUES (4,  'ABD224'	, 'Economic', 	10); 

INSERT INTO Cupoane 	VALUES (5,  'ABD124'	, 'Economic',	10); 
INSERT INTO Cupoane 	VALUES (5,  'ABD224'	, 'Economic',	9); 

INSERT INTO Cupoane 	VALUES (6,  'ABC123'	, 'Business', 	10); 
INSERT INTO Cupoane 	VALUES (6,  'ABC223'	, 'Business', 	9); 

INSERT INTO Cupoane 	VALUES (7,  'ABD124'	, 'Business', 	11); 
INSERT INTO Cupoane 	VALUES (7,  'ABD224'	, 'Business', 	10); 

INSERT INTO Cupoane 	VALUES (8,  'AAC423'	, 'Economic', 	50); 
INSERT INTO Cupoane 	VALUES (9,  'AAC423'	, 'Business', 	119); 
INSERT INTO Cupoane 	VALUES (10,  'AAC423'	, 'Business', 	120); 

INSERT INTO Cupoane 	VALUES (11,  'AAB443'	, 'Business', 	121); 

INSERT INTO Cupoane 	VALUES (12,  'ABB523'	, 'Economic', 	50); 
INSERT INTO Cupoane 	VALUES (13,  'ABB523'	, 'Economic', 	51); 
INSERT INTO Cupoane 	VALUES (14,  'ABB523'	, 'Economic', 	52); 
INSERT INTO Cupoane 	VALUES (15,  'ABB523'	, 'Business', 	10); 
INSERT INTO Cupoane 	VALUES (16,  'ABB523'	, 'Business', 	11); 
 
INSERT INTO Cupoane 	VALUES (17,  'ACC623'	, 'Economic', 	30); 
INSERT INTO Cupoane 	VALUES (18,  'ACC623'	, 'Business', 	12); 
INSERT INTO Cupoane 	VALUES (19,  'ACC623'	, 'Business', 	13); 
-- END;

ALTER TABLE Clienti
ADD adresa VARCHAR(30); 

ALTER TABLE Bilete
ADD CONSTRAINT  Bilete_valoare_ck CHECK ( clasa != 'Economic' OR valoare <= 500 ); 



INSERT INTO Zboruri  	
VALUES ('AIF213', 'A', 'B', 'AIRBUS 310-325'	,100, CONVERT('2018-08-15 10:45:00', DATETIME ), CONVERT( '2018-08-15 13:05:00', DATETIME ));  

INSERT INTO Bilete	(nrbilet, clasa, valoare, sursa, destinatia, idclient)  
VALUES (213,  'Economic'	, 470	, 'A'	, 'B' , 1);  

INSERT INTO Cupoane(nrbilet,nrzbor,clasa,loc)  
VALUES(213,'AIF213','Economic',89);  







