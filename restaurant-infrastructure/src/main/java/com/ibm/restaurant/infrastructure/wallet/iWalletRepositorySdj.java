package com.ibm.restaurant.infrastructure.wallet;

import com.ibm.restaurant.domain.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iWalletRepositorySdj extends JpaRepository<Wallet, Long> {
}
