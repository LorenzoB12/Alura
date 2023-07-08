package br.com.busolli.lorenzo.testeHibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("testeHibernate");
	
	public static EntityManager getEntityManager() {
		return JPAUtil.FACTORY.createEntityManager();
	}
}
