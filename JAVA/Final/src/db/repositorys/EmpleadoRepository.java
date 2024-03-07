package db.repositorys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.conexion.ConexionDB;
import interfaces.RepositoryInterfaces;
import models.Empleado;
import models.Genero;

public class EmpleadoRepository implements RepositoryInterfaces<Empleado> {
    GeneroRepository generoRepository = new GeneroRepository();

    @Override
    public Empleado recuperarId(Long id) {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            String q = "SELECT * FROM empleados WHERE id_empleado = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setLong(1, id);
                return dameEntidadResulSet(preparedStatement.executeQuery());

            } catch (Exception e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Empleado> recuperarTodos() {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            String q = "SELECT * FROM empleados";
            java.sql.Statement statement = connection.createStatement();
            return dameListaEmpleados(statement.executeQuery(q));
        } catch (Exception e) {
            System.out.println("Error en la conexcion: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void agregar(Empleado entidad) {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            String q = "INSERT INTO  empleados VALUES (NUll, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombe());
                preparedStatement.setString(2, entidad.getDomicilio());
                preparedStatement.setString(3, entidad.getTelefono());
                preparedStatement.setString(4, entidad.getEmail());
                preparedStatement.setDate(5, entidad.getFechadeNacimiento());
                preparedStatement.setLong(6, entidad.getGenero().getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar la conexion: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Empleado entidad) {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            String q = "UPDATE empleados SET nombre = ?, domicilio= ?, telefono= ?, email= ?, fecha_nacimiento= ?, generos_id_genero= ?   WHERE id_empleado = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombe());
                preparedStatement.setString(2, entidad.getDomicilio());
                preparedStatement.setString(3, entidad.getTelefono());
                preparedStatement.setString(4, entidad.getEmail());
                preparedStatement.setDate(5, entidad.getFechadeNacimiento());
                preparedStatement.setLong(6, entidad.getGenero().getId());
                preparedStatement.setLong(7, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar la conexion " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Empleado entidad) {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            String q = "DELETE FROM empleados WHERE id_empleado = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setLong(1, entidad.getId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar la conexcion " + e.getMessage());
        }
    }

    private Empleado dameEntidadResulSet(ResultSet resultSet) {
        Long id = null;
        String nombre = null;
        String domicilio = null;
        String telefono = null;
        String email = null;
        Date fechadeNacimiento = null;
        Long generoId = null;
        Genero genero = null;

        try {
            if (resultSet.next()) {
                id = resultSet.getLong("id_empleado");
                nombre = resultSet.getString("nombre");
                domicilio = resultSet.getString("domicilio");
                telefono = resultSet.getString("telefono");
                email = resultSet.getString("email");
                fechadeNacimiento = resultSet.getDate("fecha_nacimiento");
                generoId = resultSet.getLong("generos_id_genero");
                genero = generoRepository.recuperarId(generoId);

                return new Empleado(
                        id,
                        nombre,
                        domicilio,
                        telefono,
                        email,
                        fechadeNacimiento,
                        genero);
            }
        } catch (Exception e) {
            System.out.println("Error en el resultSet: " + e.getMessage());
        }
        return null;
    }

    List<Empleado> dameListaEmpleados(ResultSet resultSet) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {

            Long id = null;
            String nombre = null;
            String domicilio = null;
            String telefono = null;
            String email = null;
            Date fechadeNacimiento = null;
            Long generoId = null;
            Genero genero = null;
            while (resultSet.next()) {
                id = resultSet.getLong("id_empleado");
                nombre = resultSet.getString("nombre");
                domicilio = resultSet.getString("domicilio");
                telefono = resultSet.getString("telefono");
                email = resultSet.getString("email");
                fechadeNacimiento = resultSet.getDate("fecha_nacimiento");
                generoId = resultSet.getLong("generos_id_genero");
                genero = generoRepository.recuperarId(generoId);
                empleados.add(new Empleado(id, nombre, domicilio, telefono, email, fechadeNacimiento, genero));
            }

            return empleados;
        } catch (Exception e) {
            System.out.println("Error en el resultSet lista: " + e.getMessage());
        }
        return null;
    }

}
