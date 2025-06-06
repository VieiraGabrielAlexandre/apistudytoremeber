package br.com.vieiragabriel.exerciciossb.models.repositories;

import br.com.vieiragabriel.exerciciossb.models.entities.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
