package servico;

import java.util.ArrayList;
import dominio.ModulosOnline;
import repositorio.CursosOnlineRepositorio;

public class CursoOnlineServico extends BaseCursoServico<ModulosOnline> {
    
    private CursosOnlineRepositorio repositorio;

    public CursoOnlineServico() {
        this.repositorio = new CursosOnlineRepositorio();
    }

    @Override
    public ArrayList<ModulosOnline> Navegar() {
        // Browse: retorna todos os cursos online
        return repositorio.Browse();
    }

    @Override
    public ModulosOnline Ler(int chave) {
        // Read: busca um curso online específico pelo código
        return repositorio.Read(chave);
    }

    @Override
    public ModulosOnline Editar(int chave, ModulosOnline instancia) {
        // Edit: edita um curso online específico
        ModulosOnline cursoExistente = repositorio.Read(chave);
        if (cursoExistente != null) {
            return repositorio.Edit(instancia);
        }
        System.out.println("Curso não encontrado para edição.");
        return null;
    }

    @Override
    public ModulosOnline Adicionar(ModulosOnline instancia) {
        // Add: adiciona um novo curso online
        return repositorio.Add(instancia);
    }

    @Override
    public ModulosOnline Remover(int chave) {
        // Delete: remove um curso online específico
        return repositorio.Delete(chave);
    }
}
