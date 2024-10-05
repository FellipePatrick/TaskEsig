package projeto.esig.crud.dto;


import projeto.esig.crud.controller.ClienteController;
import projeto.esig.crud.domain.Cliente;
import projeto.esig.crud.domain.Status;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteResponseDTO extends RepresentationModel<ClienteResponseDTO>{

    private Long id; 
    private String titulo;
    private String responsavel;
    private String descricao;
    private String prioridade;
    private LocalDateTime deadLine;
    private Status status;

    public void addLinks(Cliente cliente){
        this.add(linkTo(ClienteController.class).slash(cliente.getId()).withSelfRel());
    }
}
