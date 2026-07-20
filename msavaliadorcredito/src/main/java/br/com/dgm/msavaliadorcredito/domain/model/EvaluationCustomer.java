package br.com.dgm.msavaliadorcredito.domain.model;

import lombok.Data;
import java.util.List;

@Data
public class EvaluationCustomer {

    private List<ApprovedCard> approvedCards;

}
