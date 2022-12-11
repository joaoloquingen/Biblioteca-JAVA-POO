import java.util.HashMap;
import java.util.Map;

public class ControladorBiblioteca {

    //HashMap é um conjunto de pares de chaves/valor, para cada elemento contém um valor salvo no HashMap,
    // deve existir uma chave "titulo" unica atrelada a ele, os elementos no HashMap deve ser acessado por suas chaves.
    private Map<String, Livro> livros = new HashMap<>();

    //Método para criar o livro
    //ContainsKey serve para verificar se uma chave especifica está sendo mapeada ou não,
    // ele pega o elemento chave como parâmetro e retorna true se o elemento estiver mapeado no mapa;

    public void criarLivro(String titulo, String autor, Integer ano, Integer numeroPag){
        if (!livros.containsKey(titulo)){
            livros.put(titulo, new Livro(titulo, autor, ano, numeroPag));
        }else{
            System.out.println("Já existe um livro com este titulo!");
        }
    }

    //Método para ler o livro pelo titulo

    public Livro readLivro(String titulo){
        return livros.get(titulo);
    }

    //Método para atualizar o livro pelo titulo

    public Livro updateLivro(String titulo, String autor, Integer ano, Integer numeroPag){
        if (livros.containsKey(titulo)){
            Livro livro = livros.get(titulo);
            livro.setTitulo(titulo);
            livro.setAutor(autor);
            livro.setAno(ano);
            livro.setNumPaginas(numeroPag);
            return livro;
        }else {
            System.out.println("Não foi encontrado nenhum livro com este titulo!");
            return null;
        }
    }

    //Método para remover o livro pelo título

        public Livro removeLivro(String titulo){

        //Desvio condicional

        if (livros.containsKey(titulo)){
            Livro livro = livros.remove(titulo);
            System.out.println("Seu livro foi removido!");
            return livro;
        }else {
            System.out.println("Não foi encontrado nenhum livro com este titulo!");
            return null;
        }
    }
}