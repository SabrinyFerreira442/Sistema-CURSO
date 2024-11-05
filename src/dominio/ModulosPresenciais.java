package dominio;

import java.util.List;

public class ModulosPresenciais extends BaseCurso {

    protected String localizacao;

    public ModulosPresenciais() {
    }

    public ModulosPresenciais(int codigo, String nome, String descricao, List<String> materias, int numeroDeAulas, int cargaHoraria, String localizacao) {
        super(codigo, nome, descricao, materias, numeroDeAulas, cargaHoraria);
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
