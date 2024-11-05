package visao;

import java.util.ArrayList;
import dominio.ModulosPresenciais;
import dominio.ModulosOnline;
import servico.CursoPresencialServico;
import servico.CursoOnlineServico;

public class ClasseCursosVisao {
    
    private CursoPresencialServico srvPresenciais;
    private CursoOnlineServico srvOnline;

    public ClasseCursosVisao() {
        this.srvPresenciais = new CursoPresencialServico();
        this.srvOnline = new CursoOnlineServico();
    }

    public void ExibirCursosPresenciais() {
        ArrayList<ModulosPresenciais> lista = this.srvPresenciais.Navegar(); 
        System.out.println("===========================================================");
        for (ModulosPresenciais curso : lista) {
            this.Imprimir(curso);
        }
    }

    public void ExibirCursosOnline() {
        ArrayList<ModulosOnline> lista = this.srvOnline.Navegar(); 
        System.out.println("===========================================================");
        for (ModulosOnline curso : lista) {
            this.Imprimir(curso);
        }
    }

    public void Imprimir(ModulosPresenciais curso) {
        System.out.println("Curso Presencial:");
        System.out.println("Código: " + curso.getCodigo());
        System.out.println("Descrição: " + curso.getDescricao());
        System.out.println("Localização: " + curso.getLocalizacao());
        System.out.println("--------------------------------------------------------");
    }

    public void Imprimir(ModulosOnline curso) {
        System.out.println("Curso Online:");
        System.out.println("Código: " + curso.getCodigo());
        System.out.println("Descrição: " + curso.getDescricao());
        System.out.println("Plataforma: " + curso.getPlataforma());
        System.out.println("--------------------------------------------------------");
    }

    public void ImprimirPorLinha(ModulosPresenciais curso) {
        String mensagem = "Curso Presencial: ";
        mensagem += "Código: " + curso.getCodigo() + " | ";
        mensagem += "Descrição: " + curso.getDescricao() + " | ";
        mensagem += "Localização: " + curso.getLocalizacao();
        System.out.println(mensagem);
    }

    public void ImprimirPorLinha(ModulosOnline curso) {
        String mensagem = "Curso Online: ";
        mensagem += "Código: " + curso.getCodigo() + " | ";
        mensagem += "Descrição: " + curso.getDescricao() + " | ";
        mensagem += "Plataforma: " + curso.getPlataforma();
        System.out.println(mensagem);
    }

    public void ImprimirPorLinhaPresencial(int chave) {
        ModulosPresenciais curso = this.srvPresenciais.Ler(chave);
        if (curso != null) {
            this.ImprimirPorLinha(curso);
        } else {
            System.out.println("Curso Presencial não localizado.");
        }
    }

    public void ImprimirPorLinhaOnline(int chave) {
        ModulosOnline curso = this.srvOnline.Ler(chave);
        if (curso != null) {
            this.ImprimirPorLinha(curso);
        } else {
            System.out.println("Curso Online não localizado.");
        }
    }

    public void CriarPresencial(ModulosPresenciais novo) {
        if (this.srvPresenciais.Adicionar(novo) != null) {
            System.out.println("Curso Presencial adicionado com sucesso.");
        } else {
            System.out.println("Problema ao adicionar Curso Presencial.");
        }
    }

    public void CriarOnline(ModulosOnline novo) {
        if (this.srvOnline.Adicionar(novo) != null) {
            System.out.println("Curso Online adicionado com sucesso.");
        } else {
            System.out.println("Problema ao adicionar Curso Online.");
        }
    }

    public void EditarPresencial(int chave, ModulosPresenciais alt) {
        ModulosPresenciais curso = this.srvPresenciais.Ler(chave);
        if (curso != null) {
            curso.setDescricao(alt.getDescricao());
            curso.setLocalizacao(alt.getLocalizacao());
            System.out.println("Curso Presencial atualizado com sucesso.");
        } else {
            System.out.println("Curso Presencial não localizado.");
        }
    }

    public void EditarOnline(int chave, ModulosOnline alt) {
        ModulosOnline curso = this.srvOnline.Ler(chave);
        if (curso != null) {
            curso.setDescricao(alt.getDescricao());
            curso.setPlataforma(alt.getPlataforma());
            System.out.println("Curso Online atualizado com sucesso.");
        } else {
            System.out.println("Curso Online não localizado.");
        }
    }

    public void RemoverPresencial(int chave) {
        ModulosPresenciais curso = this.srvPresenciais.Ler(chave);
        if (curso != null) {
            this.srvPresenciais.Remover(chave);
            System.out.println("Curso Presencial removido com sucesso.");
        } else {
            System.out.println("Curso Presencial não localizado.");
        }
    }

    public void RemoverOnline(int chave) {
        ModulosOnline curso = this.srvOnline.Ler(chave);
        if (curso != null) {
            this.srvOnline.Remover(chave);
            System.out.println("Curso Online removido com sucesso.");
        } else {
            System.out.println("Curso Online não localizado.");
        }
    }
}
