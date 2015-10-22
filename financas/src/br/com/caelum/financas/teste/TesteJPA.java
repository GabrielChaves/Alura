package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {

		double inicio = System.currentTimeMillis();

		Conta conta = new Conta();
		conta.setId(11);
		conta.setTitular("Renato Brandão");
		conta.setBanco("BRADESCO");
		conta.setNumero("123345");
		conta.setAgencia("321");

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		Conta contaRemover = em.find(Conta.class, 3);

		em.remove(contaRemover);
		
		System.out.println(conta.getId());
		
		em.getTransaction().commit();

		em.close();

		double fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");

	}
}
