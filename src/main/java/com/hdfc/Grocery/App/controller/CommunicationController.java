package com.hdfc.Grocery.App.controller;

import com.hdfc.Grocery.App.entity.Communication;
import com.hdfc.Grocery.App.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/communications")
public class CommunicationController {

    @Autowired
    private CommunicationService communicationService;

    @GetMapping
    public List<Communication> getAllCommunications() {
        return communicationService.getAllCommunications();
    }

    // Other controller methods for communication endpoints
}
