package com.wallet.app.dao;

import java.util.HashMap;
import java.util.Map;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public class WalletDaoImpl implements WalletDao {

    // Create collection to store the Wallet information.
    Map<Integer, Wallet> wallets = new HashMap<>();

    public Wallet addWallet(Wallet newWallet) throws WalletException {

                 this.wallets.put(newWallet.getId(), newWallet);
          if(this.wallets.get(newWallet.getId())==null)
          {
              throw new WalletException("New wallet was not added proprely");
          }
          else
          {
              return this.wallets.get(newWallet.getId());
          }

    }

    public Wallet getWalletById(Integer walletId) throws WalletException {
        // TODO Auto-generated method stub
        if(wallets.containsKey(walletId))
        {
            return wallets.get(walletId);
            
        }
        else
        {
            throw new WalletException("Please enter valid walletId: " + walletId);
        }
        
    }

    public Wallet updateWallet(Wallet updateWallet) throws WalletException {
        // TODO Auto-generated method stub
        Wallet p=null;
        if(wallets.containsKey(updateWallet.getId()))
        {
            p=wallets.get(updateWallet.getId());
            p.setName(updateWallet.getName());
            p.setBalance(updateWallet.getBalance());
            p.setPassword(updateWallet.getPassword());
            return p;
        }
        else
        
            throw new WalletException("Please enter valid walletId: " + updateWallet.getId());
    }

    public Wallet deleteWalletById(Integer walletID) throws WalletException {
        // TODO Auto-generated method stub
        Wallet p=null;
        if(wallets.containsKey(walletID))
          return wallets.remove(walletID);    
        else
            throw new WalletException("Please enter valid walletId: " + walletID);

    }

}
