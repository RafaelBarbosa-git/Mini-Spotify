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
            }
        }while (sairDoApp != 3);
    }
}