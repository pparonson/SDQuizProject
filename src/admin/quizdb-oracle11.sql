CONNECT SYSTEM/Oracle11
DROP USER quizdb CASCADE;
CREATE USER quizdb IDENTIFIED BY quizdb
       DEFAULT TABLESPACE users
       QUOTA UNLIMITED ON users;
GRANT CREATE SESSION,
      CREATE TABLE,
      CREATE SEQUENCE,
      CREATE TRIGGER
   TO quizdb;

CONNECT quizdb/quizdb

DROP TABLE submission_answer;
DROP TABLE quiz_submission;
DROP TABLE quiz_question;
DROP TABLE quiz;
DROP TABLE answer;
DROP TABLE question;
DROP TABLE account;

CREATE TABLE account
(
  id                 INTEGER NOT NULL,
  username           VARCHAR(30) NOT NULL UNIQUE,
  password           VARCHAR(30) NOT NULL,
  email              VARCHAR(30),
  registration_date  DATE
);
CREATE SEQUENCE seq_pk_account;
CREATE TRIGGER pk_account
       BEFORE INSERT
       ON account
       FOR EACH ROW
BEGIN
  :new.id := seq_pk_account.NEXTVAL;
END;
/

CREATE TABLE question
(
  id        INTEGER NOT NULL,
  text      VARCHAR(50) NOT NULL
);
CREATE SEQUENCE seq_pk_question;
CREATE TRIGGER pk_question
       BEFORE INSERT
       ON question
       FOR EACH ROW
BEGIN
  :new.id := seq_pk_question.NEXTVAL;
END;
/

CREATE TABLE answer
(
  id              INTEGER NOT NULL,
  question_id     INTEGER NOT NULL,
  text            VARCHAR(50) NOT NULL,
  isCorrect       CHAR(1)
);
CREATE SEQUENCE seq_pk_answer;
CREATE TRIGGER pk_answer
       BEFORE INSERT
       ON answer
       FOR EACH ROW
BEGIN
  :new.id := seq_pk_answer.NEXTVAL;
END;
/

CREATE TABLE quiz
(
  id     INTEGER NOT NULL,
  name        VARCHAR(15)
);
CREATE SEQUENCE seq_pk_quiz;
CREATE TRIGGER pk_quiz
       BEFORE INSERT
       ON quiz
       FOR EACH ROW
BEGIN
  :new.id := seq_pk_quiz.NEXTVAL;
END;
/

CREATE TABLE quiz_question
(
  quiz_id        INTEGER NOT NULL,
  question_id    INTEGER NOT NULL
);


CREATE TABLE quiz_submission
(
  id                 INTEGER NOT NULL,
  user_id            INTEGER NOT NULL,  
  quiz_id            INTEGER NOT NULL,
  submission_time    TIMESTAMP
);
CREATE SEQUENCE seq_pk_quiz_submission;
CREATE TRIGGER pk_quiz_submission
       BEFORE INSERT
       ON quiz_submission
       FOR EACH ROW
BEGIN
  :new.id := seq_pk_quiz_submission.NEXTVAL;
END;
/

CREATE TABLE submission_answer
(
  submission_id       INTEGER NOT NULL,
  question_id         INTEGER NOT NULL,  
  answer_id           INTEGER NOT NULL
);

INSERT INTO account (username, password, email, registration_date)
            VALUES ('joe', 'joe', 'joe@example.com', DATE '2015-01-07');
INSERT INTO account (username, password, email, registration_date)
            VALUES ('jim', 'jim', 'jim@example.com', DATE '2015-01-08');
INSERT INTO account (username, password, email, registration_date)
            VALUES ('jill', 'jill', 'jill@example.com', DATE '2015-01-09');
            
INSERT INTO question (text)
            VALUES ('What is the capital of Alabama?');
INSERT INTO question (text)
            VALUES ('What is the capital of Alaska?');
INSERT INTO question (text)
            VALUES ('What is the capital of Arizona?');
INSERT INTO question (text)
            VALUES ('What is the capital of Arkansas?');

INSERT INTO answer (question_id, text, isCorrect)
            VALUES (1, 'Birmingham', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (1, 'Montgomery', 'Y');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (1, 'Mobile', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (1, 'Huntsville', 'N');
            
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (2, 'Anchorage', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (2, 'Fairbanks', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (2, 'Juneau', 'Y');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (2, 'Sitka', 'N');

INSERT INTO answer (question_id, text, isCorrect)
            VALUES (3, 'Phoenix', 'Y');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (3, 'Tucson', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (3, 'Tempe', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (3, 'Flagstaff', 'N');

INSERT INTO answer (question_id, text, isCorrect)
            VALUES (4, 'Little Rock', 'Y');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (4, 'Fort Smith', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (4, 'Fayetteville', 'N');
INSERT INTO answer (question_id, text, isCorrect)
            VALUES (4, 'Springdale', 'N');

INSERT INTO quiz (name)
            VALUES ('State Capitals');


INSERT INTO quiz_question (quiz_id, question_id)
            VALUES (1, 1);
INSERT INTO quiz_question (quiz_id, question_id)
            VALUES (1, 2);
INSERT INTO quiz_question (quiz_id, question_id)
            VALUES (1, 3);
INSERT INTO quiz_question (quiz_id, question_id)
            VALUES (1, 4);
            
INSERT INTO quiz_submission (user_id, quiz_id, submission_time)
            VALUES (1, 1, TIMESTAMP '2015-03-01 11:03:20');
INSERT INTO quiz_submission (user_id, quiz_id, submission_time)
            VALUES (2, 1, TIMESTAMP '2015-03-01 12:03:20');
INSERT INTO quiz_submission (user_id, quiz_id, submission_time)
            VALUES (3, 1, TIMESTAMP '2015-03-01 13:03:20');

INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (1, 1, 1);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (1, 2, 4);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (1, 3, 1);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (1, 4, 3);

INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (2, 1, 1);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (2, 2, 4);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (2, 3, 2);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (2, 4, 3);

INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (3, 1, 4);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (3, 2, 3);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (3, 3, 2);
INSERT INTO submission_answer (submission_id, question_id, answer_id)
            VALUES (3, 4, 1);

 
ALTER TABLE account ADD CONSTRAINT pk_account PRIMARY KEY (id);
ALTER TABLE question ADD CONSTRAINT pk_question PRIMARY KEY (id);
ALTER TABLE answer ADD CONSTRAINT pk_answer PRIMARY KEY (id);
ALTER TABLE answer ADD CONSTRAINT fk_answer_question FOREIGN KEY (question_id) REFERENCES question(id);
ALTER TABLE quiz ADD CONSTRAINT pk_quiz PRIMARY KEY(id);
ALTER TABLE quiz_question ADD CONSTRAINT pk_quiz_question PRIMARY KEY (quiz_id, question_id);
ALTER TABLE quiz_question ADD CONSTRAINT fk_quiz_question_quiz FOREIGN KEY (quiz_id) REFERENCES quiz(id);
ALTER TABLE quiz_question ADD CONSTRAINT fk_quiz_question_question FOREIGN KEY (question_id) REFERENCES question(id);
ALTER TABLE quiz_submission ADD CONSTRAINT pk_quiz_submission PRIMARY KEY (id);
ALTER TABLE quiz_submission ADD CONSTRAINT fk_quiz_submission_account FOREIGN KEY (user_id) REFERENCES account(id);
ALTER TABLE quiz_submission ADD CONSTRAINT fk_quiz_submission_quiz FOREIGN KEY (quiz_id) REFERENCES quiz(id);
ALTER TABLE submission_answer ADD CONSTRAINT pk_submission_answer PRIMARY KEY (submission_id, question_id);
ALTER TABLE submission_answer ADD CONSTRAINT fk_submission_answer_quiz_sub FOREIGN KEY (submission_id) REFERENCES quiz_submission(id);
ALTER TABLE submission_answer ADD CONSTRAINT fk_submission_answer_question FOREIGN KEY (question_id) REFERENCES question(id);
ALTER TABLE submission_answer ADD CONSTRAINT fk_submission_answer_answer FOREIGN KEY (answer_id) REFERENCES answer(id);
