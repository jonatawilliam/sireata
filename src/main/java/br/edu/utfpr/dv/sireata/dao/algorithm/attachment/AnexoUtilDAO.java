package br.edu.utfpr.dv.sireata.dao.algorithm.attachment;

import br.edu.utfpr.dv.sireata.model.Anexo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnexoUtilDAO {
    public static Anexo loadingObject(ResultSet rs) throws SQLException {
        Anexo anexo = new Anexo();

        anexo.setIdAnexo(rs.getInt("idAnexo"));
        anexo.getAta().setIdAta(rs.getInt("idAta"));
        anexo.setDescricao(rs.getString("descricao"));
        anexo.setOrdem(rs.getInt("ordem"));
        anexo.setArquivo(rs.getBytes("arquivo"));

        return anexo;
    }
}