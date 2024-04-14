package br.com.devmedia.cursosspring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.com.devmedia.cursosspring")
public class Programa {
	
	public static void main(String[] args) {
		
	      Scanner lerDados = new Scanner(System.in);
	         Usuario usuario = new Usuario("Eduardo", 
	           "eduardo@exemplo.com", "eduardoDVM");
	   
	         System.out.println("Deseja recuperar a senha (S/N)?");
	         String resposta = lerDados.nextLine();
	         if (resposta.equalsIgnoreCase("S")) {
	             ApplicationContext context = new 
	              AnnotationConfigApplicationContext(Programa.class);
	             UsuarioServico usuarioServico = 
	              context.getBean(UsuarioServico.class);
	   
	             usuarioServico.setUsuario(usuario);
	             usuarioServico.lembrarSenhaPorEmail();
	         }
		
		/*
		 * ApplicationContext context = new AnnotationConfigApplicationContext
		 * (Programa.class);
		 * 
		 * Pessoa pessoa = context.getBean(Pessoa.class);
		 * 
		 * pessoa.setNome("Eduardo"); pessoa.setIdade(32); System.out.println(pessoa);
		 */
	    }
}
