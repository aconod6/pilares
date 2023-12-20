-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS ejercicio2;

-- Crea la base de datos
CREATE DATABASE ejercicio2;

-- Utilizar la base de datos
USE ejercicio2;

CREATE TABLE clientes(
     id_codigo_interno INT primary key,
     nombre varchar(20) not null,
     direccion varchar(50) not null,
     ciudad varchar(50) not null,
     numero_de_telefono INT not null unique
);

CREATE TABLE coches(
    id_matricula varchar(7) primary key,
    marca varchar(15) not null,
    modelo varchar(30) not null,
    color varchar (15) not null,
    precio decimal(10,2) default 0.01,
    id_codigo_interno INT,
    foreign key (id_codigo_interno)
    references clientes(id_codigo_interno)
);

CREATE TABLE revisiones(
    id_codigo int auto_increment primary key,
    frenos tinyint not null,
    aceite tinyint not null,
    filtro tinyint not null,
    otro varchar(200),  
    id_matricula int,
    foreign key(id_matricula)
    references coches(id_matricula)
);
