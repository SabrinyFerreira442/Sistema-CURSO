package repositorio;

import java.util.ArrayList;

public abstract class BaseCursoRepositorio<TDominio> {

    protected ArrayList<TDominio> dados = new ArrayList<>();

    public ArrayList<TDominio> getBrowse() {
        return this.dados;
    }

    public abstract TDominio Read(int chave);

    public abstract TDominio Edit(TDominio instancia);

    public abstract TDominio Add(TDominio instancia);

    public abstract TDominio Delete(int chave);
}

/*TDominio é um parâmetro do tipo genérico, que faz com que a classe Curso Repositorio
funcione para qualquer tipo de curso (presencial, online e etc.)*/

 /*O parâmetro instancia em Update e Add representa o objeto inteiro que será adicionado 
ou atualizado na lista dados.*/
