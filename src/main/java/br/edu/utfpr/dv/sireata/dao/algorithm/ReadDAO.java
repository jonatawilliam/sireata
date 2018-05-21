package br.edu.utfpr.dv.sireata.dao.algorithm;

import java.sql.SQLException;

public interface ReadDAO<Type> {
    Type read(int id) throws SQLException;
}