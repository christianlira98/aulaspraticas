package br.ufrpe.social_network.dao;
import br.ufrpe.social_network.negocio.beans.Person;
import java.time.LocalDate;
public class PersonDAO {
	
	private static PersonDAO singlePattern;
	private Person[] vetor;
	private int proxima;
	
	private PersonDAO() {
		this.vetor = new Person[10];
		this.proxima = 0;
	}
	
	public static PersonDAO getInstance() {
		if(singlePattern ==null) {
			singlePattern = new PersonDAO();
		}
		return singlePattern;
	}
	public void duplicaArray() {
		if(this.vetor != null && this.vetor.length > 0 ) {
			Person[] duplicado = new Person [this.vetor.length*2];
			for(int i = 0; i<this.vetor.length; i++) {
				duplicado[i] = this.vetor[i];
			}
			this.vetor = duplicado;
		}
	}
	
	public boolean cadastrar(Person pessoa) {
		boolean status = false;
		
		if(pessoa != null) {
			this.vetor[this.proxima] = new Person(pessoa.getName(), pessoa.getCountry(),pessoa.getBirthDate());
			this.proxima += 1;
			if(this.proxima == this.vetor.length) {
				this.duplicaArray();
			}
			status = true;
		}
		return status;
	}
	
	public boolean remover(long id) {
		boolean status = false;
			for(int i = 0; i<this.vetor.length && i != this.proxima;i++) {
				if(this.vetor[i].getId() == id) {
					status = true;
					this.vetor[i] = this.vetor[this.proxima-1];
					this.vetor[this.proxima-1] = null;
					this.proxima -= 1;
				}
			}
		return status;
	}
	
	public boolean update(long id, String name, String country, LocalDate birthDate) {
		boolean vari = false;
		for(int i = 0; i<this.vetor.length && i != this.proxima;i++) {
			if(this.vetor[i].getId()== id) {
				vetor[i].setBirthDate(birthDate);
				vetor[i].setCountry(country);
				vetor[i].setName(name);
				vari = true;
			}
		}
		return vari;
	}
	
	public String ler(long id) {
		String retorna = "nada encontrado";
		for(int i = 0; i<this.vetor.length && i!= this.proxima;i++) {
			if(this.vetor[i].getId() == id) {
				retorna = vetor[i].toString();
			}
		}
		return retorna;
	}
	
	 public Person procurar(long id) {
		 Person vari = null;
		 for(int i = 0; i <this.vetor.length;i++) {
	    		if(this.vetor[i].getId() == id) {
	    			vari = this.vetor[i];
	    		}
	    	}
		 return vari;
	    }
	 
	 public boolean existe(long id) {
		    boolean existe = false;
		    int parar = 0;
		    for(int i = 0; i<this.vetor.length && i!=this.proxima && parar == 0; i++) {
		    	if(this.vetor[i].getId() == id) {
		    		existe = true;
		    		parar = -1;
		    	}
		    }
		    return existe;
		  }
    
	 public int procurarIndice(long id) {
		    int i = 0;
		    boolean achou = false;
		    while ((!achou) && (i < this.proxima)) {
		      if (this.vetor[i].getId()==id) {
		        achou = true;
		      } else {
		        i = i + 1;
		      }
		    }
		    if(achou==false){
		    	return -1;
		    }
		    return i;
}
}
