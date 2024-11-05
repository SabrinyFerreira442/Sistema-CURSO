package servico;

import java.util.ArrayList;

public abstract class BaseCursoServico<TDominio> {

    //Browse: irá exibir todos os cursos
    public abstract ArrayList<TDominio> Navegar();

    //Read: Irá ler um curso específico
    public abstract TDominio Ler(int chave);

    //Edit: Mudará um curso específico
    public abstract TDominio Editar(int chave, TDominio obj);

    //Create: Mudrá um curso por vez
    public abstract TDominio Adicionar(TDominio obj);

    //Delete: Excluirá um curso específico
    public abstract TDominio Remover(int chave);
}
