package br.com.Springdata.Repository;




import br.com.Springdata.orm.cargo;
import br.com.Springdata.orm.cargosProjectao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cargosRepository extends PagingAndSortingRepository<cargo,Long>,
        JpaSpecificationExecutor<cargo> {


    @Query(value = "select c.id,c.nome,c.sobrenome,c.cpf,c.descricao,c.date_nascimento from cargos c", nativeQuery = true)
    List<cargosProjectao> findCargosCpf();

}

