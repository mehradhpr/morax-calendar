CREATE DATABASE Morax;
USE Morax;
 
DROP TABLE IF EXISTS user;
 
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` longtext NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
/* not using this at the moment */

/* DROP TABLE IF EXISTS schedule;
 
CREATE TABLE schedule (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 name VARCHAR(50) NOT NULL, 
 explicit INT(2) default 0,
 status VARCHAR(15) default NULL,
 created DATETIME NOT NULL,
 modified DATETIME NOT NULL
);

DROP TABLE IF EXISTS schedule_collections;
 
CREATE TABLE schedule_collections (
 id INT AUTO_INCREMENT PRIMARY KEY,
 schedule_ids json default NULL,
 name VARCHAR(50) NOT NULL, 
 explicit INT(2) default 0,
 status VARCHAR(15) default NULL,
 created DATETIME NOT NULL,
 modified DATETIME NOT NULL
); */