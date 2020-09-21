package sample.DAO;

import java.util.List;

/**
 * @param <T> Interface DAO, com a base para a interação com a base de dados.
 */
public interface DAO <T>{
    List<T> get(String condition);
    List<T> getAll();
    void update(T t);
    void delete(T t);
    void create(T t);
}
