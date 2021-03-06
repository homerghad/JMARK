DROP DATABASE heroku_f5637f306ccc2a6;
CREATE DATABASE  heroku_f5637f306ccc2a6;
USE heroku_f5637f306ccc2a6;

DROP TABLE IF EXISTS RESTAURANT;
DROP TABLE IF EXISTS  QUESTION;
DROP TABLE IF EXISTS  ANSWER;
DROP TABLE IF EXISTS  TAGS;
DROP TABLE IF EXISTS  RESTAURANT_TAGS;

CREATE TABLE RESTAURANT(
Resto_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
Resto_Name VARCHAR(255),
Budget INT,
Address VARCHAR(255)
);

CREATE TABLE QUESTION(
Question_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
Question_Text VARCHAR(255)
);

CREATE TABLE ANSWER(
Answer_ID INT NOT NULL PRIMARY KEY,
Answer_Text VARCHAR(255),
Question_ID INT NOT NULL,
FOREIGN KEY (Question_ID) REFERENCES QUESTION(Question_ID) ON DELETE CASCADE
); 

CREATE TABLE TAGS(
Tag_ID INT NOT NULL PRIMARY KEY,
Tag_Name VARCHAR(20),
Answer_ID INT NOT NULL,
FOREIGN KEY (Answer_ID) REFERENCES ANSWER(Answer_ID)
);

CREATE TABLE RESTAURANT_TAGS(
Resto_ID INT NOT NULL,
Tag_ID INT NOT NULL,
FOREIGN KEY(Resto_ID) REFERENCES RESTAURANT(Resto_ID),
FOREIGN KEY(Tag_ID) REFERENCES TAGS(Tag_ID)
);

-- Restaurant Data
INSERT INTO RESTAURANT(Resto_Name, Budget, Address) VALUES('Jolibee', 100, 'Katipunan, Quezon City');
INSERT INTO RESTAURANT(Resto_Name, Budget, Address) VALUES('McDonalds', 100, 'Katipunan, Quezon City');
INSERT INTO RESTAURANT(Resto_Name, Budget, Address) VALUES('Flaming Wings', 150, 'Katipunan, Quezon City');
INSERT INTO RESTAURANT(Resto_Name, Budget, Address) VALUES('Andre Pub', 150, 'Katipunan, Quezon City');

-- Question Data
INSERT INTO QUESTION(Question_Text) VALUES('How much are you wlling to spend?'); 
-- This actually does not need a tag. Can be directly linked to Restaurant budget
INSERT INTO QUESTION(Question_Text)  VALUES('What kind of restaurant?');
INSERT INTO QUESTION(Question_Text)  VALUES('Any ethnic preference?');
INSERT INTO QUESTION(Question_Text)  VALUES('You are in the mood for..');
INSERT INTO QUESTION(Question_Text)  VALUES('Do you need booze to go with that?');
INSERT INTO QUESTION(Question_Text)  VALUES('Wait do you want it delivered?');

-- Answer Data
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(1, 'Fast Food', 2);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(2, 'Fast Casual', 2);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(3, 'Casual Dining', 2);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(4, 'Fine Dining', 2);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(5, 'Kiosk/Stall', 2);

INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(6, 'Filipino', 3);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(7, 'Chinese', 3);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(8, 'Japanese', 3);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(9, 'American', 3);

INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(10, 'Chicken', 4);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(11, 'Pork', 4);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(12, 'Beef', 4);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(13, 'Seafood', 4);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(14, 'Salad', 4);

INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(15, 'Yes', 5);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(16, 'No', 5);

INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(17, 'Yes', 6);
INSERT INTO ANSWER(Answer_ID, Answer_Text, Question_ID) VALUES(18, 'No', 6);

-- Tags according to what kind of food
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(1, 'Fast Food', 1);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(2, 'Fast Casual', 2);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(3, 'Casual Dining', 3);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(4, 'Fine Dining', 4);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(5, 'Kiosk/Stall', 5);

-- Tags according to ethnicity
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(6, 'Filipino', 6);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(7, 'Chinese', 7);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(8, 'Japanese', 8);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(9, 'American', 9);

-- Tags according to establishment type
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(10, 'Chicken', 10);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(11, 'Pork', 11);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(12, 'Beef', 12);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(13, 'Seafood', 13);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(14, 'Salad', 14);

-- Misc Tags
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(15, 'Serves Alcohol', 15);
INSERT INTO TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(16, 'Offers Delivery', 17);

INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(1,1);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(1,3);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(1,6);

INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(2,1);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(2,3);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(2,6);

INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(3,1);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(3,8);


INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(4,1);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(4,7);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(4,8);
INSERT INTO RESTAURANT_TAGS(Tag_ID, Tag_Name, Answer_ID) VALUES(4,11);

/* Connecting the Tag with Specific Restaurant
SELECT DISTINCT RESTAURANT.Resto_Name, TAGS.Tag_Name 
FROM RESTAURANT,TAGS,RESTAURANT_TAGS 
WHERE RESTAURANT.Resto_ID = RESTAURANT_TAGS.Resto_ID AND TAGS.Tag_ID = RESTAURANT_TAGS.Tag_ID AND RESTAURANT.Resto_Name = 'Jolibee';
*/

