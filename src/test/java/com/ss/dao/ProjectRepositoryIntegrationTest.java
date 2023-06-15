package com.ss.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import com.ss.pma.ProjectManagementApplication;
import com.ss.pma.entities.Project;
import com.ss.pma.repository.ProjectRepository;

@ContextConfiguration(classes=ProjectManagementApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql", "classpath:data.sql"}),
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts= "classpath:drop.sql")})
public class ProjectRepositoryIntegrationTest {

		private static final String assertEquals = null;
		@Autowired
		ProjectRepository proRepo;
		
		@Test
		public void ifNewProjectSaved_thenSuccess() {
			Project newProject = new Project("New Test Project", "COMPLETE", "Test description");
			proRepo.save(newProject);
			
//			int count = proRepo.findAll().size();
			Assert.assertEquals(5, proRepo.findAll().size());
		}
		
}
