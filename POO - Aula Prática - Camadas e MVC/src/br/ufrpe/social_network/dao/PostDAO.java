package br.ufrpe.social_network.dao;
import br.ufrpe.social_network.negocio.beans.*;
import java.util.ArrayList;

public class PostDAO {
    private static PostDAO instance;
    private Post postsRepository2;
	ArrayList<Post> var = new ArrayList<>();;
    
	public PostDAO () {
    	
    }
    
    public static PostDAO getInstance() {
    	if(instance == null) {
    		instance = new PostDAO();
    	}
    	return instance;
    }
    
    public boolean cadastrar(Post post) {
    	boolean vari = false;
    	if(post != null) {
    		var.add(post);
    		vari = true;
    	}
    	return vari;
    }
    
    public boolean remover(long id) {
    	boolean vari = false;
    	int cond = 0;
    	for(int i = 0; i<this.var.size()&& cond!=-1; i++) {
    		if(this.var.get(i).getId() == id) {
    			cond = -1;
    			vari = true;
    			this.var.remove(i);
    		}
    	}
    	return vari;
    }
    
    public void listar(Person Author) {
    	for(int i = 0; i < this.var.size(); i++) {
    		if(this.var.get(i).getAuthor()==Author)	{
    			System.out.println(this.var.get(i).toString());
    			System.out.println();
    		}
    	}
    }
    
    public boolean atualizar(long id, String texto, Person Author) {
    	boolean vari = false;
    	int cond = 0;
    	for(int i = 0; i<this.var.size() && cond!=-1;i++) {
    		if(this.var.get(i).getId() == id) {
    			cond = -1;
    			vari = true;
    			this.var.get(i).setPerson(Author);
    			this.var.get(i).setTexto(texto);
    		}
    	}
    	return vari;
    }
    
    public String ler(long id) {
    	int cond = 0;
    	String vari = null;
    	for(int i = 0; i<this.var.size() && cond!=-1;i++) {
    		if(this.var.get(i).getId() == id) {
    			cond = -1;
    			vari =  this.var.get(i).toString();
    		}
    }
    	return vari;
    }
    
    
    public Post procurar(long id) {
    	int cond = 0;
    	Post vari = null;
    	for(int i = 0; i<this.var.size() && cond !=-1; i++) {
    		if(this.var.get(i).getId()==id) {
    			cond = -1;
    			vari = this.var.get(i);
    		}
    	}
    	return vari;
    }
    
    public boolean existe(long id) {
    	boolean vari = false;
    	int cond = 0;
    	for(int i = 0; i <this.var.size() && cond !=-1; i++) {
    		if(this.var.get(i).getId() == id) {
    			cond = -1;
    			vari = true;
    		}
    	}
    	return vari;
    }
    // retorna -1, se não existir...
    public int procurarIndice (long id) {
    	int cond = 0, guarda= -1;
    	for(int i = 0; i<this.var.size() && cond !=-1;i++) {
    		if(this.var.get(i).getId() == id) {
    			cond = -1;
    			guarda = i;
    		}
    	}
    	return guarda;
    }   

    
}
