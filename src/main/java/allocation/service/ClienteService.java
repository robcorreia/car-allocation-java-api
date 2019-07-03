package allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import allocation.domain.Cliente;
import allocation.exceptions.CustomRuntimeException;
import allocation.projections.ClienteProjection;
import allocation.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Optional<Cliente> clienteOptional = this.clienteRepository.findByCpf(cliente.getCpf());
		if (clienteOptional.isPresent()) {
			Cliente clienteCpf = clienteOptional.get();
			if (cliente.getIdCliente() == null ||
					cliente.getIdCliente() != clienteCpf.getIdCliente()) {
				throw new CustomRuntimeException("cpf", "CPF já cadastrado!");
			}
		}
		clienteOptional = this.clienteRepository.buscarPorEmail(cliente.getEmail());
		if (clienteOptional.isPresent()) {
			Cliente clienteEmail = clienteOptional.get();
			if (cliente.getIdCliente() == null ||
					clienteEmail.getIdCliente() != cliente.getIdCliente()) {
				throw new CustomRuntimeException("email", "E-mail já cadastrado!");
			}
		}
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("id", "Não foi informado um ID para consulta!");
		}
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}
	
	public Iterable<Cliente> buscarTodos() {
		return this.clienteRepository.findAll();
	}
	
	public List<ClienteProjection> listarTodos() {
		return this.clienteRepository.listarTodos();
	}
	
}
