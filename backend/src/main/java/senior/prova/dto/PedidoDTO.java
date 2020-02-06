package senior.prova.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import senior.prova.enums.StatusPedido;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO implements Serializable {

    private Long id;
    @NotNull
    @Length(min = 3)
    private String nome;
    @NotNull
    @Length(min = 3)
    private String descricao;
    @NotNull
    private BigDecimal preco;
    private StatusPedido status;

}
