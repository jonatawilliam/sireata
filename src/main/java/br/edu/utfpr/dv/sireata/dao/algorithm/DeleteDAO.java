package br.edu.utfpr.dv.sireata.dao.algorithm;

import java.sql.SQLException;

public interface DeleteDAO<Type> {
    void delete(int id) throws SQLException;
}