package projeto.esig.crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.esig.crud.domain.Cliente;
import projeto.esig.crud.dto.ClienteRequestDTO;
import projeto.esig.crud.dto.ClienteResponseDTO;
import projeto.esig.crud.service.ClienteService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.net.URI;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

// @CrossOrigin(origins = "${HOST_URL}")
@CrossOrigin(origins = "https://esig.cog.d3tu.com")
@RestController
@RequestMapping("/tarefas/")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService service;
    private final ModelMapper mapper;

    @GetMapping
    public Page<ClienteResponseDTO> listAll(Pageable pageable) {
        Page<Cliente> usuariosPage = service.listAll(pageable);
        return usuariosPage.map(this::convertToDto);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody ClienteRequestDTO cliente) {
        Cliente created = service.create(convertToEntity(cliente));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponseDTO> listById(@PathVariable("id") Long id) {
        Cliente p = service.findById(id);
        ClienteResponseDTO dto = mapper.map(p, ClienteResponseDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponseDTO> update(@RequestBody ClienteRequestDTO requestDto, @PathVariable("id") Long id) {
        try {
            Cliente clienteExistente = service.findById(id);
            mapper.map(requestDto, clienteExistente);
            Cliente clienteAtualizado = service.update(clienteExistente, id);
            return ResponseEntity.ok(convertToDto(clienteAtualizado));
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    
    private ClienteResponseDTO convertToDto(Cliente created) {
        ClienteResponseDTO clienteResponseDTO = mapper.map(created, ClienteResponseDTO.class);
        clienteResponseDTO.addLinks(created);
        return clienteResponseDTO;
    }

    private Cliente convertToEntity(ClienteRequestDTO cliente) {
        Cliente entityPessoa = mapper.map(cliente, Cliente.class);
        return entityPessoa;
    }
}
