package interfaces;
import java.util.List;


public interface RepositoryInterfaces<T> {
    T recuperarId(Long id);
    List<T> recuperarTodos();
    void agregar(T entidad);
    void modificar(T entidad);
    void eliminar(T entidad);
}