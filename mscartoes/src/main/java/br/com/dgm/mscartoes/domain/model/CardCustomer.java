package br.com.dgm.mscartoes.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class CardCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;
    private String taxId;
    @Column(name = "approved_limit")
    private BigDecimal approvedLimit;

}
