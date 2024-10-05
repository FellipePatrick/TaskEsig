package projeto.esig.crud.service;

import org.springframework.stereotype.Service;

import projeto.esig.crud.domain.Cliente;
import projeto.esig.crud.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService extends GenericService<Cliente, Long, ClienteRepository> {
    
    public ClienteService(ClienteRepository repository) {
        super(repository);
    }

    @Override
    public List<Cliente> findAll() {
        
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
