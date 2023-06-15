package com.ss.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.pma.dto.EmployeeProject;
import com.ss.pma.entities.Project;
import com.ss.pma.repository.EmployeeRepository;
import com.ss.pma.repository.ProjectRepository;

@Controller
public class HomeController {
//	@Value("${envVersionNum}")
//	private String ver;
	
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projectList = proRepo.findAll();
		model.addAttribute("projectList", projectList);
		
		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeeList", employeesProjectCnt );
		
		return "main/home";
		
	}
	
	

}
