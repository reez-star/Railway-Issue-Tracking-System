package com.example.railwaystationissuetrackingsystem.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long  projectId;
private String projectName;
private String description;
private String status;

@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
private List<Ticket> tickets;
public Long getProjectId() {
    return projectId;
}
public void setProjectId(Long projectId) {
    this.projectId = projectId;
}
public String getProjectName() {
    return projectName;
}
public void setProjectName(String projectName) {
    this.projectName = projectName;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
public Project(String projectName, String description, String status) {
    this.projectName = projectName;
    this.description = description;
    this.status = status;
}
public Project()
{
    
}
}
