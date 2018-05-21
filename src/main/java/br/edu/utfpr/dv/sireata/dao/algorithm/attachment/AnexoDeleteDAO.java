package br.edu.utfpr.dv.sireata.dao.algorithm.attachment;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithm.DeleteDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AnexoDeleteDAO implements DeleteDAO<Anexo> {

    @Override
    public void delete(int id) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.createStatement();

            stmt.execute("DELETE FROM anexos WHERE idanexo=" + String.valueOf(id));
        } finally {
            if ((stmt != null) && !stmt.isClosed())
                stmt.close();
            if ((conn != null) && !conn.isClosed())
                conn.close();
        }
    }

}