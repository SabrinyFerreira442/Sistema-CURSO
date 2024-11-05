package dominio;

import java.util.List;

public class ModulosOnline extends BaseCurso {

    protected String plataforma;
    protected String linkDeACesso;
    protected String formatoDasAulas;

    public ModulosOnline() {
    }

    public ModulosOnline(String formatoDasAulas, String linkDeACesso, String plataforma, int codigo, String nome, String descricao, List<String> materias, int numeroDeAulas, int cargaHoraria) {
        super(codigo, nome, descricao, materias, numeroDeAulas, cargaHoraria);
        this.formatoDasAulas = formatoDasAulas;
        this.linkDeACesso = linkDeACesso;
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinkDeACesso() {
        return linkDeACesso;
    }

    // caso seja inserido um link invalido
    public void setLinkDeACesso(String linkDeACesso) {
        if (linkDeACesso == null || !linkDeACesso.startsWith("http")) {
            throw new IllegalArgumentException("O link de acesso deve começar com http.");
        }
        this.linkDeACesso = linkDeACesso;
    }

    public String getFormatoDasAulas() {
        return formatoDasAulas;
    }

    public void setFormatoDasAulas(String formatoDasAulas) {
        this.formatoDasAulas = formatoDasAulas;
    }

}
