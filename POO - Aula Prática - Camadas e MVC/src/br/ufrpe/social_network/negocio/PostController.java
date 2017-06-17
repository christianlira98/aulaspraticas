package br.ufrpe.social_network.negocio;
import br.ufrpe.social_network.dao.PostDAO;
import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class PostController {
    private PostDAO postsRepository;
    private static PostController instance;
    
    private PostController () {
    	this.postsRepository = PostDAO.getInstance();
    }
    public static PostController getInstance(){
    	if(instance == null) {
    		instance = new PostController();
    	}
    	return instance;
    }
    
    public boolean cadastrar (Object p) {
    	boolean vari = false;
    	if(p instanceof Post) {
    		Post variavel = (Post) p;
    		this.cadastro(variavel);
    		vari = true;
    	}
    	return vari;
    }
    
    public boolean remover(Object p) {
    	boolean vari = false;
    	if(p instanceof Post) {
    		Post variavel = (Post) p;
    		this.deletar(variavel.getId());
    		vari = true;
    	}
    	return vari; // imagino que do tipo boolean, fica melhor para
    				// Saber se realmente foi excluído.
    }
    
    public boolean atualizar(Object novo, long id) { // ID do post a ser atualizado
    	boolean vari = false;
    	if(novo instanceof Post) {
    		Post variavel = (Post) novo;
    		if(this.existe(id)== true){
	    		this.update(id, variavel.getTexto(), variavel.getAuthor());
	    		vari = true;
    		}
    	}
    	return vari;
    }
    
    public void listar(Object obj) {
    	if(obj instanceof Person) {
    		Person p = (Person) obj;
    		this.postsRepository.listar(p);
    	}
    }
    public Post find(Post post) {
    	return this.procurar(post.getId());
    }
    
    public Post procurar(long id) {
        return this.postsRepository.procurar(id);
      }
    
    public boolean update(long id, String texto, Person Author) {
    	return this.postsRepository.atualizar(id, texto, Author);
    }
    
    public boolean existe(long id) {
        return this.postsRepository.existe(id);
      }
      
    public boolean cadastro(Post p) {
    	  return this.postsRepository.cadastrar(p);
      }
      
    public boolean deletar(long id) {
    	  return this.postsRepository.remover(id);
      }
    
      
}
