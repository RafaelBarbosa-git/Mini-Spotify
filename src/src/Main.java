public class Main {
    public static void main(String[] args) {
        Gerenciamento gerenciameto = new Gerenciamento();
        int sairDoApp;
        do {
        sairDoApp = gerenciameto.login();
            switch (sairDoApp) {
                case 1:
                    gerenciameto.criarUsuario();
                    //deixar sem break para executar os 2 nesse caso
                case 2:
                    gerenciameto.escolherUsuario();
                    gerenciameto.menu();
                    break;
                case 3:
                default:
                    System.out.println("Opção inválida! Digite apenas números inteiros de 1 a 3!");
            }
            }while (sairDoApp != 3);
//                 case 3:
//                        if (usuario == null) {
//                            System.out.println("Cadastre um usuário primeiro!\n");
//                            break;
//                        }
//                        gerenciameto.exibirCatalogo();
//                        System.out.print("Digite o título da mídia para adicionar: ");
//                        String tituloAdd = sc.nextLine();
//                        System.out.print("Digite o nome da playlist: ");
//                        String nomePL = sc.nextLine();
//
//                        Playlist p = usuario.getPlaylist(nomePL);
//                        if (p != null) {
//                            for (Midias m : gerenciameto.midias) {
//                                if (m.getTitulo().equalsIgnoreCase(tituloAdd)) {
//                                    p.adicionarMidia(m);
//                                    System.out.println("Mídia adicionada!\n");
//                                }
//                            }
//                        } else {
//                            System.out.println("Playlist não encontrada!\n");
//                        }
//                        break;
//
//                    case 4:
//                        if (usuario == null) {
//                            System.out.println("Cadastre um usuário primeiro!\n");
//                            break;
//                        }
//                        System.out.print("Nome da playlist: ");
//                        String nomeRemover = sc.nextLine();
//                        Playlist pr = usuario.getPlaylist(nomeRemover);
//                        if (pr != null) {
//                            System.out.print("Título da mídia a remover: ");
//                            String tituloRemover = sc.nextLine();
//                            pr.removerMidia(tituloRemover);
//                            System.out.println("Mídia removida!\n");
//                        } else {
//                            System.out.println("Playlist não encontrada!\n");
//                        }
//                        break;
//
//                    case 5:
//                        if (usuario == null) {
//                            System.out.println("Cadastre um usuário primeiro!\n");
//                            break;
//                        }
//                        usuario.exibirPlaylists();
//                        break;
//
        }
    }
