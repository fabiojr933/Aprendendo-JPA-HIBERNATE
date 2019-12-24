package com.fabio.curso.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fabio.curso.modelo.Conta;

public class Transferencia {

	public static void main(String[] args) {
		EntityManagerFactory emt = Persistence.createEntityManagerFactory("banco");
		EntityManager em = emt.createEntityManager();

		Scanner entrada = new Scanner(System.in);
		Conta conta1 = em.find(Conta.class, 1);
		if (conta1 == null) {
			System.out.println("Digite o saldo inicial da conta1");
			Double saldoIncialConta1 = entrada.nextDouble();
			conta1 = new Conta();
			conta1.setSaldo(saldoIncialConta1);
		}

		Conta conta2 = em.find(Conta.class, 2);
		if (conta2 == null) {
			System.out.println("digite o saldo incial da conta2");
			Double saldoIncialConta2 = entrada.nextDouble();
			conta2 = new Conta();
			conta2.setSaldo(saldoIncialConta2);
		}
		em.getTransaction().begin();
		em.persist(conta1);
		em.persist(conta2);
		em.getTransaction().commit();

		System.out.println("saldo conta1 " + conta1.getSaldo() + "saldo conta2 " + conta2.getSaldo());

		System.out.println("--------------------------------------------------");
		System.out.println("digite do valor para depositar na conta 1");
		Double valorTransfencia = entrada.nextDouble();

		em.getTransaction().begin();
		conta1.setSaldo(conta1.getSaldo() - valorTransfencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransfencia);

		if (conta1.getSaldo() > 0) {
			em.getTransaction().commit();
			System.out.println("transferencia realizada com sucesso");
		} else {
			em.getTransaction().rollback();
			System.out.println("sando insuficiente");
		}
	}

}
