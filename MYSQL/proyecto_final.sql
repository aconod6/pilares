-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS proyecto_final;

-- Crea la base de datos
CREATE DATABASE proyecto_final;

-- Utilizar la base de datos
USE proyecto_final;

CREATE table proveedores(
    codigo_proveedor int auto_increment primary key,
    nombre varchar(100) not null,
    direccion varchar (200)not null,
    ciudad varchar (100)not null,
    provincia varchar (100)not null   
);

CREATE table categorias(
    codigo_categoria int auto_increment primary key,
    nombre varchar(100) not null
);

CREATE table piezas(
    codigo_pieza int primary key, /* no le puse "auto_increment" porque podrian tener codigo de barras*/
    nombre varchar (100)not null,
    color varchar (100)not null,
    precio double not null,
    categorias_codigo_categoria int not null,
    foreign key (categorias_codigo_categoria)
    references categorias(codigo_categoria)

);

CREATE table suministra(
    cantidad int not null,
    proveedores_codigo_proveedor int not null,
    piezas_codigo_pieza int not null,
    fecha DATE,
    primary key(fecha, proveedores_codigo_proveedor, piezas_codigo_pieza),
    foreign key (proveedores_codigo_proveedor)
    references proveedores(codigo_proveedor),
    foreign key (piezas_codigo_pieza)
    references piezas(codigo_pieza)
);

INSERT INTO proveedores (codigo_proveedor, nombre, direccion, ciudad, provincia)
VALUES(null, "prv1","casa1","tlalpan", "mexico"),
      (null, "prv2","casa2","tlalpan", "mexico"),
      (null, "prv3","casa3","tlalpan", "mexico"),
      (null, "prv4","casa4","tlalpan", "mexico");


INSERT INTO categorias (codigo_categoria, nombre)
VALUES (null,"externas"),
       (null,"internas"),
       (null,"extras");

INSERT INTO piezas (codigo_pieza, nombre, color, precio, categorias_codigo_categoria)
VALUES (1,"pantalla","negro",560,1 ),
       (2,"bocina","negro",60,2),
       (3,"bateria","negro",100,2 ),
       (4,"funda","azul",200,3 );

INSERT INTO suministra ( cantidad, proveedores_codigo_proveedor, piezas_codigo_pieza, fecha)
VALUES (3,1,1,CURDATE()), /* SE PONE CURDATE() PARA QUE DE LA FECHA EN AUTOMATICO*/
       (3,2,3,CURDATE()); 
