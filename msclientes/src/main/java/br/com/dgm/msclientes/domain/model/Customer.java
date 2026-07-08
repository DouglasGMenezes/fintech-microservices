package br.com.dgm.msclientes.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "cliente")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String taxId;
    @Column
    private String name;
    @Column
    private Integer age;


    public Customer(String taxId, String name, Integer age) {
        this.taxId = taxId;
        this.name = name;
        this.age = age;
    }

}
