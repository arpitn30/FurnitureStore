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


CREATE  TABLE `shop`.`furniture` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(200) NOT NULL ,
  `type` VARCHAR(45) NOT NULL ,
  `room` VARCHAR(45) NOT NULL ,
  `price` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) );
