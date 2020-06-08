package com.pe.freelo.documento;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class MatriculaItem {

	@DBRef
	private Cursos cursos;

	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	

}
