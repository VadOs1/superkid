-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: superkid_local
-- ------------------------------------------------------
-- Server version	5.7.8-rc-log

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
-- Table structure for table `order_clients`
--

DROP TABLE IF EXISTS `order_clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_clients` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_clients`
--

LOCK TABLES `order_clients` WRITE;
/*!40000 ALTER TABLE `order_clients` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_statuses`
--

DROP TABLE IF EXISTS `order_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_statuses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_statuses`
--

LOCK TABLES `order_statuses` WRITE;
/*!40000 ALTER TABLE `order_statuses` DISABLE KEYS */;
INSERT INTO `order_statuses` VALUES (1,'Новый'),(2,'В работе'),(3,'Доставка'),(4,'Заказ закрыт'),(6,'Отказ клиента');
/*!40000 ALTER TABLE `order_statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `order_status` int(2) unsigned NOT NULL,
  `client_id` int(10) unsigned NOT NULL,
  `shipping_address` varchar(100) NOT NULL,
  `shipping_details` varchar(200) NOT NULL,
  `comments` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs58p4hybhraufrjn6g3sstywl` (`client_id`),
  KEY `FK54qn2rttxg5s7o4w5h5lrv9x6` (`order_status`),
  CONSTRAINT `FK54qn2rttxg5s7o4w5h5lrv9x6` FOREIGN KEY (`order_status`) REFERENCES `order_statuses` (`id`),
  CONSTRAINT `FKs58p4hybhraufrjn6g3sstywl` FOREIGN KEY (`client_id`) REFERENCES `order_clients` (`id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `order_clients` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`order_status`) REFERENCES `order_statuses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_categories`
--

DROP TABLE IF EXISTS `product_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_categories` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_categories`
--

LOCK TABLES `product_categories` WRITE;
/*!40000 ALTER TABLE `product_categories` DISABLE KEYS */;
INSERT INTO `product_categories` VALUES (1,'Кидсы','<br>\nУдобные и модные детские Кидсы <br><br>\n\nЛегкие, красивые, яркие <br><br>\n\nОтличное качество<br><br>\n\nВаш малыш будет в восторге <br><br>\n\nМатериал: полимер на основе мягкого  пластика <br><br>\n\nСтрана производитель: Гонконг <br><br>\n\nВ наличии все размеры: <br><br>\n\n24 размер, 2,5 года, стопа 14,6 см<br>\n25 размер, 2,5 — 3 года, стопа 15,3 см<br>\n26 размер, 3 — 4 года, стопа 16,5 см <br>\n27 размер, 4 — 4,5 года, стопа 17,3 см <br>\n28 размер, 4,5 — 5 лет, стопа 17,6 см <br>\n29 размер, 5-6 лет, стопа 18,5 см<br><br>\n\nДоставка: <br><br>\n\n— самовывоз по адресу г.Киев, пр. Бажана 10 (метро Осокорки) — бесплатно <br>\n— доставка курьером до любой станции метро (г. Киев) — 20 грн <br>\n— доставка курьером по указанному адресу (г.Киев) — 30 грн <br>\n— доставка Укрпочтой или Новой Почтой в любой город Украины — 25 грн <br><br>\n\nОплата: <br><br>\n— наличными курьеру при получении товара <br>\n— предоплата на карточку Приватбанка <br>'),(2,'Пижамы','<br> Детская пижама с длинным рукавом + длинные брюки (комплект) <br><br>\n\nЛегкая, теплая, уютная, красивая и яркая<br><br>\n\nОтличное качество<br><br>\n\nВаш малыш будет в восторге<br><br>\n\nМатериал: 100% хлопок <br><br>\n\nСтрана производитель: Гонконг <br><br>\n\nВ наличии все размеры: <br><br>\n\nРазмер 2Т (2 года) — Рост- 90 см<br>\nРазмер 3Т (3 года) — Рост — 95 см<br>\nРазмер 4т (4 года) — Рост — 100 см<br>\nРазмер 5т (5 лет) — Рост — 110 см<br>\nРазмер 6т (6 лет) — Рост — 120 см<br>\nРазмер-7т (7 лет) — Рост — 130 см<br><br>\n\n<div class = \"hidden-xs\">\n<br>\n<img src=\"/resources/img/sizes/ironman.png\">\n<img src=\"/resources/img/sizes/superman.png\">\n<img src=\"/resources/img/sizes/spiderman.png\">\n<img src=\"/resources/img/sizes/hellokitty.png\">\n<br>\n<br>\n</div>\nДоставка:<br><br>\n\n— самовывоз по адресу г.Киев, пр. Бажана 10 (метро Осокорки) — бесплатно <br>\n— доставка курьером до любой станции метро (г. Киев) — 20 грн <br>\n— доставка курьером по указанному адресу (г.Киев) — 30 грн<br>\n— доставка Укрпочтой или Новой Почтой в любой город Украины — 25 грн<br><br>\n\nОплата:<br><br>\n— наличными курьеру при получении товара<br>\n— предоплата на карточку Приватбанка<br>'),(3,'Трусики','<br>Детские трусики-боксеры для мальчиков<br><br>\n\nВ серии представлены трусы с различными принтами: Angry birds, Cars, Spiderman, SpongeBob, Mickey Mouse, Doreamon, Thomas<br><br>\n\nЗадняя сторона трусиков однотонная<br><br>\n\nВаш малыш будет в восторге<br><br>\n\nОтличное качество<br><br>\n\nМатериал: 100% хлопок<br><br>\n\nСтрана производитель: Гонконг<br><br>\n\nВ наличии размеры:<br><br>\n\nРазмер S, рост 100-110 см, талия 22 см * 2, 4-6 лет<br>\nРазмер M, рост 110-120 см, талия 24 см * 2, 7-8 лет<br>\nРазмер L, рост 120-130 см, талия 26 см * 2, 9-10 лет<br><br>\n\nДоставка:<br><br>\n\n— самовывоз по адресу г.Киев, пр. Бажана 10 (метро Осокорки) — бесплатно<br>\n— доставка курьером до любой станции метро (г. Киев) — 20 грн<br>\n— доставка курьером по указанному адресу (г.Киев) — 30 грн<br>\n— доставка Укрпочтой или Новой Почтой в любой город Украины — 25 грн<br><br>\n\nОплата:<br><br>\n— наличными курьеру при получении товара<br>\n— предоплата на карточку Приватбанка<br>');
/*!40000 ALTER TABLE `product_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `article` int(10) unsigned NOT NULL,
  `photo_link_short` varchar(100) NOT NULL,
  `photo_link_long` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES (1,'Купить Кидсы (цвет голубой)',300101,'/img/kids/preview/01blue185X185.png','/img/kids/01blue500X500.jpg'),(2,'Купить Кидсы (цвет бело-розовый)',300102,'/img/kids/preview/02white-pink185X185.png','/img/kids/02white-pink500X500.jpg'),(3,'Купить Кидсы (цвет желтый)',300103,'/img/kids/preview/03yellow185X185.png','/img/kids/03yellow500X500.jpg'),(4,'Купить Кидсы (цвет желто-зеленый)',300104,'/img/kids/preview/04yellow-green185X185.png','/img/kids/04yellowgreen500X500.jpg'),(5,'Купить Кидсы (цвет белый)',300105,'/img/kids/preview/05white185X185.png','/img/kids/05white500X500.jpg'),(6,'Купить Кидсы (цвет желто-голубые)',300106,'/img/kids/preview/06blue-yellow185X185.png','/img/kids/06blue-yellow500X500.jpg'),(7,'Купить Кидсы (цвет розовый)',300107,'/img/kids/preview/07pink185X185.png','/img/kids/07pink500X500.jpg'),(8,'Купить Кидсы (цвет салатовый)',300108,'/img/kids/preview/08green185X185.png','/img/kids/08green500X500.jpg'),(9,'Купить детскую пижаму железный человек (ironman)',400101,'/img/pajamas/preview/01ironman185X185.png','/img/pajamas/01ironman500X500.png'),(10,'Купить детскую пижаму человек паук (spiderman)',400102,'/img/pajamas/preview/02spiderman185X185.png','/img/pajamas/02spiderman500X500.png'),(11,'Купить детскую пижаму супермена',400103,'/img/pajamas/preview/03superman185X185.png','/img/pajamas/03superman500X500.png'),(12,'Купить детскую пижаму корпорация монстров',400104,'/img/pajamas/preview/04monsters185X185.png','/img/pajamas/04monsters500X500.png'),(13,'Купить детскую пижаму Hello Kitty',400105,'/img/pajamas/preview/05hellokitty185X185.png','/img/pajamas/05hellokitty500X500.png'),(14,'Купить детскую пижаму Hello Kitty Just Dance',400106,'/img/pajamas/preview/06hellokitty185X185.png','/img/pajamas/06hellokitty500X500.png'),(15,'Купить детскую пижаму Hello Kitty Old Navy',400107,'/img/pajamas/preview/07hellokitty185X185.png','/img/pajamas/07hellokitty500X500.png'),(16,'Купить детские трусики Angry Birds',500101,'/img/panties/preview/01angrybirds185X185.png','/img/panties/01angrybirds500X500.jpg'),(17,'Купить детские трусики Cars (тачки)',500102,'/img/panties/preview/02cars185X185.png','/img/panties/02cars500X500.jpg'),(18,'Купить детские трусики Doraemon',500103,'/img/panties/preview/03doreamon185X185.png','/img/panties/03doreamon500X500.jpg'),(19,'Купить детские трусики Mickey Mouse',500104,'/img/panties/preview/04mickey185X185.png','/img/panties/04mickey500X500.jpg'),(20,'Купить детские трусики Spiderman',500105,'/img/panties/preview/05spiderman185X185.png','/img/panties/05spiderman500X500.jpg'),(21,'Купить детские трусики Паровозик Томас',500106,'/img/panties/preview/06thomas185X185.png','/img/panties/06thomas500X500.jpg'),(22,'Купить детские трусики Спанч Боб',500107,'/img/panties/preview/07spanchbob185X185.png','/img/panties/07spanchbob500X500.jpg'),(23,'Купить детские трусики набор 4 штуки',500108,'/img/panties/preview/08mix185X185.png','/img/panties/08mix500X500.jpg'),(24,'Купить детскую пижаму Hello Kitty',400108,'/img/pajamas/preview/08hellokitty185X185.png','/img/pajamas/08hellokitty500X500.png');
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_sizes`
--

DROP TABLE IF EXISTS `product_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_sizes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `size` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_sizes`
--

LOCK TABLES `product_sizes` WRITE;
/*!40000 ALTER TABLE `product_sizes` DISABLE KEYS */;
INSERT INTO `product_sizes` VALUES (1,'[24 размер, 2,5 года, стопа 14,6 см]'),(2,'[25 размер, 2,5 - 3 года, стопа 15,3 см]'),(3,'[26 размер, 3 - 4 года, стопа 16,5 см]'),(4,'[27 размер, 4 - 4,5 года, стопа 17,3 см]'),(5,'[28 размер, 4,5 - 5 лет, стопа 17,6 см]'),(6,'[29 размер, 5-6 лет, стопа 18,5 см]'),(7,'[2T, рост 90 см, 2 года]'),(8,'[3T, рост 95 см, 3 года]'),(9,'[4T, рост 100 см, 4 года]'),(10,'[5T, рост 110 см, 5 лет]'),(11,'[6T, рост 120 см, 6 лет]'),(12,'[7T, рост 130 см, 7 лет]'),(13,'[размер S, рост 100-110 см, талия 22 см * 2, 4-6 лет]'),(14,'[размер M, рост 110-120 см, талия 24 см * 2, 7-8 лет]'),(15,'[размер L, рост 120-130 см, талия 26 см * 2, 9-10 лет]');
/*!40000 ALTER TABLE `product_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_info_id` int(10) unsigned DEFAULT NOT NULL,
  `product_category_id` int(10) unsigned NOT NULL,
  `product_size_id` int(10) unsigned NOT NULL,
  `price` decimal(7,2) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe05mpyhp4howtq8q4s65wm3q8` (`product_category_id`),
  KEY `FKnpuuouiy0uguykbmytyji9agw` (`product_info_id`),
  KEY `FKhvfanagj0wv3d5h0f6ks7gp4y` (`product_size_id`),
  CONSTRAINT `FKe05mpyhp4howtq8q4s65wm3q8` FOREIGN KEY (`product_category_id`) REFERENCES `product_categories` (`id`),
  CONSTRAINT `FKhvfanagj0wv3d5h0f6ks7gp4y` FOREIGN KEY (`product_size_id`) REFERENCES `product_sizes` (`id`),
  CONSTRAINT `FKnpuuouiy0uguykbmytyji9agw` FOREIGN KEY (`product_info_id`) REFERENCES `product_info` (`id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`product_info_id`) REFERENCES `product_info` (`id`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`product_category_id`) REFERENCES `product_categories` (`id`),
  CONSTRAINT `products_ibfk_3` FOREIGN KEY (`product_size_id`) REFERENCES `product_sizes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,1,1,415.00,0),(2,1,1,2,415.00,0),(3,1,1,3,415.00,0),(4,1,1,4,415.00,0),(5,1,1,5,415.00,0),(6,1,1,6,415.00,0),(7,2,1,1,415.00,0),(8,2,1,2,415.00,0),(9,2,1,3,415.00,0),(10,2,1,4,415.00,0),(11,2,1,5,415.00,0),(12,2,1,6,415.00,0),(13,3,1,1,415.00,0),(14,3,1,2,415.00,0),(15,3,1,3,415.00,0),(16,3,1,4,415.00,0),(17,3,1,5,415.00,0),(18,3,1,6,415.00,0),(19,4,1,1,415.00,0),(20,4,1,2,415.00,0),(21,4,1,3,415.00,0),(22,4,1,4,415.00,0),(23,4,1,5,415.00,0),(24,4,1,6,415.00,0),(25,5,1,1,415.00,0),(26,5,1,2,415.00,0),(27,5,1,3,415.00,0),(28,5,1,4,415.00,0),(29,5,1,5,415.00,0),(30,5,1,6,415.00,0),(31,6,1,1,415.00,0),(32,6,1,2,415.00,0),(33,6,1,3,415.00,0),(34,6,1,4,415.00,0),(35,6,1,5,415.00,0),(36,6,1,6,415.00,0),(37,7,1,1,415.00,0),(38,7,1,2,415.00,0),(39,7,1,3,415.00,0),(40,7,1,4,415.00,0),(41,7,1,5,415.00,0),(42,7,1,6,415.00,0),(43,8,1,1,415.00,0),(44,8,1,2,415.00,0),(45,8,1,3,415.00,0),(46,8,1,4,415.00,0),(47,8,1,5,415.00,0),(48,8,1,6,415.00,0),(49,9,2,7,315.00,0),(50,9,2,8,315.00,0),(51,9,2,9,315.00,0),(52,9,2,10,315.00,0),(53,9,2,11,315.00,0),(54,9,2,12,315.00,0),(55,10,2,7,350.00,0),(56,10,2,8,350.00,0),(57,10,2,9,350.00,0),(58,10,2,10,350.00,0),(59,10,2,11,350.00,0),(60,10,2,12,350.00,0),(61,11,2,7,350.00,0),(62,11,2,8,350.00,0),(63,11,2,9,350.00,0),(64,11,2,10,350.00,0),(65,11,2,11,350.00,0),(66,11,2,12,350.00,0),(67,12,2,7,315.00,0),(68,12,2,8,315.00,0),(69,12,2,9,315.00,0),(70,12,2,10,315.00,0),(71,12,2,11,315.00,0),(72,12,2,12,315.00,0),(73,13,2,7,315.00,0),(74,13,2,8,315.00,0),(75,13,2,9,315.00,0),(76,13,2,10,315.00,0),(77,13,2,11,315.00,0),(78,13,2,12,315.00,0),(79,14,2,7,315.00,0),(80,14,2,8,315.00,0),(81,14,2,9,315.00,0),(82,14,2,10,315.00,0),(83,14,2,11,315.00,0),(84,14,2,12,315.00,0),(85,15,2,7,350.00,0),(86,15,2,8,350.00,0),(87,15,2,9,350.00,0),(88,15,2,10,350.00,0),(89,15,2,11,350.00,0),(90,15,2,12,350.00,0),(91,24,2,7,350.00,0),(92,24,2,8,350.00,0),(93,24,2,9,350.00,0),(94,24,2,10,350.00,0),(95,24,2,11,350.00,0),(96,24,2,12,350.00,0),(97,16,3,13,85.00,0),(98,16,3,14,85.00,0),(99,16,3,15,85.00,0),(100,17,3,13,85.00,0),(101,17,3,14,85.00,0),(102,17,3,15,85.00,0),(103,18,3,13,85.00,0),(104,18,3,14,85.00,0),(105,18,3,15,85.00,0),(106,19,3,13,85.00,0),(107,19,3,14,85.00,0),(108,19,3,15,85.00,0),(109,20,3,13,85.00,0),(110,20,3,14,85.00,0),(111,20,3,15,85.00,0),(112,21,3,13,85.00,0),(113,21,3,14,85.00,0),(114,21,3,15,85.00,0),(115,22,3,13,85.00,0),(116,22,3,14,85.00,0),(117,22,3,15,85.00,0),(118,23,3,13,275.00,0),(119,23,3,14,275.00,0),(120,23,3,15,275.00,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `price` decimal(7,2) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgxrnhq2tp53byfqurssompdvg` (`order_id`),
  KEY `FKkxc13g7l4ioljxqyoo15nh051` (`product_id`),
  CONSTRAINT `FKgxrnhq2tp53byfqurssompdvg` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKkxc13g7l4ioljxqyoo15nh051` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-05 16:45:46
