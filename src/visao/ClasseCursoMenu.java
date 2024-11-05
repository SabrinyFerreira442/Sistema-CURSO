package visao;

import java.util.ArrayList;
import java.util.List;

import dominio.ModulosPresenciais;
import dominio.ModulosOnline;
import servico.CursoPresencialServico;
import servico.CursoOnlineServico;

public class ClasseCursoMenu extends BaseMenu {

    private CursoPresencialServico srvPresenciais;
    private CursoOnlineServico srvOnline;

    public ClasseCursoMenu() {
        super();
        this.srvPresenciais = new CursoPresencialServico();
        this.srvOnline = new CursoOnlineServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while (opcao != 11) {
            Util.LimparConsole();
            System.out.print("Selecione uma opção:\n");
            System.out.println("Cadastro dos Cursos Presencias:");
            System.out.println("1 - Listar Cursos Presenciais");
            System.out.println("2 - Localizar Cursos Presenciais");
            System.out.println("3 - Adicionar Curso Presencial");
            System.out.println("4 - Atualizar Curso Presencial");
            System.out.println("5 - Remover Curso Presencial");
            System.out.println("\nCadastro dos Cursos Online:");
            System.out.println("6 - Listar Cursos Online");
            System.out.println("7 - Localizar Cursos Online");
            System.out.println("8 - Adicionar Curso Online");
            System.out.println("9 - Atualizar Curso Online");
            System.out.println("10 - Remover Curso Online");
            System.out.println("11 - Sair");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.ListarPresenciais();
                    break;
                case 2:
                    this.LocalizarPresencial();
                    break;
                case 3:
                    this.AdicionarPresencial();
                    break;
                case 4:
                    this.AtualizarPresencial();
                    break;
                case 5:
                    this.RemoverPresencial();
                    break;
                case 6:
                    this.ListarOnline();
                    break;
                case 7:
                    this.LocalizarOnline();
                    break;
                case 8:
                    this.AdicionarOnline();
                    break;
                case 9:
                    this.AtualizarOnline();
                    break;
                case 10:
                    this.RemoverOnline();
                    break;
                case 11:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida! \n Tente Novamente! \n");
                    break;
            }
        }
    }

    public void ListarPresenciais() {
        Util.LimparConsole();
        System.out.println("Listando Cursos Presenciais");

        ArrayList<ModulosPresenciais> lista = this.srvPresenciais.Navegar();
        for (ModulosPresenciais curso : lista) {
            this.ImprimirPorLinha(curso);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    public void ListarOnline() {
        Util.LimparConsole();
        System.out.println("Listando Cursos Online");

        ArrayList<ModulosOnline> lista = this.srvOnline.Navegar();
        for (ModulosOnline curso : lista) {
            this.ImprimirPorLinha(curso);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    public void LocalizarPresencial() {
        Util.LimparConsole();
        System.out.println("Localizando Curso Presencial");

        System.out.print("Informe o código do Curso Presencial: ");
        int cod = this.scanner.nextInt();

        ModulosPresenciais curso = this.srvPresenciais.Ler(cod);
        if (curso != null) {
            this.ImprimirPorLinha(curso);
            System.out.println("Curso Presencial localizado com sucesso.");
        } else {
            System.out.println("Curso Presencial não encontrado.");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine(); // Limpa o buffer
        this.scanner.nextLine(); // Espera o usuário pressionar <ENTER>
    }

    
    public void LocalizarOnline() {
        Util.LimparConsole();
        System.out.println("Localizando Curso Online");

        System.out.print("Informe o código do Curso Online: ");
        int cod = this.scanner.nextInt();

        ModulosOnline curso = this.srvOnline.Ler(cod);
        if (curso != null) {
            this.ImprimirPorLinha(curso);
            System.out.println("Curso Online localizado com sucesso.");
        } else {
            System.out.println("Curso Online não encontrado.");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine(); 
        this.scanner.nextLine(); 
    }



    public void AdicionarPresencial() {
            Util.LimparConsole();
            System.out.println("Adicionando Curso Presencial");
        
            ModulosPresenciais curso = new ModulosPresenciais();
            
            System.out.print("Informe o código: ");
            curso.setCodigo(this.scanner.nextInt());
            this.scanner.nextLine();

            System.out.print("Informe o nome: ");
            curso.setNome(this.scanner.next());
            
            System.out.print("Informe a descrição: ");
            curso.setDescricao(this.scanner.next());
            this.scanner.nextLine();

            System.out.print("Informe o número de aulas: ");
            curso.setNumeroDeAulas(this.scanner.nextInt());
            this.scanner.nextLine();

            System.out.print("Informe a carga horária: ");
            curso.setCargaHoraria(this.scanner.nextInt());
            this.scanner.nextLine();

            System.out.print("Informe a localização: ");
            curso.setLocalizacao(this.scanner.next());
        
            // Captura das matérias
            List<String> materias = new ArrayList<>();
            System.out.println("Informe as matérias (digite 'fim' para encerrar):");
            while (true) {
                System.out.print("Matéria: ");
                String materia = this.scanner.next();
                if (materia.equalsIgnoreCase("fim")) {
                    break; // Encerra a captura de matérias
                }
                materias.add(materia); // Adiciona a matéria à lista
            }
        
            curso.setMaterias(materias); // Define as matérias no curso
        
            if (this.srvPresenciais.Adicionar(curso) != null) {
                System.out.println("Curso Presencial adicionado com sucesso");
            } else {
                System.out.println("Problema - Erro ao adicionar Curso Presencial");
            }
        
            System.out.println("Clique <ENTER> para continuar...");
            this.scanner.nextLine(); // Limpa o buffer
            this.scanner.nextLine();
        }
        
    public void AdicionarOnline() {
            Util.LimparConsole();
            System.out.println("Adicionando Curso Online");
        
            ModulosOnline curso = new ModulosOnline();
            
            System.out.print("Informe o código: ");
            curso.setCodigo(this.scanner.nextInt());
            this.scanner.nextLine();

            System.out.print("Informe o nome: ");
            curso.setNome(this.scanner.next());
            
            System.out.print("Informe a descrição: ");
            curso.setDescricao(this.scanner.next());
            
            System.out.print("Informe o número de aulas: ");
            curso.setNumeroDeAulas(this.scanner.nextInt());
            this.scanner.nextLine();
            
            System.out.print("Informe a carga horária: ");
            curso.setCargaHoraria(this.scanner.nextInt());
            this.scanner.nextLine();

            System.out.print("Informe a plataforma: ");
            curso.setPlataforma(this.scanner.next());
        
            // Captura das matérias
            List<String> materias = new ArrayList<>();
            System.out.println("Informe as matérias (digite 'fim' para encerrar):");
            while (true) {
                System.out.print("Matéria: ");
                String materia = this.scanner.next();
                if (materia.equalsIgnoreCase("fim")) {
                    break; 
                }
                materias.add(materia);
            }
        
            curso.setMaterias(materias);
        
            if (this.srvOnline.Adicionar(curso) != null) {
                System.out.println("Curso Online adicionado com sucesso");
            } else {
                System.out.println("Problema - Erro ao adicionar Curso Online");
            }
        
            System.out.println("Clique <ENTER> para continuar...");
            this.scanner.nextLine(); 
            this.scanner.nextLine(); 
    }

    public void AtualizarPresencial() {
        Util.LimparConsole();        
            System.out.print("Informe o código do Curso Presencial: ");
            int cod = this.scanner.nextInt();
            this.scanner.nextLine();
        
            ModulosPresenciais curso = this.srvPresenciais.Ler(cod);
            if (curso != null) {
                System.out.print("Informe o novo nome do Curso: ");
                String nome = this.scanner.nextLine();
                curso.setNome(nome);
        
                System.out.print("Informe a nova Descrição: ");
                String descricao = this.scanner.nextLine();
                curso.setDescricao(descricao);
        
                System.out.println("Informe as matérias (separadas por vírgula): ");
                String materiasInput = this.scanner.nextLine();
                List<String> materias = new ArrayList<>();
                for (String materia : materiasInput.split(",")) {
                    materias.add(materia.trim());
                }
                curso.setMaterias(materias);
        
                System.out.print("Informe o número de aulas: ");
                int numeroDeAulas = this.scanner.nextInt();
                curso.setNumeroDeAulas(numeroDeAulas);
                this.scanner.nextLine();
        
                System.out.print("Informe a carga horária do curso: ");
                int cargaHoraria = this.scanner.nextInt();
                curso.setCargaHoraria(cargaHoraria);
                this.scanner.nextLine();
        
                if (this.srvPresenciais.Editar(cod, curso) != null) {
                    System.out.println("Curso Presencial atualizado com sucesso!");
                } else {
                    System.out.println("Problema - Não foi possível atualizar o Curso Presencial.");
                }
            } else {
                System.out.println("Problema - Curso Presencial não encontrado.");
            }
        
            System.out.println("Clique <ENTER> para continuar...");
            this.scanner.nextLine();
        
    }
    
    
    public void AtualizarOnline() {
        Util.LimparConsole();
    
        System.out.print("Informe o código do Curso Online: ");
        int cod = this.scanner.nextInt();
        this.scanner.nextLine(); // Limpa o buffer após nextInt()
    
        ModulosOnline curso = this.srvOnline.Ler(cod);
        if (curso != null) {
            System.out.print("Informe o novo nome do Curso: ");
            String nome = this.scanner.nextLine();
            curso.setNome(nome);
    
            System.out.print("Informe a nova Descrição: ");
            String descricao = this.scanner.nextLine();
            curso.setDescricao(descricao);
    
            System.out.println("Informe as matérias (separadas por vírgula): ");
            String materiasInput = this.scanner.nextLine();
            List<String> materias = new ArrayList<>();
            for (String materia : materiasInput.split(",")) {
                materias.add(materia.trim());
            }
            curso.setMaterias(materias);
    
            System.out.print("Informe o número de aulas: ");
            while (!this.scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido para o número de aulas.");
                this.scanner.next(); // Descarta a entrada inválida
            }
            int numeroDeAulas = this.scanner.nextInt();
            curso.setNumeroDeAulas(numeroDeAulas);
            this.scanner.nextLine(); // Limpa o buffer
    
            System.out.print("Informe a carga horária do curso: ");
            while (!this.scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido para a carga horária.");
                this.scanner.next(); // Descarta a entrada inválida
            }
            int cargaHoraria = this.scanner.nextInt();
            curso.setCargaHoraria(cargaHoraria);
            this.scanner.nextLine(); // Limpa o buffer
    
            if (this.srvOnline.Editar(cod, curso) != null) {
                System.out.println("Curso Online atualizado com sucesso!");
            } else {
                System.out.println("Problema - Não foi possível atualizar o Curso Online.");
            }
        } else {
            System.out.println("Problema - Curso Online não encontrado.");
        }
    
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine(); // Aguarda o usuário pressionar Enter
    }
    
        
  
    public void RemoverPresencial() {
        Util.LimparConsole();
        System.out.println("Removendo Curso Presencial");
    
        System.out.print("Informe o código do Curso Presencial: ");
        int cod = this.scanner.nextInt();
        ModulosPresenciais curso = this.srvPresenciais.Ler(cod);
        if (curso != null) {
            if (this.srvPresenciais.Remover(cod) != null) {
                System.out.println("Curso Presencial excluído com sucesso");
            } else {
                System.out.println("Problema - Curso Presencial não foi excluído");
            }
        } else {
            System.out.println("Problema - Curso Presencial não encontrado");
        }
    
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
    
    public void RemoverOnline() {
        Util.LimparConsole();
        System.out.println("Removendo Curso Online");
    
        System.out.print("Informe o código do Curso Online: ");
        int cod = this.scanner.nextInt();
        ModulosOnline curso = this.srvOnline.Ler(cod);
        if (curso != null) {
            if (this.srvOnline.Remover(cod) != null) {
                System.out.println("Curso Online excluído com sucesso");
            } else {
                System.out.println("Problema - Curso Online não foi excluído");
            }
        } else {
            System.out.println("Problema - Curso Online não encontrado");
        }
    
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
    

    private void ImprimirPorLinha(ModulosPresenciais curso) {
        String mensagem = "";
        mensagem += "Curso Presencial: ";
        mensagem += "Código: " + curso.getCodigo() + " | ";
        mensagem += "Nome: " + curso.getNome() + " | ";
        mensagem += "Localização: " + curso.getLocalizacao();
        System.out.println(mensagem);
    }

    private void ImprimirPorLinha(ModulosOnline curso) {
        String mensagem = "";
        mensagem += "Curso Online: ";
        mensagem += "Código: " + curso.getCodigo() + " | ";
        mensagem += "Nome: " + curso.getNome() + " | ";
        mensagem += "Plataforma: " + curso.getPlataforma();
        System.out.println(mensagem);
        }
}
