package fakedb;

import java.util.ArrayList;

public abstract class BaseCursoFakeDB<TDominio> {

    protected ArrayList<TDominio> tabela;

    public ArrayList<TDominio> getTabela() {
        return tabela;
    }

    protected abstract void preencherDados();

    public BaseCursoFakeDB() {
        this.tabela = new ArrayList<>();
    }

}
