-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: library_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `book_id` bigint NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `book_description` varchar(255) DEFAULT NULL,
  `book_author` varchar(255) DEFAULT NULL,
  `book_pages` bigint DEFAULT NULL,
  `book_published` date DEFAULT NULL,
  `checked_out_date` date DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `checked_out_user` bigint DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `FKam9riv8y6rjwkua1gapdfew4j` (`category_id`),
  KEY `FK7qg23euhry9505vymss5c8g1u` (`checked_out_user`),
  CONSTRAINT `FK7qg23euhry9505vymss5c8g1u` FOREIGN KEY (`checked_out_user`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKam9riv8y6rjwkua1gapdfew4j` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'The Fellowship','Fellowship','Tolkien',10,NULL,'2021-12-01',1,NULL),(2,'The Two Towers',NULL,'Tolkien',10,NULL,'2021-12-01',1,2),(3,'Return of the King',NULL,'Tolkien',10,NULL,'2021-12-01',1,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `category_code` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `edited_by` bigint DEFAULT NULL,
  `edited_date` datetime DEFAULT NULL,
  `entered_by` bigint DEFAULT NULL,
  `entered_date` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,_binary '','SCIFI','Science Fiction',1,'2021-12-10 12:34:56',1,'2021-12-10 12:34:56'),(2,_binary '','FICTION','Fiction',1,'2021-12-10 12:34:56',1,'2021-12-10 12:34:56');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_code` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `entered_by` bigint DEFAULT NULL,
  `entered_date` datetime DEFAULT NULL,
  `edited_by` bigint DEFAULT NULL,
  `edited_date` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN','Administrator',1,'2021-12-10 12:34:56',1,'2021-12-10 12:34:56'),(2,'LIB','Librarian',1,'2021-12-10 12:34:56',1,'2021-12-10 12:34:56'),(3,'USER','User',1,'2021-12-10 12:34:56',1,'2021-12-10 12:34:56');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `token_id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`token_id`),
  KEY `FKe32ek7ixanakfqsdaokm4q9y2` (`user_id`),
  CONSTRAINT `FKe32ek7ixanakfqsdaokm4q9y2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_initial` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `suffix` varchar(255) DEFAULT NULL,
  `cell_phone` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `salted_password` varchar(255) DEFAULT NULL,
  `reset_key` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `work_phone` varchar(255) DEFAULT NULL,
  `entered_by` bigint DEFAULT NULL,
  `entered_date` datetime DEFAULT NULL,
  `edited_by` bigint DEFAULT NULL,
  `edited_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '',NULL,'System',NULL,'Admin',NULL,NULL,NULL,'librarian@librarian.com','password',NULL,'sysadmin',NULL,1,'2021-12-10 12:34:56',1,'2021-12-10 12:34:56'),(2,_binary '',NULL,'Tom',NULL,'Holmes',NULL,NULL,NULL,NULL,'password',NULL,'tholmes',NULL,1,'2021-12-10 12:34:56',1,'2021-12-10 12:34:56');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_role_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  `entered_by` bigint DEFAULT NULL,
  `entered_date` date DEFAULT NULL,
  `edited_by` bigint DEFAULT NULL,
  `edited_date` date DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uq_user_role_idx` (`user_id`,`role_id`),
  KEY `fk_role_user_id_idx` (`role_id`),
  CONSTRAINT `fk_role_user_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `fk_user_role_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,1,'2021-12-13',1,'2021-12-13'),(2,1,2,1,'2021-12-13',1,'2021-12-13'),(3,1,3,1,'2021-12-13',1,'2021-12-13'),(4,2,3,1,'2021-12-13',1,'2021-12-13');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-13 13:07:48
