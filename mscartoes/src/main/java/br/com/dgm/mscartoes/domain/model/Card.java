package br.com.dgm.mscartoes.domain.model;

import br.com.dgm.mscartoes.domain.model.enuns.CardBrand;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@NoArgsConstructor
@Table(name="card")
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "holder_name")
    private String holderName;
    @Column(name = "card_brand")
    @Enumerated(EnumType.STRING)
    private CardBrand cardBrand;
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;
    @Column(name = "income")
    private BigDecimal income;

    public Card(String holderName, CardBrand cardBrand, BigDecimal creditLimit, BigDecimal income) {
        this.holderName = holderName;
        this.cardBrand = cardBrand;
        this.creditLimit = creditLimit;
        this.income = income;
    }

    public Long getId() {
        return this.id;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public CardBrand getCardBrand() {
        return this.cardBrand;
    }

    public BigDecimal getCreditLimit() {
        return this.creditLimit;
    }

    public BigDecimal getIncome() {
        return this.income;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setCardBrand(CardBrand cardBrand) {
        this.cardBrand = cardBrand;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

}
