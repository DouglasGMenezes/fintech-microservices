package br.com.dgm.mscartoes.infra.repository;

import br.com.dgm.mscartoes.domain.model.CardCustumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardCustumerRepository extends JpaRepository<CardCustumer,Long> {
    List<CardCustumer> findByTaxId(String taxId);
}
