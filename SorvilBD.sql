-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sorvil
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sorvil
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sorvil` DEFAULT CHARACTER SET utf8 ;
USE `sorvil` ;

-- -----------------------------------------------------
-- Table `sorvil`.`livros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sorvil`.`livros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `isbn` VARCHAR(13) NOT NULL,
  `data_publicacao` DATE NOT NULL,
  `nome_autor` VARCHAR(90) NOT NULL,
  `editora` VARCHAR(90) NOT NULL,
  `quantidade_paginas` INT NOT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sorvil`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sorvil`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `senha` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sorvil`.`estantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sorvil`.`estantes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `nome_autor` VARCHAR(90) NOT NULL,
  `editora` VARCHAR(90) NOT NULL,
  `quantidade_paginas` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
