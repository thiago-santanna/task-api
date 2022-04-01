package com.tsswebapps.taskapi.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tsswebapps.taskapi.entities.Task;


public class ReportRepositoryImpl implements ReportRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Task> getTasksByDate(LocalDate dateInit, LocalDate dateEnd) {
		StringBuilder builder = new StringBuilder();
		builder.append("select t from Task t ");
		builder.append("where t.createdAt >= :dateInit ");		
		builder.append("and t.createdAt <= :dateEnd");
		
		TypedQuery<Task> query = entityManager.createQuery(builder.toString(), Task.class);
		query.setParameter("dateInit", dateInit);
		if(dateEnd != null) {
			query.setParameter("dateEnd", dateEnd);
		}
		
		return query.getResultList();
	}

	@Override
	public List<Task> getTasksPartialDescription(String partialDescription) {
		StringBuilder builder = new StringBuilder();
		builder.append("select t from Task t ");		
		builder.append("where t.description LIKE :partialDescription");
		
		TypedQuery<Task> query = entityManager.createQuery(builder.toString(), Task.class);
		
		query.setParameter("partialDescription", "%"+partialDescription+"%");
		return query.getResultList();
	}

}
