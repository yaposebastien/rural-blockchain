/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.civruralblockchain.webapp.config.demo;

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
    
}
