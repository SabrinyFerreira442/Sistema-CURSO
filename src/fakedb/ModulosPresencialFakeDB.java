package fakedb;

import dominio.ModulosPresenciais;
import java.util.List;

public final class ModulosPresencialFakeDB extends BaseCursoFakeDB<ModulosPresenciais> {

    public ModulosPresencialFakeDB() {
        super();
        this.preencherDados();

    }

    @Override
    protected void preencherDados() {
        this.tabela.add(new ModulosPresenciais(1010,
                "Se Tornando um programador",
                "Conhecendo desde o básico ao mais avançado no mundo da Programação",
                List.of("O que são Algoritmos?", "Algoritmos e estrutura de Dados", "Princípios da POO", "Programando em Java",
                 "Conhecendo as linguagens de estilização"),
                120, 500, "Rua Tal"));
    
                this.tabela.add(new ModulosPresenciais(1009,
                "Se Tornando um programador",
                "Conhecendo desde o básico ao mais avançado no mundo da Programação",
                List.of("O que é o JavaScript?", "Programando em JavaScript", "Por que consideram a linguagem C a 'mãe' de todas as linguagens?", "Programando em Linguagem C",
                 "Algoritmos e Estrutura de Dados Avançado"),
                100, 400, "Rua Tal"));
    }
}
