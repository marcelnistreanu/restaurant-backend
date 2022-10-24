package com.ibm.restaurant.wallet;

import com.ibm.restaurant.domain.wallet.Wallet;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class WalletMapperService {

    public Wallet mapToDomain(WalletDto dto){
        Wallet wallet = new Wallet();
        wallet.setWalletId(dto.walletId);
        wallet.setBalance(dto.balance);
        wallet.setCustomer(dto.customer);
        return wallet;
    }

    public HashSet<WalletDto> mapFromDomain(HashSet<Wallet> walletList){
        HashSet<WalletDto> dtoList = new HashSet<>();
        for(Wallet wallet : walletList){
            dtoList.add(mapFromDomain(wallet));
        }
        return dtoList;
    }

    public WalletDto mapFromDomain(Wallet wallet){
        WalletDto dto = new WalletDto();
        dto.walletId = wallet.getWalletId();
        dto.balance = wallet.getBalance();
        dto.customer = wallet.getCustomer();
//        dto.customerName = wallet.getCustomer().getFirstName() + " " + wallet.getCustomer().getLastName();
        return dto;
    }
}
