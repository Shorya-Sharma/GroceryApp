package com.hdfc.Grocery.App.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import com.hdfc.Grocery.App.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Query(value = "SELECT * FROM wallet WHERE purchase_amount <= :totalValue ORDER BY purchase_amount DESC LIMIT 1", nativeQuery = true)
    Wallet findByTotalValue(@Param("totalValue") BigDecimal totalValue);
}

