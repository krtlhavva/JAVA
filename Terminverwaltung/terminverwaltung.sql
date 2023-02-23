

Drop DATABASE IF EXISTS terminverwaltung;

Create terminverwaltung;

USE terminverwaltung;

CREATE TABLE termin(
	ID int PRIMARY KEY AUTO_INCREMENT,
	Datum  VARCHAR(20) NOT NULL,
	Uhrzeit VARCHAR(20) NOT NULL,
	Termin VARCHAR(100) NOT NULL,
	Beschreibung VARCHAR(200) NOT NULL
);