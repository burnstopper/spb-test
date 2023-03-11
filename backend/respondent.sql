CREATE SCHEMA respondent;

CREATE TABLE respondent.respondents
(
    id    SERIAL PRIMARY KEY,
    token VARCHAR NOT NULL
);
