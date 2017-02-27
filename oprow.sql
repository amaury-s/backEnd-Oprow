-- MySQL dump 10.13  Distrib 5.5.42, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: oprow
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrations`
--

DROP TABLE IF EXISTS `administrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `morningOpeningTime` time DEFAULT NULL,
  `morningClosingTime` time DEFAULT NULL,
  `afternoonOpeningTime` time DEFAULT NULL,
  `afternoonClosingTime` time DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrations`
--

LOCK TABLES `administrations` WRITE;
/*!40000 ALTER TABLE `administrations` DISABLE KEYS */;
INSERT INTO `administrations` VALUES (1,'08:00:00','12:00:00','14:00:00','18:00:00','Mairie 15'),(2,'08:00:00','12:00:00','14:00:00','18:00:00','Mairie 12');
/*!40000 ALTER TABLE `administrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asks`
--

DROP TABLE IF EXISTS `asks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asks` (
  `adminId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `serviceId` int(11) DEFAULT NULL,
  `arrivalTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `departureTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `asks_administrations_id_fk` (`adminId`),
  KEY `asks_users_id_fk` (`userId`),
  KEY `asks_services_serviceId_fk` (`serviceId`),
  CONSTRAINT `asks_administrations_id_fk` FOREIGN KEY (`adminId`) REFERENCES `administrations` (`id`),
  CONSTRAINT `asks_services_serviceId_fk` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`),
  CONSTRAINT `asks_users_id_fk` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asks`
--

LOCK TABLES `asks` WRITE;
/*!40000 ALTER TABLE `asks` DISABLE KEYS */;
INSERT INTO `asks` VALUES (1,1,1,'2017-02-26 09:09:00','2017-02-26 10:23:00');
/*!40000 ALTER TABLE `asks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favoriteAdministration`
--

DROP TABLE IF EXISTS `favoriteAdministration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favoriteAdministration` (
  `idUser` int(11) DEFAULT NULL,
  `idAdministration` int(11) DEFAULT NULL,
  KEY `favoriteAdministration_users_id_fk` (`idUser`),
  KEY `favoriteAdministration_administrations_id_fk` (`idAdministration`),
  CONSTRAINT `favoriteAdministration_administrations_id_fk` FOREIGN KEY (`idAdministration`) REFERENCES `administrations` (`id`),
  CONSTRAINT `favoriteAdministration_users_id_fk` FOREIGN KEY (`idUser`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favoriteAdministration`
--

LOCK TABLES `favoriteAdministration` WRITE;
/*!40000 ALTER TABLE `favoriteAdministration` DISABLE KEYS */;
INSERT INTO `favoriteAdministration` VALUES (1,2),(1,1);
/*!40000 ALTER TABLE `favoriteAdministration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedules` (
  `morningOpeningTime` time DEFAULT NULL,
  `morningClosingTime` time DEFAULT NULL,
  `afternoonOpeningTime` time DEFAULT NULL,
  `afternoonClosingTime` time DEFAULT NULL,
  `dayOfTheWeek` int(11) DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  KEY `schedules_administrations_id_fk` (`adminId`),
  CONSTRAINT `schedules_administrations_id_fk` FOREIGN KEY (`adminId`) REFERENCES `administrations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `serviceName` varchar(255) DEFAULT NULL,
  `serviceId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`serviceId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES ('Passport',1),('Information',2),('Allocation',3);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'baptiste.morellab@gmail.com','Baptiste'),(8,NULL,NULL),(9,NULL,NULL);
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

-- Dump completed on 2017-02-27 13:25:16
