import java.sql.Date;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import javax.swing.JFrame;

import db.conexion.ConexionDB;
import db.repositorys.EmpleadoRepository;
import db.repositorys.GeneroRepository;
import models.Empleado;
import models.Genero;
import screens.EmpleadosVentana;
import screens.VentaLogin;

public class App {
    public static void main(String[] args) throws Exception {
        GeneroRepository generoRepository = new GeneroRepository(); // se manda a
        EmpleadoRepository empleadoRepository = new EmpleadoRepository();// llamar todo los metodos de repository
        // llamar la clase para todas las
        // funciones de Genero

        //EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        //Empleado e1 = new Empleado(0, null, null, null, null, null, null)

        
         // ?Para generar un nuevo Genero
         /* Genero g = new Genero(null,"OTRO");
         Genero g2 = new Genero(null,"FEMENINO");
         Genero g3 = new Genero(null,"MASCULINO");
         Genero g4 = new Genero(null,"BINARIO");
         generoRepository.agregar(g);
         generoRepository.agregar(g2);
         generoRepository.agregar(g3);
         generoRepository.agregar(g4); */

         /* Genero g4 = new Genero(null,"BINARIO");
         generoRepository.agregar(g4); */

             


        //modificar genero
         /* Genero mg = new Genero(3L, "OTROS");
         generoRepository.modificar(mg);
          */

        
         //Este es para poder imprimir toda la tabla genero
        /*  List<Genero> t = generoRepository.recuperarTodos();
         for (Genero genero : t) {
         System.out.println(genero.getNombre());
         } */
        /* List<Empleado> em = empleadoRepository.recuperarTodos();
         for (Empleado empleado : em ) {
         System.out.println(empleado.getNombe());
         } */

         //Buscar empleado por id
         /* Empleado empleado = empleadoRepository.recuperarId(1l);
         System.out.println(empleado.getNombe());
         System.out.println(empleado.getGenero());
         String nombre = empleado.getNombe(); */
        
         //Iniciar ventana login
         /* VentaLogin ventaLogin = new VentaLogin(null);
        ventaLogin.setVisible(true); */
        

        //Iniciar venta empleado
        EmpleadosVentana empleadosVentana = new EmpleadosVentana();
        empleadosVentana.setVisible(true);


        //Este es para poder imprimir toda la tabla genero
        /* List<Empleado> t = empleadoRepository.recuperarTodos();
        for (Empleado empleado : t) {
        System.out.println(empleado.getNombe());
        } */

    }
}
