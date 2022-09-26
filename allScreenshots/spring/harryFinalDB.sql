CREATE DATABASE  IF NOT EXISTS `rentalmanagementdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rentalmanagementdb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: rentalmanagementdb
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(20) DEFAULT NULL,
  `country` varchar(60) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Kolkata','Denmark','Bengal','P76BaradaAvenue','700084'),(2,'Kolkata','Denmark','Bengal','P76BaradaAvenue','700084'),(3,'Kolkata','Denmark','Bengal','P76BaradaAvenue','700084'),(4,'Kolkata','Denmark','Bengal','P76BaradaAvenue','700084'),(5,'Kolkata','Denmark','Bengal','P76BaradaAvenue','700084'),(6,'Kolkata','Denmark','Bengal','P934BaradaAvenue','700084'),(7,'Kolkata','Denmark','Bengal','P76BaradaAvenue','700084'),(8,'Kolkata','Denmark','Bengal','P934BaradaAvenue','700084'),(9,'Kolkata','India','Bengal','P76BaradaAvenue','700084'),(10,'Kolkata','India','Bengal','P934BaradaAvenue','700084'),(11,'Kolkata','India','Bengal','P76BaradaAvenue','700084'),(12,'Kolkata','India','Bengal','P934BaradaAvenue','700084'),(13,'Kolkata','India','Bengal','P76BaradaAvenue','700084'),(14,'Kolkata','India','Bengal','P934BaradaAvenue','700084'),(15,'Pune','India','Maharashtra','221b, Baker Street','411057'),(16,'Pune','India','Maharashtra','221b, Baker Street','411057'),(17,'London','India','Maharashtra','221b, Baker Street','001'),(18,'London','India','Maharashtra','221b, Baker Street','001'),(19,'Montreal','Canada','Quebec','1, Canada Street','654489'),(20,'Montreal','Canada','Quebec','1, Canada Street','654489'),(21,'Munchen',NULL,NULL,'Near Bayern Munich FC','700094'),(22,'Munchen',NULL,NULL,'Near Bayern Munich FC','700094'),(23,'CanadaCity','Canada','British Columbia','British221b Street','411014'),(24,'CanadaCity','Canada','British Columbia','British221b Street','411014'),(25,'Rio','Brazil','Rio de Janeiro','79, football brazil street','900000'),(26,'Rio','Brazil','Rio de Janeiro','79, football brazil street','900000'),(27,'HelloCity',NULL,NULL,'mikeRossStreet','700084'),(28,'HelloCity',NULL,NULL,'mikeRossStreet','700084'),(29,'anotherCity','India','Haryana','anotherStreet','700084'),(30,'anotherCity','India','Haryana','anotherStreet','700084'),(31,'cityname','India','Haryana','streetname','700084'),(32,'cityname','India','Haryana','streetname','700084'),(33,'cityName','India','Haryana','streetName','700084'),(34,'cityName','India','Haryana','streetName','700084'),(35,'city there','India','Andhra Pradesh','hello there state','700084'),(36,'city there','India','Andhra Pradesh','hello there state','700084'),(37,'Pune','INDIA','Maharashtra','Narhe Gaon Road','411041'),(38,'Pune','INDIA','Maharashtra','Narhe Gaon Road','411041'),(39,'Pune','INDIA','Maharashtra','NarheGaon Road','411041'),(40,'Pune','INDIA','Maharashtra','NarheGaon Road','411041');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_admin`
--

DROP TABLE IF EXISTS `contact_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_admin` (
  `contact_admin_id` bigint NOT NULL AUTO_INCREMENT,
  `contact_admin_created` datetime(6) DEFAULT NULL,
  `contact_admin_email` varchar(255) DEFAULT NULL,
  `contact_admin_message` varchar(255) DEFAULT NULL,
  `contact_admin_name` varchar(255) DEFAULT NULL,
  `contact_admin_purpose` varchar(255) DEFAULT NULL,
  `contact_admin_request_status` varchar(255) DEFAULT NULL,
  `contact_admin_updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`contact_admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_admin`
--

LOCK TABLES `contact_admin` WRITE;
/*!40000 ALTER TABLE `contact_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_us`
--

DROP TABLE IF EXISTS `contact_us`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_us` (
  `contact_us_id` bigint NOT NULL AUTO_INCREMENT,
  `contact_us_created` datetime(6) DEFAULT NULL,
  `contact_us_email` varchar(255) DEFAULT NULL,
  `contact_us_message` varchar(255) DEFAULT NULL,
  `contact_us_name` varchar(255) DEFAULT NULL,
  `contact_us_purpose` varchar(255) DEFAULT NULL,
  `contact_us_request_status` varchar(255) DEFAULT NULL,
  `contact_us_updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`contact_us_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_us`
--

LOCK TABLES `contact_us` WRITE;
/*!40000 ALTER TABLE `contact_us` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_us` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'IN','INDIA');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Chanakya','Lahiri','chanakya@test.com'),(2,'Harry','Lahiri','harry@hogwarts.com'),(3,'Harry','Lahiri','dmc1922020@zealeducation.com'),(4,'Demo','CustomerSirname','hikyoffee@gmail.com'),(5,'Harvey','Spector','helloclahiri@gmail.com'),(6,'Customer1','Customer1Sirname','hello@gmail.com'),(7,'another','Person','anotherperson@gmail.com'),(8,'Chanakya','Lahiri','chan@gmail.com'),(9,'Chan','Lahiri','tello@gmail.com'),(10,'Harry','Lahiri','harry@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `newsletter` (
  `newsletter_id` bigint NOT NULL AUTO_INCREMENT,
  `newsletter_date_created` datetime(6) DEFAULT NULL,
  `newsletter_email` varchar(255) DEFAULT NULL,
  `newsletter_last_updated` datetime(6) DEFAULT NULL,
  `newsletter_request_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`newsletter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsletter`
--

LOCK TABLES `newsletter` WRITE;
/*!40000 ALTER TABLE `newsletter` DISABLE KEYS */;
/*!40000 ALTER TABLE `newsletter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` decimal(19,2) DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `K_order_id` (`order_id`),
  KEY `FK_product_id` (`product_id`),
  CONSTRAINT `FK_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (51,'assets/images/products/marriageEvent/marriageEvent.jpg',1,35000.00,19,1),(52,'assets/images/products/marriageEvent/marriageEvent.jpg',3,35000.00,20,1);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_tracking_number` varchar(255) DEFAULT NULL,
  `total_price` decimal(19,2) DEFAULT NULL,
  `total_quantity` int DEFAULT NULL,
  `billing_address_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `shipping_address_id` bigint DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `last_updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_billing_address_id` (`billing_address_id`),
  UNIQUE KEY `UK_shipping_address_id` (`shipping_address_id`),
  KEY `K_customer_id` (`customer_id`),
  CONSTRAINT `FK_billing_address_id` FOREIGN KEY (`billing_address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FK_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK_shipping_address_id` FOREIGN KEY (`shipping_address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'274e20b2-82b9-4d7a-b2f5-f489e092d668',36.98,2,1,1,2,NULL,'2022-03-25 04:37:40.743000','2022-03-25 04:37:40.743000'),(2,'c1c86579-9283-4323-b7e7-dd42d44b868f',36.98,2,3,1,4,NULL,'2022-03-25 04:38:51.606000','2022-03-25 04:38:51.606000'),(3,'86e12af0-782b-45c2-933a-f0fba2f95202',36.98,2,5,2,6,NULL,'2022-03-25 04:40:36.286000','2022-03-25 04:40:36.286000'),(4,'9edfabcb-7960-4a2d-b5ed-60c258b24678',36.98,2,7,2,8,NULL,'2022-03-25 04:40:37.509000','2022-03-25 04:40:37.509000'),(5,'a3a6d594-5ccc-49c8-b82b-2e9cd3737f64',36.98,2,9,3,10,NULL,'2022-03-26 23:02:04.674000','2022-03-26 23:02:04.674000'),(6,'3932677d-bf03-4106-849c-aafe56caa0f0',36.98,2,11,3,12,NULL,'2022-03-26 23:02:07.065000','2022-03-26 23:02:07.065000'),(7,'3344a95f-bf32-44b4-8c37-6d1a713f3b3a',36.98,2,13,3,14,NULL,'2022-03-26 23:02:08.145000','2022-03-26 23:02:08.145000'),(8,'a22bf34e-bbe6-44f0-ada9-fba1b4e7e60a',64.96,4,15,4,16,NULL,'2022-03-26 23:13:52.104000','2022-03-26 23:13:52.104000'),(9,'236be3ca-d0ee-46c8-9111-036cc52696f6',119.94,6,17,4,18,NULL,'2022-03-26 23:15:33.671000','2022-03-26 23:15:33.671000'),(10,'04b70670-70de-430d-822e-bb4d815af6be',49.97,3,19,4,20,NULL,'2022-03-26 23:40:41.730000','2022-03-26 23:40:41.730000'),(11,'6c4ce4b9-4856-487f-b657-179956e075b9',74.95,5,21,3,22,NULL,'2022-03-27 06:04:25.438000','2022-03-27 06:04:25.438000'),(12,'258c8c1e-f641-4502-848c-f793ecb2c6ff',88.94,6,23,5,24,NULL,'2022-03-29 00:01:50.897000','2022-03-29 00:01:50.897000'),(13,'78e7d8f2-6be6-4a58-b275-eac5a444b7d3',166.91,9,25,5,26,NULL,'2022-03-29 01:12:34.509000','2022-03-29 01:12:34.509000'),(14,'5f12951a-8960-4c41-ae06-f9f044e2b622',28.98,2,27,6,28,NULL,'2022-04-20 21:34:44.665000','2022-04-20 21:34:44.665000'),(15,'951d0f3a-b83b-4787-8ec5-52a7d6ce4dbe',28.98,2,29,7,30,NULL,'2022-04-20 21:35:47.057000','2022-04-20 21:35:47.057000'),(16,'5b5527f9-aa46-49df-a2da-87b815f18f43',35.98,2,31,3,32,NULL,'2022-04-21 21:47:30.201000','2022-04-21 21:47:30.201000'),(17,'f0583dba-09ad-4a30-8967-6ccfec7d954f',56.97,3,33,8,34,NULL,'2022-04-21 22:02:35.546000','2022-04-21 22:02:35.546000'),(18,'6ff8164c-8553-4f8c-a6c4-59fc7b43264b',56.97,3,35,9,36,NULL,'2022-04-21 22:10:29.682000','2022-04-21 22:10:29.682000'),(19,'3f145f53-9d06-49e5-878f-61bef99e99f8',35000.00,1,37,10,38,NULL,'2022-06-09 09:20:11.726000','2022-06-09 09:20:11.726000'),(20,'5509d278-132c-49ae-816e-fb037acd58e6',105000.00,3,39,10,40,NULL,'2022-06-09 09:21:27.253000','2022-06-09 09:21:27.253000');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `last_updated` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `unit_price` decimal(19,2) DEFAULT NULL,
  `units_in_stock` int DEFAULT NULL,
  `product_category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKcwclrqu392y86y0pmyrsi649r` (`product_category_id`),
  CONSTRAINT `FKcwclrqu392y86y0pmyrsi649r` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,_binary '','2022-06-08 13:01:20.273000','Seven day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-08 13:01:20.273000','Marriage Pack (7Day)','20',35000.00,10,1),(2,_binary '','2022-06-11 11:04:08.802000','One day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:08.802000','Marriage Pack (1Day)','20',10000.00,10,1),(3,_binary '','2022-06-11 11:04:30.729000','Two day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:30.729000','Marriage Pack (2Day)','20',15000.00,10,1),(4,_binary '','2022-06-11 11:04:40.926000','Three day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:40.926000','Marriage Pack (3Day)','20',20000.00,10,1),(5,_binary '','2022-06-11 11:04:49.727000','Four day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:49.727000','Marriage Pack (4Day)','20',25000.00,10,1),(6,_binary '','2022-06-11 11:05:00.045000','Five day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:05:00.045000','Marriage Pack (5Day)','20',32000.00,10,1),(7,_binary '','2022-06-11 11:06:37.802000','One day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:06:37.802000','Festival Pack (1Day)','20',10000.00,10,2),(8,_binary '','2022-06-11 11:06:56.572000','Two day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:06:56.572000','Festival Pack (2Day)','20',15000.00,10,2),(9,_binary '','2022-06-11 11:07:09.870000','Three day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:09.870000','Festival Pack (3Day)','20',22000.00,10,2),(10,_binary '','2022-06-11 11:07:23.272000','Four day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:23.272000','Festival Pack (4Day)','20',27000.00,10,2),(11,_binary '','2022-06-11 11:07:36.668000','Five day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:36.668000','Festival Pack (5Day)','20',32000.00,10,2),(12,_binary '','2022-06-11 11:07:52.656000','Seven day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:52.656000','Festival Pack (7Day)','20',45000.00,10,2),(13,_binary '','2022-06-11 11:13:10.075000','One day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:10.075000','Birthday Pack (1Day)','20',5000.00,10,3),(14,_binary '','2022-06-11 11:13:27.203000','Two day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:27.203000','Birthday Pack (2Day)','20',10000.00,10,3),(15,_binary '','2022-06-11 11:13:38.084000','Three day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:38.084000','Birthday Pack (3Day)','20',15000.00,10,3),(16,_binary '','2022-06-11 11:13:52.532000','Four day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:52.532000','Birthday Pack (4Day)','20',17000.00,10,3),(17,_binary '','2022-06-11 11:14:01.361000','Five day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:14:01.361000','Birthday Pack (5Day)','20',20000.00,10,3),(18,_binary '','2022-06-11 11:14:12.026000','Seven day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:14:12.026000','Birthday Pack (7Day)','20',23000.00,10,3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `product_category_id` bigint NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'Marriage Event'),(2,'Festival Event'),(3,'Birthday Event');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_name` varchar(255) NOT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('Admin','Admin role'),('User','Default role for newly created record');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `country_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKghic7mqjt6qb9vq7up7awu0er` (`country_id`),
  CONSTRAINT `FKghic7mqjt6qb9vq7up7awu0er` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Maharashtra',1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_name` varchar(255) NOT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_created` datetime(6) DEFAULT NULL,
  `user_dob` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_first_name` varchar(255) DEFAULT NULL,
  `user_last_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone_number` varchar(255) DEFAULT NULL,
  `user_secret_pin` bigint DEFAULT NULL,
  `user_status` bit(1) DEFAULT NULL,
  `user_updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','Nanded District, Hadgaon',NULL,'01/02/1980','admin@gmail.com','Mr','Jaiswal','$2a$10$UrbR8XaCMwQZAWO9yhk9t.6ilsiUy3vhe9Dc.zii0SPIG6H8xcmAe','9330689787',9696,_binary '','2022-06-17 17:04:06.392000'),('admin123',NULL,NULL,NULL,NULL,'admin','admin','$2a$10$4sB/TyZ6CF3XOQe7kuGvbulmeRdwA9EQ955bQbBaroVg/1vDn6Co2',NULL,NULL,NULL,'2022-06-17 14:10:22.573000'),('chanakyaLahiri','221B Baker Street, Pune 411041',NULL,'1994/06/27','chanakya@gmail.com','Chanakya','Lahiri','$2a$10$lkXn3anE3VVhP02cdIXBs.nG7XvDuZ5iF4CLaAavGAeUMh8nW25lO','9330689787',1234,_binary '','2022-06-15 11:28:48.516000'),('harryLahiri','P76 Barada Avenue Garia Kolkata 700084',NULL,'27/06/1994','harry@gmail.com','Harry','Lahiri','$2a$10$lkXn3anE3VVhP02cdIXBs.nG7XvDuZ5iF4CLaAavGAeUMh8nW25lO','9330689787',1234,_binary '','2022-06-15 11:25:40.764000');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_name`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('admin','Admin'),('admin123','Admin'),('chanakyaLahiri','User'),('harryLahiri','User');
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

-- Dump completed on 2022-06-17 18:57:52
