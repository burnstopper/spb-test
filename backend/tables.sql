CREATE SCHEMA spb;

CREATE TYPE spb.answer_type AS ENUM (
    'COMPLETELY_AGREE',
    'MOSTLY_AGREE',
    'SLIGHTLY_AGREE',
    'SLIGHTLY_DISAGREE',
    'MOSTLY_DISAGREE',
    'COMPLETELY_DISAGREE');

CREATE CAST (VARCHAR AS spb.answer_type) WITH INOUT AS IMPLICIT;

CREATE TABLE spb.answers
(
    id            BIGSERIAL PRIMARY KEY,
    respondent_id INTEGER                  NOT NULL,
    date_time     TIMESTAMP WITH TIME ZONE NOT NULL,
    quiz_id       INTEGER,
    answer1       spb.answer_type              NOT NULL,
    answer2       spb.answer_type              NOT NULL,
    answer3       spb.answer_type              NOT NULL,
    answer4       spb.answer_type              NOT NULL,
    answer5       spb.answer_type              NOT NULL,
    answer6       spb.answer_type              NOT NULL,
    answer7       spb.answer_type              NOT NULL,
    answer8       spb.answer_type              NOT NULL,
    answer9       spb.answer_type              NOT NULL,
    answer10      spb.answer_type              NOT NULL,
    answer11      spb.answer_type              NOT NULL,
    answer12      spb.answer_type              NOT NULL,
    answer13      spb.answer_type              NOT NULL,
    answer14      spb.answer_type              NOT NULL,
    answer15      spb.answer_type              NOT NULL,
    answer16      spb.answer_type              NOT NULL,
    answer17      spb.answer_type              NOT NULL,
    answer18      spb.answer_type              NOT NULL,
    answer19      spb.answer_type              NOT NULL,
    answer20      spb.answer_type              NOT NULL,
    answer21      spb.answer_type              NOT NULL,
    answer22      spb.answer_type              NOT NULL,
    answer23      spb.answer_type              NOT NULL,
    answer24      spb.answer_type              NOT NULL,
    answer25      spb.answer_type              NOT NULL,
    answer26      spb.answer_type              NOT NULL,
    answer27      spb.answer_type              NOT NULL,
    answer28      spb.answer_type              NOT NULL,
    answer29      spb.answer_type              NOT NULL,
    answer30      spb.answer_type              NOT NULL,
    answer31      spb.answer_type              NOT NULL,
    answer32      spb.answer_type              NOT NULL,
    answer33      spb.answer_type              NOT NULL,
    answer34      spb.answer_type              NOT NULL,
    answer35      spb.answer_type              NOT NULL,
    answer36      spb.answer_type              NOT NULL,
    answer37      spb.answer_type              NOT NULL,
    answer38      spb.answer_type              NOT NULL,
    answer39      spb.answer_type              NOT NULL,
    answer40      spb.answer_type              NOT NULL,
    answer41      spb.answer_type              NOT NULL,
    answer42      spb.answer_type              NOT NULL,
    answer43      spb.answer_type              NOT NULL,
    answer44      spb.answer_type              NOT NULL,
    answer45      spb.answer_type              NOT NULL,
    answer46      spb.answer_type              NOT NULL,
    answer47      spb.answer_type              NOT NULL,
    answer48      spb.answer_type              NOT NULL,
    answer49      spb.answer_type              NOT NULL,
    answer50      spb.answer_type              NOT NULL
);

CREATE TABLE spb.results
(
    id                        BIGSERIAL PRIMARY KEY,
    respondent_id             INTEGER NOT NULL,
    date_time                 TIMESTAMP WITH TIME ZONE,
    quiz_id                   INTEGER,
    catastrophization         INTEGER,
    self_duty                 INTEGER,
    others_duty               INTEGER,
    low_frustration_tolerance INTEGER,
    self_esteem               INTEGER
);
