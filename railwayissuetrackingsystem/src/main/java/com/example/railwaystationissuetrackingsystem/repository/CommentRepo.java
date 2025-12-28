package com.example.railwaystationissuetrackingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.railwaystationissuetrackingsystem.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
