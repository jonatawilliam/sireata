package br.edu.utfpr.dv.sireata.dao;

import br.edu.utfpr.dv.sireata.dao.algorithm.*;
import br.edu.utfpr.dv.sireata.dao.algorithm.attachment.AnexoDeleteDAO;
import br.edu.utfpr.dv.sireata.dao.algorithm.attachment.AnexoReadDAO;
import br.edu.utfpr.dv.sireata.dao.algorithm.attachment.AnexoReadAloudDAO;
import br.edu.utfpr.dv.sireata.dao.algorithm.attachment.AnexoSaveDAO;
import br.edu.utfpr.dv.sireata.model.Anexo;

public class AnexoDAO extends DefaultDAO<Anexo> {

	public AnexoDAO () {
		read = new AnexoReadDAO();
		readForField = new AnexoReadAloudDAO();
		save = new AnexoSaveDAO();
		delete = new AnexoDeleteDAO();
	}

	public AnexoDAO(ReadDAO read, ReadForFieldDAO readForField, SaveDAO save, DeleteDAO delete) {
		this.read = read;
		this.readForField = readForField;
		this.save = save;
		this.delete = delete;
	}

}