package br.edu.utfpr.dv.sireata.dao.algorithm.attachment;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;
import br.edu.utfpr.dv.sireata.dao.algorithm.ReadForFieldDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnexoReadAloudDAO implements ReadForFieldDAO<Anexo> {

    @Override
    public List<Anexo> readForField(int minute) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT anexos.* FROM anexos " +
                    "WHERE idAta=" + String.valueOf(minute) + " ORDER BY anexos.ordem");

            List<Anexo> list = new ArrayList<>();

            while (rs.next()) {
                list.add(AnexoUtilDAO.loadingObject(rs));
            }

            return list;
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