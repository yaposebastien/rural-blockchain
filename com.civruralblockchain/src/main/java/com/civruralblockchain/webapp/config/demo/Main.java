/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civruralblockchain.webapp.config.demo;

import com.civruralblockchain.webapp.smartRuralContract.RuralContract;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

/**
 *
 * @author nkeyapo
 */
public class Main {
    
    private final static String PRIVATE_KEY = "79d37b7f820cc15f67d39c02014806faa82313fb5996b5b814d1a277882edf13";
    
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(2000000000L);

    private final static String RECIPIENT = "0x7b1128E70bECb5e3B3cffFaB254bc6C76C9EEAD5";
    
    private final static String RURAL_CONTRACT_ADDRESS = "0x23bbca085784e222cbb4ec21cced7e6c3f292740";
    
    
    public static void main(String[] args) {
        
        try {
            new Main();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    //Function to trigger the transfer
    private Main() throws Exception {
       
         Web3j web3j = Web3j.build(new HttpService());
         //Retrieve Credentials from Ganache
         Credentials credentials = getCredentialsFromPrivateKey();
         
         RuralContract ruralContract = loadRuralContract(RURAL_CONTRACT_ADDRESS, web3j, credentials);
         
         
        

        TransactionManager transactionManager = new RawTransactionManager(
                web3j,
                getCredentialsFromPrivateKey()
        );

        Transfer transfer = new Transfer(web3j, transactionManager);

        TransactionReceipt transactionReceipt = transfer.sendFunds(
                RECIPIENT,
                BigDecimal.ONE,
                Convert.Unit.ETHER,
                GAS_PRICE,
                GAS_LIMIT
        ).send();

        System.out.print("Hash of the transaction = " + transactionReceipt.getTransactionHash() + "\n");
        printWeb3Version(web3j);
        deployRuralContract(web3j, credentials);
        
        //Display the Rural Contract Address
        String ruralContractAddress = deployRuralContract(web3j, credentials);
        System.out.println("The Rural Contract address: " +ruralContractAddress);
        
        //Register New Land Title
        registration("Nke","Yapo",22,45,800,"Abidjan","Attecoube");
        
       
        
       
       
    }
    
    
    //Function to print The client version of Web3
    private void printWeb3Version(Web3j web3j) {
        
        Web3ClientVersion web3ClientVersion = null;
        
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String web3ClientVersionString = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Web client version: " + web3ClientVersionString);
        
    }
    
    //Function to load Credentials
//    private Credentials getCredentialsFromWallet() throws IOException, CipherException {
//        
//        return WalletUtils.loadCredentials("passphrase", "wallet/path");
//    }
    
    private Credentials getCredentialsFromPrivateKey() {
        
        return Credentials.create(PRIVATE_KEY);
        
    }
    
    //Function to deploy our RuralContract
    private String deployRuralContract(Web3j web3j, Credentials credentials) throws Exception {
        
        return RuralContract.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT)
                .send()
                .getContractAddress();
    }
    
    //Function helps to load the Rural Smart Contract
    private RuralContract loadRuralContract(String ruralContractAddress, Web3j web3j, Credentials credentials) {
        
        return RuralContract.load(ruralContractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
        
    }
    
    //Function helps to register a new land title
    private void registration(String firstName, String lastName,double geoLatLand,
                                double geoLongLand, double areaLand, 
                                String city, String villageName) 
    {
        try {
             Credentials credentials = getCredentialsFromPrivateKey();
               Web3j web3j = Web3j.build(new HttpService());
             RuralContract ruralContract = loadRuralContract(RURAL_CONTRACT_ADDRESS, web3j, credentials);
             TransactionReceipt receipt = ruralContract.registerLandTitle(firstName, lastName, GAS_LIMIT, GAS_LIMIT, GAS_LIMIT, city, villageName).send();
             System.out.println( "Land Registration Hash : " + receipt.getTransactionHash());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Function helps to remove land title
    
    
}
