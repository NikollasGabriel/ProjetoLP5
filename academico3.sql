-- MySQL Script generated by MySQL Workbench
-- Fri May 11 19:19:37 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Disciplina` (
  `idDisciplina` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `numeroCreditos` INT NULL,
  `numeroVagas` INT NULL,
  PRIMARY KEY (`idDisciplina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ViceCoordenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ViceCoordenador` (
  `idViceCoordenador` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `idade` INT NULL,
  `salarioBase` FLOAT NULL,
  `salarioFinal` FLOAT NULL,
  PRIMARY KEY (`idViceCoordenador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Coordenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Coordenador` (
  `idCoordenador` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `idade` INT NULL,
  `salarioBase` FLOAT NULL,
  `salarioFinal` FLOAT NULL,
  `ViceCoordenador_idViceCoordenador` INT NOT NULL,
  PRIMARY KEY (`idCoordenador`, `ViceCoordenador_idViceCoordenador`),
  INDEX `fk_Coordenador_ViceCoordenador1_idx` (`ViceCoordenador_idViceCoordenador` ASC),
  CONSTRAINT `fk_Coordenador_ViceCoordenador1`
    FOREIGN KEY (`ViceCoordenador_idViceCoordenador`)
    REFERENCES `mydb`.`ViceCoordenador` (`idViceCoordenador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Turma` (
  `idTurma` INT NOT NULL AUTO_INCREMENT,
  `periodo` VARCHAR(45) NULL,
  `tamanho` INT NULL,
  `Disciplina_idDisciplina` INT NOT NULL,
  `Coordenador_idCoordenador` INT NOT NULL,
  PRIMARY KEY (`idTurma`, `Coordenador_idCoordenador`),
  INDEX `fk_Turma_Disciplina1_idx` (`Disciplina_idDisciplina` ASC),
  INDEX `fk_Turma_Coordenador1_idx` (`Coordenador_idCoordenador` ASC),
  CONSTRAINT `fk_Turma_Disciplina1`
    FOREIGN KEY (`Disciplina_idDisciplina`)
    REFERENCES `mydb`.`Disciplina` (`idDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turma_Coordenador1`
    FOREIGN KEY (`Coordenador_idCoordenador`)
    REFERENCES `mydb`.`Coordenador` (`idCoordenador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Aluno` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `idade` INT NULL,
  `Turma_idTurma` INT NOT NULL,
  `numeroFaltas` INT NULL,
  `mediaNotas` FLOAT NULL,
  `situacao` VARCHAR(45) NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_Pessoa_Turma1_idx` (`Turma_idTurma` ASC),
  CONSTRAINT `fk_Pessoa_Turma1`
    FOREIGN KEY (`Turma_idTurma`)
    REFERENCES `mydb`.`Turma` (`idTurma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Professor` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `idade` INT NULL,
  `numeroFaltas` INT NULL,
  `nivelEnsinoSuperior` VARCHAR(45) NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prova`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prova` (
  `idProva` INT NOT NULL AUTO_INCREMENT,
  `valor` INT NULL,
  `Disciplina_idDisciplina` INT NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  `Professor_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idProva`),
  INDEX `fk_Prova_Disciplina1_idx` (`Disciplina_idDisciplina` ASC),
  INDEX `fk_Prova_Pessoa1_idx` (`Pessoa_idPessoa` ASC),
  INDEX `fk_Prova_Professor1_idx` (`Professor_idPessoa` ASC),
  CONSTRAINT `fk_Prova_Disciplina1`
    FOREIGN KEY (`Disciplina_idDisciplina`)
    REFERENCES `mydb`.`Disciplina` (`idDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prova_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `mydb`.`Aluno` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prova_Professor1`
    FOREIGN KEY (`Professor_idPessoa`)
    REFERENCES `mydb`.`Professor` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
