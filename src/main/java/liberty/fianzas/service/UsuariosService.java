package liberty.fianzas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import liberty.fianzas.entity.Usuario;
import liberty.fianzas.repository.UsuariosRepository;

@Service
public class UsuariosService {
	@Autowired
	UsuariosRepository repository;
	
	public List<Usuario> getAllUsuarios(Integer pageNo, Integer pageSize){
		Pageable paginacion = PageRequest.of(pageNo, pageSize);
		Page<Usuario> resPag = repository.findAll(paginacion);
		
		if(resPag.hasContent())
			return resPag.getContent();
		else
			return new ArrayList<Usuario>();
	}
	
	public Usuario getUsuario(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Usuario createUsuario(Usuario body) {
		return repository.save(body);
	}
	
	public void deleteUsuario(Integer id) {
		repository.deleteById(id);
	}
	
	public Usuario updateUsuario(Usuario updateUser) {
		Usuario oldUsuario = getUsuario(updateUser.getId());
		
		oldUsuario.setNombre(updateUser.getNombre());
		oldUsuario.setEmail(updateUser.getEmail());
		oldUsuario.setEstatus(updateUser.getEstatus());
		oldUsuario.setGender(updateUser.getGender());
		oldUsuario.setFoto(updateUser.getFoto());
		
		return repository.save(oldUsuario);
	}
}
