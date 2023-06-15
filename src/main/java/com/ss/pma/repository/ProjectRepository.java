package com.ss.pma.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ss.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public List<Project> findAll();
	

}
