
CREATE TABLE IF NOT EXISTS `cliente`(
  `id` INT NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `comprobante`(
  `id` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `cantidad` INT NOT NULL,
  `total` FLOAT NOT NULL,
  `cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`cliente_id_cliente`)
  REFERENCES `cliente` (`id_cliente`));

CREATE TABLE IF NOT EXISTS `producto` (
  `id` INT NOT NULL,
  `codigo` INT NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `linea` (
  `id` INT NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` FLOAT NOT NULL,
  `comprobante_id_comprobante` INT NOT NULL,
  `producto_id_producto` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`comprobante_id_comprobante`)
  REFERENCES `comprobante` (`id_comprobante`),
  FOREIGN KEY (`producto_id_producto`)
  REFERENCES `producto` (`id_producto`));