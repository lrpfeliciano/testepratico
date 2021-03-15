package br.org.ecad.testepratico.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.org.ecad.testepratico.model.Arquivo;
import br.org.ecad.testepratico.repository.ArquivoRepository;

@Service
public class ArquivoService {

	private ArquivoRepository repository;
	private List<Arquivo> arquivos;
	
	public void createArquivoList() {
		arquivos = repository.find();
		if(arquivos == null) {
		   arquivos = new ArrayList<>();
		}
	}
	
	public List<Arquivo> find() {
		createArquivoList();
		return arquivos;
	}
	
	public List<Arquivo> find(Date inicio, Date fim, String nome, String tipo){
		return repository.find(inicio, fim, nome, tipo);
	}
}
