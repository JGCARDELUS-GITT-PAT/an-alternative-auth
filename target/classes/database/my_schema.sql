DROP TABLE IF EXISTS USERS;

CREATE TABLE  "USERS" (
    "USER_ID" IDENTITY NOT NULL PRIMARY KEY,
	"USERNAME" VARCHAR2(40) NOT NULL,
	"EMAIL" VARCHAR2(35) NOT NULL,
    "PASSWORD" VARCHAR2(512) NOT NULL
);

DROP TABLE IF EXISTS DOCUMENTS;

CREATE TABLE  "DOCUMENTS" (
    "DOC_ID" IDENTITY NOT NULL PRIMARY KEY,
	"DOC" VARCHAR2(40) NOT NULL,
	"USER_ID" NUMBER NOT NULL
);