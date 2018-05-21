package br.edu.utfpr.dv.sireata.dao.algorithm;

import java.sql.SQLException;

public interface SaveDAO<Type> {
    int save (Type entity) throws SQLException;
}