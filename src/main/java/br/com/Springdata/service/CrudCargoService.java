package br.com.Springdata.service;


import br.com.Springdata.Repository.cargosRepository;
import br.com.Springdata.orm.cargo;
import br.com.Springdata.orm.cargosProjectao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class CrudCargoService {
    private cargosRepository cargosrepository;
    private Boolean system = true;

    public CrudCargoService(cargosRepository cargosrepository){
        this.cargosrepository = cargosrepository;


    }

    public void commence(Scanner scanner){
        while (system) {
            System.out.println("qual açao voce quer executar");
            System.out.println(" 0 - sair");
            System.out.println(" 1 - salvar");
            System.out.println(" 2 - atualizar");
            System.out.println(" 3 - visualizar");
            System.out.println(" 4 - Delectar");
            System.out.println(" 5 - visualizarCpf");


            int action = scanner.nextInt();

            switch (action){
                case 1:
                    salvar(scanner);
                break;
                case 2:
                    atualizar(scanner);
                break;
                case 3:
                    visualizar(scanner);
                    break;
                case 4:
                    detectar(scanner);
                    break;
                case 5:
                    pesquisaSalario();
                    break;

                default:
                    system = false;
                    break;
            }
        }

    }

    private void salvar(Scanner scanner){
        System.out.println("Descricao do cargo");
        String descricao = scanner.next();
        System.out.println("Nome do cargo");
        String nome = scanner.next();
        System.out.println("sobreNome do cargo");
        String SobreNome = scanner.next();
        System.out.println("datanascimento do cargo");
        String dataNascimento = scanner.next();
        System.out.println("CPF do cargo");
        String cpf = scanner.next();

        cargo cg = new  cargo();
        cg.setNome(nome);
        cg.setDescricao(descricao);
        cg.setSobrenome(SobreNome);
        cg.setCpf(cpf);
        cg.setDateNascimento(dataNascimento);
        cargosrepository.save(cg);
        System.out.println("salvo");
    }

    private void atualizar(Scanner scanner){
        System.out.println("informe o id");
        Long id = scanner.nextLong();
        System.out.println("Descricao do cargo");
        String descricao = scanner.next();
        cargo cg = new  cargo();
        cg.setId(id);
        cg.setDescricao(descricao);
        cargosrepository.save(cg);
        System.out.println("atualizado");

    }

    private void visualizar(Scanner scanner){
        System.out.println("qual pagina deseja visualizar");
        Integer page = scanner.nextInt();
        Pageable pageable = PageRequest.of(page,7, Sort.by(Sort.Direction.ASC,"cpf"));

        Page<cargo> cgs = cargosrepository.findAll(pageable);
        System.out.println(cgs);
        System.out.println("a pagina atual " + cgs.getNumber());
        System.out.println("total do elmentos " + cgs.getTotalElements());
        cgs.forEach(cargo -> System.out.println(cargo));
    }

    private void detectar(Scanner scanner){
        System.out.println("informe o id");
        Long id = scanner.nextLong();
        cargosrepository.deleteById(id);
        System.out.println("foi deletado");
    }
    private void pesquisaSalario(){
        List<cargosProjectao> list = cargosrepository.findCargosCpf();
        list.forEach(c -> System.out.println("cargos: id: " + c.getId() + " | Nome "
        + c.getNome() + "| sobrenome " + c.getSobrenome() + "| cpf " + c.getCpf() +
                " | descricao " + c.getDescricao() + " | datanascimento " + c.getDate_nascimento()));
    }
}


