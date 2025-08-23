import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        int sairDoApp;
        do {
        sairDoApp = catalogo.login();
            switch (sairDoApp){
                case 1:
                    catalogo.criarUsuario();
                    //deixar sem break para executar os 2 nesse caso
                case 2:
                    catalogo.escolherUsuario();
                    catalogo.menu();
                    break;
                default:

            }
        }while (sairDoApp != 3);
    }
}