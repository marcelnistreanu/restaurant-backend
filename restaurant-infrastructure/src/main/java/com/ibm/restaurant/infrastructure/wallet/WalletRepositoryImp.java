package com.ibm.restaurant.infrastructure.wallet;

import com.ibm.restaurant.domain.wallet.Wallet;
import com.ibm.restaurant.domain.wallet.iWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class WalletRepositoryImp implements iWalletRepository {

    @Autowired
    private iWalletRepositorySdj iWalletRepositorySdj;

    @Override
    public void createWallet(Wallet wallet) {
        iWalletRepositorySdj.save(wallet);
    }

    @Override
    public HashSet<Wallet> getWalletList() {
        return new HashSet<>(iWalletRepositorySdj.findAll());
    }

    @Override
    public Wallet getWalletById(Long id) {
        return iWalletRepositorySdj.findById(id).orElse(null);
    }

    @Override
    public void updateWallet(Wallet wallet) {
        iWalletRepositorySdj.save(wallet);
    }

    @Override
    public void deleteWallet(Wallet wallet) {
       iWalletRepositorySdj.delete(wallet);
    }
}
