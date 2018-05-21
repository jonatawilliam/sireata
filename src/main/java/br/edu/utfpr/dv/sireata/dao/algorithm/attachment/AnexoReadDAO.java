package br.edu.utfpr.dv.sireata.dao.algorithm.attachment;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithm.ReadDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnexoReadDAO implements ReadDAO<Anexo> {

    @Override
    public Anexo read(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.prepareStatement("SELECT anexos.* FROM anexos " +
                    "WHERE idAnexo = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return AnexoUtilDAO.loadingObject(rs);
            } else {
                return null;
            }
        } finally {
            if ((rs != null) && !rs.isClosed())
                rs.close();
            if ((stmt != null) && !stmt.isClosed())
                stmt.close();
            if ((conn != null) && !conn.isClosed())
                conn.close();
        }
    }

}