package com.fabio.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {
		// insert banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo");
		EntityManager em = emf.createEntityManager();

		Cliente cliente = new Cliente();
		cliente.setNome("pABLO");
		cliente.setIdade(45);
		cliente.setProfissao("FARMACEUTICO");
		cliente.setSexo("M");

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		//  em.close();

	}

}
