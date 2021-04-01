package br.com.Springdata.specifiquetion;


import br.com.Springdata.orm.cargo;
import org.springframework.data.jpa.domain.Specification;

public class cargoSpecifique {
    public static Specification<cargo> nome(String nome){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"),"%" + nome + "%"));
    }
    public static Specification<cargo> Sobrenome(String Sobrenome){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("Sobrenome"),"%" + Sobrenome + "%"));
    }
    public static Specification<cargo> descricao(String descricao){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("descricao"),"%" + descricao + "%"));
    }
    public static Specification<cargo> cpf(String cpf){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"),cpf));
    }
    public static Specification<cargo> dateNascimento(String dateNascimento){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("dateNascimento"),"%" + dateNascimento + "%"));
    }
}
