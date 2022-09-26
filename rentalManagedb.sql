CREATE DATABASE  IF NOT EXISTS `rentalmanagedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rentalmanagedb`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: rentalmanagedb
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
  `country` varchar(5) DEFAULT NULL,
  `state` varchar(25) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `zip_code` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Nanded','INDIA','Maharashtra','P76, Hadgaon Road','431712'),(2,'Nanded','INDIA','Maharashtra','P76, Hadgaon Road','431712'),(3,'Nanded','INDIA','Maharashtra','H71, Hadgaon Main Road, off ganpati mandir','431712'),(4,'Nanded','INDIA','Maharashtra','H71, Hadgaon Main Road, off ganpati mandir','431712'),(5,'Nanded City','INDIA','Maharashtra','P56, Hadgaon Main Central Road','431712'),(6,'Nanded City','INDIA','Maharashtra','P56, Hadgaon Main Central Road','431712'),(7,'Nanded City','INDIA','Maharashtra','H15, Hadgaon Road','431712'),(8,'Nanded City','INDIA','Maharashtra','H15, Hadgaon Road','431712'),(9,'Nanded','INDIA','Maharashtra','M11/2, Hadgaon Main Road, Opposite of Shimla Mandir','431712'),(10,'Nanded','INDIA','Maharashtra','M11/2, Hadgaon Main Road, Opposite of Shimla Mandir','431712'),(11,'Nanded City','INDIA','Maharashtra','G39, Hadgaon Main Road, Opposite of manas society','431712'),(12,'Nanded City','INDIA','Maharashtra','G39, Hadgaon Main Road, Opposite of manas society','431712'),(13,'Nanded City','INDIA','Maharashtra','HG4/3, Hadgaon Side Road','431712'),(14,'Nanded City','INDIA','Maharashtra','HG4/3, Hadgaon Side Road','431712'),(15,'Nanded City','INDIA','Maharashtra','Y41/2, Hadgaon Main Road','431712'),(16,'Nanded City','INDIA','Maharashtra','Y41/2, Hadgaon Main Road','431712'),(17,'Nanded','INDIA','Maharashtra','K41, Hadgaon Main Road','431712'),(18,'Nanded','INDIA','Maharashtra','K41, Hadgaon Main Road','431712'),(19,'Nanded City','INDIA','Maharashtra','Hadgaon Main Road','431712'),(20,'Nanded City','INDIA','Maharashtra','Hadgaon Main Road','431712'),(21,'Nanded','INDIA','Maharashtra','H51, Hadgaon Road','431712'),(22,'Nanded','INDIA','Maharashtra','H51, Hadgaon Road','431712'),(23,'Hadgaon','INDIA','Maharashtra','Hadgaon Main Road, Nanded','431712'),(24,'Hadgaon','INDIA','Maharashtra','Hadgaon Main Road, Nanded','431712'),(25,'Nanded','INDIA','Maharashtra','P74, Hadgaon Main Road','431712'),(26,'Nanded','INDIA','Maharashtra','P74, Hadgaon Main Road','431712'),(27,'Nanded','INDIA','Maharashtra','Hadgaon main road ','431712'),(28,'Nanded','INDIA','Maharashtra','Hadgaon main road ','431712');
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
  `contact_admin_name` varchar(25) DEFAULT NULL,
  `contact_admin_purpose` varchar(100) DEFAULT NULL,
  `contact_admin_request_status` varchar(20) DEFAULT NULL,
  `contact_admin_updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`contact_admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_admin`
--

LOCK TABLES `contact_admin` WRITE;
/*!40000 ALTER TABLE `contact_admin` DISABLE KEYS */;
INSERT INTO `contact_admin` VALUES (1,'2022-06-18 01:55:27.114000','helloclahiri@gmail.com','requesting to send the materials faster for order number caf0eb36-a07c-411c-99f2-d59a1cdb898b','Harry Lahiri','Requesting to send materials faster','ACCEPTED','2022-09-07 02:04:10.872000'),(2,'2022-06-29 19:03:59.739000','helloclahiri@gmail.com','requesting to send the materials plus extra light bulbs','Harry Lahiri','Requesting to send extra light bulbs','ACCEPTED','2022-07-26 02:17:24.190000'),(4,'2022-07-12 15:35:48.926000','harry@gmail.com','I am about to order a new three day office package, could i get more bulbs. I need four more','Chanakya Lahiri','Requesting more bulbs','PENDING','2022-07-12 15:35:48.926000'),(5,'2022-07-22 01:11:51.727000','ved@gmail.com','I took a package from you guys. But didnt find any motorfans attached with the package','Vedanshoo Kadam','About the motors','PENDING','2022-07-22 01:11:51.727000'),(6,'2022-07-22 01:13:25.582000','ved@gmail.com','Ive ordered the items just now, send them asap faster','Vedanshoo Kadam','Request to Send material fast','PENDING','2022-07-22 01:13:25.582000'),(7,'2022-07-28 12:29:43.679000','manas@gmail.com','How would you like to be in a partnership business with me','Manas Ramachandran','Order accepted','REJECTED','2022-07-28 12:34:29.636000'),(8,'2022-08-20 02:53:54.953000','lata@gmail.com','Just ordered the item , need confirmation of the product within two days','Lata Naik','Just Ordered need clarification','PENDING','2022-08-20 02:53:54.953000'),(9,'2022-09-10 13:51:02.106000','rajkumari@gmail.com','I want to place my order of birthday package for twelve days but it is not available','Rajkumari','I want to know about my recent order','PENDING','2022-09-10 13:51:02.106000'),(10,'2022-09-19 01:22:13.864000','ved@gmail.com','bd2a7320-e898-48c8-bc2e-bbadd29b0f7e I just wanted to know the status of my order','Vedanshoo Kadam','About my recent order','PENDING','2022-09-19 01:22:13.864000');
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
  `contact_us_name` varchar(25) DEFAULT NULL,
  `contact_us_purpose` varchar(100) DEFAULT NULL,
  `contact_us_request_status` varchar(20) DEFAULT NULL,
  `contact_us_updated` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`contact_us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_us`
--

LOCK TABLES `contact_us` WRITE;
/*!40000 ALTER TABLE `contact_us` DISABLE KEYS */;
INSERT INTO `contact_us` VALUES (1,'2022-06-18 02:18:00.891000','hikyoffee@gmail.com','Need quotation for bachelors party at my place 1 day','Harold Lahiri','Quotation for bachelors party','ACCEPTED','2022-07-28 12:38:59.389000'),(2,'2022-07-12 14:28:52.679000','preeti@gmail.com','More information about latest packages please','Preeti Gill','Quotation for bachelors party','PENDING','2022-07-12 14:28:52.679000'),(3,'2022-07-12 14:33:31.012000','avi@gmail.com','Are there any combo offers for two day packages','Avinash Bindra','Enquiry of combo offers','ACCEPTED','2022-07-28 12:34:52.808000'),(4,'2022-07-13 13:43:28.219000','arijit@gmail.com','This is an enquiry email about your two day office party discounts','Arijit Sinha','Enquiry','PENDING','2022-07-13 13:43:28.219000'),(5,'2022-07-13 13:49:45.803000','hena@gmail.com','What is your lowest and best package','Hena Mukherjee','Enquiry about most lowest priced items','ACCEPTED','2022-07-30 11:50:16.308000'),(6,'2022-07-21 14:19:52.107000','ankita@gmail.com','I was wondering if there are any festival discounts coming up during the upcoming durga puja festival','Ankita Gupta','Enquiry about items','PENDING','2022-07-21 14:19:52.107000'),(7,'2022-07-21 14:23:59.658000','prithvi@gmail.com','Does the festival package also cover eid and muharram ones','Prithvi Raj','Inquiry about packages','PENDING','2022-07-21 14:23:59.658000'),(8,'2022-07-22 01:18:20.592000','usha@gmail.com','Any discounts for me','Usha Bose','How about discounts','PENDING','2022-07-22 01:18:20.592000'),(9,'2022-07-28 12:20:39.589000','aryanchhabra@gmail.com','Do you provide any custom discounts to people who wants to make partnership','Aryan Chhabra','Query in discounts','PENDING','2022-07-28 12:20:39.590000'),(10,'2022-07-30 11:36:30.300000','harshgupta@gmail.com','Could you email me about discounts in bachelors package','Harsh Gupta','Query about discounts','PENDING','2022-07-30 11:36:30.300000'),(11,'2022-08-20 02:36:52.034000','lata@gmail.com','how is the quantity in the packages.','Lata Naik','Quantity query','PENDING','2022-08-20 02:36:52.034000'),(12,'2022-09-10 13:46:12.960000','rajkumari@gmail.com','Could i subscribe to anything to know more about the packages','Rajkumari Jayaraman','Curios about packages','PENDING','2022-09-10 13:46:12.960000');
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
  `code` varchar(2) DEFAULT NULL,
  `name` varchar(5) DEFAULT NULL,
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
  `first_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Harry','Lahiri','harry@gmail.com'),(2,'Vedanshoo','Kadam','ved@gmail.com'),(3,'Manas','Ramachandran','manas@gmail.com'),(4,'Prithvi','Raj','prithvi@gmail.com'),(5,'Vishnu','Patel','vishnu@gmail.com'),(6,'Hrishikesh','Mukherjee','hrishikesh@gmail.com'),(7,'Lata','Naik','lata@gmail.com'),(8,'Rajkumari','Jayaraman','rajkumari@gmail.com');
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
  `newsletter_request_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`newsletter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsletter`
--

LOCK TABLES `newsletter` WRITE;
/*!40000 ALTER TABLE `newsletter` DISABLE KEYS */;
INSERT INTO `newsletter` VALUES (1,'2022-07-12 14:55:54.164000','chanakya@gmail.com','2022-08-08 00:20:35.745000','ACCEPTED'),(2,'2022-07-12 14:55:59.226000','hikyoffee@gmail.com','2022-07-12 14:55:59.226000','PENDING'),(3,'2022-07-12 14:56:03.584000','preetigill@gmail.com','2022-07-12 14:56:03.584000','PENDING'),(4,'2022-07-13 14:17:14.846000','nishant@gmail.com','2022-07-13 14:17:14.846000','PENDING'),(5,'2022-07-13 15:14:25.487000','amitrothade@gmail.com','2022-07-30 11:50:48.218000','ACCEPTED'),(6,'2022-07-14 02:01:46.558000','kamala@gmail.com','2022-07-14 02:01:46.559000','PENDING'),(7,'2022-07-14 02:03:01.140000','hariharan@gmail.com','2022-07-14 02:03:01.140000','PENDING'),(8,'2022-07-28 15:16:42.651000','accha@gmail.com','2022-07-28 15:16:42.651000','PENDING'),(9,'2022-07-30 11:34:32.610000','harshgupta@gmail.com','2022-07-30 11:34:32.610000','PENDING'),(10,'2022-08-15 22:24:55.883000','niti@gmail.com','2022-08-15 22:24:55.883000','PENDING'),(11,'2022-08-20 02:35:18.816000','lata@gmail.com','2022-08-20 02:35:57.613000','HOLD'),(12,'2022-08-20 10:43:26.183000','madhavi@gmail.com','2022-08-20 10:43:26.183000','PENDING'),(13,'2022-08-25 02:33:30.401000','sanky@gmail.com','2022-08-25 02:34:21.665000','ACCEPTED'),(14,'2022-09-07 01:53:15.706000','kiran@gmail.com','2022-09-07 01:53:15.706000','PENDING'),(15,'2022-09-10 13:46:37.827000','rajkumari@gmail.com','2022-09-10 13:46:37.827000','PENDING'),(16,'2022-09-12 22:53:59.502000','kalyan@gmail.com','2022-09-12 22:53:59.502000','PENDING'),(17,'2022-09-19 01:06:00.323000','muralimishra@gmail.com','2022-09-19 01:06:00.323000','PENDING'),(18,'2022-09-19 01:06:15.912000','pravingrewal@gmail.com','2022-09-19 01:06:15.912000','PENDING'),(19,'2022-09-19 01:06:26.563000','manasgola@gmail.com','2022-09-19 01:06:26.563000','PENDING'),(20,'2022-09-20 12:35:38.676000','das@gmail.com','2022-09-20 12:35:38.676000','PENDING');
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
  `unit_price` decimal(8,2) DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `K_order_id` (`order_id`),
  KEY `FK_product_id` (`product_id`),
  CONSTRAINT `FK_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,'assets/images/products/officeEvent/officeEvent.jpg',1,22000.00,1,32),(2,'assets/images/products/retirementEvent/retirementEvent.jpg',1,12000.00,2,40),(3,'assets/images/products/officeEvent/officeEvent.jpg',1,26000.00,3,33),(4,'assets/images/products/festivalEvent/festivalEvent.jpg',1,15000.00,4,8),(5,'assets/images/products/politicalEvent/politicalEvent.jpg',1,30000.00,5,35),(6,'assets/images/products/retirementEvent/retirementEvent.jpg',2,12000.00,6,40),(7,'assets/images/products/politicalEvent/politicalEvent.jpg',1,37000.00,7,36),(8,'assets/images/products/officeEvent/officeEvent.jpg',1,22000.00,8,32),(9,'assets/images/products/politicalEvent/politicalEvent.jpg',1,30000.00,9,35),(10,'assets/images/products/politicalEvent/politicalEvent.jpg',1,37000.00,9,36),(11,'assets/images/products/politicalEvent/politicalEvent.jpg',1,37000.00,10,36),(12,'assets/images/products/marriageEvent/marriageEvent.jpg',1,10000.00,11,2),(13,'assets/images/products/bachelorsEvent/bachelorsEvent.jpg',1,17000.00,12,21),(14,'assets/images/products/politicalEvent/politicalEvent.jpg',1,30000.00,13,35),(15,'assets/images/products/bachelorsEvent/bachelorsEvent.jpg',1,15000.00,14,20);
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
  `total_price` decimal(8,2) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'9987657d-14ee-4e47-98fb-6cf4b6532cd2',22000.00,1,1,1,2,'HOLD','2022-07-23 02:04:04.021000','2022-09-19 02:29:00.342000'),(2,'49569bb3-8a45-49bd-bf23-e9be4d99a2ae',12000.00,1,3,2,4,'ACCEPTED','2022-07-23 10:53:40.875000','2022-07-26 01:20:25.507000'),(3,'5f7f8832-e70d-43c4-8509-9037dca71e8e',26000.00,1,5,1,6,'PENDING','2022-07-27 13:09:43.453000','2022-07-27 13:09:43.453000'),(4,'4ee8071a-0787-49d6-8748-a71cf5cf4ba8',15000.00,1,7,2,8,'PENDING','2022-07-27 15:59:45.203000','2022-07-27 15:59:45.203000'),(5,'d1d85edf-d226-464d-af38-2ab6a1994ac0',30000.00,1,9,2,10,'PENDING','2022-07-27 18:26:59.829000','2022-07-27 18:26:59.829000'),(6,'d3e5388a-0af3-4738-9cdb-d71404fd343c',24000.00,2,11,3,12,'HOLD','2022-07-28 12:31:24.215000','2022-09-19 13:21:04.068000'),(7,'19b64b6c-55e6-4e04-b4f7-5b0da2617007',37000.00,1,13,4,14,'PENDING','2022-07-30 03:22:59.392000','2022-07-30 03:22:59.392000'),(8,'abf3485e-1be5-4de1-bb8d-29d68000a71b',22000.00,1,15,5,16,'PENDING','2022-07-30 11:47:00.732000','2022-07-30 11:47:00.732000'),(9,'dd6e62b9-db61-4373-8bf1-eda8c0d96159',67000.00,2,17,6,18,'PENDING','2022-08-11 17:10:50.753000','2022-08-11 17:10:50.753000'),(10,'9a770d79-cf44-48f1-8b95-73dca5c80d45',37000.00,1,19,7,20,'PENDING','2022-08-20 02:52:30.707000','2022-08-20 02:52:30.707000'),(11,'41425d8f-d396-4832-aeca-e7be4175f8d9',10000.00,1,21,8,22,'PENDING','2022-09-10 13:52:35.312000','2022-09-10 13:52:35.312000'),(12,'bd2a7320-e898-48c8-bc2e-bbadd29b0f7e',17000.00,1,23,2,24,'HOLD','2022-09-19 01:09:30.346000','2022-09-19 01:48:23.403000'),(13,'0e1553a9-8d9b-437d-bc3c-de6e4c673403',30000.00,1,25,2,26,'PENDING','2022-09-20 11:35:12.517000','2022-09-20 11:35:12.517000'),(14,'e7f158cc-27b2-4a63-b73e-1b7cdc3fc122',15000.00,1,27,2,28,'PENDING','2022-09-20 12:40:27.384000','2022-09-20 12:40:27.384000');
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
  `unit_price` decimal(8,2) DEFAULT NULL,
  `units_in_stock` int DEFAULT NULL,
  `product_category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKcwclrqu392y86y0pmyrsi649r` (`product_category_id`),
  CONSTRAINT `FKcwclrqu392y86y0pmyrsi649r` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,_binary '','2022-06-08 13:01:20.273000','Seven day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-08 13:01:20.273000','Marriage Pack (7Day)','20',35000.00,10,1),(2,_binary '','2022-06-11 11:04:08.802000','One day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:08.802000','Marriage Pack (1Day)','20',10000.00,10,1),(3,_binary '','2022-06-11 11:04:30.729000','Two day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:30.729000','Marriage Pack (2Day)','20',15000.00,10,1),(4,_binary '','2022-06-11 11:04:40.926000','Three day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:40.926000','Marriage Pack (3Day)','20',20000.00,10,1),(5,_binary '','2022-06-11 11:04:49.727000','Four day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:04:49.727000','Marriage Pack (4Day)','20',25000.00,10,1),(6,_binary '','2022-06-11 11:05:00.045000','Five day Marriage equipment package for upto 300 sqFeet area, including equipments (lighting, balloons, flowers, mandav, chairs and Dj) for celebrations','assets/images/products/marriageEvent/marriageEvent.jpg','2022-06-11 11:05:00.045000','Marriage Pack (5Day)','20',32000.00,10,1),(7,_binary '','2022-06-11 11:06:37.802000','One day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:06:37.802000','Festival Pack (1Day)','20',10000.00,10,2),(8,_binary '','2022-06-11 11:06:56.572000','Two day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:06:56.572000','Festival Pack (2Day)','20',15000.00,10,2),(9,_binary '','2022-06-11 11:07:09.870000','Three day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:09.870000','Festival Pack (3Day)','20',22000.00,10,2),(10,_binary '','2022-06-11 11:07:23.272000','Four day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:23.272000','Festival Pack (4Day)','20',27000.00,10,2),(11,_binary '','2022-06-11 11:07:36.668000','Five day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:36.668000','Festival Pack (5Day)','20',32000.00,10,2),(12,_binary '','2022-06-11 11:07:52.656000','Seven day Festival equipment package for upto 300+350 sqFeet area, including equipments (lighting, chandellior, stage, flowers, purahit, holymass) for celebrations and Puja','assets/images/products/festivalEvent/festivalEvent.jpg','2022-06-11 11:07:52.656000','Festival Pack (7Day)','20',45000.00,10,2),(13,_binary '','2022-06-11 11:13:10.075000','One day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:10.075000','Birthday Pack (1Day)','20',5000.00,10,3),(14,_binary '','2022-06-11 11:13:27.203000','Two day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:27.203000','Birthday Pack (2Day)','20',10000.00,10,3),(15,_binary '','2022-06-11 11:13:38.084000','Three day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:38.084000','Birthday Pack (3Day)','20',15000.00,10,3),(16,_binary '','2022-06-11 11:13:52.532000','Four day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:13:52.532000','Birthday Pack (4Day)','20',17000.00,10,3),(17,_binary '','2022-06-11 11:14:01.361000','Five day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:14:01.361000','Birthday Pack (5Day)','20',20000.00,10,3),(18,_binary '','2022-06-11 11:14:12.026000','Seven day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, balloons, hats, party poppers, confetti) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-06-11 11:14:12.026000','Birthday Pack (7Day)','20',23000.00,10,3),(19,_binary '','2022-06-19 01:53:59.273000','One day Bachelors day party package for upto 400+400 sqFeet area, including equipments (lighting, professional camera and video recorder, 2 cakes, balloons, hats, party poppers, confetti, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-06-19 01:53:59.273000','Bachelors Pack (1Day)','20',10000.00,10,4),(20,_binary '','2022-06-19 01:54:14.439000','Two day Bachelors day party package for upto 400+400 sqFeet area, including equipments (lighting, professional camera and video recorder, 2 cakes, balloons, hats, party poppers, confetti, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-06-19 01:54:14.439000','Bachelors Pack (2Day)','20',15000.00,10,4),(21,_binary '','2022-06-19 01:54:44.133000','Three day Bachelors day party package for upto 400+400 sqFeet area, including equipments (lighting, professional camera and video recorder, 2 cakes, balloons, hats, party poppers, confetti, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-06-19 01:54:44.133000','Bachelors Pack (3Day)','20',17000.00,10,4),(22,_binary '','2022-06-19 01:54:56.147000','Four day Bachelors day party package for upto 400+400 sqFeet area, including equipments (lighting, professional camera and video recorder, 2 cakes, balloons, hats, party poppers, confetti, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-06-19 01:54:56.147000','Bachelors Pack (4Day)','20',20000.00,10,4),(23,_binary '','2022-06-19 01:55:05.724000','Five day Bachelors day party package for upto 400+400 sqFeet area, including equipments (lighting, professional camera and video recorder, 2 cakes, balloons, hats, party poppers, confetti, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-06-19 01:55:05.724000','Bachelors Pack (5Day)','20',25000.00,10,4),(24,_binary '','2022-06-19 01:55:15.921000','Seven day Bachelors day party package for upto 400+400 sqFeet area, including equipments (lighting, professional camera and video recorder, 2 cakes, balloons, hats, party poppers, confetti, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-06-19 01:55:15.921000','Bachelors Pack (7Day)','20',30000.00,10,4),(25,_binary '','2022-06-19 02:00:47.285000','One day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-06-19 02:00:47.285000','Funeral Pack (1Day)','20',12000.00,10,5),(26,_binary '','2022-06-19 02:00:59.981000','Two day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-06-19 02:00:59.981000','Funeral Pack (2Day)','20',17000.00,10,5),(27,_binary '','2022-06-19 02:01:12.052000','Three day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-06-19 02:01:12.052000','Funeral Pack (3Day)','20',20000.00,10,5),(28,_binary '','2022-06-19 02:01:20.487000','Four day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-06-19 02:01:20.487000','Funeral Pack (4Day)','20',22000.00,10,5),(29,_binary '','2022-06-19 02:01:30.452000','Five day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-06-19 02:01:30.452000','Funeral Pack (5Day)','20',25000.00,10,5),(30,_binary '','2022-06-19 02:01:39.451000','Seven day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-06-19 02:01:39.451000','Funeral Pack (7Day)','20',27000.00,10,5),(31,_binary '','2022-06-19 02:03:57.892000','One day office space decorations and celebrations with 4 one pound chocolate cakes and festivity collections. A confetti filled floor with seperate office party hats. Memorable customized video (maximum length 5 mins)','assets/images/products/officeEvent/officeEvent.jpg','2022-06-19 02:03:57.892000','Office Pack (1Day)','20',20000.00,10,6),(32,_binary '','2022-06-19 02:04:10.748000','Two day office space decorations and celebrations with 4 one pound chocolate cakes and festivity collections. A confetti filled floor with seperate office party hats. Memorable customized video (maximum length 5 mins)','assets/images/products/officeEvent/officeEvent.jpg','2022-06-19 02:04:10.748000','Office Pack (2Day)','20',22000.00,10,6),(33,_binary '','2022-06-19 02:04:20.967000','three day office space decorations and celebrations with 4 one pound chocolate cakes and festivity collections. A confetti filled floor with seperate office party hats. Memorable customized video (maximum length 5 mins)','assets/images/products/officeEvent/officeEvent.jpg','2022-06-19 02:04:20.968000','Office Pack (3Day)','20',26000.00,10,6),(34,_binary '','2022-06-19 02:04:30.721000','Four day office space decorations and celebrations with 4 one pound chocolate cakes and festivity collections. A confetti filled floor with seperate office party hats. Memorable customized video (maximum length 5 mins)','assets/images/products/officeEvent/officeEvent.jpg','2022-06-19 02:04:30.721000','Office Pack (4Day)','20',30000.00,10,6),(35,_binary '','2022-06-19 02:06:07.127000','One day political maanch with main mic stand and 500x500 sq feet maanch space. JBL speaker set for proper sound and flowers and flower maala ( 20 pieces ) to collaborate the political event','assets/images/products/politicalEvent/politicalEvent.jpg','2022-06-19 02:06:07.127000','Political Pack (1Day)','20',30000.00,10,7),(36,_binary '','2022-06-19 02:07:12.726000','Two day political maanch with main mic stand and 500x500 sq feet maanch space. JBL speaker set for proper sound and flowers and flower maala ( 20 pieces ) to collaborate the political event','assets/images/products/politicalEvent/politicalEvent.jpg','2022-06-19 02:07:12.726000','Political Pack (2Day)','20',37000.00,10,7),(37,_binary '','2022-06-19 02:07:25.042000','Three day political maanch with main mic stand and 500x500 sq feet maanch space. JBL speaker set for proper sound and flowers and flower maala ( 20 pieces ) to collaborate the political event','assets/images/products/politicalEvent/politicalEvent.jpg','2022-06-19 02:07:25.042000','Political Pack (3Day)','20',40000.00,10,7),(38,_binary '','2022-06-19 02:07:34.067000','Four day political maanch with main mic stand and 500x500 sq feet maanch space. JBL speaker set for proper sound and flowers and flower maala ( 20 pieces ) to collaborate the political event','assets/images/products/politicalEvent/politicalEvent.jpg','2022-06-19 02:07:34.067000','Political Pack (4Day)','20',45000.00,10,7),(39,_binary '','2022-06-19 02:09:50.452000','One day retirement package with fun board games and winner prizes of reasonable choices. Retirement home celebrations include full confetti fever with fun balloons (20 pieces) and party poppers x2 ','assets/images/products/retirementEvent/retirementEvent.jpg','2022-06-19 02:09:50.452000','Retirement Pack (1Day)','20',10000.00,10,8),(40,_binary '','2022-06-19 02:10:02.505000','Two day retirement package with fun board games and winner prizes of reasonable choices. Retirement home celebrations include full confetti fever with fun balloons (20 pieces) and party poppers x2 ','assets/images/products/retirementEvent/retirementEvent.jpg','2022-06-19 02:10:02.505000','Retirement Pack (2Day)','20',12000.00,10,8),(41,_binary '','2022-06-19 02:10:12.648000','Three day retirement package with fun board games and winner prizes of reasonable choices. Retirement home celebrations include full confetti fever with fun balloons (20 pieces) and party poppers x2 ','assets/images/products/retirementEvent/retirementEvent.jpg','2022-06-19 02:10:12.648000','Retirement Pack (3Day)','20',15000.00,10,8),(42,_binary '','2022-06-19 02:10:24.445000','Four day retirement package with fun board games and winner prizes of reasonable choices. Retirement home celebrations include full confetti fever with fun balloons (20 pieces) and party poppers x2 ','assets/images/products/retirementEvent/retirementEvent.jpg','2022-06-19 02:10:24.445000','Retirement Pack (4Day)','20',20000.00,10,8),(43,_binary '','2022-06-19 02:10:34.084000','Five day retirement package with fun board games and winner prizes of reasonable choices. Retirement home celebrations include full confetti fever with fun balloons (20 pieces) and party poppers x2 ','assets/images/products/retirementEvent/retirementEvent.jpg','2022-06-19 02:10:34.084000','Retirement Pack (5Day)','20',25000.00,10,8),(44,_binary '','2022-06-19 02:10:43.932000','Six day retirement package with fun board games and winner prizes of reasonable choices. Retirement home celebrations include full confetti fever with fun balloons (20 pieces) and party poppers x2 ','assets/images/products/retirementEvent/retirementEvent.jpg','2022-06-19 02:10:43.932000','Retirement Pack (6Day)','20',27000.00,10,8),(45,_binary '','2022-06-19 02:10:53.704000','Seven day retirement package with fun board games and winner prizes of reasonable choices. Retirement home celebrations include full confetti fever with fun balloons (20 pieces) and party poppers x2 ','assets/images/products/retirementEvent/retirementEvent.jpg','2022-06-19 02:10:53.704000','Retirement Pack (7Day)','20',30000.00,10,8),(46,_binary '','2022-06-19 02:12:54.806000','One day sports package with location in vijendra stadium east gate. Full customized jerseys, with first, second and third prize trophies of steel. Including celebratory DJ afterwards. Towel x10, Chair x30 arrangements','assets/images/products/sportsEvent/sportsEvent.jpg','2022-06-19 02:12:54.806000','Sports Pack (1Day)','20',30000.00,10,9),(47,_binary '','2022-06-19 02:13:09.256000','Two day sports package with location in vijendra stadium east gate. Full customized jerseys, with first, second and third prize trophies of steel. Including celebratory DJ afterwards. Towel x10, Chair x30 arrangements','assets/images/products/sportsEvent/sportsEvent.jpg','2022-06-19 02:13:09.256000','Sports Pack (2Day)','20',35000.00,10,9),(48,_binary '','2022-06-19 02:13:18.768000','Three day sports package with location in vijendra stadium east gate. Full customized jerseys, with first, second and third prize trophies of steel. Including celebratory DJ afterwards. Towel x10, Chair x30 arrangements','assets/images/products/sportsEvent/sportsEvent.jpg','2022-06-19 02:13:18.768000','Sports Pack (3Day)','20',40000.00,10,9),(49,_binary '','2022-06-19 02:13:27.027000','Four day sports package with location in vijendra stadium east gate. Full customized jerseys, with first, second and third prize trophies of steel. Including celebratory DJ afterwards. Towel x10, Chair x30 arrangements','assets/images/products/sportsEvent/sportsEvent.jpg','2022-06-19 02:13:27.027000','Sports Pack (4Day)','20',45000.00,10,9),(50,_binary '','2022-06-19 02:13:36.542000','Five day sports package with location in vijendra stadium east gate. Full customized jerseys, with first, second and third prize trophies of steel. Including celebratory DJ afterwards. Towel x10, Chair x30 arrangements','assets/images/products/sportsEvent/sportsEvent.jpg','2022-06-19 02:13:36.542000','Sports Pack (5Day)','20',50000.00,10,9),(51,_binary '','2022-06-19 02:13:47.055000','Seven day sports package with location in vijendra stadium east gate. Full customized jerseys, with first, second and third prize trophies of steel. Including celebratory DJ afterwards. Towel x10, Chair x30 arrangements','assets/images/products/sportsEvent/sportsEvent.jpg','2022-06-19 02:13:47.055000','Sports Pack (7Day)','20',60000.00,10,9),(52,_binary '','2022-09-07 02:30:49.719000','Six day Marriage equipment package for upto 300 sqFeet area. Starting from the bridal shower to bridal makeup, only upto the haldi celebrations, the food preparations and afterparty costs seperate','assets/images/products/marriageEvent/marriageEvent.jpg','2022-09-07 02:30:49.719000','Marriage Pack (6Day)','20',27000.00,10,1),(53,_binary '','2022-09-07 02:33:52.755000','Ten day Marriage equipment package for upto 300 sqFeet area. Starting from the bridal shower to bridal makeup, only upto the haldi celebrations and continueing upto honeymoon seeoff','assets/images/products/marriageEvent/marriageEvent.jpg','2022-09-07 02:33:52.755000','Marriage Pack (10Day)','20',70000.00,10,1),(54,_binary '','2022-09-07 02:41:10.257000','Ten day Festival equipment package for upto 800 sqFeet area. Starting from agomoni to visarjan. Flower costs are not included','assets/images/products/festivalEvent/festivalEvent.jpg','2022-09-07 02:41:10.257000','Festival Pack (10Day)','20',50000.00,10,2),(55,_binary '','2022-09-07 02:41:45.636000','Twelve day Festival equipment package for upto 1000 sqFeet area. Starting from agomoni to visarjan. Flower costs are not included','assets/images/products/festivalEvent/festivalEvent.jpg','2022-09-07 02:41:45.636000','Festival Pack (12Day)','20',60000.00,10,2),(56,_binary '','2022-09-10 13:30:39.115000','Ten day Birthday celebration equipment package for upto 200+250 sqFeet area, including equipments (lighting, professional camera and video recorder, birthday cake, confetti, clown, premium movie) for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-09-10 13:30:39.115000','Birthday Pack (10Day)','21',70000.00,15,3),(57,_binary '','2022-09-10 13:32:55.546000','Fifteen day Birthday celebration package for upto 200+250 sqFeet area, personal movie and collage wallpapers with celebration balloons and confetti pre-existing celebrations in the room for making your birthday even more special','assets/images/products/birthdayEvent/birthdayEvent.jpg','2022-09-10 13:32:55.546000','Birthday Pack (15Day)','22',75000.00,10,3),(58,_binary '','2022-09-10 13:36:09.775000','Eight day Bachelors party package with personal city tours and 400+400 sqFeet area, including equipments (lighting, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-09-10 13:36:09.775000','Bachelors Pack (8Day)','22',35000.00,10,4),(59,_binary '','2022-09-10 13:36:45.801000','Ten day Bachelors party package with personal city tours and 400+400 sqFeet area, including equipments (lighting, DJ, projector) for making your bachelors party even more special','assets/images/products/bachelorsEvent/bachelorsEvent.jpg','2022-09-10 13:36:45.801000','Bachelors Pack (10Day)','22',45000.00,10,4),(60,_binary '','2022-09-10 13:38:25.491000','Eight day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-09-10 13:38:25.491000','Funeral Pack (8Day)','12',30000.00,10,5),(61,_binary '','2022-09-10 13:38:46.072000','Ten day Funeral arrangements pack with white clothes and ashan and chitra katha reading seminars with purahit Gita paath followed by remembrance and full scaled framed picture in memory of your loved one.','assets/images/products/funeralEvent/funeralEvent.jpg','2022-09-10 13:38:46.072000','Funeral Pack (10Day)','12',35000.00,10,5);
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
  `category_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'Marriage Event'),(2,'Festival Event'),(3,'Birthday Event'),(4,'Bachelors Event'),(5,'Funeral Event'),(6,'Office Event'),(7,'Political Event'),(8,'Retirement Event'),(9,'Sports Event');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_stock`
--

DROP TABLE IF EXISTS `product_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_stock` (
  `product_stock_id` int NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `product_quantity` int DEFAULT NULL,
  PRIMARY KEY (`product_stock_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_stock_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_stock`
--

LOCK TABLES `product_stock` WRITE;
/*!40000 ALTER TABLE `product_stock` DISABLE KEYS */;
INSERT INTO `product_stock` VALUES (1,1,20),(2,2,20),(3,3,45),(4,4,52),(5,5,11),(6,6,12),(7,7,14),(8,8,15),(9,9,30),(10,15,21);
/*!40000 ALTER TABLE `product_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_name` varchar(255) NOT NULL,
  `role_description` varchar(50) DEFAULT NULL,
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
  `name` varchar(27) DEFAULT NULL,
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
  `user_dob` varchar(50) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_first_name` varchar(25) DEFAULT NULL,
  `user_last_name` varchar(25) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone_number` varchar(12) DEFAULT NULL,
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
INSERT INTO `user` VALUES ('aartiKaar','B47, Hadgaon Road, Nanded 431712','2022-07-02 11:01:04.033000','2000-02-10','aarti@gmail.com','Aarti','Kaar','$2a$10$X2HhgL6w0Bg1ypMdX9T8p.EcGFlppLrrQogjZxaH5k1alQTlDKNTK','9495623156',1234,_binary '','2022-07-22 01:26:54.398000'),('admin','Nanded District, Hadgaon',NULL,'01/02/1980','admin@gmail.com','Mr','Jaiswal','$2a$10$BiiM28L4O5Rws6v30q2pbeeC.43/.kHZgXWgQUW8fDDWGlEA7PSsW','9330689787',9696,_binary '','2022-09-20 12:06:50.017000'),('chanakyaLahiri','221B Baker Street, Nanded 431712','2022-08-07 10:18:04.033000','1994/06/27','chanakya@gmail.com','Chanakya','Lahiri','$2a$10$lkXn3anE3VVhP02cdIXBs.nG7XvDuZ5iF4CLaAavGAeUMh8nW25lO','9330689787',1234,_binary '','2022-06-15 11:28:48.516000'),('harryLahiri','P76 Barada Avenue Garia Hadgaon 431712','2022-08-04 15:18:04.033000','1994-06-27','harry@gmail.com','Harry','Lahiri','$2a$10$lkXn3anE3VVhP02cdIXBs.nG7XvDuZ5iF4CLaAavGAeUMh8nW25lO','9330689785',1234,_binary '','2022-08-15 22:26:10.833000'),('hrishikeshMukherjee','P41 Hadgaon Road, upper west side','2022-07-02 17:28:04.033000','2000-09-25','hrishikesh@gmail.com','Hrishikesh','Mukherjee','$2a$10$38X6mPF0KtoYNgYK1IEkheguneZK.vn07LdBK9Bff9zFyKDMS29GC','9330689783',1234,_binary '','2022-07-08 15:52:23.911000'),('hritickAmbani','P44, Hadgaon Road, Pune 431712','2022-08-07 19:33:04.033000','1994/06/27','hritick@gmail.com','Hritick','Ambani','$2a$10$UKBlBH1e8mIE/.5da66Qd.lW/jgP5yNgRaR1o7jLqH754TGYpb3pW','9330689782',1234,_binary '','2022-07-08 16:12:39.181000'),('latanaik','H41, Hadgaon Road, Nanded 431712','2022-08-20 02:38:22.141000','2006-11-16','lata@gmail.com','Lata','Naik','$2a$10$MUDZC8TPs2iFMWiL4lJKA.rmtvcmOKg2LOzzLeYPg9cziD0e42xpW','9553214587',1234,_binary '','2022-08-20 02:50:19.218000'),('manasRamachandran','G39, Hadgaon Road, Nanded','2022-02-07 01:18:04.033000','1992-11-19','manas@gmail.com','Manas','Ramachandran','$2a$10$qWvltO0Vk0SEMLT/vj7useaQnnSsPC/HF7rdkDWvi0hrbjj76SD2u','9445210364',1234,_binary '','2022-07-28 12:24:52.529000'),('nikitaBhushan','K1, Hadgaon Road, Nanded 431712','2022-04-17 15:18:04.033000','1993-02-02','nikita@gmail.com','Nikita','Bhushan','$2a$10$uw2ZAlT0r.Oa5uVM92vVXesBhkzQhPlqf/qSt2G2qerlCsoBlMKCe','9596919293',3214,_binary '','2022-07-21 14:32:18.939000'),('nishantDeshmukh','P79, Hadgaon Road Hadgaon 431712','2022-03-11 06:20:04.033000','2000-05-09','nishant@gmail.com','Nishant','Deshmukh','passwordResetHappened','9123602544',1234,_binary '','2022-07-13 14:12:49.833000'),('prithviRaj','P11, Hadgaon Road, Nanded 431712','2022-03-07 15:30:04.033000','1996-10-17','prithvi@gmail.com','Prithvi','Raj','$2a$10$94L8cWPZ155BmX6Sch51R.MuNUTDbxFLhQnginPqUSbzyuJvnssQS','9596929391',1234,_binary '','2022-07-21 14:26:10.494000'),('rajkumariJayaraman','I45, Barada Park, Hadgaon 431712','2022-09-10 13:47:56.364000','1993-11-18','rajkumari@gmail.com','Rajkumari','Jayaraman','$2a$10$UMDyJP9nwWTbDFTOERmME.Mu3HqJTaoQZWLrVlclEsqs1jVFL8xsG','9566523215',1234,_binary '','2022-09-10 13:47:56.376000'),('rameshKulkarni','H9, Hadgaon Main Road, Nanded 431712','2022-08-07 15:18:04.033000','2004-10-10','rameshkulkarni@gmail.com','Ramesh','Kulkarni','$2a$10$0bJyhrg9.Y9byYz8vuHjlO68E7YQLwAZZela4y0CbEGKbNPJgz0wm','9951223564',1234,_binary '','2022-08-07 15:18:04.068000'),('vedanshooKadam','P54, Hadgaon Road, Nanded 43172','2022-05-22 09:08:04.033000','1989-11-17','ved@gmail.com','Vedanshoo','Kadam','$2a$10$94L8cWPZ155BmX6Sch51R.MuNUTDbxFLhQnginPqUSbzyuJvnssQS','9330689784',1234,_binary '','2022-09-20 12:42:51.085000'),('vinodSood','P14, Hadgaon Road, Nanded 431712','2022-05-10 12:18:04.033000','1993/10/02','vinod@gmail.com','Vinod','Sood','passwordResetHappened','7030631963',1234,_binary '','2022-07-21 14:42:37.516000'),('vishnuPatel','Y41/2, Hadgaon Road, Nanded 431712','2022-01-17 22:04:04.033000','1992-11-12','vishnu@gmail.com','Vishnu','Patel','$2a$10$p1pta0TmtJ17FnLoXm5o2e5/SP87OFjP7HtNQLCSTyeOd.c2ED/fC','9552623300',1234,_binary '','2022-07-30 11:39:36.105000');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL,
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
INSERT INTO `user_role` VALUES ('admin','Admin'),('aartiKaar','User'),('chanakyaLahiri','User'),('harryLahiri','User'),('hrishikeshMukherjee','User'),('hritickAmbani','User'),('latanaik','User'),('manasRamachandran','User'),('nikitaBhushan','User'),('nishantDeshmukh','User'),('prithviRaj','User'),('rajkumariJayaraman','User'),('rameshKulkarni','User'),('vedanshooKadam','User'),('vinodSood','User'),('vishnuPatel','User');
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

-- Dump completed on 2022-09-26 13:59:39
