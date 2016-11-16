-- MySQL Script generated by MySQL Workbench
-- 10/17/16 00:18:41
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gc
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gc` ;

-- -----------------------------------------------------
-- Schema gc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gc` DEFAULT CHARACTER SET latin1 ;
USE `gc` ;

-- -----------------------------------------------------
-- Table `gc`.`aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`aluno` ;

CREATE TABLE IF NOT EXISTS `gc`.`aluno` (
  `COD_ALUNO` INT(11) NOT NULL AUTO_INCREMENT,
  `COD_CURSO` INT(11) NOT NULL,
  `NUM_RA` VARCHAR(10) NOT NULL,
  `NOM_ALUNO` VARCHAR(100) NOT NULL,
  `NUM_CPF_ALUNO` VARCHAR(25) NULL DEFAULT NULL,
  `DES_EMAIL` VARCHAR(100) NULL DEFAULT NULL,
  `IND_DEFICIENTE` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`COD_ALUNO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gc`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`empresa` ;

CREATE TABLE IF NOT EXISTS `gc`.`empresa` (
  `COD_EMPRESA` INT(11) NOT NULL AUTO_INCREMENT,
  `NOM_EMPRESA` VARCHAR(200) NOT NULL,
  `NUM_CNPJ` VARCHAR(20) NULL DEFAULT NULL,
  `DES_ENDERECO` VARCHAR(200) NULL DEFAULT NULL,
  `NOM_BAIRRO` VARCHAR(100) NULL DEFAULT NULL,
  `NUM_CEP` VARCHAR(20) NULL DEFAULT NULL,
  `NOM_CIDADE` VARCHAR(100) NULL DEFAULT NULL,
  `DES_UF` VARCHAR(2) NULL DEFAULT NULL,
  `DES_EMAIL` VARCHAR(100) NULL DEFAULT NULL,
  `NUM_TELEFONE` VARCHAR(200) NULL DEFAULT NULL,
  `NOM_CONTATO` VARCHAR(100) NULL DEFAULT NULL,
  `DES_OBSERVACAO` VARCHAR(4000) NULL DEFAULT NULL,
  PRIMARY KEY (`COD_EMPRESA`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gc`.`contrato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`contrato` ;

CREATE TABLE IF NOT EXISTS `gc`.`contrato` (
  `COD_CONTRATO` INT(11) NOT NULL AUTO_INCREMENT,
  `COD_ALUNO` INT(11) NOT NULL,
  `COD_EMPRESA` INT(11) NOT NULL,
  `COD_CONTRATO_TIPO` INT(11) NOT NULL,
  `COD_CONTRATO_SITUACAO_ATUAL` INT(11) NOT NULL,
  `NUM_PROTOCOLO` VARCHAR(20) NULL DEFAULT NULL,
  `DAT_ENTRADA` DATE NULL DEFAULT NULL,
  `DAT_INICIO_ATUAL` DATE NULL DEFAULT NULL,
  `DAT_TERMINO_ATUAL` DATE NULL DEFAULT NULL,
  `DAT_RESCISAO` DATE NULL DEFAULT NULL,
  `VAL_BOLSA` DECIMAL(20,2) NULL DEFAULT NULL,
  `VAL_AUXILIO_TRANSPORTE` DECIMAL(20,2) NULL DEFAULT NULL,
  `QTD_CARGA_HORARIA_DIARIA` DECIMAL(10,2) NULL DEFAULT NULL,
  `QTD_CARGA_HORARIA_SEMANAL` DECIMAL(10,2) NULL DEFAULT NULL,
  `DES_OBSERVACAO` VARCHAR(4000) NULL DEFAULT NULL,
  `IND_ALUNO_CONTRATADO` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`COD_CONTRATO`),
  INDEX `FK_ALUNO_CONTRATO` (`COD_ALUNO` ASC),
  INDEX `FK_EMPRESA_CONTRATO` (`COD_EMPRESA` ASC),
  CONSTRAINT `FK_ALUNO_CONTRATO`
    FOREIGN KEY (`COD_ALUNO`)
    REFERENCES `gc`.`aluno` (`COD_ALUNO`),
  CONSTRAINT `FK_EMPRESA_CONTRATO`
    FOREIGN KEY (`COD_EMPRESA`)
    REFERENCES `gc`.`empresa` (`COD_EMPRESA`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gc`.`contrato_situacao_historico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`contrato_situacao_historico` ;

CREATE TABLE IF NOT EXISTS `gc`.`contrato_situacao_historico` (
  `COD_CONTRATO_SITUACAO_HISTORICO` INT(11) NOT NULL AUTO_INCREMENT,
  `COD_CONTRATO` INT(11) NOT NULL,
  `COD_CONTRATO_SITUACAO` INT(11) NOT NULL,
  `DAT_SITUACAO` DATE NULL DEFAULT NULL,
  `DES_OBSERVACAO` VARCHAR(4000) NULL DEFAULT NULL,
  PRIMARY KEY (`COD_CONTRATO_SITUACAO_HISTORICO`),
  INDEX `FK_CONTRATO_CONTRATO_SITUACAO_HISTORICO` (`COD_CONTRATO` ASC),
  CONSTRAINT `FK_CONTRATO_CONTRATO_SITUACAO_HISTORICO`
    FOREIGN KEY (`COD_CONTRATO`)
    REFERENCES `gc`.`contrato` (`COD_CONTRATO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gc`.`contrato_termo_aditivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`contrato_termo_aditivo` ;

CREATE TABLE IF NOT EXISTS `gc`.`contrato_termo_aditivo` (
  `COD_TERMO_ADITIVO` INT(11) NOT NULL AUTO_INCREMENT,
  `COD_CONTRATO` INT(11) NOT NULL,
  `DAT_TERMO_ADITIVO` DATE NULL DEFAULT NULL,
  `DES_OBSERVACAO` VARCHAR(4000) NULL DEFAULT NULL,
  `DAT_INICIO_HISTORICO` DATE NULL DEFAULT NULL,
  `DAT_TERMINO_HISTORICO` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`COD_TERMO_ADITIVO`),
  INDEX `FK_FK_CONTRATO_CONTRATO_TERMO_ADITIVO` (`COD_CONTRATO` ASC),
  CONSTRAINT `FK_FK_CONTRATO_CONTRATO_TERMO_ADITIVO`
    FOREIGN KEY (`COD_CONTRATO`)
    REFERENCES `gc`.`contrato` (`COD_CONTRATO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gc`.`convenio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`convenio` ;

CREATE TABLE IF NOT EXISTS `gc`.`convenio` (
  `COD_CONVENIO` INT(11) NOT NULL AUTO_INCREMENT,
  `COD_EMPRESA` INT(11) NOT NULL,
  `COD_CURSO` INT(11) NULL DEFAULT NULL,
  `COD_CONVENIO_SITUACAO` INT(11) NOT NULL,
  `DAT_VENCIMENTO` DATE NULL DEFAULT NULL,
  `DAT_ASSINATURA` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`COD_CONVENIO`),
  INDEX `FK_EMPRESA_CONVENIIO` (`COD_EMPRESA` ASC),
  CONSTRAINT `FK_EMPRESA_CONVENIIO`
    FOREIGN KEY (`COD_EMPRESA`)
    REFERENCES `gc`.`empresa` (`COD_EMPRESA`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gc`.`documento_digitalizado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`documento_digitalizado` ;

CREATE TABLE IF NOT EXISTS `gc`.`documento_digitalizado` (
  `COD_DOCUMENTO_DIGITALIZADO` INT(11) NOT NULL AUTO_INCREMENT,
  `COD_CONTRATO` INT(11) NULL DEFAULT NULL,
  `COD_TERMO_ADITIVO` INT(11) NULL DEFAULT NULL,
  `IMG_DOCUMENTO` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`COD_DOCUMENTO_DIGITALIZADO`),
  INDEX `FK_CONTRATO_DOCUMENTO_DIGITALIZADO` (`COD_CONTRATO` ASC),
  INDEX `FK_CONTRATO_TERMO_ADITIVO_DOCUMENTO_DIGITALIZADO` (`COD_TERMO_ADITIVO` ASC),
  CONSTRAINT `FK_CONTRATO_DOCUMENTO_DIGITALIZADO`
    FOREIGN KEY (`COD_CONTRATO`)
    REFERENCES `gc`.`contrato` (`COD_CONTRATO`),
  CONSTRAINT `FK_CONTRATO_TERMO_ADITIVO_DOCUMENTO_DIGITALIZADO`
    FOREIGN KEY (`COD_TERMO_ADITIVO`)
    REFERENCES `gc`.`contrato_termo_aditivo` (`COD_TERMO_ADITIVO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gc`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gc`.`usuario` ;

CREATE TABLE IF NOT EXISTS `gc`.`usuario` (
  `COD_USUARIO` INT(11) NOT NULL AUTO_INCREMENT,
  `NOM_USUARIO` VARCHAR(100) NOT NULL,
  `DES_LOGIN` VARCHAR(50) NOT NULL,
  `COD_SENHA` VARCHAR(100) NOT NULL,
  `DES_EMAIL` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`COD_USUARIO`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
