CREATE DATABASE  IF NOT EXISTS `Orders_directory`;
USE `Orders_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
   `product_id` int NOT NULL ,
   `number` int NOT NULL,
   `price` int NOT NULL,
   
  `client_id` int NOT NULL ,
  `salesman_id` int NOT NULL,
  `creation_time` datetime DEFAULT NULL,
  `is_authorised` bool DEFAULT false,
  `authorised_person_id` int ,
  `authorised_time` datetime,
   `is_finished` bool DEFAULT false,
   `finished_person_id` int ,
   `finished_time` datetime,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Data for table `employee`
--

INSERT INTO `orders` VALUES(1, 1, 2, 3, 4, 5, '1123-04-11 17:31:53', false, 2, '2222-04-11 17:31:53', false, 2, '2345-04-11 17:31:53'),
(2,1, 2, 3, 4, 5, '2262-04-11 17:31:53', false, 2, '2222-04-11 17:31:53', false, 2, '2345-04-11 17:31:53'),
(3, 2, 5, 8, 6, 7, '2222-04-11 17:31:53', false, 3, '2222-04-12 08:45:00', false, 3, '2345-04-12 08:45:00'),
(4, 3, 1, 5, 8, 9,'2222-04-11 17:31:53', false, 4, '2222-04-13 14:20:30', false, 4, '2345-04-13 14:20:30'),
(5, 1, 3, 6, 5, 6, '2222-04-11 17:31:53', false, 5, '2222-04-14 10:15:45', false, 5, '2345-04-14 10:15:45');