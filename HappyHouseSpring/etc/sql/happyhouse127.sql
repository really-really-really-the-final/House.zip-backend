-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema happyhouse127
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse127
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse127` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happyhouse127` ;

-- -----------------------------------------------------
-- Table `happyhouse127`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`sido` (
  `sidoCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sidoCode`),
  UNIQUE INDEX `sidoName` (`sidoName` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`dong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`dong` (
  `dongCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`dongCode`),
  INDEX `sidoName` (`sidoName` ASC) VISIBLE,
  CONSTRAINT `dongcode_ibfk_1`
    FOREIGN KEY (`sidoName`)
    REFERENCES `happyhouse127`.`sido` (`sidoName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`userinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`userinfo` (
  `id` VARCHAR(15) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NULL DEFAULT NULL,
  `isManager` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`favorite` (
  `userid` VARCHAR(15) NOT NULL,
  `dongCode` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`userid`, `dongCode`),
  INDEX `fk_favorite_userinfo1_idx` (`userid` ASC) VISIBLE,
  INDEX `fk_favorite_dong1_idx` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `fk_favorite_dong1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse127`.`dong` (`dongCode`),
  CONSTRAINT `fk_favorite_userinfo1`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse127`.`userinfo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`gugun` (
  `gugunCode` VARCHAR(10) NOT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`gugunCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`houseinfo` (
  `aptCode` INT NOT NULL,
  `aptName` VARCHAR(50) NULL DEFAULT NULL,
  `dongCode` VARCHAR(10) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  `buildYear` INT NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  `img` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`aptCode`),
  INDEX `dongCode` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `houseinfo_ibfk_1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse127`.`dong` (`dongCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`housedeal` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `aptCode` INT NULL DEFAULT NULL,
  `dealAmount` VARCHAR(20) NULL DEFAULT NULL,
  `dealYear` INT NULL DEFAULT NULL,
  `dealMonth` INT NULL DEFAULT NULL,
  `dealDay` INT NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `aptCode` (`aptCode` ASC) VISIBLE,
  CONSTRAINT `housedeal_ibfk_1`
    FOREIGN KEY (`aptCode`)
    REFERENCES `happyhouse127`.`houseinfo` (`aptCode`))
ENGINE = InnoDB
AUTO_INCREMENT = 68865
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`notice` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(15) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `regtime` TIMESTAMP NOT NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_notice_userinfo1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_notice_userinfo1`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse127`.`userinfo` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`storeinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`storeinfo` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `category` VARCHAR(10) NULL DEFAULT NULL,
  `dongCode` VARCHAR(10) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_storeinfo_dongcode1_idx` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `fk_storeinfo_dongcode1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `happyhouse127`.`dong` (`dongCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse127`.`qna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse127`.`qna` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(15) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `asktime` TIMESTAMP NOT NULL,
  `masterid` VARCHAR(15) NULL DEFAULT NULL,
  `anscontent` TEXT NULL DEFAULT NULL,
  `anstime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `fk_qna_userinfo1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_qna_userinfo1`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse127`.`userinfo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
