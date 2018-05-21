package br.edu.utfpr.dv.sireata.dao.algorithm;

import java.sql.SQLException;
import java.util.List;

public class DefaultDAO<Type> {
    protected ReadDAO<Type> read;
    protected ReadForFieldDAO<Type> readForField;
    protected SaveDAO<Type> save;
    protected DeleteDAO<Type> delete;

    public Type read(int id) throws SQLException {
        return read.read(id);
    }

    public List<Type> readForField(int value) throws SQLException {
        return readForField.readForField(value);
    }

    public int save (Type entity) throws SQLException {
        return save.save(entity);
    }

    public void delete(int id) throws SQLException {
        delete.delete(id);
    }
}