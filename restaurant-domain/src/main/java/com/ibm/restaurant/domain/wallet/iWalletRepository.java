package com.ibm.restaurant.domain.wallet;

import java.util.HashSet;

public interface iWalletRepository {

    void createWallet(Wallet wallet);

    HashSet<Wallet> getWalletList();

    Wallet getWalletById(Long id);

    void updateWallet(Wallet wallet);

    void deleteWallet(Wallet wallet);
}
