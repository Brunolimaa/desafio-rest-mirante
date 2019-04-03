package com.desafio.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.domain.Historico;
import com.desafio.dto.HistoricoDTO;
import com.desafio.services.HistoricoService;

@CrossOrigin
@RestController
@RequestMapping(value="/historicos")
public class HistoricoResource {
	
	@Autowired
	private HistoricoService service;
	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<Produto>> buscarTodos() {
//		List<Produto> list = service.findAll();
//		return ResponseEntity.ok().body(list);
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<HistoricoDTO>> buscarTodos() {
		List<Historico> list = service.findAll();
		List<HistoricoDTO> listDto = list.stream().map(x -> new HistoricoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarId(@PathVariable Integer id){
		Historico obj = service.findById(id);
		HistoricoDTO entityDto = new HistoricoDTO(obj);
		return ResponseEntity.ok().body(entityDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Historico produto){
		produto = service.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Historico produto){
		produto.setId(id);
		produto = service.update(produto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
