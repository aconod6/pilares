-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS Modelo_relacional;

-- Crea la base de datos
CREATE DATABASE Modelo_relacional;

-- Utilizar la base de datos
USE Modelo_relacional;

CREATE TABLE sucursales(
        codigo_de_sucursal int primary key,
        domicilio varchar(200) not null,
        telefono int not null unique,
);

CREATE TABLE 
