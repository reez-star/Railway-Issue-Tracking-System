package com.example.railwaystationissuetrackingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.railwaystationissuetrackingsystem.model.Ticket;
import com.example.railwaystationissuetrackingsystem.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {

  @Autowired
  private TicketService ticketservice;

  @PostMapping("/tickets")
  public Ticket createTicket(@RequestBody Ticket ticket) {
    return ticketservice.CreateTicket(ticket);
  }

  @GetMapping("/tickets")
  public List<Ticket> getAllTickets() {
    return ticketservice.GetAllUsers();
  }

  @GetMapping("/tickets/{id}")
  public Ticket getTicketById(@PathVariable("id") Long id) {
    return ticketservice.GetTicketById(id);
  }

}
