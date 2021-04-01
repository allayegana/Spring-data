package br.com.Springdata.orm;

import org.springframework.stereotype.Component;

@Component
public interface cargosProjectao {
    Integer getId();
    String getDescricao();
    String getNome();
    String getSobrenome();
    String getCpf();
    String getDate_nascimento();
}
