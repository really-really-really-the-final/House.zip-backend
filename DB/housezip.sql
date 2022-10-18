-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema housezip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema housezip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `housezip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `housezip` ;

-- -----------------------------------------------------
-- Table `housezip`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`sido` (
  `sidoCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sidoCode`),
  UNIQUE INDEX `sidoName` (`sidoName` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`dong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`dong` (
  `dongCode` VARCHAR(10) NOT NULL,
  `sidoName` VARCHAR(30) NULL DEFAULT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`dongCode`),
  INDEX `sidoName` (`sidoName` ASC) VISIBLE,
  CONSTRAINT `dongcode_ibfk_1`
    FOREIGN KEY (`sidoName`)
    REFERENCES `housezip`.`sido` (`sidoName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`gugun` (
  `gugunCode` VARCHAR(10) NOT NULL,
  `gugunName` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`gugunCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`housedeal` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `aptCode` INT NULL DEFAULT NULL,
  `dealAmount` VARCHAR(20) NULL DEFAULT NULL,
  `dealYear` INT NULL DEFAULT NULL,
  `dealMonth` INT NULL DEFAULT NULL,
  `dealDay` INT NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `dealType` VARCHAR(10) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `aptFK_idx` (`aptCode` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 85354
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`houseinfo` (
  `aptCode` INT NOT NULL,
  `aptName` VARCHAR(50) NULL DEFAULT NULL,
  `dongCode` VARCHAR(10) NULL DEFAULT NULL,
  `dongName` VARCHAR(30) NULL DEFAULT NULL,
  `buildYear` VARCHAR(10) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `infoType` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`aptCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`userinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`userinfo` (
  `id` VARCHAR(15) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NULL DEFAULT NULL,
  `isManager` TINYINT NULL DEFAULT '0',
  `category` VARCHAR(100) NULL DEFAULT NULL,
  `interestSidoCode` VARCHAR(10) NULL DEFAULT NULL,
  `interestGugunCode` VARCHAR(10) NULL DEFAULT NULL,
  `isReview` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`interestarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`interestarea` (
  `userid` VARCHAR(15) NOT NULL,
  `dongCode` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`userid`, `dongCode`),
  INDEX `fk_favorite_userinfo1_idx` (`userid` ASC) VISIBLE,
  INDEX `fk_favorite_dong1_idx` (`dongCode` ASC) VISIBLE,
  CONSTRAINT `fk_interest_dong1`
    FOREIGN KEY (`dongCode`)
    REFERENCES `housezip`.`dong` (`dongCode`),
  CONSTRAINT `fk_interest_userinfo1`
    FOREIGN KEY (`userid`)
    REFERENCES `housezip`.`userinfo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`notice` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(15) NOT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  `regtime` TIMESTAMP NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT '0',
  PRIMARY KEY (`no`),
  INDEX `fk_notice_userinfo1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_notice_userinfo1`
    FOREIGN KEY (`userid`)
    REFERENCES `housezip`.`userinfo` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 215
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`qna`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`qna` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(15) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `asktime` TIMESTAMP NOT NULL,
  `masterid` VARCHAR(15) NULL DEFAULT NULL,
  `anscontent` TEXT NULL DEFAULT NULL,
  `anstime` TIMESTAMP NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT '0',
  PRIMARY KEY (`no`),
  INDEX `fk_qna_userinfo1_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_qna_userinfo1`
    FOREIGN KEY (`userid`)
    REFERENCES `housezip`.`userinfo` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 134
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `housezip`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `housezip`.`review` (
  `userid` VARCHAR(15) NOT NULL,
  `aptCode` INT NOT NULL,
  `time` INT NULL DEFAULT NULL,
  `commute` INT NULL DEFAULT NULL,
  `park` INT NULL DEFAULT NULL,
  `noise` INT NULL DEFAULT NULL,
  `facilities` INT NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`userid`, `aptCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
