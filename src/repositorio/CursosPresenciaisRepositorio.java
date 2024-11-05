package repositorio;

import java.util.ArrayList;
import dominio.ModulosPresenciais;
import fakedb.ModulosPresencialFakeDB;

public class CursosPresenciaisRepositorio extends BaseCursoRepositorio<ModulosPresenciais> {

    private ModulosPresencialFakeDB db;

    public CursosPresenciaisRepositorio() {
        this.db = new ModulosPresencialFakeDB();
        this.dados = this.db.getTabela();
    }

    // Browse - Retorna todos os cursos
    public ArrayList<ModulosPresenciais> Browse() {
        return this.dados;
    }

    // Read - Busca um curso específico pelo código
    @Override
    public ModulosPresenciais Read(int chave) {
        for (ModulosPresenciais curso : this.dados) {
            if (curso.getCodigo() == chave) {
                return curso;
            }
        }
        return null;
    }

    // Edit - Atualiza um curso existente
    @Override
    public ModulosPresenciais Edit(ModulosPresenciais instancia) {
        for (ModulosPresenciais curso : dados) {
            if (curso.getCodigo() == instancia.getCodigo()) {
                curso.setNome(instancia.getNome());
                curso.setDescricao(instancia.getDescricao());
                curso.setCargaHoraria(instancia.getCargaHoraria());
                curso.setNumeroDeAulas(instancia.getNumeroDeAulas());
                curso.setMaterias(instancia.getMaterias());
                curso.setLocalizacao(instancia.getLocalizacao());                return curso;
            }
        }
        return null;
    }

    // Add - Adiciona um novo curso
    @Override
    public ModulosPresenciais Add(ModulosPresenciais instancia) {
        for (ModulosPresenciais curso : dados) {
            if (curso.getCodigo() == instancia.getCodigo()) {
                return null;
            }
        }
        dados.add(instancia);
        return instancia;
    }

    // Delete - Remove um curso existente
    @Override
    public ModulosPresenciais Delete(int chave) {
        for (ModulosPresenciais curso : this.dados) {
            if (curso.getCodigo() == chave) {
                dados.remove(curso);
                return curso;
            }
        }
        return null;
    }
}
