package com.example.railwaystationissuetrackingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.railwaystationissuetrackingsystem.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {

}
