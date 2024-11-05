package fakedb;

import dominio.ModulosOnline;
import java.util.List;

public final class ModulosOnlineFakeDB extends BaseCursoFakeDB<ModulosOnline> {

    public ModulosOnlineFakeDB() {
        super();
        this.preencherDados();
    }

    @Override
    protected void preencherDados() {
        this.tabela.add(new ModulosOnline("Remoto",
                "http.setornandoumdesenvolvedor.com",
                "Se Tornando Um Desenvolvedor",
                1009,
                "Aprimorando seus conhecimentos para se tornar um programador ágil ",
                "Breves conteúdos que visam facilitar a implementação daquilo que você já sabe!",
                List.of("O que são boas práticas na hora de programar?", "Como organizar meu código de forma mais eficiente?", "Onde publicar meus projetos?",
                "Onde recorrer quando me surgir dúvidas?"),
                15, 90));
    
    this.tabela.add(new ModulosOnline("Remoto",
                "http.setornandoumdesenvolvedor.com",
                "Se Tornando Um Desenvolvedor",
                1011,
                "Trabalahando com HTML e CSS",
                "Esse curso tem por objetivo te ensinar a criar páginas web",
                List.of("O que é HTML", "O que é CSS?", "Como utilizar os dois em conjunto?",
                "Comocriar efeitos especiais nas minhas páginas?", "Como alicar o JavaScript no HTML?"),
                30, 70));
    }
}
