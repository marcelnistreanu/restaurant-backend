package com.ibm.restaurant.wallet;

import com.ibm.restaurant.application.wallet.WalletService;
import com.ibm.restaurant.domain.wallet.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private WalletMapperService walletMapperService;

    @PostMapping
    public ResponseEntity<Void> createWallet(@RequestBody WalletDto dto){
        Wallet wallet = walletMapperService.mapToDomain(dto);
        walletService.createWallet(wallet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<HashSet<WalletDto>> getWalletList(){
        HashSet<Wallet> walletList = walletService.getWalletList();
        HashSet<WalletDto> dtoList = walletMapperService.mapFromDomain(walletList);
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletDto> getWalletById(@PathVariable Long id){
        Wallet wallet = walletService.getWalletById(id);
        WalletDto dto = walletMapperService.mapFromDomain(wallet);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateWallet(@PathVariable Long id, @RequestBody WalletDto dto){
        Wallet wallet = walletMapperService.mapToDomain(dto);
        walletService.updateWallet(id, wallet);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long id){
        walletService.deleteWallet(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
