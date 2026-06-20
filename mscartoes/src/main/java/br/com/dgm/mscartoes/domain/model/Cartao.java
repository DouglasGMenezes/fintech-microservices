package br.com.dgm.mscartoes.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@NoArgsConstructor
@Table(name="cartoes")
@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String bandeira;
    @Column
    private BigDecimal limeite;
    @Column
    private BigDecimal salario;

}
