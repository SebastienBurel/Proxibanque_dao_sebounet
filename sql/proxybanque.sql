CREATE DATABASE  IF NOT EXISTS `proxibanque` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proxibanque`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: proxibanque
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `agence`
--

DROP TABLE IF EXISTS `agence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agence` (
  `numero` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `numero_gerant` int(11) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agence`
--

LOCK TABLES `agence` WRITE;
/*!40000 ALTER TABLE `agence` DISABLE KEYS */;
/*!40000 ALTER TABLE `agence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `numero_conseiller` int(11) DEFAULT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `code_postal` varchar(45) DEFAULT NULL,
  `ville` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE KEY `nom_UNIQUE` (`nom`),
  KEY `fk_conseiller_1_idx` (`numero_conseiller`),
  CONSTRAINT `fk_conseiller_1` FOREIGN KEY (`numero_conseiller`) REFERENCES `conseiller` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,NULL,'OUAHIDI','Hafid','17 rue droite','06300','Nice','0619643172'),(12,NULL,'Tata','titi','fff','46565','Nice',NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compte`
--

DROP TABLE IF EXISTS `compte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compte` (
  `numero` int(11) NOT NULL,
  `solde` float DEFAULT NULL,
  `date_creation` date NOT NULL,
  `numero_CB` varchar(45) DEFAULT NULL,
  `numero_client` int(11) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `fkey_idx` (`numero_client`),
  CONSTRAINT `fk_client_1` FOREIGN KEY (`numero_client`) REFERENCES `client` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compte`
--

LOCK TABLES `compte` WRITE;
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conseiller`
--

DROP TABLE IF EXISTS `conseiller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conseiller` (
  `numero` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `numero_agence` int(11) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `fkey_idx` (`numero_agence`),
  CONSTRAINT `fk_agence_1` FOREIGN KEY (`numero_agence`) REFERENCES `agence` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conseiller`
--

LOCK TABLES `conseiller` WRITE;
/*!40000 ALTER TABLE `conseiller` DISABLE KEYS */;
/*!40000 ALTER TABLE `conseiller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virement`
--

DROP TABLE IF EXISTS `virement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virement` (
  `numero` int(11) NOT NULL,
  `date` date NOT NULL,
  `montant` float NOT NULL,
  `numero_conseiller` int(11) NOT NULL,
  `numero_compte_debiteur` int(11) NOT NULL,
  `numero_compte_crediteur` int(11) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `fk_conseiller_2_idx` (`numero_conseiller`),
  KEY `fk_compte_1_idx` (`numero_compte_debiteur`),
  KEY `fk_compte_2_idx` (`numero_compte_crediteur`),
  CONSTRAINT `fk_compte_crediteur` FOREIGN KEY (`numero_compte_crediteur`) REFERENCES `compte` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compte_debiteur` FOREIGN KEY (`numero_compte_debiteur`) REFERENCES `compte` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_conseiller_2` FOREIGN KEY (`numero_conseiller`) REFERENCES `conseiller` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virement`
--

LOCK TABLES `virement` WRITE;
/*!40000 ALTER TABLE `virement` DISABLE KEYS */;
/*!40000 ALTER TABLE `virement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-08 17:43:22
