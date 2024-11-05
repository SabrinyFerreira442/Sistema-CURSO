package visao;

import java.util.Scanner;


public abstract class BaseMenu {

    protected Scanner scanner;

    public BaseMenu(){
        this.scanner = new Scanner(System.in);
    }

    public abstract void ExibirMenu();
    public abstract void ListarPresenciais();
    public abstract void ListarOnline();
    public abstract void LocalizarPresencial();
    public abstract void LocalizarOnline();
    public abstract void AdicionarPresencial();
    public abstract void AdicionarOnline();
    public abstract void AtualizarPresencial();
    public abstract void AtualizarOnline();
    public abstract void RemoverPresencial();
    public abstract void RemoverOnline();

}