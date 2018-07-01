DROP DATABASE IF EXISTS otem_db;
create database otem_db;

use otem_db;
CREATE TABLE `users` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `exam` (
  `exam_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(2000) NOT NULL DEFAULT '',
  `exam_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `questions` (
  `question_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `question_text` varchar(200) NOT NULL DEFAULT '',
  `question_index` int(2) DEFAULT NULL,
  `exam_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`question_id`),
  KEY `fk_exam_id` (`exam_id`),
  CONSTRAINT `fk_exam_id` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



CREATE TABLE `answers` (
  `answer_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ans_text` varchar(20) NOT NULL DEFAULT '',
  `ans_index` int(2) DEFAULT NULL,
  `question_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`answer_id`),
  CONSTRAINT `fk_question_id` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `test` (
  `test_id` varchar(40) NOT NULL DEFAULT '',
  `test_name` varchar(20) NOT NULL DEFAULT '',
  `exam_id` int(11) unsigned  NOT NULL,
  `total_ques` int(11) unsigned NOT NULL,
  PRIMARY KEY (`test_id`),
  CONSTRAINT `fk_test_exam_id` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `correct_answers` (
  `question_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `correct_ans_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`question_id`),
  CONSTRAINT `fk_correct_ans_que_id` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_correct_ans_id` FOREIGN KEY (`correct_ans_id`) REFERENCES `answers` (`answer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `user_test_result` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `question_id` int(11) unsigned NOT NULL,
  `received_ans_index` int(2) DEFAULT NULL,
  `test_id` varchar(40)  NULL DEFAULT '',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_test_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ut_question_id` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ut_test_id` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user_test_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `test_id` varchar(40) NULL DEFAULT '',
  `score` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_uts_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uts_test_id` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `otem_db`.`exam` (`exam_id`, `description`,	`exam_name`) VALUES (1, 'This Java Online Test simulates a real online certification exams. You will be presented Multiple Choice Questions (MCQs) based on Core Java Concepts, where you will be given four options. You will select the best suitable answer for the question and then proceed to the next question without wasting given time. You will get your online test score after finishing the complete test.\n\nInstructions:\nTotal Time for the Test is: 10 Minutes\nEach question carry 1 mark.\nNo Negative Marking.','Java Online MCQ Test');


INSERT INTO `otem_db`.`questions` (`question_id`, `question_text`, `question_index`, `exam_id`) VALUES (1,'Q. Which class cannot be a subclass in java?', 1, 1);
INSERT INTO `otem_db`.`questions` (`question_id`, `question_text`, `question_index`, `exam_id`) VALUES (2,'Q. Suspended thread can be revived by using?', 2, 1);
INSERT INTO `otem_db`.`questions` (`question_id`, `question_text`, `question_index`, `exam_id`) VALUES (3,'Q. Which collection class associates values with keys, and orders the keys according to their natural order?', 3, 1);
INSERT INTO `otem_db`.`questions` (`question_id`, `question_text`, `question_index`, `exam_id`) VALUES (4,'Q. Which methods are utilized to control the access to an object in multi-threaded programming?', 4, 1);
INSERT INTO `otem_db`.`questions` (`question_id`, `question_text`, `question_index`, `exam_id`) VALUES (5,'Q. Which of these operators is used to allocate memory to array variable in Java?', 5, 1);

INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('Abstract class', 1, 1);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('Parent class', 2, 1);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('Final class', 3, 1);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('None of the above', 4, 1);

INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('start() method', 1, 2);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('Suspend() method', 2, 2);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('resume() method', 3, 2);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('yield() method', 4, 2);

INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('java.util.HashSet', 1, 3);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('java.util.LinkedList', 2, 3);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('java.util.TreeMap', 3, 3);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('java.util.SortedSet', 4, 3);

INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('Asynchronized methods', 1, 4);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('Synchronized methods', 2, 4);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('Serialized methods', 3, 4);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('None of above', 4, 4);

INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('malloc', 1, 5);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('new malloc', 2, 5);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('new', 3, 5);
INSERT INTO `otem_db`.`answers` (`ans_text`, `ans_index`, `question_id`) VALUES ('calloc', 4, 5);

INSERT INTO `otem_db`.`correct_answers` (`question_id`, `correct_ans_id`) VALUES (1, 3);
INSERT INTO `otem_db`.`correct_answers` (`question_id`, `correct_ans_id`) VALUES (2, 3);
INSERT INTO `otem_db`.`correct_answers` (`question_id`, `correct_ans_id`) VALUES (3, 3);
INSERT INTO `otem_db`.`correct_answers` (`question_id`, `correct_ans_id`) VALUES (4, 2);
INSERT INTO `otem_db`.`correct_answers` (`question_id`, `correct_ans_id`) VALUES (5, 3);

