package com.wallet.app.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.wallet.app.dao.WalletDao;
import com.wallet.app.dao.WalletDaoImpl;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;
import com.wallet.app.service.WalletService;
import com.wallet.app.service.WalletServiceImpl;

public class Controller {

    public static void main(String[] args) {
        System.out.println("\n\t\t\t\tWallet Application\n\n");
        
        
        
      

        WalletService walletService = new WalletServiceImpl();
        
        int k;
        do
        {
        Scanner sc=new Scanner(System.in);
        
        System.out.println(" 1 Registration\n 2 Login\n 3 addFundsToWallet\n 4 showWalletBalance\n 5 fundTransfer\n 6 unRegisterWallet\n 0 to exit");
        k=sc.nextInt();
        switch(k)
        {
        case 1:
            System.out.println("Enter ID:");
            Integer id=sc.nextInt();
            System.out.println("Enter Name:");
            String name=sc.next();
            System.out.println("Enter amount:");
            Double amt=sc.nextDouble();
            System.out.println("Password");
            String psw=sc.next();
            try 
            {
            Wallet wallet = walletService.registerWallet(new Wallet(id, name, amt, psw));
            if(id==wallet.getId())
            System.out.println("Successfully registered\n");
            }
            catch (WalletException e)
            {
            // TODO Auto-generated catch block
                  System.out.println(e.getMessage());
            }
            break;
        case 2:
            System.out.println("Enter ID:");
            Integer id1=sc.nextInt();
            System.out.println("Password");
            String psw1=sc.next();
            
            try {
                boolean wallet = walletService.login(id1, psw1);
                if(wallet)
                {
                    System.out.println("Successfully logged in\n");
                }
            } 
        
            catch (WalletException e)
            {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            
            }
            break;
        case 3:
            System.out.println("Enter ID:");
            Integer id2=sc.nextInt();
            System.out.println("amount");
            Double amt1=sc.nextDouble();
            try {
                Double k1=walletService.addFundsToWallet(id2,amt1);
                System.out.println("after funds added to the wallet balance: "+k1+"\n");
            } catch (WalletException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
            break;
        case 4:
            System.out.println("Enter wallet ID");
            Integer id3=sc.nextInt();
            try {
                Double wallet = walletService.showWalletBalance(id3);
                System.out.println("wallet balance : "+wallet);
            } catch (WalletException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
            break;
        case 5:
            System.out.println("Enter from wallet ID");
            Integer from=sc.nextInt();
            System.out.println("Enter to wallet ID");
            Integer to=sc.nextInt();
            System.out.println("Enter amount to transfer");
            Double s=sc.nextDouble();
            
            
            try {
                boolean wallet = walletService.fundTransfer(from, to, s);
                if(wallet)
                {
                    System.out.println("Successfully Transfered:"+s+"\n");
                }
                
            } catch (WalletException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
            }
            break;
        case 6:
            System.out.println("Enter ID:");
            Integer id11=sc.nextInt();
            System.out.println("Password");
            String psw11=sc.next();
            
            
                try {
                    Wallet wallet = walletService.unRegisterWallet(id11, psw11);
                    System.out.println("unregistered successfully \n");
                } catch (WalletException e) {
                    // TODO Auto-generated catch block
                    System.out.println(e.getMessage());
                }
                break;
            
          }
        }
        while(k!=0);
        
    }

}