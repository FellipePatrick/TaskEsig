package projeto.esig.crud.domain;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "tarefa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente extends AbstractEntity {

    private String titulo;

    private String responsavel;
    private String descricao;
    private String prioridade;

    private LocalDateTime deadLine;

    @Enumerated(EnumType.STRING)
    private Status status;
}
