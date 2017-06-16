package br.ufrpe.social_network.negocio.beans;

import java.util.ArrayList;

public class Post {
    private static long nextID = 1;
	
    private long id;
    private String texto;
    private Person author;
    private ArrayList<Post> comments;

    public Post(String texto, Person author) {
        this.id = nextID;
        nextID++;
        
        this.texto = texto;
        this.author = author;
        this.comments = new ArrayList<>();
    }
    
    public Post() {
        this(null, null);
    }
    
    public String getTexto() {
    	
    	return this.texto;
    }
    
    public Person getAuthor() {
    	return this.author;
    }
    
    
    public long getId() {
    	return id;
    }
    
    
    public ArrayList<Post> getComments() {
 	   return this.comments;
    }
    
    
    public void setComments(ArrayList<Post> comments) {
		this.comments = comments;
	}
    
    
    public void setPerson(Person outro) {
    	this.author = outro;
    }
    
    
    public void setTexto(String novo) {
    	this.texto = novo;
    }
    
    

	public void addComment(Post comment) {
        if (comment != null) {
            this.comments.add(comment);
        }
    }
    
    public void removeComment(Long id) {
    	for(int i = 0; i<this.comments.size(); i++) {
    		
    		if(this.comments.get(i).getId()==id) {
    			
    			this.comments.remove(id);
    		}
    	}
    }
    
    public void listaSubComments(Person author) {
    	for(int i = 0; i<this.comments.size();i++) {
    		
    		for(int j = 0; j<this.comments.get(i).comments.size(); j++) {
    			
    			for(int k = 0; k<this.comments.get(i).comments.get(j).comments.size(); k++) {
    				
	    			if(this.comments.get(i).comments.get(j).getAuthor()==author) {
	    				
		    			System.out.println(this.comments.get(i).comments.get(j).toString());
		    		}
	    			
	    			if(this.comments.get(i).comments.get(j).comments.get(k).getAuthor()==author) {
	    				
	    				System.out.println(this.comments.get(i).comments.get(j).comments.get(k).toString());
	    			}
    			}
    		
    		
    		}
    	}
    }
    
    @Override
    public String toString() {
    	String str = " Post: " +getTexto()+ "Id: "+getId()+"\n" + this.author.toString() ;
    	
        return str;
    }
}