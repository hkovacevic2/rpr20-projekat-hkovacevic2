BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "user" (
	"id"	INTEGER,
	"username"	TEXT,
	"password"	TEXT,
	"admin"	INTEGER,
	"ime"	TEXT,
	"prezime"	TEXT,
	"brtel"	TEXT,
	PRIMARY KEY("id")
);
INSERT INTO "user" VALUES (0,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO "user" VALUES (1,'admin','head',1,NULL,NULL,NULL);
INSERT INTO "user" VALUES (2,'amahmic3','coravopile',0,'Adnan','Mahmić','0603020890');
INSERT INTO "user" VALUES (3,'momerovic1','mukicuki',0,'Muhamed','Omerović','062014090');
INSERT INTO "user" VALUES (4,'hkukuruzov2','haregare',0,'Haris','Kukuruzović','062138357');
INSERT INTO "user" VALUES (5,'kselimovic1','kenofole',0,'Kenan','Selimović','061267710');
INSERT INTO "user" VALUES (6,'apalavra2','pocoloco321',0,'Adnan','Palavra','063853958');
COMMIT;
