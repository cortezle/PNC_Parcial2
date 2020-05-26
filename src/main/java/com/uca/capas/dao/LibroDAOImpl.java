package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;


@Repository
public class LibroDAOImpl implements LibroDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Transactional
	public void insert(Libro libro) throws DataAccessException {
		entityManager.persist(libro);
		
	}

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> resulset = query.getResultList();
		return resulset;
	}

}
