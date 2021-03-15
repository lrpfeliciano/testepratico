package br.org.ecad.testepratico.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.org.ecad.testepratico.model.Arquivo;

public class ArquivoRepository {

	public List<Arquivo> find(){
		
		List<Arquivo> lista = getArquivos();
		return lista;
	}

	public List<Arquivo> find(Date inicio, Date fim, String nome, String tipo) {
		List<Arquivo> lista = getArquivos();
		List<Arquivo> retorno = new ArrayList<Arquivo>();

		for (Arquivo arq: lista) {
			if ( ( arq.getData().after(inicio) && arq.getData().before(fim) ) &&
				   arq.getNomeArquivo().equalsIgnoreCase(nome) &&
				   arq.getTipo().equalsIgnoreCase(tipo) ) {
				retorno.add(arq);
			}
		}
		
		return retorno;
	}
	private List<Arquivo> getArquivos() {
		// TODO Auto-generated method stub
		List<Arquivo> retorno = new ArrayList<Arquivo>();
		
		
		Arquivo registro = new Arquivo();
		Calendar dia = Calendar.getInstance();
		dia.set(Calendar.YEAR, 2020);
		dia.set(Calendar.MONTH, Calendar.JANUARY);
		dia.set(Calendar.DAY_OF_MONTH, 1);
		
		registro.setId((long) 1);
		registro.setNomeArquivo("Arquivo.doc");
		registro.setData(new Date(dia.getTimeInMillis()));
		registro.setQuantidade(20.0);
		registro.setTipo("Remessa");
		registro.setValor(new BigDecimal(2000.0));
		retorno.add(registro);
		
		registro = new Arquivo();
		dia = Calendar.getInstance();
		dia.set(Calendar.YEAR, 2020);
		dia.set(Calendar.MONTH, Calendar.MARCH);
		dia.set(Calendar.DAY_OF_MONTH, 2);

		registro.setId((long) 2);
		registro.setNomeArquivo("Arquivo2.doc");
		registro.setData(new Date(dia.getTimeInMillis()));
		registro.setQuantidade(25.0);
		registro.setTipo("Remessa");
		registro.setValor(new BigDecimal(12000.0));
		retorno.add(registro);

		registro = new Arquivo();
		dia = Calendar.getInstance();
		dia.set(Calendar.YEAR, 2020);
		dia.set(Calendar.MONTH, Calendar.APRIL);
		dia.set(Calendar.DAY_OF_MONTH, 2);

		registro.setId((long) 3);
		registro.setNomeArquivo("Arquivo3.doc");
		registro.setData(new Date(dia.getTimeInMillis()));
		registro.setQuantidade(30.0);
		registro.setTipo("Retorno");
		registro.setValor(new BigDecimal(12000.0));
		retorno.add(registro);
		
		registro = new Arquivo();
		dia = Calendar.getInstance();
		dia.set(Calendar.YEAR, 2020);
		dia.set(Calendar.MONTH, Calendar.JULY);
		dia.set(Calendar.DAY_OF_MONTH, 2);

		registro.setId((long) 4);
		registro.setNomeArquivo("Arquivo4.doc");
		registro.setData(new Date(dia.getTimeInMillis()));
		registro.setQuantidade(25.0);
		registro.setTipo("Retorno");
		registro.setValor(new BigDecimal(13000.0));
		retorno.add(registro);

		registro = new Arquivo();
		dia = Calendar.getInstance();
		dia.set(Calendar.YEAR, 2020);
		dia.set(Calendar.MONTH, Calendar.AUGUST);
		dia.set(Calendar.DAY_OF_MONTH, 2);

		registro.setId((long) 5);
		registro.setNomeArquivo("Arquivo5.doc");
		registro.setData(new Date(dia.getTimeInMillis()));
		registro.setQuantidade(25.0);
		registro.setTipo("Retorno");
		registro.setValor(new BigDecimal(12000.0));
		retorno.add(registro);

		registro = new Arquivo();
		dia = Calendar.getInstance();
		dia.set(Calendar.YEAR, 2020);
		dia.set(Calendar.MONTH, Calendar.MARCH);
		dia.set(Calendar.DAY_OF_MONTH, 2);

		registro.setId((long) 6);
		registro.setNomeArquivo("Arquivo6.doc");
		registro.setData(new Date(dia.getTimeInMillis()));
		registro.setQuantidade(25.0);
		registro.setTipo("Remessa");
		registro.setValor(new BigDecimal(12000.0));
		retorno.add(registro);

		
		
		return retorno;
	}
	
}
