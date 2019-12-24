package com.fabio.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fabio.curso.modelo.Cliente;

public class Atualizacao {

	public static void main(String[] args) {
		
		//METEDO ATUALIZAR
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1L);
		em.getTransaction().begin();
		cliente.setNome("Fabio Junior Pereira");
		cliente.setIdade(90);
		em.getTransaction().commit();
		System.out.println("cliente alterado com sucesso");

	}

}
