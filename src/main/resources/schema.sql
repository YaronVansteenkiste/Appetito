DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;
CREATE TABLE users
(
    username varchar(50) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
);
CREATE TABLE authorities
(
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('admin', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
VALUES ('admin', 'ADMIN');
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
VALUES ('stefferke', '$2a$10$a3/jTRNSkn0Rt/vENxt8.u2pxbJtWV8f1li3QmrIGt/C5RQ2R1wpG', true);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
VALUES ('stefferke', 'USER');
