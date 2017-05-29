package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Caixa;

public class CaixaDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException{
		
		Caixa caixa = new Caixa();
		caixa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse("29/05/2015"));
		caixa.setValorAbertura(new BigDecimal("100.00"));
		
		CaixaDAO dao = new CaixaDAO();
		dao.salvar(caixa);
	}
	
	@Test
	public void buscar(){
		
		
	}

}
