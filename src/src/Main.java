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
                    boolean existeUsuario = gerenciameto.escolherUsuario();
                    if (existeUsuario) {
                        int opcaoMenu;
                        do {
                            opcaoMenu = gerenciameto.menu();
                            switch (opcaoMenu) {
                                case 1:
                                    gerenciameto.criarPlaylist();
                                    break;
                                case 2:
                                    gerenciameto.verPlaylists();
                                    break;
                                case 3:
                                    gerenciameto.adicionarMidia();
                                    break;
                                case 4:
                                    gerenciameto.verSuasMidias();
                                    break;
                                case 5:
                                    gerenciameto.pesquisarMidias();
                                    break;
                                case 6:
                                    System.out.println("Saindo da conta...");
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                        } while (opcaoMenu != 6);
                    }
                    break;
                case 3:
                    System.out.println("Saindo do aplicativo...");
                    break;

                default:

                    System.out.println("Opção inválida! Digite apenas números inteiros de 1 a 3!");
            }
            }while (sairDoApp != 3);
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
