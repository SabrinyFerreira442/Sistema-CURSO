package servico;

import java.util.ArrayList;
import dominio.ModulosPresenciais;
import repositorio.CursosPresenciaisRepositorio;

public class CursoPresencialServico extends BaseCursoServico<ModulosPresenciais> {
    
    private CursosPresenciaisRepositorio repositorio;

    public CursoPresencialServico() {
        this.repositorio = new CursosPresenciaisRepositorio();
    }

    @Override
    public ArrayList<ModulosPresenciais> Navegar() {
        return repositorio.Browse();
    }

    @Override
    public ModulosPresenciais Ler(int chave) {
        return repositorio.Read(chave);
    }

    @Override
    public ModulosPresenciais Editar(int chave, ModulosPresenciais instancia) {
        ModulosPresenciais cursoExistente = repositorio.Read(chave);
        if (cursoExistente != null) {
            return repositorio.Edit(instancia);
        }
        System.out.println("Curso não encontrado para edição.");
        return null;
    }

    @Override
    public ModulosPresenciais Adicionar(ModulosPresenciais instancia) {
        return repositorio.Add(instancia);
    }

    @Override
    public ModulosPresenciais Remover(int chave) {
        return repositorio.Delete(chave);
    }
}
