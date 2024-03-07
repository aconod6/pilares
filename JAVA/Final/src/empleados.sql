-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS empleados;

-- Crea la base de datos
CREATE DATABASE empleados;

-- Utilizar la base de datos
USE empleados;
CREATE table generos(
    id_genero int auto_increment primary key,
    nombre varchar (20)
);
CREATE table login (
    id_login int auto_increment primary key,
    nombre varchar (100),
    email varchar (100) not null,
    usuario varchar (100) not null,
    contrasenia VARCHAR(100) NOT NULL

);
CREATE table empleados (
    id_empleado int auto_increment primary key,
    nombre varchar (100) not null,
    domicilio varchar (100) not null,
    telefono varchar(12) not null,
    email varchar (100) not null,
    fecha_nacimiento DATE,
    generos_id_genero int not null,
    foreign key (generos_id_genero)
    references generos(id_genero)

);

INSERT INTO generos VALUES
	(null,'Femenino'),
	(null,'Masculino'),
	(null,'Otro');

INSERT INTO login VALUES 
	(null, 'Acono', 'mariagomez@gmail.com', 'mariacbr', 'maria123'),
	(null, 'CarlosLopez', 'carloslopez@gmail.com', 'carloscbr', 'carlos456'),
	(null, 'LauraFernandez', 'laurafernandez@gmail.com', 'lauracbr', 'laura789'),
	(null, 'JuanPerez', 'juanperez@gmail.com', 'juancbr', 'juan000');

INSERT INTO empleados VALUES
	(null, 'Isabel Pérez', 'Calle Principal 123', '5551234567', 'isabel@example.com', '1991-04-12',1),
	(null, 'Isabel Pérez', 'Calle Principal 123', '5551234567', 'isabel@example.com', '1991-04-12',1),
    (null, 'Carmen López', 'Avenida Central 456', '555-987-6543', 'carmen@example.com', '1989-03-28',1),
	(null, 'Fernando Rodríguez', 'Calle Secundaria 789', '555-555-5555', 'fernando@example.com', '1996-01-08',2),
	(null, 'José García', 'Boulevard Norte 321', '555-111-2222', 'jose@example.com', '1998-02-18',2),
	(null, 'Pedro Martínez', 'Calle Sur 567', '555-444-3333', 'pedro@example.com', '1992-11-05',3),
	(null, 'Laura Sánchez', 'Avenida Oeste 987', '555-888-9999', 'laura@example.com', '1990-05-15',1),
	(null, 'Carlos Ramírez', 'Calle Este 654', '555-777-8888', 'carlos@example.com', '1985-07-30',2),
	(null, 'Sofía Torres', 'Boulevard Central 789', '555-222-1111', 'sofia@example.com', '1993-12-25',1),
	(null, 'Diego Vargas', 'Avenida Principal 234', '555-666-7777', 'diego@example.com', '1987-08-22',2),
	(null, 'Elena Fernández', 'Calle Norte 876', '555-333-4444', 'elena@example.com', '1999-07-01',1),
	(null, 'Andrés López', 'Boulevard Sur 543', '555-999-0000', 'andres@example.com', '1994-10-15',2),
	(null, 'María Martínez', 'Avenida Este 210', '555-444-5555', 'maria@example.com', '1995-03-10',1),
	(null, 'Ricardo Soto', 'Calle Oeste 765', '555-777-6666', 'ricardo@example.com', '1994-09-10',2),
	(null, 'Juan Ramírez', 'Boulevard Norte 123', '555-555-4444', 'juan@example.com', '1997-06-05',2),
	(null, 'Ana González', 'Avenida Sur 432', '555-888-7777', 'ana@example.com', '1988-09-20',1);


SELECT * FROM generos;
SELECT * FROM login;
SELECT * FROM empleados;
SELECT * FROM empleados WHERE id_empleado = 1 ;
