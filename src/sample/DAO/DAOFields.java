package sample.DAO;

/**
 * Interface com os campos de DAOfields, que serão utilizados para as interações com a base de dados
 */
public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
    String getSelectConditionalString(String table);
}
