DROP TABLE submission_answer;
DROP TABLE quiz_submission;
DROP TABLE quiz_question;
DROP TABLE quiz;
DROP TABLE answer;
DROP TABLE question;
DROP TABLE account;

CREATE TABLE account
(
  id                 INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  username           VARCHAR(30) NOT NULL,
  password           VARCHAR(30) NOT NULL,
  email              VARCHAR(30),
  registration_date  DATE,
  PRIMARY KEY (id), 
  UNIQUE (username)
);


CREATE TABLE question
(
  id        INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  text      VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE answer
(
  id              INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  question_id     INTEGER NOT NULL,
  text            VARCHAR(50) NOT NULL,
  isCorrect       CHAR(1),
  PRIMARY KEY (id),
  FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE quiz
(
  id     INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name        VARCHAR(15),
  PRIMARY KEY (id)
);


CREATE TABLE quiz_question
(
  quiz_id        INTEGER NOT NULL,
  question_id    INTEGER NOT NULL,
  PRIMARY KEY (quiz_id, question_id),
  FOREIGN KEY (quiz_id) REFERENCES quiz(id),
  FOREIGN KEY (question_id) REFERENCES question(id)
);


CREATE TABLE quiz_submission
(
  id                 INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  user_id            INTEGER NOT NULL,  
  quiz_id            INTEGER NOT NULL,
  submission_time    TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES account(id),
  FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);


CREATE TABLE submission_answer
(
  submission_id       INTEGER NOT NULL,
  question_id         INTEGER NOT NULL,  
  answer_id           INTEGER NOT NULL,
  PRIMARY KEY (submission_id, question_id),
  FOREIGN KEY (submission_id) REFERENCES quiz_submission(id),
  FOREIGN KEY (question_id) REFERENCES question(id),
  FOREIGN KEY (answer_id) REFERENCES answer(id)  
);

INSERT INTO account (username, password, email, registration_date)
            VALUES ('joe', 'joe', 'joe@example.com', '2015-01-07');
INSERT INTO account (username, password, email, registration_date)
            VALUES ('jim', 'jim', 'jim@example.com', '2015-01-08');
INSERT INTO account (username, password, email, registration_date)
            VALUES ('jill', 'jill', 'jill@example.com', '2015-01-09');
            
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
            VALUES (1, 1, '2015-03-01 11:03:20');
INSERT INTO quiz_submission (user_id, quiz_id, submission_time)
            VALUES (2, 1, '2015-03-01 12:03:20');
INSERT INTO quiz_submission (user_id, quiz_id, submission_time)
            VALUES (3, 1, '2015-03-01 13:03:20');

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

 