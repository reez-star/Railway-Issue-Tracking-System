package com.example.railwaystationissuetrackingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.railwaystationissuetrackingsystem.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long>{
}
