-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS entregable_8;

-- Crea la base de datos
CREATE DATABASE entregable_8;

-- Utilizar la base de datos
USE entregable_8;

CREATE table test(
     id int auto_increment primary key,
     nombre varchar (50) not null,
     apellido1 varchar (50) not null,
     apellido2 varchar (50)not null,
     nota double
);

/*
   Trigger 1: trigger_check_nota_before_insert
Se ejecuta sobre la tabla alumnos.

Se ejecuta antes de una operación de inserción.

Si el nuevo valor de la nota que se quiere insertar es negativo, se guarda como 0.

Si el nuevo valor de la nota que se quiere insertar es mayor que 10, se guarda como 10.
*/

DELIMITER $$
CREATE TRIGGER trigger_check_nota_before_insert
BEFORE INSERT ON test
FOR EACH ROW
BEGIN
    IF NEW.nota < 0 THEN
        SET NEW.nota = 0;
    ELSEIF NEW.nota > 10 THEN
        SET NEW.nota = 10;
    END IF;
END;
$$
DELIMITER ;


/*
   Trigger2 : trigger_check_nota_before_update

Se ejecuta sobre la tabla alumnos.

Se ejecuta antes de una operación de actualización.

Si el nuevo valor de la nota que se quiere actualizar es negativo, se guarda como 0.

Si el nuevo valor de la nota que se quiere actualizar es mayor que 10, se guarda como 10.
*/



DELIMITER $$
CREATE TRIGGER trigger_check_nota_before_update
BEFORE UPDATE ON test
FOR EACH ROW
BEGIN
    IF NEW.nota < 0 THEN
        SET NEW.nota = 0;
    ELSEIF NEW.nota > 10 THEN
        SET NEW.nota = 10;
    END IF;
END;
$$
DELIMITER ;