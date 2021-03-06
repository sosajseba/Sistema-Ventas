-- MySQL Script generated by MySQL Workbench
-- Sat Feb 15 13:12:21 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cerrajeria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cerrajeria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cerrajeria` DEFAULT CHARACTER SET utf32 ;
USE `cerrajeria` ;

-- -----------------------------------------------------
-- Table `cerrajeria`.`vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cerrajeria`.`vendedor` (
  `idvendedor` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(8) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `user` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idvendedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrajeria`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cerrajeria`.`cliente` (
  `idcliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(8) NULL,
  `direccion` VARCHAR(100) NULL,
  `telefono` VARCHAR(15) NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrajeria`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cerrajeria`.`venta` (
  `idventa` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `idvendedor` INT NOT NULL,
  `idcliente` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idventa`),
  CONSTRAINT `fk_venta_vendedor`
    FOREIGN KEY (`idvendedor`)
    REFERENCES `cerrajeria`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_cliente1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `cerrajeria`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrajeria`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cerrajeria`.`producto` (
  `idproducto` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `precio` DOUBLE UNSIGNED NOT NULL,
  `stock` INT UNSIGNED NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `estado` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cerrajeria`.`detalle_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cerrajeria`.`detalle_venta` (
  `idventa` INT UNSIGNED NOT NULL,
  `idproducto` INT UNSIGNED NOT NULL,
  `cantidad` INT UNSIGNED NOT NULL,
  `monto` DOUBLE UNSIGNED NOT NULL,
  PRIMARY KEY (`idventa`, `idproducto`),
  CONSTRAINT `fk_venta_has_producto_venta1`
    FOREIGN KEY (`idventa`)
    REFERENCES `cerrajeria`.`venta` (`idventa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_has_producto_producto1`
    FOREIGN KEY (`idproducto`)
    REFERENCES `cerrajeria`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO cerrajeria.cliente (dni,nombre,direccion,telefono) values
('11111111','Cliente 1','Calle 1','1111111111'),
('22222222','Cliente 2','Calle 2','2222222222'),
('33333333','Cliente 3','Calle 3','3333333333'),
('44444444','Cliente 4','Calle 4','4444444444'),
('55555555','Cliente 5','Calle 5','5555555555'),
('66666666','Cliente 6','Calle 6','6666666666');

INSERT INTO cerrajeria.vendedor (nombres,dni,telefono,user) values
('Juan','38794933','1122535585','user1'),
('Carlos','38794934','1111111111','user2');

INSERT INTO cerrajeria.producto (precio,stock,descripcion,estado) values
(100,1,'Producto 1',1),
(200,2,'Producto 2',1),
(300,3,'Producto 3',1),
(400,4,'Producto 4',1),
(500,5,'Producto 5',1),
(600,6,'Producto 6',1),
(700,7,'Producto 7',1),
(800,8,'Producto 8',1);