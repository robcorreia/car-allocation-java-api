package allocation.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import allocation.domain.Usuario;
import allocation.projections.UsuarioProjection;

public interface UsuarioRepository extends 
	CrudRepository<Usuario, Long> {
	
	Optional<Usuario> findByCpf(String cpf);
	
	@Query(value="SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> buscarPorEmail(@Param("email") String email);
	
	@Query(value="SELECT u.nome AS nome, u.email AS email FROM Usuario u")
	List<UsuarioProjection> listarTodos();

}
