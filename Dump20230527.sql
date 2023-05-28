-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: quizapp
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- Table structure for table `questionlist`
--

DROP TABLE IF EXISTS `questionlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionlist` (
  `Question` varchar(255) DEFAULT NULL,
  `OptionA` varchar(255) DEFAULT NULL,
  `OptionB` varchar(255) DEFAULT NULL,
  `OptionC` varchar(255) DEFAULT NULL,
  `OptionD` varchar(255) DEFAULT NULL,
  `CorrectAnswer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionlist`
--

LOCK TABLES `questionlist` WRITE;
/*!40000 ALTER TABLE `questionlist` DISABLE KEYS */;
INSERT INTO `questionlist` VALUES ('Who invented Java Programming?',' Guido van Rossum',' James Gosling',' Dennis Ritchie',' Bjarne Stroustrup','b'),('Which statement is true about Java?',' Java is a sequence-dependent programming language',' Java is a code dependent programming language',' Java is a platform-dependent programming language',' Java is a platform-independent programming language','d'),('Which component is used to compile, debug and execute the java programs?',' JRE',' JIT',' JDK',' JVM','c'),('Which one of the following is not a Java feature?',' Object-oriented',' Use of pointers',' Portable',' Dynamic and Extensible','b'),('Which of these cannot be used for a variable name in Java?',' identifier & keyword',' identifier',' keyword',' none of the mentioned','c'),('What is the extension of java code files?',' .js',' .txt',' .class',' .java','d'),('Which of the following is not an OOPS concept in Java?',' Polymorphism',' Inheritance',' Compilation',' Encapsulation','c'),('What is not the use of \"this\" keyword in Java?',' Referring to the instance variable when a local variable has the same name',' Passing itself to the method of the same class',' Passing itself to another method',' Calling another constructor in constructor chaining','c'),('Which of the following is a type of polymorphism in Java Programming?',' Multiple polymorphism',' Compile time polymorphism',' Multilevel polymorphism',' Execution time polymorphism','b'),('Which of the following is a superclass of every class in Java?','ArrayList','Abstract class','Object class','String','c');
/*!40000 ALTER TABLE `questionlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `StudentUsername` varchar(255) DEFAULT NULL,
  `StudentPassword` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `MailId` varchar(255) DEFAULT NULL,
  `MobileNumber` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `StudentUsername_UNIQUE` (`StudentUsername`),
  UNIQUE KEY `StudentPassword_UNIQUE` (`StudentPassword`),
  UNIQUE KEY `MobileNumber_UNIQUE` (`MobileNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Riya','Joshi','riya_joshi','riya@123','Pune','riya.joshi@gmail.com',9751580236),(2,'Siddhi','Patil','siddhi_patil','siddhi@123','Mumbai','siddhi.patil@gmail.com',9863214794);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentscore`
--

DROP TABLE IF EXISTS `studentscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentscore` (
  `id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  KEY `id` (`id`),
  CONSTRAINT `studentscore_ibfk_1` FOREIGN KEY (`id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentscore`
--

LOCK TABLES `studentscore` WRITE;
/*!40000 ALTER TABLE `studentscore` DISABLE KEYS */;
INSERT INTO `studentscore` VALUES (1,6),(2,9);
/*!40000 ALTER TABLE `studentscore` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-27 18:57:40
