package com.wallet.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public class WalletDaoMysqlImpl implements WalletDao {
	

		// Create collection to store the Wallet information.
		//Map<Integer, Wallet> wallets = new HashMap<>();

		public Wallet addWallet(Wallet newWallet) throws WalletException {
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletApp", "root", "root");
				PreparedStatement pt = con.prepareStatement("Insert into wallet values(?,?,?,? )")){
               
				pt.setInt(1,newWallet.getId());
				pt.setString(2,newWallet.getName());
				pt.setDouble(3,newWallet.getBalance());
				pt.setString(4,newWallet.getPassword());
				pt.execute();
				//System.out.println("Added successfully");

				 }
				 catch (Exception e) {
					 throw new WalletException("ID is already available");
				 }




			return newWallet;
		}

		public Wallet getWalletById(Integer walletId) throws WalletException {
			// TODO Auto-generated method stub

			Wallet a = null;

			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletApp", "root", "root");
				 PreparedStatement pt = con.prepareStatement("SELECT * FROM wallet WHERE id=?")) {
				pt.setInt(1, walletId);

				ResultSet rs = pt.executeQuery();
				rs.next();
                //if(rs.next())
				a = new Wallet(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
				//System.out.println("get successfully");
			} catch (Exception e) {
				throw new WalletException("Please enter valid id");
			}
			return a;
		}

			public Wallet updateWallet(Wallet updateWallet) throws WalletException {
				Wallet b = null;
				try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletApp", "root", "root");
					 PreparedStatement pt = con.prepareStatement("update wallet set balance=? where id=?");
					 PreparedStatement ptd = con.prepareStatement("SELECT * FROM wallet WHERE id=?")){
					pt.setDouble(1,updateWallet.getBalance());
					pt.setInt(2,updateWallet.getId());
					pt.executeUpdate();
					//System.out.println("updated");
	                                /*----get updated wallet--->*/
					ptd.setInt(1,updateWallet.getId() );

					ResultSet rs = ptd.executeQuery();
					rs.next();
					 //if(rs.next())
					b = new Wallet(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));

				} catch (SQLException e) {
					throw new WalletException("Please enter valid id");
		}
			return b;
		}

		public Wallet deleteWalletById(Integer walletID) throws WalletException {
			// TODO Auto-generated method stub
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/walletApp", "root", "root");
				 PreparedStatement pt = con.prepareStatement("Delete  FROM wallet WHERE id=?")) {
				pt.setInt(1, walletID);
				pt.execute();
				//System.out.println("Deleted successfully");


			} catch (SQLException e) {
				throw new WalletException("Please enter valid id");


			}
			return null;
		}

	}


