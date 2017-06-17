package br.ufrpe.social_network.negocio;
import java.time.LocalDate;
import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class Fachada {
    private static Fachada instance;
    private PersonController cadastroPerson;
    private PostController posts;
    
    private Fachada () {
    	this.cadastroPerson = PersonController.getInstance();
    	this.posts = PostController.getInstance();
    	
    }
    
    public static Fachada getInstance() {
    	if(instance == null) {
    		instance = new Fachada();
    	}
    	return instance;
    }
    
    public Person procuraPessoa(long id) {
        return this.cadastroPerson.procurar(id);
      }
    
    public boolean updatePessoa(long id, String name, String country, LocalDate birthDate) {
  	  return this.cadastroPerson.upd(id, name, country, birthDate);
    }
      
   
    public void cadastrarPessoa(Person p) {
    	  this.cadastroPerson.cadastro(p);
      }
    
    public boolean removePessoa(long id) {
    	  return this.cadastroPerson.remover(id);
      }
   
    public Post procurarPost(long id) {
    	return this.posts.procurar(id);
    }
    
    public boolean updatePost(long id, String texto, Person Author) {
    	return this.posts.update(id, texto, Author);
    }
    
    public boolean existePost(long id) {
        return this.posts.existe(id);
      }
      
    public boolean cadastroPost(Post p) {
    	  return this.posts.cadastrar(p);
      }
      
    public boolean deletar(long id) {
    	  return this.posts.remover(id);
      }
    
    public void listar(Person p) {
    	this.posts.listar(p);
    }
    

    
}
