package com.fabio.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fabio.curso.modelo.Cliente;

public class Deletar {

	public static void main(String[] args) {
		
		//METEDO DELETAR
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 4L);
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		System.out.println("cliente deletado com sucesso");
	}

}
