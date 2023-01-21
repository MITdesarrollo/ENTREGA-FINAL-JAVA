CREATE DATABASE facturacion;

CREATE TABLE facturacion.cliente (
	cliente_id int NOT NULL AUTO_INCREMENT,
    dni int NOT NULL,
    name varchar(255) NOT NULL,
    surname varchar(255),
    PRIMARY KEY (clienteid)
);

CREATE TABLE facturacion.producto (
	producto_id int NOT NULL AUTO_INCREMENT,
    code int NOT NULL,
    description varchar(255) NOT NULL,
    quantity int,
    price FLOAT(5, 2),
    PRIMARY KEY (productoid)
);

CREATE TABLE facturacion.comprobante (
    comprobante_id int NOT NULL AUTO_INCREMENT,
    date datetime,
    quantity int,
    total FLOAT(5, 2),
    clienteid int,
    PRIMARY KEY (comprobanteid),
    CONSTRAINT FK_cliente FOREIGN KEY (clienteid)
    REFERENCES cliente(clienteid)
);

CREATE TABLE facturacion.linea (
    linea_id int NOT NULL AUTO_INCREMENT,
    description varchar(255) NOT NULL,
    quantity int,
    price FLOAT(5, 2),
    comprobanteid int NOT NULL,
    productoid int NOT NULL,
    PRIMARY KEY (lineaid),
    CONSTRAINT FK_comprobante FOREIGN KEY (comprobanteid)
    REFERENCES comprobante(comprobanteid),
    CONSTRAINT FK_producto FOREIGN KEY (productoid)
    REFERENCES producto(productoid)
);