-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smartbusmanagement
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `eid` varchar(10) NOT NULL,
  `password` text,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1810002724','rajeshwari_08'),('1810002748','siddharth_24');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_sched`
--

DROP TABLE IF EXISTS `bus_sched`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus_sched` (
  `bus_no` int(11) NOT NULL,
  `bus_seats` int(11) NOT NULL,
  `bus_route` text,
  `avail_seats` int(11) DEFAULT NULL,
  PRIMARY KEY (`bus_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_sched`
--

LOCK TABLES `bus_sched` WRITE;
/*!40000 ALTER TABLE `bus_sched` DISABLE KEYS */;
INSERT INTO `bus_sched` VALUES (1,8,'MR10',0),(2,10,'MHOW',0),(3,12,'RAU',0),(4,20,'GOPUR',1);
/*!40000 ALTER TABLE `bus_sched` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `challan` text,
  `feed` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reg_stud`
--

DROP TABLE IF EXISTS `reg_stud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reg_stud` (
  `enroll` varchar(20) NOT NULL,
  `challan` varchar(40) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `bus` int(11) DEFAULT NULL,
  `book` int(1) DEFAULT NULL,
  `route` text,
  PRIMARY KEY (`enroll`,`challan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reg_stud`
--

LOCK TABLES `reg_stud` WRITE;
/*!40000 ALTER TABLE `reg_stud` DISABLE KEYS */;
INSERT INTO `reg_stud` VALUES ('18100BTCSE00001','buschallan2020@1','abc@1',1,1,'MR10'),('18100BTCSE00002','buschallan2020@2','abc@2',1,1,'MR10'),('18100BTCSE00003','buschallan2020@3','abc@3',1,1,'MR10'),('18100BTCSE00004','buschallan2020@4','abc@4',1,1,'MR10'),('18100BTCSE00005','buschallan2020@5','abc@5',1,1,'MR10'),('18100BTCSE00006','buschallan2020@6','abc@6',1,1,'MR10'),('18100BTCSE00007','buschallan2020@7','abc@7',1,1,'MR10'),('18100BTCSE00008','buschallan2020@8','abc@8',1,1,'MR10'),('18100BTCSE00009','buschallan2020@9','abc@9',2,1,'MHOW'),('18100BTCSE00010','buschallan2020@10','abc@10',2,1,'MHOW'),('18100BTCSE00011','buschallan2020@11','abc@11',2,1,'MHOW'),('18100BTCSE00012','buschallan2020@12','abc@12',2,1,'MHOW'),('18100BTCSE00013','buschallan2020@13','abc@13',2,1,'MHOW'),('18100BTCSE00014','buschallan2020@14','abc@14',2,1,'MHOW'),('18100BTCSE00015','buschallan2020@15','abc@15',2,1,'MHOW'),('18100BTCSE00016','buschallan2020@16','abc@16',2,1,'MHOW'),('18100BTCSE00017','buschallan2020@17','abc@17',2,1,'MHOW'),('18100BTCSE00018','buschallan2020@18','abc@18',2,1,'MHOW'),('18100BTCSE00019','buschallan2020@19','abc@19',3,1,'RAU'),('18100BTCSE00020','buschallan2020@20','abc@20',3,1,'RAU'),('18100BTCSE00021','buschallan2020@21','abc@21',3,1,'RAU'),('18100BTCSE00022','buschallan2020@22','abc@22',3,1,'RAU'),('18100BTCSE00023','buschallan2020@23','abc@23',3,1,'RAU'),('18100BTCSE00024','buschallan2020@24','abc@24',3,1,'RAU'),('18100BTCSE00025','buschallan2020@25','abc@25',3,1,'RAU'),('18100BTCSE00026','buschallan2020@26','abc@26',3,1,'RAU'),('18100BTCSE00027','buschallan2020@27','abc@27',3,1,'RAU'),('18100BTCSE00028','buschallan2020@28','abc@28',3,1,'RAU'),('18100BTCSE00029','buschallan2020@29','abc@29',3,1,'RAU'),('18100BTCSE00030','buschallan2020@30','abc@30',3,1,'RAU'),('18100BTCSE00031','buschallan2020@31','abc@31',4,1,'GOPUR'),('18100BTCSE00032','buschallan2020@32','abc@32',4,1,'GOPUR'),('18100BTCSE00033','buschallan2020@33','abc@33',4,1,'GOPUR'),('18100BTCSE00034','buschallan2020@34','abc@34',0,0,'GOPUR'),('18100BTCSE00035','buschallan2020@35','abc@35',4,1,'GOPUR'),('18100BTCSE00036','buschallan2020@36','abc@36',4,1,'GOPUR'),('18100BTCSE00037','buschallan2020@37','abc@37',4,1,'GOPUR'),('18100BTCSE00038','buschallan2020@38','abc@38',4,1,'GOPUR'),('18100BTCSE00039','buschallan2020@39','abc@39',4,1,'GOPUR'),('18100BTCSE00040','buschallan2020@40','abc@40',4,1,'GOPUR'),('18100BTCSE00041','buschallan2020@41','abc@41',4,1,'GOPUR'),('18100BTCSE00042','buschallan2020@42','abc@42',4,1,'GOPUR'),('18100BTCSE00043','buschallan2020@43','abc@43',4,1,'GOPUR'),('18100BTCSE00044','buschallan2020@44','abc@44',4,1,'GOPUR'),('18100BTCSE00045','buschallan2020@45','abc@45',4,1,'GOPUR'),('18100BTCSE00046','buschallan2020@46','abc@46',4,1,'GOPUR'),('18100BTCSE00047','buschallan2020@47','abc@47',4,1,'GOPUR'),('18100BTCSE00048','buschallan2020@48','abc@48',4,1,'GOPUR'),('18100BTCSE00049','buschallan2020@49','abc@49',4,1,'GOPUR'),('18100BTCSE00050','buschallan2020@50','abc@50',4,1,'GOPUR');
/*!40000 ALTER TABLE `reg_stud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stop_dist`
--

DROP TABLE IF EXISTS `stop_dist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stop_dist` (
  `stop_id` int(11) NOT NULL,
  `stop_name` text,
  `distance_km` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`stop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stop_dist`
--

LOCK TABLES `stop_dist` WRITE;
/*!40000 ALTER TABLE `stop_dist` DISABLE KEYS */;
INSERT INTO `stop_dist` VALUES (101,'rau',23.80),(102,'mhow',36.00),(103,'mr10',9.50),(104,'Gopur',17.80);
/*!40000 ALTER TABLE `stop_dist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud_data`
--

DROP TABLE IF EXISTS `stud_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stud_data` (
  `enroll` varchar(20) NOT NULL,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `challan` varchar(50) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `route` text,
  `shift` char(2) DEFAULT NULL,
  `stop` text,
  PRIMARY KEY (`enroll`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud_data`
--

LOCK TABLES `stud_data` WRITE;
/*!40000 ALTER TABLE `stud_data` DISABLE KEYS */;
INSERT INTO `stud_data` VALUES ('18100BTCSE00001','ABC','AAA','buschallan2020@1','8574963216','MR10','I','MR10'),('18100BTCSE00002','BCD','BBB','buschallan2020@2','8085499532','MR10','I','MR10'),('18100BTCSE00003','DEF','CCC','buschallan2020@3','8085499532','MR10','I','MR10'),('18100BTCSE00004','EFG','DDD','buschallan2020@4','9683857412','MR10','I','MR10'),('18100BTCSE00005','FGH','EEE','buschallan2020@5','9876543213','MR10','II','MR10'),('18100BTCSE00006','GHI','FFF','buschallan2020@6','9685743215','MR10','II','MR10'),('18100BTCSE00007','HIJ','GGG','buschallan2020@7','2514369878','MR10','II','MR10'),('18100BTCSE00008','IJK','HHH','buschallan2020@8','9898787865','MR10','II','MR10'),('18100BTCSE00009','JKL','III','buschallan2020@9','9877844566','MHOW','I','MHOW'),('18100BTCSE00010','KLM','JJJ','buschallan2020@10','8958744596','MHOW','I','MHOW'),('18100BTCSE00011','MNO','KKK','buschallan2020@11','8962959846','MHOW','I','MHOW'),('18100BTCSE00012','NOP','LLL','buschallan2020@12','9874562163','MHOW','I','MHOW'),('18100BTCSE00013','OPQ','MMM','buschallan2020@13','9887555465','MHOW','I','MHOW'),('18100BTCSE00014','PQR','NNN','buschallan2020@14','9855624477','MHOW','II','MHOW'),('18100BTCSE00015','QRS','OOO','buschallan2020@15','9875656625','MHOW','II','MHOW'),('18100BTCSE00016','RST','PPP','buschallan2020@16','7899655522','MHOW','II','MHOW'),('18100BTCSE00017','STU','QQQ','buschallan2020@17','6598745418','MHOW','II','MHOW'),('18100BTCSE00018','TUV','RRR','buschallan2020@18','9875412145','MHOW','II','MHOW'),('18100BTCSE00019','UVW','SSS','buschallan2020@19','9877854565','RAU','I','RAU'),('18100BTCSE00020','VWX','TTT','buschallan2020@20','9887554632','RAU','I','RAU'),('18100BTCSE00021','WXY','UUU','buschallan2020@21','8565245455','RAU','I','RAU'),('18100BTCSE00022','XYZ','VVV','buschallan2020@22','8789654522','RAU','I','RAU'),('18100BTCSE00023','AABC','WWW','buschallan2020@23','9658745865','RAU','I','RAU'),('18100BTCSE00024','ABCD','XXX','buschallan2020@24','8596354555','RAU','I','RAU'),('18100BTCSE00025','ACDE','YYY','buschallan2020@25','9685745266','RAU','II','RAU'),('18100BTCSE00026','ADEF','ZZZ','buschallan2020@26','8357445625','RAU','II','RAU'),('18100BTCSE00027','AEFG','AAAA','buschallan2020@27','9685741236','RAU','II','RAU'),('18100BTCSE00028','AFGH','ABBB','buschallan2020@28','9874586955','RAU','II','RAU'),('18100BTCSE00029','AGHI','ACCC','buschallan2020@29','8745663655','RAU','II','RAU'),('18100BTCSE00030','AHIJ','ADDD','buschallan2020@30','8745696455','RAU','II','RAU'),('18100BTCSE00031','AIJK','AEEE','buschallan2020@31','8574596555','GOPUR','I','GOPUR'),('18100BTCSE00032','AJKL','AFFF','buschallan2020@32','7896554521','GOPUR','I','GOPUR'),('18100BTCSE00033','AKLM','AGGG','buschallan2020@33','7896545655','GOPUR','I','GOPUR'),('18100BTCSE00034','ALMN','AHHH','buschallan2020@34','9874548547','GOPUR','I','GOPUR'),('18100BTCSE00035','AMNO','AIII','buschallan2020@35','9685745475','GOPUR','I','GOPUR'),('18100BTCSE00036','ANOP','AJJJ','buschallan2020@36','8596547455','GOPUR','I','GOPUR'),('18100BTCSE00037','AOPQ','AKKK','buschallan2020@37','9685478544','GOPUR','I','GOPUR'),('18100BTCSE00038','APQR','ALLL','buschallan2020@38','8596547859','GOPUR','I','GOPUR'),('18100BTCSE00039','AQRS','AMMM','buschallan2020@39','8965874585','GOPUR','I','GOPUR'),('18100BTCSE00040','ARST','ANNN','buschallan2020@40','9685478544','GOPUR','I','GOPUR'),('18100BTCSE00041','ASTU','AOOO','buschallan2020@41','8357445625','GOPUR','II','GOPUR'),('18100BTCSE00042','ATUV','APPP','buschallan2020@42','7896554521','GOPUR','II','GOPUR'),('18100BTCSE00043','AUVW','AQQQ','buschallan2020@43','8745663655','GOPUR','II','GOPUR'),('18100BTCSE00044','AVWX','ARRR','buschallan2020@44','8965874585','GOPUR','II','GOPUR'),('18100BTCSE00045','AWXY','ASSS','buschallan2020@45','9685478544','GOPUR','II','GOPUR'),('18100BTCSE00046','AXYZ','ATTT','buschallan2020@46','7896554521','GOPUR','II','GOPUR'),('18100BTCSE00047','AYZA','AUUU','buschallan2020@47','8745663655','GOPUR','II','GOPUR'),('18100BTCSE00048','AZAB','AVVV','buschallan2020@48','8357445625','GOPUR','II','GOPUR'),('18100BTCSE00049','AAAB','AWWW','buschallan2020@49','8965874585','GOPUR','II','GOPUR'),('18100BTCSE00050','AABC','AXXX','buschallan2020@50','7896554521','GOPUR','II','GOPUR');
/*!40000 ALTER TABLE `stud_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-16 11:00:17
