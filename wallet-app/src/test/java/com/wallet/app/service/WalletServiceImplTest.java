package com.wallet.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.wallet.app.dao.WalletDao;
import com.wallet.app.dao.WalletDaoImpl;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

class WalletServiceImplTest {
    static WalletService walletServiceTest = new WalletServiceImpl();

    @Test
    @Order(1)
    public void registerWalletTest()  {
        try{
            Wallet wallet1 = new Wallet(1, "shiva", 20000.0, "123");
            Wallet wallet2 = new Wallet(2, "kumar", 100.0, "678");

           assertEquals(wallet1,walletServiceTest.registerWallet(wallet1));
           //assertEquals(wallet2,walletServiceTest.registerWallet(wallet2));
           assertNotNull(wallet1);
          // assertNotNull(wallet2);
        }catch (Exception e){
             System.out.println(e.getMessage());

        }

    }

    @Test
    @Order(2)
    public void LoginTest()  {
        try{
            assertTrue(walletServiceTest.login(1,"123"));

        }catch (Exception e){
           System.out.println(e.getMessage());

        }

    }

    @Test
    @Order(3)
    public void AddFundsToWalletsTest()  {
        try{
            assertEquals(20010.0,walletServiceTest.addFundsToWallet(1,10.0));

        }catch (Exception e){
             System.out.println(e.getMessage());

        }

    }

    @Test
    @Order(4)
    public void ShowWalletBalanceTest()  {
        try{
            assertEquals(20010.0,walletServiceTest.showWalletBalance(1));
            assertThrows(WalletException.class,()-> walletServiceTest.showWalletBalance(2));

        }catch (Exception e){
             System.out.println(e.getMessage());

        }

    }

    @Test
    @Order(5)
    public void FundTransfer()  {
        try{

            assertEquals(true, walletServiceTest.fundTransfer(1, 2, 10.0));


        }catch (Exception e){
             System.out.println(e.getMessage());

        }

    }





    @Test
    @Order(6)
    public void UnRegisterWallet()  {
        try{

            assertEquals(null,walletServiceTest.unRegisterWallet(2,"12345"));
           // assertEquals(null,walletServiceTest.unRegisterWallet(109,"678"));


        }catch (Exception e){
             System.out.println(e.getMessage());

        }

    }
}