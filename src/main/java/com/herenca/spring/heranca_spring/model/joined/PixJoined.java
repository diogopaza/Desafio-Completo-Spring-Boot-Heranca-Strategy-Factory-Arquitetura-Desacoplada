package com.herenca.spring.heranca_spring.model.joined;


import com.herenca.spring.heranca_spring.dto.PagamentoDTO;
import com.herenca.spring.heranca_spring.enums.PagamentoEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "pix_joined")
@PrimaryKeyJoinColumn(name = "pagamento_id")
public class PixJoined extends PagamentoJoined {

    private String chavePix;

    @Override
    public String processaPagamento() {
        return "Pagando com PIX";
    }

    @Override
    public PagamentoDTO toDTO() {
        return new PagamentoDTO(
                "PIX",
                this.getValor(),
                this.getData(),
                null,
                null,
                this.getChavePix()
        );
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
