package br.com.vieiragabriel.exerciciossb.models.repositories;

import br.com.vieiragabriel.exerciciossb.models.entities.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>, PagingAndSortingRepository<Produto, Integer> {
    public Iterable<Produto> findByNomeContaining(String parteNome);

}
