package com.hdfc.Grocery.App.dao;

import com.hdfc.Grocery.App.entity.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Integer> {
    // Define custom query methods if needed
}

