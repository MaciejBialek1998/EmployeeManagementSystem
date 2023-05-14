-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: emp_management_system
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('0001-1','bialek','db/changelog/0001_create_tables.xml','2023-05-14 17:26:01',1,'EXECUTED','8:c78f5d1e60f943a9c39eb2e0f702e804','createTable tableName=employee_details','',NULL,'4.17.2',NULL,NULL,'4081561589'),('0001-2','bialek','db/changelog/0001_create_tables.xml','2023-05-14 17:26:01',2,'EXECUTED','8:3ac95211c24c40b7a36aece8769f6cc7','createTable tableName=employee','',NULL,'4.17.2',NULL,NULL,'4081561589'),('0001-3','bialek','db/changelog/0001_create_tables.xml','2023-05-14 17:26:01',3,'EXECUTED','8:79f7e0acb7c57f36ca7df52f23a95e28','createTable tableName=employee_role','',NULL,'4.17.2',NULL,NULL,'4081561589'),('0001-4','bialek','db/changelog/0001_create_tables.xml','2023-05-14 17:26:01',4,'EXECUTED','8:1f6c0abdae77b0ab0acaf9d99a2377ca','createTable tableName=employee_roles','',NULL,'4.17.2',NULL,NULL,'4081561589'),('0001-5','bialek','db/changelog/0001_create_tables.xml','2023-05-14 17:26:01',5,'EXECUTED','8:b56216c771bef369a934d6cf85cf5f9f','createTable tableName=task','',NULL,'4.17.2',NULL,NULL,'4081561589'),('raw','includeAll','db/changelog/testData/employee_details.sql','2023-05-14 17:26:01',6,'EXECUTED','8:7fa732412dfdfe61645a248bfb88dc25','sql','',NULL,'4.17.2',NULL,NULL,'4081561589'),('raw','includeAll','db/changelog/testData/employee.sql','2023-05-14 17:26:01',7,'EXECUTED','8:652780d4bbe168650f6dc447c7ac5546','sql','',NULL,'4.17.2',NULL,NULL,'4081561589'),('raw','includeAll','db/changelog/testData/employee_role.sql','2023-05-14 17:26:01',8,'EXECUTED','8:efb9818bbab47bfd56f949b25dd3674e','sql','',NULL,'4.17.2',NULL,NULL,'4081561589'),('raw','includeAll','db/changelog/testData/employee_roles.sql','2023-05-14 17:26:01',9,'EXECUTED','8:ad0e1377b4e231d359f3bf0cb0a94243','sql','',NULL,'4.17.2',NULL,NULL,'4081561589'),('raw','includeAll','db/changelog/testData/task.sql','2023-05-14 17:26:01',10,'EXECUTED','8:ea542a3e654534dfc42fe11a27a61f8b','sql','',NULL,'4.17.2',NULL,NULL,'4081561589');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-14 17:26:56
