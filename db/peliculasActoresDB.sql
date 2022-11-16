-- MySQL Script generated by MySQL Workbench
-- Wed Nov 16 19:13:48 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema peliculasActoresDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema peliculasActoresDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `peliculasActoresDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `peliculasActoresDB` ;

-- -----------------------------------------------------
-- Table `peliculasActoresDB`.`Peliculas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peliculasActoresDB`.`Peliculas` ;

CREATE TABLE IF NOT EXISTS `peliculasActoresDB`.`Peliculas` (
  `idPelicula` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(60) NOT NULL,
  `año` INT NOT NULL,
  `duracion` INT NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `sinopsis` TEXT NOT NULL,
  `portada` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idPelicula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peliculasActoresDB`.`Actores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peliculasActoresDB`.`Actores` ;

CREATE TABLE IF NOT EXISTS `peliculasActoresDB`.`Actores` (
  `idActor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idActor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `peliculasActoresDB`.`Peliculas_has_Actores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `peliculasActoresDB`.`Peliculas_has_Actores` ;

CREATE TABLE IF NOT EXISTS `peliculasActoresDB`.`Peliculas_has_Actores` (
  `Peliculas_idPelicula` INT NOT NULL,
  `Actores_idActor` INT NOT NULL,
  PRIMARY KEY (`Peliculas_idPelicula`, `Actores_idActor`),
  INDEX `fk_Cursos_has_Alumnos_Alumnos1_idx` (`Actores_idActor` ASC) VISIBLE,
  INDEX `fk_Cursos_has_Alumnos_Cursos_idx` (`Peliculas_idPelicula` ASC) VISIBLE,
  CONSTRAINT `fk_Cursos_has_Alumnos_Cursos`
    FOREIGN KEY (`Peliculas_idPelicula`)
    REFERENCES `peliculasActoresDB`.`Peliculas` (`idPelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cursos_has_Alumnos_Alumnos1`
    FOREIGN KEY (`Actores_idActor`)
    REFERENCES `peliculasActoresDB`.`Actores` (`idActor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;