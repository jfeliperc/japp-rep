package com.module.ejb;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeralEjb {

	public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
 
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
 
        return String.format("%32x", hash);
    }
	
//	public static void main(String[] args) {
//        String password1 = "Senha1";
//        String password2 = "Senha2";
// 
//        try {
//            String password1MD5 = GeralEjb.convertPasswordToMD5(password1);
//            String password2MD5 = GeralEjb.convertPasswordToMD5(password2); 
//            String passwordCompareMD5 = GeralEjb.convertPasswordToMD5(password1);
// 
//            System.out.println("Password1: " + password1MD5);
//            System.out.println("Password2: " + password2MD5); 
//            System.out.println("passwordCompareMD5: " + passwordCompareMD5);
// 
//            if (password1MD5.equals(passwordCompareMD5)) {
//                System.out.println("Compare OK");
//            } else {
//                System.out.println("Compare NOK");
//            }
// 
//            if (password2MD5.equals(passwordCompareMD5)) {
//                System.out.println("Compare OK");
//            } else {
//                System.out.println("Compare NOK");
//            }
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
	
}
