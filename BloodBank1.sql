-- MySQL dump 10.16  Distrib 10.2.21-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: BloodBank
-- ------------------------------------------------------
-- Server version	10.2.21-MariaDB

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
-- Table structure for table `ADULTDONORS`
--

DROP TABLE IF EXISTS `ADULTDONORS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADULTDONORS` (
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `idnumber` varchar(10) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `subcounty` varchar(7) NOT NULL,
  `age` int(2) NOT NULL,
  `date_registered` varchar(15) NOT NULL,
  PRIMARY KEY (`idnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADULTDONORS`
--

LOCK TABLES `ADULTDONORS` WRITE;
/*!40000 ALTER TABLE `ADULTDONORS` DISABLE KEYS */;
INSERT INTO `ADULTDONORS` VALUES ('Esther','Wanjiku','3420000','+254725091068','Female','Central',40,'2019-06-27'),('Victor','Gachau','34288203','+254701502302','Male','East',19,'2019-06-27'),('Faith','Mureithi','34288204','+254712775156','Female','West',22,'2019-06-27'),('Joyce','Wangui','34288205','+254713776565','Female','North',25,'2019-06-27'),('Moses','Kiriga','34288206','+254715974918','Male','South',23,'2019-06-27'),('Robert','Thuita','34288207','+254728278744','Male','Central',22,'2019-06-27');
/*!40000 ALTER TABLE `ADULTDONORS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ALLDONORS`
--

DROP TABLE IF EXISTS `ALLDONORS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALLDONORS` (
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `donorID` varchar(20) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `bloodgroup` varchar(5) NOT NULL,
  `bloodtype` varchar(5) NOT NULL,
  `date_of_donation` varchar(10) NOT NULL,
  `date_last_donated` varchar(10) NOT NULL,
  `category` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALLDONORS`
--

LOCK TABLES `ALLDONORS` WRITE;
/*!40000 ALTER TABLE `ALLDONORS` DISABLE KEYS */;
INSERT INTO `ALLDONORS` VALUES ('Winfred','Wanjiru','1000','Female','A','+ve','2019-05-26','2019-05-26','student'),('Adrian','Kamau','1001','Male','B','+ve','2019-06-02','2019-06-02','student'),('Maureen','wambua','1002','Female','B','+ve','2019-05-26','2019-05-26','student'),('Victor','Gachau','34288203','Male','AB','-ve','2019-06-16','2019-06-16','adult'),('Joyce','Wangui','34288205','Female','B','+ve','2019-06-23','2019-06-23','adult'),('Jason','Maina','1100','Male','B','-ve','2019-05-05','2019-05-05','student'),('Adrian','Kamau','1001','Male','B','+ve','2019-06-16','2019-06-16','student'),('Esther','Wanjiku','3420000','Female','B','-ve','2019-06-09','2019-06-09','adult'),('Robert','Thuita','34288207','Male','A','-ve','2019-05-26','2019-05-26','adult'),('Moses','Kiriga','34288206','Male','AB','+ve','2019-05-27','2019-05-27','adult'),('Joyce','Wangui','34288205','Female','B','+ve','2019-06-23','2019-06-23','adult'),('Jason','Maina','1100','Male','B','-ve','2019-06-16','2019-06-16','student'),('Trony','Kingor','1003','Male','AB','+ve','2019-06-16','2019-06-16','student');
/*!40000 ALTER TABLE `ALLDONORS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BLOODBAGS`
--

DROP TABLE IF EXISTS `BLOODBAGS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BLOODBAGS` (
  `bloodgroup` varchar(5) NOT NULL,
  `number_of_bags` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BLOODBAGS`
--

LOCK TABLES `BLOODBAGS` WRITE;
/*!40000 ALTER TABLE `BLOODBAGS` DISABLE KEYS */;
INSERT INTO `BLOODBAGS` VALUES ('A+',1),('A-',1),('B+',1),('B-',1),('AB+',2),('AB-',1),('O+',1),('O-',1);
/*!40000 ALTER TABLE `BLOODBAGS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BLOODTYPE`
--

DROP TABLE IF EXISTS `BLOODTYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BLOODTYPE` (
  `donorID` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `bloodgroup` varchar(2) NOT NULL,
  `bloodtype` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BLOODTYPE`
--

LOCK TABLES `BLOODTYPE` WRITE;
/*!40000 ALTER TABLE `BLOODTYPE` DISABLE KEYS */;
INSERT INTO `BLOODTYPE` VALUES ('738392','student','O','-ve'),('7383912','minor','A','+ve'),('1426','student','A','+ve'),('34288203','adult','A','+ve'),('1425','student','A','+ve'),('1425','student','A','+ve'),('34288203','adult','A','+ve'),('34288204','adult','AB','-ve'),('3213142','adult','AB','-ve'),('3213141','adult','AB','-ve'),('3213141','adult','AB','-ve'),('3213141','adult','AB','-ve'),('2222222','adult','B','+ve'),('2222222','adult','A','+ve'),('2222222','adult','A','+ve'),('2222222','adult','B','+ve'),('8808801','adult','A','+ve'),('12616','student','O','+ve'),('12617','student','O','-ve'),('34220830','adult','O','-ve');
/*!40000 ALTER TABLE `BLOODTYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ELIGIBILITY`
--

DROP TABLE IF EXISTS `ELIGIBILITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ELIGIBILITY` (
  `donorID` varchar(20) NOT NULL,
  `eligibilty` varchar(3) NOT NULL,
  `date_of_donation` varchar(10) NOT NULL,
  `date_last_donated` varchar(10) NOT NULL,
  `bloodgroup` varchar(3) NOT NULL,
  `bloodtype` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ELIGIBILITY`
--

LOCK TABLES `ELIGIBILITY` WRITE;
/*!40000 ALTER TABLE `ELIGIBILITY` DISABLE KEYS */;
INSERT INTO `ELIGIBILITY` VALUES ('34288203','Yes','2019-04-28','2019-05-07','',''),('34288204','Yes','2020-05-27','2019-05-14','',''),('3213142','Yes','2019-05-05','2019-05-05','',''),('2222222','Yes','2019-05-12','2019-05-12','B','+ve'),('12617','Yes','2019-05-10','2019-05-10','O','-ve'),('34220830','Yes','2019-05-05','2019-05-05','O','-ve');
/*!40000 ALTER TABLE `ELIGIBILITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXPIREDBLOOD`
--

DROP TABLE IF EXISTS `EXPIREDBLOOD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXPIREDBLOOD` (
  `donorID` varchar(15) DEFAULT NULL,
  `bloodgroup` varchar(5) NOT NULL,
  `bloodtype` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXPIREDBLOOD`
--

LOCK TABLES `EXPIREDBLOOD` WRITE;
/*!40000 ALTER TABLE `EXPIREDBLOOD` DISABLE KEYS */;
INSERT INTO `EXPIREDBLOOD` VALUES ('1234','B','+ve'),('1100','B','-ve');
/*!40000 ALTER TABLE `EXPIREDBLOOD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STUDENTDONORS`
--

DROP TABLE IF EXISTS `STUDENTDONORS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STUDENTDONORS` (
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `schoolname` varchar(50) NOT NULL,
  `admission` varchar(10) NOT NULL,
  `level_of_study` varchar(7) NOT NULL,
  `age` int(2) NOT NULL,
  `date_registered` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STUDENTDONORS`
--

LOCK TABLES `STUDENTDONORS` WRITE;
/*!40000 ALTER TABLE `STUDENTDONORS` DISABLE KEYS */;
INSERT INTO `STUDENTDONORS` VALUES ('Winfred','Wanjiru','Female','TumuTumu Girls','1000','II',17,'2019-06-27'),('Adrian','Kamau','Male','Kagumo High','1001','III',16,'2019-06-27'),('Maureen','wambua','Female','ArkRoad','1002','II',18,'2019-06-27'),('Trony','Kingor','Male','Ongata Academy','1003','IV',19,'2019-06-27'),('Jason','Maina','Male','Kagumo High','1100','II',17,'2019-06-27'),('Joshua','Koine','Male','Kambiti High','12616','III',18,'2019-06-27');
/*!40000 ALTER TABLE `STUDENTDONORS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloodbags`
--

DROP TABLE IF EXISTS `bloodbags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bloodbags` (
  `bagID` int(7) NOT NULL,
  `category` varchar(10) NOT NULL,
  `bloodgroup` varchar(3) NOT NULL,
  `bloodtype` varchar(5) NOT NULL,
  `bloodstatus` varchar(15) NOT NULL,
  `date_of_donation` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloodbags`
--

LOCK TABLES `bloodbags` WRITE;
/*!40000 ALTER TABLE `bloodbags` DISABLE KEYS */;
INSERT INTO `bloodbags` VALUES (1000,'student','A','+ve','Yes','2019-05-26'),(1002,'student','B','+ve','Yes','2019-05-26'),(1003,'adult','AB','-ve','Yes','2019-06-16'),(1004,'adult','B','+ve','Yes','2019-06-23'),(1200,'student','O','-ve','Yes','2019-06-16'),(1201,'adult','B','-ve','Yes','2019-06-09'),(1202,'adult','A','-ve','Yes','2019-05-26'),(1203,'adult','AB','+ve','Yes','2019-05-27'),(1204,'adult','O','+ve','Yes','2019-06-23'),(1207,'student','O','+ve','No','2019-06-16'),(1101,'student','AB','+ve','Yes','2019-06-16');
/*!40000 ALTER TABLE `bloodbags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipients`
--

DROP TABLE IF EXISTS `recipients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipients` (
  `bagID` int(10) NOT NULL,
  `bloodgroup` varchar(5) NOT NULL,
  `bloodtype` varchar(5) NOT NULL,
  `recipients_date` varchar(15) NOT NULL,
  `hospital` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipients`
--

LOCK TABLES `recipients` WRITE;
/*!40000 ALTER TABLE `recipients` DISABLE KEYS */;
INSERT INTO `recipients` VALUES (1001,'B','+ve','2019-06-27','County Referral Hospital');
/*!40000 ALTER TABLE `recipients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL,
  `idnumber` varchar(10) NOT NULL,
  `rank` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin254','34288203','admin'),('victor','34288204','34288204','officer'),('victor','34288204','34288204','officer'),('user1','543123','543123','admin'),('james','1234567','678543','admin'),('user4','42156252','42156252','admin'),('user5','user5','user3','admin'),('moses','332123','332123','officer'),('user123','0987654','0987654','officer'),('user123','0987654','0987654','officer'),('user123','0987654','0987654','officer'),('user123','0987654','0987654','officer'),('user123','0987654','0987654','officer'),('john','28292','28292','suspended'),('Joyce','37337337','37337337','officer'),('  ','17282991','17282991','officer'),('Paul','87654321','87654321','suspended');
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

-- Dump completed on 2019-06-27 13:19:47
