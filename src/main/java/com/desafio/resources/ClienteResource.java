package com.desafio.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.domain.Cliente;
import com.desafio.domain.Contato;
import com.desafio.domain.Endereco;
import com.desafio.domain.Historico;
import com.desafio.domain.Usuario;
import com.desafio.dto.ClienteDTO;
import com.desafio.services.ClienteService;
import com.desafio.services.ContatoService;
import com.desafio.services.EnderecoService;
import com.desafio.services.HistoricoService;
import com.desafio.services.UsuarioService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
//	@Autowired
//	private UsuarioService clienteServico;
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private EnderecoService serviceEndereco;
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Autowired
	private HistoricoService historicoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> buscarTodos() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDto = list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarId(@PathVariable Integer id) {
		Cliente entity = service.findById(id);
		ClienteDTO entityDto = new ClienteDTO(entity); 
		return ResponseEntity.ok().body(entityDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Cliente entity) {

		Historico historico = new Historico();
		historico.setUsuario(entity.getUsuario());
		historico.setDataOperacao(new Date());
		historico.setTipoOperacao("INCLUSAO");
		historicoService.save(historico);
		
		
		Contato contato = new Contato();
		contato.setEmail(entity.getContato().getEmail());
		contato.setTelefone(entity.getContato().getTelefone());
		entity.getContato().setId(contatoService.save(contato).getId());

		Endereco endereco = new Endereco();
		
		endereco.setCep(entity.getEndereco().getCep());
		endereco.setBairro(entity.getEndereco().getBairro());
		endereco.setCidade(entity.getEndereco().getCidade());
		endereco.setComplemento(entity.getEndereco().getComplemento());
		endereco.setLogradouro(entity.getEndereco().getLogradouro());
		endereco.setUf(entity.getEndereco().getUf());
		entity.getEndereco().setId(serviceEndereco.save(endereco).getId());
		
		
		entity = service.save(entity);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Cliente entity, @PathVariable Integer id) {
		
		Historico historico = new Historico();
		historico.setUsuario(entity.getUsuario());
		historico.setDataOperacao(new Date());
		historico.setTipoOperacao("ALTERACAO");
		historicoService.save(historico);
		
		entity.setId(id);
		service.update(entity);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		
		Cliente entity = service.findById(id);
		Historico historico = new Historico();
		historico.setUsuario(entity.getUsuario());
		historico.setDataOperacao(new Date());
		historico.setTipoOperacao("EXCLUSAO");
		historicoService.save(historico);
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
