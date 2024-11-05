package repositorio;

import java.util.ArrayList;
import dominio.ModulosOnline;
import fakedb.ModulosOnlineFakeDB;

public class CursosOnlineRepositorio extends BaseCursoRepositorio<ModulosOnline> {

    private ModulosOnlineFakeDB db;

    public CursosOnlineRepositorio() {
        this.db = new ModulosOnlineFakeDB();
        this.dados = this.db.getTabela();
    }

    // Browse - Retorna todos os cursos
    public ArrayList<ModulosOnline> Browse() {
        return this.dados;
    }

    // Read - Busca um curso específico pelo código
    @Override
    public ModulosOnline Read(int chave) {
        for (ModulosOnline curso : this.dados) {
            if (curso.getCodigo() == chave) {
                return curso;
            }
        }
        return null;
    }

    // Edit - Atualiza um curso existente
    @Override
    public ModulosOnline Edit(ModulosOnline instancia) {
        for (ModulosOnline curso : dados) {
            if (curso.getCodigo() == instancia.getCodigo()) {
                curso.setNome(instancia.getNome());
                curso.setDescricao(instancia.getDescricao());
                curso.setCargaHoraria(instancia.getCargaHoraria());
                curso.setNumeroDeAulas(instancia.getNumeroDeAulas());
                curso.setMaterias(instancia.getMaterias());
                curso.setLinkDeACesso(instancia.getLinkDeACesso());
                curso.setFormatoDasAulas(instancia.getFormatoDasAulas());
                curso.setPlataforma(instancia.getPlataforma());

                return curso;
            }
        }
        return null;
    }

    // Add - Adiciona um novo curso
    @Override
    public ModulosOnline Add(ModulosOnline instancia) {
        for (ModulosOnline curso : dados) {
            if (curso.getCodigo() == instancia.getCodigo()) {
                return null;
            }
        }
        dados.add(instancia);
        return instancia;
    }

    // Delete - Remove um curso existente
    @Override
    public ModulosOnline Delete(int chave) {
        for (ModulosOnline curso : this.dados) {
            if (curso.getCodigo() == chave) {
                dados.remove(curso);
                return curso;
            }
        }
        return null;
    }
}
