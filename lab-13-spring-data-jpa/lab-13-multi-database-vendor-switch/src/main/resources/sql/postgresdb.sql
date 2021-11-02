create table users(
    id int4 PRIMARY key,
    username varchar(50)
);

DROP SEQUENCE IF EXISTS "users_id_seq";
CREATE SEQUENCE "users_id_seq"
    INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

ALTER SEQUENCE "users_id_seq"
    OWNED BY "users"."id";