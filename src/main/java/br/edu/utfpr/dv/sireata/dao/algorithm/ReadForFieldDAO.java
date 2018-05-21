package br.edu.utfpr.dv.sireata.dao.algorithm;

import java.sql.SQLException;
import java.util.List;

public interface ReadForFieldDAO<Type> {
    List<Type> readForField(int value) throws SQLException;
}