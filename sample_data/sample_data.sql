INSERT INTO director VALUES (1, '', 'Martin Scorcese', NULL);
INSERT INTO director VALUES (2, '', 'Chris Nolan', NULL);
INSERT INTO director VALUES (3, '', 'Joe Russo', NULL);
INSERT INTO director VALUES (4, '', 'Anthony Russo', NULL);
INSERT INTO director VALUES (5, '', 'Joseph Kozinski', NULL);
INSERT INTO director VALUES (6, '', 'David Cameron', NULL);

INSERT INTO actor VALUES (1, '', 'Dwayne Johnson', NULL);
INSERT INTO actor VALUES (2, '', 'Leaonardo di Caprio', NULL);
INSERT INTO actor VALUES (3, '', 'Brad Pitt', NULL);
INSERT INTO actor VALUES (4, '', 'Scarlet Johansson', NULL);
INSERT INTO actor VALUES (5, '', 'Chris Evans', NULL);
INSERT INTO actor VALUES (6, '', 'Chris Rock', NULL);
INSERT INTO actor VALUES (7, '', 'Judy Dench', NULL);
INSERT INTO actor VALUES (8, '', 'Adam Sandler', NULL);
INSERT INTO actor VALUES (9, '', 'Leaonardo Pozolivo', NULL);
INSERT INTO actor VALUES (10, '', 'Maryl Streep', NULL);

INSERT INTO film VALUES (1, '', 201, 'Titanic', 1997, 6, NULL);
INSERT INTO film VALUES (2, '', 201, 'Avengers', 2012, 3, NULL);
INSERT INTO film VALUES (3, '', 201, 'Irish Man', 2019, 1, NULL);
INSERT INTO film VALUES (4, '', 201, 'Best Man', 1999, 5, NULL);
INSERT INTO film VALUES (5, '', 201, 'Batman', 2008, 2, NULL);

INSERT INTO film_actor VALUES (1, 2);
INSERT INTO film_actor VALUES (1, 7);
INSERT INTO film_actor VALUES (2, 5);
INSERT INTO film_actor VALUES (2, 1);
INSERT INTO film_actor VALUES (2, 9);
INSERT INTO film_actor VALUES (3, 3);
INSERT INTO film_actor VALUES (3, 10);
INSERT INTO film_actor VALUES (4, 4);