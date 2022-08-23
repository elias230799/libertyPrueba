package liberty.fianzas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import liberty.fianzas.entity.Usuario;
import liberty.fianzas.service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private UsuariosService service;

	@GetMapping
	@ApiOperation(value = "Busca a todos los usuarios", notes = "Recibe por parametros la paginacion "
			+ "y el tamaño de pagina que desee el usuario")
	public ResponseEntity<List<Usuario>> getAllUsuarios(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		List<Usuario> listaUsuarios = service.getAllUsuarios(pageNo, pageSize);

		return new ResponseEntity<List<Usuario>>(listaUsuarios, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Busca a un usuario en especifico", notes = "La busqueda se realiza mediante su ID")
	public ResponseEntity<Usuario> getUsuario(@PathVariable(name = "id", required = true) Integer id) {
		Usuario resUsuario = service.getUsuario(id);
		if(resUsuario==null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(resUsuario);
	}
	
	@PostMapping
	@ApiOperation(value="Crea a un usuario")
	public ResponseEntity<Usuario> createUsuario(@RequestBody(required = true) Usuario newUsuario, BindingResult respuesta){
		if(respuesta.hasErrors())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		newUsuario = service.createUsuario(newUsuario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newUsuario);
	}
	
	@DeleteMapping(value="/{id}")
	@ApiOperation(value="Elimina a un usuario en especifico", notes ="La eliminacion se realiza mediante su ID")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(name="id", required = true) Integer id){
		Usuario deleteUsuario = service.getUsuario(id);
		
		if(deleteUsuario==null)
			return ResponseEntity.notFound().build();
		
		service.deleteUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(name="id", required = true) Integer id, @RequestBody(required = true) Usuario newUsuario){
		Usuario oldUser = service.getUsuario(id);
		if(oldUser==null)
			return ResponseEntity.notFound().build();
		oldUser = service.updateUsuario(newUsuario);
		return ResponseEntity.ok(oldUser);
	}
}
