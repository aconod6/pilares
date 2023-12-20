-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS proyecto_final;

-- Crea la base de datos
CREATE DATABASE proyecto_final;

-- Utilizar la base de datos
USE proyecto_final;

CREATE table proveedores(
    codigo_proveedor int primary key,
    nombre varchar(100) not null,
    direccion varchar (200)not null,
    ciudad varchar (100)not null,
    provincia varchar (100)not null   
);

CREATE table piezas(
    codigo_pieza int primary key,
    nombre varchar (100)not null,
    color varchar (100)not null,
    precio double not null,
    proveedores_codigo_proveedor int not null,
    categorias_codigo_categoria int not null,
    foreign key (categorias_codigo_categoria)
    references categorias(codigo_categoria)
    foreign key (categorias_codigo_categoria)
    references categorias(codigo_categoria)

);

CREATE table control(
    cantidad int not null,
    folio int auto_increment not null,
    proveedores_codigo_proveedor int not null,
    piezas_codigo_pieza int not null,
    fecha DATETIME not null,
    primary key (folio,proveedores_codigo_proveedor,piezas_codigo_pieza),
    foreign key (proveedores_codigo_proveedor)
    references proveedores(codigo_proveedor),
    foreign key (piezas_codigo_pieza)
    references piezas(codigo_pieza)
);

CREATE table categorias(
    codigo_categoria int primary key,
    nombre varchar(100) not null
);

