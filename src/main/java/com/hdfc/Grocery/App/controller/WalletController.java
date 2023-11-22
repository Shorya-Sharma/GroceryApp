package com.hdfc.Grocery.App.controller;

import com.hdfc.Grocery.App.entity.Wallet;
import com.hdfc.Grocery.App.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("/{walletId}")
    public Wallet getWalletById(@PathVariable Long walletId) {
        return walletService.getWalletById(walletId);
    }

    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @PutMapping("/{walletId}")
    public Wallet updateWallet(@PathVariable Long walletId, @RequestBody Wallet walletDetails) {
        return walletService.updateWallet(walletId, walletDetails);
    }

    @DeleteMapping("/{walletId}")
    public void deleteWallet(@PathVariable Long walletId) {
        walletService.deleteWallet(walletId);
    }
}
