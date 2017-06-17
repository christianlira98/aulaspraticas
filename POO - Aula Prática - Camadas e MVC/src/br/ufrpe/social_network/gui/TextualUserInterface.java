package br.ufrpe.social_network.gui;
import br.ufrpe.social_network.negocio.beans.*;
import java.time.LocalDate;

import br.ufrpe.social_network.dao.PersonDAO;
import br.ufrpe.social_network.negocio.*;
public class TextualUserInterface {
    
	public void showUserInterface() {
		PersonDAO per = PersonDAO.getInstance();
		Fachada var = Fachada.getInstance();
		Person[] p = new Person[4];
		//criando
		p[0] = new Person("Marcos", "Brasil",LocalDate.of(2017, 5, 26) );
		p[1] = new Person("Mohhammed", "Estados Unidos",LocalDate.of(2015, 3, 20) );
		p[2] = new Person("Ana", "Itália",LocalDate.of(2010, 3, 12) );
		p[3] = new Person("Yoko", "Tailândia",LocalDate.of(2003, 3, 12) );

		//salvando
		for(int i = 0; i<p.length;i++) {
			var.cadastrarPessoa(p[i]);
		}
		
		// apagando
		var.removePessoa(1);
		
		//Atualizando um dos nomes.
		var.updatePessoa(1, "Yonazaki", "Japão", LocalDate.of(2003, 3, 12));
		
		
		// buscando
		var.procuraPessoa(2);
		
		//Criando posts
		Post[] posts = new Post[15];
		for(int i = 0; i< 5; i++) {
			posts[i] = new Post("texto1.0", p[0] );
		}
		
		
		for(int i = 5; i< 10; i++) {
			posts[i] = new Post("texto2.0", p[1] );
		}
		
		
		
		for(int i = 10; i< 15; i++) {
			posts[i] = new Post("texto3.0", p[2] );
		}
		
		//
		for( int i = 0; i < 15; i++ ) {
			var.cadastroPost(posts[i]);
		}
		
		//Adicionando comentários em outros posts.
		Post[] comentario = new Post[2];
		comentario[0] = new Post ("Nao sei o que dizer !", p[1]);
		comentario[1] = new Post("Polêmica !", p[1]);
		
		for(int i = 0; i < 5; i++) {
			posts[i].addComment(comentario[0]);
			posts[i].addComment(comentario[1]);
		}
		
		comentario[0] = new Post ("Isso é errado cara... ", p[2]);
		comentario[1] = new Post("Não sei se vc deve ", p[2]);
		
		for(int i = 5; i < 10; i++ ) {
			posts[i].addComment(comentario[0]);
			posts[i].addComment(comentario[1]);
		}
		
		comentario[0] = new Post ("Dou valor ! ", p[0]);
		comentario[1] = new Post("Vish ! ", p[0]);
		
		for(int i = 10; i < 15; i++ ) {
			posts[i].addComment(comentario[0]);
			posts[i].addComment(comentario[1]);
		}

        // TODO implementar código que usa a Fachada. Detalhamento:
        
		
		//listando posts
		var.listar(p[0]);
		var.listar(p[1]);
		var.listar(p[2]);
		var.listar(p[3]);
		
		
		/*
        
        // não consegui concluir o desafio...
        1.  Crie quatro pessoas e salve-as
        2.  Apague uma das pessoas
        3.  Atualize o nome de uma das pessoas
        4.  Busque por um objeto do tipo pessoa que tenha um ID qualquer.
        5.  Crie 15 posts aleatórios, 5 para cada uma das pessoas criadas anteriormente
        6.  Crie 2 comentários de resposta de uma das pessoas em cada um dos posts de outra pessoa
        7.  Liste todos os posts de todas as pessoas
        8.  (DESAFIO) Liste somente os comentários que cada uma das pessoas fez em outros posts de outras pessoas

        */
        
    }

}
