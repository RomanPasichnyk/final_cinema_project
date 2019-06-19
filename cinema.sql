-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(150) NOT NULL,
  `comment_date` date NOT NULL,
  `comment_time` time NOT NULL,
  `film_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpiw1eyj5u8hwd162g9kgj3vuc` (`film_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKpiw1eyj5u8hwd162g9kgj3vuc` FOREIGN KEY (`film_id`) REFERENCES `films` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'TestTest!!!','2019-06-17','23:09:32',2,1),(2,'Hello','2019-06-19','19:13:30',2,1),(3,'авііі','2019-06-19','19:15:30',2,1),(4,'test!','2019-06-19','21:22:49',2,2);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_entity_genre`
--

DROP TABLE IF EXISTS `film_entity_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `film_entity_genre` (
  `film_entity_id` bigint(20) NOT NULL,
  `genre` int(11) DEFAULT NULL,
  KEY `FKmn1sws2p5wnaf8u4tj3v8iehs` (`film_entity_id`),
  CONSTRAINT `FKmn1sws2p5wnaf8u4tj3v8iehs` FOREIGN KEY (`film_entity_id`) REFERENCES `films` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_entity_genre`
--

LOCK TABLES `film_entity_genre` WRITE;
/*!40000 ALTER TABLE `film_entity_genre` DISABLE KEYS */;
INSERT INTO `film_entity_genre` VALUES (2,3),(2,9),(3,4),(3,9),(3,10),(4,3),(4,4),(4,7),(5,4),(5,9),(5,10);
/*!40000 ALTER TABLE `film_entity_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `films`
--

DROP TABLE IF EXISTS `films`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `films` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `duration` int(11) NOT NULL,
  `end_rental` date NOT NULL,
  `film_name` varchar(150) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `language` varchar(40) NOT NULL,
  `link_trailer` varchar(255) DEFAULT NULL,
  `original_name` varchar(255) NOT NULL,
  `release_film` date NOT NULL,
  `start_rental` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `films`
--

LOCK TABLES `films` WRITE;
/*!40000 ALTER TABLE `films` DISABLE KEYS */;
INSERT INTO `films` VALUES (2,115,'2019-07-10','Люди в чорному: Інтернешнл','film_id_2.jpg','UA','https://www.youtube.com/embed/WYnsacBGpqk','Man in black: International','2019-06-10','2019-06-13'),(3,114,'2019-06-03','Люди Ікс: Темний Фенікс','film_id_3.jpg','UA','https://www.youtube.com/embed/azvR__GRQic','X-Men: Dark Phoenix','2019-06-01','2019-06-06'),(4,131,'2019-06-19','Джон Уік 3','film_id_4.jpg','UA','https://www.youtube.com/embed/lNGOlvIKvd4','John Wick 3','2019-05-10','2019-05-16'),(5,132,'2019-06-26','Годзіла 2: Король Монстрів','film_id_5.jpg','UA','https://www.youtube.com/embed/B12REtkl2KY','Godzilla: King of the Monsters','2019-05-25','2019-05-30');
/*!40000 ALTER TABLE `films` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sessions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `link_session` varchar(255) DEFAULT NULL,
  `name_cinema` varchar(255) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `film_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn2m0d43s7i2gofapl0d8qkvq7` (`film_id`),
  CONSTRAINT `FKn2m0d43s7i2gofapl0d8qkvq7` FOREIGN KEY (`film_id`) REFERENCES `films` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (1,'2019-06-19','https://multiplex.ua/movie/351520#17062019','Multiplex','23:00:00',5),(2,'2019-06-19','https://pay.planetakino.ua/hall/pk-lvov2/604320','Forum','12:15:00',2),(3,'2019-06-19','https://pay.planetakino.ua/hall/pk-lvov2/604321','Forum','17:00:00',2),(5,'2019-06-18','https://multiplex.ua/movie/352010#17062019','Multiplex','18:00:00',2),(6,'2019-06-19','Test','Lviv Film Center','10:00:00',2),(7,'2019-06-19','57457','Cinema Copernyk','15:00:00',2),(8,'2019-06-19','3464','Lviv Film Center','17:00:00',2);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  `favorite_genre` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(13) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_9q63snka3mdh91as4io72espi` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,19,'2000-02-20','admin@admin.com',0,0,'user_id_1.jpg','Admin','$2a$10$TUkYc8SNjKHk1JxFV7iK9.YZDo2KqUZpvFDgJ4oJURAVbP.lZv/wm','380961650321'),(2,19,'2000-02-20','user@user.com',12,1,NULL,'User','$2a$10$08nDuE1fi8mXgKtT22o3qubavdQxbn5PwZtdj7.Df.m5YKU3tGA3e','380961650322');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-20  0:40:18
