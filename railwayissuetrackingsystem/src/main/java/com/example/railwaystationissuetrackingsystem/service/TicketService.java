package com.example.railwaystationissuetrackingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.railwaystationissuetrackingsystem.model.Ticket;
import com.example.railwaystationissuetrackingsystem.repository.TicketRepo;

@Service
public class TicketService {
  
    @Autowired
    private TicketRepo ticketrepo;

    public Ticket CreateTicket(Ticket ticket)
    {
        Ticket t=ticketrepo.save(ticket);
        return t;
    }
    public List<Ticket> GetAllUsers()
    {
        return ticketrepo.findAll();
    }
    public Ticket GetTicketById(Long id)
    {
        Ticket t=ticketrepo.findById(id).orElse(null);
        return t;
    }

}
