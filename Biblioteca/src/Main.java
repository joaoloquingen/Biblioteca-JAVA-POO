import java.util.Scanner;

public class Main {

  //Criando função para controlar biblioteca

    private static final ControladorBiblioteca controladorBiblioteca = new ControladorBiblioteca();
    public static void main(String[] args) {

        //Importando scanner

        Scanner imput = new Scanner(System.in);
        boolean naoTerminou;

        //Loop do menu, precisa escolher de acordo com as opções do meu se não ficará repetindo até

        do {
            mostrarMenu();
            naoTerminou = escolherOpcao(imput);
        }while (naoTerminou);
    }

    //Função do menu
    public static void mostrarMenu(){
        System.out.println("------------- Bem vindo a nossa biblioteca de livros -------------");
        System.out.println("Escolha uma das opções do menu abaixo.");
        System.out.println("1 - Cadastrar livro.");
        System.out.println("2 - Buscar livro.");
        System.out.println("3 - Editar livro.");
        System.out.println("4 - Remover livro.");
        System.out.println("5 - Sair.");
    }

    //Enquanto eu digitar de 1 a 5 será true, caso eu digite algo fora disso dará false e repetirá o loop.
    public static boolean escolherOpcao(Scanner imput){
        int opcao = imput.nextInt();
        imput.nextLine();

        //não finalizou começa verdadeiro e depois que digitar o numero 5 e ficar falso ele finalizará o programa.

        boolean naoFinalizou = true;
        switch (opcao){
            case 1:
                criarLivros(imput);
                break;
            case 2:
                buscarLivros(imput);
                break;
            case 3:
                atualizarLivros(imput);
                break;
            case 4:
                removerLivros(imput);
                break;
            case 5:
                naoFinalizou = false;
                System.out.println("Você saiu da biblioteca.");
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
        return naoFinalizou;
    }

    //Criando funções que trabalham juntos com os métodos do controlador da biblioteca.

    public static void criarLivros(Scanner imput){
        System.out.println("Digite o nome do livro.");
        String nomeLivro = imput.nextLine();
        System.out.println("Digite o nome do autor do livro.");
        String autor = imput.nextLine();
        System.out.println("Digite o ano do livro.");
        Integer anoLivro = imput.nextInt();
        System.out.println("Digite o numero de paginas do livro.");
        Integer numPag = imput.nextInt();
        imput.nextLine();
        controladorBiblioteca.criarLivro(nomeLivro, autor, anoLivro, numPag);
    }
    public static void buscarLivros(Scanner imput){
        System.out.println("Digite o nome do livro que você deseja encontrar.");
        String nome = imput.nextLine();
        Livro livro = controladorBiblioteca.readLivro(nome);
        System.out.println("\nNome do livro " + livro.getTitulo() +
                            "\nAutor do livro " + livro.getAutor() +
                            "\nPáginas do livro " + livro.getNumPaginas() +
                            "\nAno da publicação do livro " + livro.getAno() +
                            "!!!!!");
    }
    public static void atualizarLivros(Scanner imput){
        System.out.println("Digite o nome do livro que você deseja atualizar.");
        String nomeLivro = imput.nextLine();
        System.out.println("Digite a atualização do autor do livro.");
        String autorLivro = imput.nextLine();
        System.out.println("Digite a atualização do ano do livro.");
        Integer anoLivro = imput.nextInt();
        System.out.println("Digite a atualização do número de páginas do livro.");
        Integer pagLivro = imput.nextInt();
        imput.nextLine();
        controladorBiblioteca.updateLivro( nomeLivro, autorLivro, anoLivro, pagLivro);
    }
    public static void removerLivros(Scanner imput){
        System.out.println("Digite o nome do livro que deseja remover.");
        String nomeLivro = imput.nextLine();
        controladorBiblioteca.removeLivro(nomeLivro);
    }
}

//Métodos não tem Static, só funções.

//Quando tem void, não tem return.

//Get é para buscar a informação.
//Set é pra setar um novo dado na variável.