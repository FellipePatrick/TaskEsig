package projeto.esig.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import projeto.esig.crud.domain.Status;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClienteRequestDTO {

    @NotBlank(message = "O título não pode estar em branco.")
    @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres.")
    private String titulo;

    @NotBlank(message = "O responsável não pode estar em branco.")
    @Size(min = 5, max = 100, message = "O responsável deve ter entre 5 e 100 caracteres.")
    private String responsavel;

    @NotBlank(message = "A descrição não pode estar em branco.")
    @Size(max = 500, message = "A descrição não pode ter mais de 500 caracteres.")
    private String descricao;

    @NotBlank(message = "A prioridade não pode estar em branco.")
    private String prioridade;

    @NotNull(message = "O deadline não pode ser nulo.")
    private LocalDateTime deadLine;

    @NotNull(message = "O status não pode ser nulo.")
    private Status status;
}
