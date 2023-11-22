package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.WalletRepository;
import com.hdfc.Grocery.App.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet getWalletById(Long walletId) {
        return walletRepository.findById(walletId).orElse(null);
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public Wallet updateWallet(Long walletId, Wallet walletDetails) {
        Wallet existingWallet = walletRepository.findById(walletId).orElse(null);
        if (existingWallet != null) {
            // Update existingWallet with walletDetails
            // Set values and save back to repository
            // example: existingWallet.setPurchaseAmount(walletDetails.getPurchaseAmount());
            // Save the updated wallet: walletRepository.save(existingWallet);
        }
        return existingWallet;
    }

    public void deleteWallet(Long walletId) {
        walletRepository.deleteById(walletId);
    }
}
