package liberty.fianzas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import liberty.fianzas.entity.Usuario;

@Repository
public interface UsuariosRepository extends PagingAndSortingRepository<Usuario, Integer>{

}
