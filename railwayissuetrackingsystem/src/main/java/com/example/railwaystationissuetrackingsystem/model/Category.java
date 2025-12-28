package com.example.railwaystationissuetrackingsystem.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryId;
  private String categoryName;
  private String description;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Ticket> tickets;
  public Long getCategoryId() {
    return categoryId;
  }
  public String getCategoryName() {
    return categoryName;
  }
  public String getDescription() {
    return description;
  }
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Category(String categoryName, String description) {
    this.categoryName = categoryName;
    this.description = description;
  }
  
  public Category()
  {

  }

}
