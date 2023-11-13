
DELETE FROM room;
DELETE FROM person;
DELETE FROM hotel;

INSERT INTO person (id, login, name, password, permissions, surname) VALUES
(1, 'user', 'user','password','USER','user'),
(2,'admin', 'admin', 'admin','ADMIN','admin');

INSERT INTO hotel (id,name) VALUES
(11,'Hotel 1*'),
(12,'Hotel 2*'),
(13,'Hotel 3*'),
(14,'Hotel 4*'),
(15,'Hotel 5*');
INSERT INTO room (id,hotel_id,number,city,description,street) VALUES
(101,11,1,'City1','Beuty room with view on city','new'),
(102,11,2,'City1','Beuty room with view on beach','new'),
(103,11,3,'City1','Beuty room without view','new'),
(104,11,4,'City1','Beuty room with view on river','new'),
(105,11,5,'City1','Modern room with view on city','new'),
(106,11,6,'City1','Modern room with view on river','new'),
(107,12,1,'City2','Industrial room with view on city','old'),
(108,12,2,'City2','Beuty room with view on city','old'),
(109,12,3,'City2','Beuty room with view on city','old'),
(110,13,1,'City3','Beuty room with view on city','old'),
(111,13,2,'City3','Beuty room with view on city','old'),
(112,13,3,'City3','Beuty room with view on city','old'),
(113,14,1,'City3','Beuty room with view on city','modern'),
(114,14,2,'City3','Beuty room with view on city','modern'),
(115,14,3,'City3','Beuty room with view on city','modern'),
(116,14,4,'City3','Beuty room with view on city','modern'),
(117,15,1,'City4','Beuty room with view on city','kingstreet'),
(118,15,2,'City4','Beuty room with view on city','kingstreet'),
(119,15,3,'City4','Beuty room with view on city','kingstreet');
