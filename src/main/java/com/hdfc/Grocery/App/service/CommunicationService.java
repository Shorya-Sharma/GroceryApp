package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.CommunicationRepository;
import com.hdfc.Grocery.App.entity.Communication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommunicationService {

    @Autowired
    private CommunicationRepository communicationRepository;

    public List<Communication> getAllCommunications() {
        return communicationRepository.findAll();
    }

    // Other service methods as needed
}
