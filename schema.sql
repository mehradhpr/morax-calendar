CREATE DATABASE Morax;
USE Morax;
 
CREATE TABLE user (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  username varchar(15) NOT NULL,
  password longtext NOT NULL,
  created datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;