package com.example.railwaystationissuetrackingsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.railwaystationissuetrackingsystem.model.Project;
import com.example.railwaystationissuetrackingsystem.repository.ProjectRepo;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    public Project updateProject(Long id, Project project) {
        Project existing = projectRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setProjectName(project.getProjectName());
            existing.setDescription(project.getDescription());
            existing.setStatus(project.getStatus());
            return projectRepo.save(existing);
        }
        return null;
    }
    public List<Project> getProjectsByStatus(String status) {
        return projectRepo.findAll()
                .stream()
                .filter(p -> p.getStatus().equals(status))
                .toList();
    }
}
