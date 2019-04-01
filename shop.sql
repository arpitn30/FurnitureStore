CREATE SCHEMA `shop`;

CREATE  TABLE `shop`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `balance` BIGINT ZEROFILL UNSIGNED NULL ,
  `security` VARCHAR(100) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
COMMENT = 'The tables to store the details of the users of the Online F' /* comment truncated */;

