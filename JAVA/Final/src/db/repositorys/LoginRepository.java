package db.repositorys;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.conexion.ConexionDB;
import models.Login;

public class LoginRepository {

    public boolean iniciarSesion(String usuario, String contrenia) {
        return false;
    }

    public void agregar (Login entidad)  {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            String q = "INSERT INTO login VALUES (null, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(q)) {
                preparedStatement.setString(1, entidad.getNombre());
                preparedStatement.setString(2, entidad.getEmail());
                preparedStatement.setString(3, entidad.getUsuario());
                preparedStatement.setString(4, entidad.getContrasenia());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en la consulta "+e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar la conexion "+e.getMessage());
        }
    }

}