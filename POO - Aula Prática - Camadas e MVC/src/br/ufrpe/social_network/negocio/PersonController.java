package br.ufrpe.social_network.negocio;
import java.time.LocalDate;
import br.ufrpe.social_network.dao.PersonDAO;
import br.ufrpe.social_network.negocio.beans.Person;

public class PersonController {
    
    private PersonDAO personsRepository;
    private static PersonController instance;
    private PersonController() {
    	this.personsRepository = PersonDAO.getInstance();
    }

    public static PersonController getInstance() {
        if (instance == null) {
            instance = new PersonController();
        }
        return instance;
    }
    
    public void savePerson(Object p) {
    	if(p instanceof Person) {
    		Person novo = (Person) p;
    		this.cadastro(novo);
    	}
    }
    
    public Person find(long personId) {
        return this.procurar(personId);
    }
    
    public void update(Object newPerson, long id) {
    	if(newPerson instanceof Person) {
    		Person novo = (Person) newPerson;
	         if(this.existe(id)==true) {
	        	  this.upd(id, novo.getName(), novo.getCountry(), novo.getBirthDate());
	         }
    	}

    }
    
    public void delete(Object p) {
        if(p instanceof Person) {
        	Person novo = (Person) p;
        	this.remover(novo.getId());
        }
    }
    
      public Person procurar(long id) {
        return this.personsRepository.procurar(id);
      }

      public boolean existe(long id) {
        return this.personsRepository.existe(id);
      }
      
      public boolean upd(long id, String name, String country, LocalDate birthDate) {
    	  return this.personsRepository.update(id, name, country, birthDate);
      }
      public boolean cadastro(Person p) {
    	  return this.personsRepository.cadastrar(p);
      }
      public boolean remover(long id) {
    	  return this.personsRepository.remover(id);
      }
}
