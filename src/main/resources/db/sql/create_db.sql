CREATE TABLE Spitters (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  Username VARCHAR(16),
  Password VARCHAR(25), -- todo: keep this encrypted
  FirstName VARCHAR(30),
  LastName VARCHAR(30)

);

CREATE TABLE Spittles (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  Message VARCHAR(400),
  Time DATETIME,
  Latitude DOUBLE,
  Longitude DOUBLE

);
