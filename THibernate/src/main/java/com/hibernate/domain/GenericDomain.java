package com.hibernate.domain;

import java.io.Serializable;

public class GenericDomain implements Serializable{
	
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
