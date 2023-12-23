-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS entregable_6;

-- Crea la base de datos
CREATE DATABASE entregable_6;

-- Utilizar la base de datos
USE entregable_6;

CREATE table fabricantes (
      codigo_fabricante int (10) auto_increment primary key,
      nombre varchar(50) not null
);

CREATE table producto(
    idproducto int (10) auto_increment primary key,
    nombre varchar(100) not null,
    precio double not null,
    fabricantes_codigo_fabricante int not null,
    constraint producto_fabricantes_codigo_fabricante_fk
    foreign key (fabricantes_codigo_fabricante)
    references fabricantes(codigo_fabricante)
);

INSERT INTO fabricantes (codigo_fabricante, nombre)
VALUES (null, "Asus" ),
       (null, "LENOVO" ),
       (null, "Hewlett-Packard" ),
       (null, "Samsung" ),
       (null, "Seagate" ),
       (null, "Crucial" ),
       (null, "Gigabyte"),
       (null, "Huawei" ),
       (null, "Xiaomi" );

INSERT INTO producto (idproducto, nombre, precio, fabricantes_codigo_fabricante)
VALUES (null, "Disco Duro SATA3 1TB",86.99,5),
       (null, "Memoria RAM DDR4 8GB",120,6),
       (null, "Disco SSD 1TB",150.99,4),
       (null, "GeForce GTX 1050 Ti",185,7),
       (null, "GeForce GTX 1080 Xtreme",755,6),
       (null, "Monitor 24 LED Full HD",202,1),
       (null, "Monitor 27 LED Full HD",245.99,1),
       (null, "Portátil Yoga 520",559,2),
       (null, "Portátil Ideapad 320",444,2),
       (null, "Impresora HP Deskjet 3720",59.99,3),
       (null, "Impresora HP Laserjet Pro M26nw",180,3);


/* ____________________________________________ENTREGABLE 7___________________________________________________*/


/* 
    1 Calcula el número total de productos que hay en la tabla productos. 
*/
   
 select count(*) AS total_productos FROM producto;

  /* 2 Muestra el número total de productos que tiene cada uno de los fabricantes. El listado también debe incluir los fabricantes que no tienen ningún producto. 
   El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene. Ordene el resultado descendentemente por el número de productos.*/

SELECT f.nombre AS nombre_fabricante, 
COUNT(p.idproducto) AS total_productos
FROM fabricantes f
LEFT JOIN producto p 
ON f.codigo_fabricante = p.fabricantes_codigo_fabricante
GROUP BY f.nombre
ORDER BY COUNT(p.idproducto) 
DESC;/* lo vamos a usar para poner en orden*/
   
 /*
   Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes. 
   El resultado mostrará el nombre del fabricante junto con los datos que se solicitan. 
 */
SELECT 
    f.nombre AS nombre_fabricante,
    MAX(p.precio) AS precio_maximo,
    MIN(p.precio) AS precio_minimo,
    AVG(p.precio) AS precio_medio
FROM fabricantes f
LEFT JOIN producto p ON f.codigo_fabricante = p.fabricantes_codigo_fabricante
GROUP BY f.nombre;

/*
  Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo, precio medio y 
  el número total de productos de los fabricantes que tienen un precio medio superior a 200.
*/

SELECT 
    f.nombre AS nombre_fabricante,
    MAX(p.precio) AS precio_maximo,
    MIN(p.precio) AS precio_minimo,
    AVG(p.precio) AS precio_medio,
    COUNT(p.idproducto) AS total_productos
FROM fabricantes f
LEFT JOIN producto p ON f.codigo_fabricante = p.fabricantes_codigo_fabricante
GROUP BY f.nombre
HAVING AVG(p.precio) > 200;









/*__________________________ entregable 9_____________________________*/








/*
    Lista el nombre de todos los productos que hay en la tabla producto.
*/

select nombre FROM producto;


/*
Lista los nombres y los precios de todos los productos de la tabla producto.
*/

SELECT nombre, precio from producto;

/*
     Lista todas las columnas de la tabla producto.
*/

select * from producto;

/*
    Devuelve una lista con el nombre del producto, precio y
    nombre de fabricante de todos los productos de la base de datos.
*/

SELECT p.nombre AS nombre_producto, p.precio, 
f.nombre AS nombre_fabricante
FROM producto p
INNER JOIN fabricantes f 
ON p.fabricantes_codigo_fabricante = f.codigo_fabricante;

/*
  Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
*/

SELECT nombre as Productos_de_lenovo
from producto
WHERE fabricantes_codigo_fabricante = (
             SELECT codigo_fabricante 
             from fabricantes 
             WHERE nombre = "lenovo"
             );

/*
   Devuelve todos los datos de los productos que tienen el mismo precio que el 
   producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
*/

SELECT *
FROM producto
WHERE precio = (
    SELECT MAX(precio)
    FROM producto
    WHERE fabricantes_codigo_fabricante = (
        SELECT codigo_fabricante
        FROM fabricantes
        WHERE nombre = "lenovo"
    )
);

/*
     Lista el nombre del producto más caro del fabricante Lenovo.
*/

SELECT nombre
FROM producto
WHERE fabricantes_codigo_fabricante = (
    SELECT codigo_fabricante
    FROM fabricantes
    WHERE nombre = "lenovo"
)
ORDER BY precio DESC
LIMIT 1;