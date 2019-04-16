CREATE SCHEMA `shop`;

CREATE TABLE `shop`.`users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `secQues` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `shop`.`users` VALUES (1,'Arpit','arpit@altran.com','456123','gagan'),
(2,'Gagan','gagan@altran.com','789456','gagan');


CREATE TABLE `shop`.`wallet` (
  `user_id` int(11) NOT NULL,
  `balance` bigint(20) unsigned zerofill NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `shop`.`wallet` VALUES (1,10000000),(2,100000000);


CREATE TABLE `shop`.`furniture` (
  `furniture_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `type` varchar(45) NOT NULL,
  `room` varchar(45) NOT NULL,
  `price` int(11) NOT NULL DEFAULT '0',
  `image` varchar(500) DEFAULT 'default',
  PRIMARY KEY (`furniture_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `shop`.`furniture` VALUES (1,'SportsCar Bed','Bed','Kids',12000,'img2'),
(2,'Mahagony Table','Table','Living',40000,'img1'),
(3,'Gaming Chair','Chair','Bed',5000,'img3'),
(4,'Barcalounger','Sofa','Living',10000,'img4');


CREATE TABLE `shop`.`orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `furniture_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `totalAmount` bigint(20) DEFAULT '0',
  `orderDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `shop`.`orders` VALUES (1,1,1,2,24000,'2019-04-14 09:15:56'),
(2,2,1,5,200000,'2019-04-14 09:15:56'),
(3,3,1,2,10000,'2019-04-14 09:15:56');
