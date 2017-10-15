
--Players
CREATE TABLE players (
    playerid integer NOT NULL,
    name character varying(255),
    deleted boolean DEFAULT false NOT NULL
);

CREATE SEQUENCE players_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
	
ALTER SEQUENCE players_id_seq OWNED BY players.playerid;
ALTER TABLE ONLY players ALTER COLUMN playerid SET DEFAULT nextval('players_id_seq'::regclass);

ALTER TABLE ONLY players
    ADD CONSTRAINT players_pkey PRIMARY KEY (playerid);


--Ratings
CREATE TABLE ratings (
    ratingid integer NOT NULL,
    player_id integer,
    source_player_id integer,
    rating character varying(255),
    rating_date timestamp without time zone
);

CREATE SEQUENCE ratings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
	
ALTER SEQUENCE ratings_id_seq OWNED BY ratings.ratingid;
ALTER TABLE ONLY ratings ALTER COLUMN ratingid SET DEFAULT nextval('ratings_id_seq'::regclass);

ALTER TABLE ONLY ratings
    ADD CONSTRAINT ratings_pkey PRIMARY KEY (ratingid);
	
ALTER TABLE ONLY ratings
    ADD CONSTRAINT ratings2_to_players FOREIGN KEY (source_player_id) REFERENCES players(playerid) ON DELETE SET NULL;

ALTER TABLE ONLY ratings
    ADD CONSTRAINT ratings_to_players FOREIGN KEY (player_id) REFERENCES players(playerid) ON DELETE SET NULL;


--INSERT DATA
INSERT INTO players (playerid, name, deleted) VALUES (1, 'test', false);
INSERT INTO players (playerid, name, deleted) VALUES (2, 'John', false);
INSERT INTO players (playerid, name, deleted) VALUES (3, 'Lars', false);
INSERT INTO players (playerid, name, deleted) VALUES (5, 'Erik', false);

SELECT pg_catalog.setval('players_id_seq', 5, true);



INSERT INTO ratings (ratingid, player_id, source_player_id, rating, rating_date) VALUES (1, 2, 1, 'like', NULL);

SELECT pg_catalog.setval('ratings_id_seq', 1, true);


