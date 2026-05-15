-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema viverodb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema viverodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `viverodb` DEFAULT CHARACTER SET utf8 ;
USE `viverodb` ;

-- -----------------------------------------------------
-- Table `viverodb`.`Tipo_documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Tipo_documento` (
  `idTipo_documento` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion_doc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipo_documento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viverodb`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Roles` (
  `idRoles` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion_rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRoles`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viverodb`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Usuarios` (
  `idUsuarios` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `documento` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `Tipo_documento_idTipo_documento` INT UNSIGNED NOT NULL,
  `Roles_idRoles` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE INDEX `documento_UNIQUE` (`documento` ASC),
  CONSTRAINT `fk_Usuarios_Tipo_documento`
    FOREIGN KEY (`Tipo_documento_idTipo_documento`)
    REFERENCES `viverodb`.`Tipo_documento` (`idTipo_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_Roles1`
    FOREIGN KEY (`Roles_idRoles`)
    REFERENCES `viverodb`.`Roles` (`idRoles`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `viverodb`.`Horarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Horarios` (
  `idHorarios` INT NOT NULL AUTO_INCREMENT,
  `hora_ini` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  PRIMARY KEY (`idHorarios`),
  UNIQUE INDEX `idHorarios_UNIQUE` (`idHorarios` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viverodb`.`Disponibilidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Disponibilidad` (
  `idDisponibilidad` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `cupo_total` INT NOT NULL,
  `cupo_disponible` INT NOT NULL,
  `Horarios_idHorarios` INT NOT NULL,
  PRIMARY KEY (`idDisponibilidad`),
  UNIQUE INDEX `idDisponibilidad_UNIQUE` (`idDisponibilidad` ASC) ,
  INDEX `fk_Disponibilidad_Horarios1_idx` (`Horarios_idHorarios` ASC) ,
  CONSTRAINT `fk_Disponibilidad_Horarios1`
    FOREIGN KEY (`Horarios_idHorarios`)
    REFERENCES `viverodb`.`Horarios` (`idHorarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viverodb`.`Estado_reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Estado_reserva` (
  `idEstado_reserva` INT NOT NULL AUTO_INCREMENT,
  `descripcion_esta` VARCHAR(45) NULL,
  PRIMARY KEY (`idEstado_reserva`),
  UNIQUE INDEX `idEstado_reserva_UNIQUE` (`idEstado_reserva` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `viverodb`.`Pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Pagos` (
  `idPagos` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `estado_pago` VARCHAR(45) NULL,
  PRIMARY KEY (`idPagos`),
  UNIQUE INDEX `idPagos_UNIQUE` (`idPagos` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `viverodb`.`Tipo_Actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Tipo_Actividad` (
  `idTipo_Actividad` INT NOT NULL AUTO_INCREMENT,
  `nombre_activi` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idTipo_Actividad`),
  UNIQUE INDEX `idTipo_Actividad_UNIQUE` (`idTipo_Actividad` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viverodb`.`Lista_Precios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Lista_Precios` (
  `idLista_Precios` INT NOT NULL AUTO_INCREMENT,
  `descrip_precio` INT NOT NULL,
  PRIMARY KEY (`idLista_Precios`),
  UNIQUE INDEX `idLista_Precios_UNIQUE` (`idLista_Precios` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viverodb`.`Actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Actividad` (
  `idActividad` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion_actividad` VARCHAR(45) NOT NULL,
  `Tipo_Actividad_idTipo_Actividad` INT NOT NULL,
  `Lista_Precios_idLista_Precios` INT NOT NULL,
  PRIMARY KEY (`idActividad`),
  INDEX `fk_Actividad_Tipo_Actividad1_idx` (`Tipo_Actividad_idTipo_Actividad` ASC) ,
  INDEX `fk_Actividad_Lista_Precios1_idx` (`Lista_Precios_idLista_Precios` ASC) ,
  CONSTRAINT `fk_Actividad_Tipo_Actividad1`
    FOREIGN KEY (`Tipo_Actividad_idTipo_Actividad`)
    REFERENCES `viverodb`.`Tipo_Actividad` (`idTipo_Actividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Actividad_Lista_Precios1`
    FOREIGN KEY (`Lista_Precios_idLista_Precios`)
    REFERENCES `viverodb`.`Lista_Precios` (`idLista_Precios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `viverodb`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `viverodb`.`Reserva` (
  `idReserva` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `num_personas` INT NOT NULL,
  `hora` TIME NOT NULL,
  `fecha` DATE NOT NULL,
  `Usuarios_idUsuarios` INT UNSIGNED NOT NULL,
  `Disponibilidad_idDisponibilidad` INT NOT NULL,
  `Estado_reserva_idEstado_reserva` INT NOT NULL,
  `Actividad_idActividad` INT UNSIGNED NOT NULL,
  `Pagos_idPagos` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idReserva`),
  UNIQUE INDEX `idReserva_UNIQUE` (`idReserva` ASC),
  CONSTRAINT `fk_Reserva_Usuarios1`
    FOREIGN KEY (`Usuarios_idUsuarios`)
    REFERENCES `viverodb`.`Usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Disponibilidad1`
    FOREIGN KEY (`Disponibilidad_idDisponibilidad`)
    REFERENCES `viverodb`.`Disponibilidad` (`idDisponibilidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Estado_reserva1`
    FOREIGN KEY (`Estado_reserva_idEstado_reserva`)
    REFERENCES `viverodb`.`Estado_reserva` (`idEstado_reserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Actividad1`
    FOREIGN KEY (`Actividad_idActividad`)
    REFERENCES `viverodb`.`Actividad` (`idActividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
   CONSTRAINT `fk_Reserva_Pagos1`
    FOREIGN KEY (`Pagos_idPagos`)
    REFERENCES `viverodb`.`Pagos` (`idPagos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

select * from usuarios;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

