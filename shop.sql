CREATE SCHEMA `shop`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `balance` bigint(20) unsigned zerofill NOT NULL DEFAULT 0,
  `secQues` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);




INSERT INTO `shop`.`users` (`name`, `email`, `password`, `balance`, `secQues`) VALUES ('Arpit', 'arpit@altran.com', '456123', 10000, 'gagan');

CREATE TABLE `furniture` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `type` varchar(45) NOT NULL,
  `room` varchar(45) NOT NULL,
  `price` int(11) NOT NULL default '0',
  `image` varchar(500) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


