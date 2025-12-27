package com.example.railwaystationissuetrackingsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.railwaystationissuetrackingsystem.model.Category;

@Repository
public interface CategoryRepo  extends JpaRepository<Category,Long>{


}
