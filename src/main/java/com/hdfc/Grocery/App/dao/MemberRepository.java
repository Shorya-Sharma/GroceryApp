package com.hdfc.Grocery.App.dao;

import com.hdfc.Grocery.App.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Additional methods if needed
}

