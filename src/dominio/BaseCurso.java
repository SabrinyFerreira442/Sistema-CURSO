package dominio;

import java.util.ArrayList;
import java.util.List;

public class BaseCurso {

    protected int codigo;
    protected String nome;
    protected String descricao;
    protected int cargaHoraria;
    protected List<String> materias;
    protected int numeroDeAulas;

    public BaseCurso() {
        materias = new ArrayList<>();
    }

    public BaseCurso(int codigo, String nome, String descricao, List<String> materias, int numeroDeAulas, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.materias = materias;
        this.numeroDeAulas = numeroDeAulas;
        this.cargaHoraria = cargaHoraria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    public int getNumeroDeAulas() {
        return numeroDeAulas;
    }

    public void setNumeroDeAulas(int numeroDeAulas) {
        this.numeroDeAulas = numeroDeAulas;
    }

    public void inserirMaterias(List<String> novasMaterias) {
        materias.addAll(novasMaterias);
    }

}
