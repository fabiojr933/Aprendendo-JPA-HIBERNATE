package com.fabio.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fabio.curso.modelo.Cliente;

public class Consulta {

	public static void main(String[] args) {
		
		//METEDO CONSULTAR
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo");
		EntityManager em = emf.createEntityManager();
				
		Cliente cliente = em.find(Cliente.class, 5L);
		if(cliente != null) {
		System.out.println("nome " + cliente.getNome());
		System.out.println("idade " + cliente.getIdade());
		System.out.println("sexo " + cliente.getSexo());
		System.out.println("profissao " + cliente.getProfissao());
		}else {
			System.out.println("cliente nao encontrado");
		}
	}

}
