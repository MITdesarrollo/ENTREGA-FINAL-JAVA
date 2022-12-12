CREATE TABLE CLIENTE(
  cliente_id INT NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  dni INT(11) NOT NULL,
  PRIMARY KEY (cliente_id));

-- PROBE CREANDO ESTA PRIMERA TABLA PERO NO ME CORRE



--CREATE TABLE `comprobante` (
--  `comprobante_id` INT NOT NULL,
--  `fecha` DATE NOT NULL,
--  `cantidad` INT NOT NULL,
--  `total` FLOAT NOT NULL,
--  `cliente_id` INT NOT NULL,
--  PRIMARY KEY (`comprobante_id`),
--  FOREIGN KEY (`cliente_id`)
--  REFERENCES `cliente` (`cliente_id`));

