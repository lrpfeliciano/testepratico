package br.org.ecad.testepratico.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.ecad.testepratico.model.Arquivo;
import br.org.ecad.testepratico.service.ArquivoService;

@RestController
@RequestMapping("/api-arquivos/arquivos")
public class ArquivoController {

private static final Logger logger = Logger.getLogger("ArquivoController");
	
	@Autowired
	private ArquivoService arquivoService;
	
	@GetMapping
	public ResponseEntity<List<Arquivo>> find() {
		if(arquivoService.find().isEmpty()) {
			return ResponseEntity.notFound().build(); 
		}
		logger.info("Finalizando");
		return ResponseEntity.ok(arquivoService.find());
		
	}
	
	@GetMapping(path="/{inicio}/{fim}/{nome}/{tipo}", produces= {"application/json"})
	public ResponseEntity<List<Arquivo>> find(
			@PathVariable("inicio") String inicio,
			@PathVariable("fim") String fim,
			@PathVariable("nome") String nome,
			@PathVariable("tipo") String tipo
			){
		
		String[] strData = inicio.split("-");
		int ano = Integer.parseInt( strData[0] );
		int mes = Integer.parseInt( strData[1] );
		int dia = Integer.parseInt( strData[2] );
		
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.set(Calendar.YEAR, ano);
		dataInicio.set(Calendar.MONTH, mes);
		dataInicio.set(Calendar.DAY_OF_MONTH, dia);

		strData = fim.split("-");
		ano = Integer.parseInt( strData[0] );
		mes = Integer.parseInt( strData[1] );
		dia = Integer.parseInt( strData[2] );
		
		Calendar dataFinal = Calendar.getInstance();
		dataFinal.set(Calendar.YEAR, ano);
		dataFinal.set(Calendar.MONTH, mes);
		dataFinal.set(Calendar.DAY_OF_MONTH, dia);

		if(arquivoService.find(new Date(dataInicio.getTimeInMillis()), new Date(dataFinal.getTimeInMillis()), nome, tipo).isEmpty()) {
			return ResponseEntity.notFound().build(); 
		}
		logger.info("Finalizando");
		return ResponseEntity.ok(arquivoService.find(new Date(dataInicio.getTimeInMillis()), new Date(dataFinal.getTimeInMillis()), nome, tipo));
		
	}
}
