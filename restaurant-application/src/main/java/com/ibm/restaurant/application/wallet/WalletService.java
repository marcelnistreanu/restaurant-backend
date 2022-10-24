package com.ibm.restaurant.application.wallet;

import com.ibm.restaurant.domain.exception.BusinessException;
import com.ibm.restaurant.domain.exception.NotFoundException;
import com.ibm.restaurant.domain.wallet.Wallet;
import com.ibm.restaurant.domain.wallet.iWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class WalletService {

    @Autowired
    private iWalletRepository iWalletRepository;

    public void createWallet(Wallet wallet) {

        if (validationCriteria(wallet)) {
            iWalletRepository.createWallet(wallet);
        }
    }

    public HashSet<Wallet> getWalletList() {
        return iWalletRepository.getWalletList();
    }

    public Wallet getWalletById(Long id) {
        Wallet wallet = iWalletRepository.getWalletById(id);
        if (checkIfWalletExists(wallet, id)) {
            return wallet;
        }
        return null;
    }

    public void updateWallet(Long id, Wallet wallet) {

        if (validationCriteria(wallet)) {
            Wallet walletFromDb = getWalletById(id);
            if (checkIfWalletExists(walletFromDb, id)) {
//                walletFromDb.setWalletId(wallet.getWalletId());
                walletFromDb.setBalance(walletFromDb.getBalance() + wallet.getBalance());
//                walletFromDb.setCustomer(wallet.getCustomer());
                iWalletRepository.updateWallet(wallet);
            }
        }
    }

    public void deleteWallet(Long id) {
        Wallet wallet = getWalletById(id);
        if (checkIfWalletExists(wallet, id)) {
            iWalletRepository.deleteWallet(wallet);
        }
    }

    private boolean validationCriteria(Wallet wallet) {
        if (wallet.getBalance() < 0) {
            String message = "No minus amounts are accepted.";
            String code = "BAD_REQUEST";
            throw new BusinessException(message, code);
        }
        return true;
    }

    private boolean checkIfWalletExists(Wallet wallet, Long id) {
        if (wallet == null) {
            throw new NotFoundException("Wallet with id " + id + " not found.");
        }
        return true;
    }
}
