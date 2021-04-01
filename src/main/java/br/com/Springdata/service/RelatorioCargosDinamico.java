package br.com.Springdata.service;


import br.com.Springdata.Repository.cargosRepository;
import br.com.Springdata.orm.cargo;
import br.com.Springdata.specifiquetion.cargoSpecifique;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;


import java.util.List;
import java.util.Scanner;


@Configuration
public class RelatorioCargosDinamico {

    private final cargosRepository repository;
    public RelatorioCargosDinamico(cargosRepository repository) {
        this.repository = repository;
    }

    public void commence(Scanner scanner){
        System.out.println("digite o nome");
        String nome = scanner.next();
        if (nome.equalsIgnoreCase("NULL")){
            nome = null;
        }
        System.out.println("digite o descricao");
        String descricao = scanner.next();
        if (descricao.equalsIgnoreCase("NULL")){
            descricao = null;
        }
        System.out.println("digite o cpf");
        String cpf = scanner.next();
        if (cpf.equalsIgnoreCase("NULL")){
            cpf = null;
        }
        System.out.println("digite o Sobrenome");
        String Sobrenome = scanner.next();
        if (Sobrenome.equalsIgnoreCase("NULL")){
            Sobrenome = null;
        }
        System.out.println("digite o date_nascimento");
        String dateNascimento = scanner.next();
        if (dateNascimento.equalsIgnoreCase("NULL")) {
            dateNascimento = null;
        }

        List<cargo> cgS = repository.findAll(Specification.where(cargoSpecifique.nome(nome))
        .or(cargoSpecifique.cpf(cpf))
        .or(cargoSpecifique.descricao(descricao).or(cargoSpecifique.Sobrenome(Sobrenome))));
        cgS.forEach(System.out::println);

    }
}
