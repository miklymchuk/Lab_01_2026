/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_01;

/**
 *
 * @author 6312398
 */
public class ZipCode {
    int Zip = 0;
    public ZipCode(int Zip) {
        if (Zip > 99999) {
            System.out.println("The integer has too many digits.");
            return;
        }
        this.Zip = Zip;
    }
    
    public ZipCode(String barcode) {
        if (barcode.length() % 5 != 2) {
            System.out.println("The barcode is invalid, it is not in a multiple of 5 binary digits.");
            return;
        }
        
        if (barcode.charAt(0) != '1' || barcode.charAt(barcode.length() - 1) != '1') {
            System.out.println("The barcode is missing a 1 at the start or end.");
            return;
        }
        boolean check = false;
        
        for (int a = 0; a < barcode.length() - 1; a++) {
            if (barcode.charAt(a) != '0' && barcode.charAt(a) != '1') {
                System.out.println("Character" + barcode.charAt(a) + "must be '0' or '1'.");
                check = true;
            }     
            
        }       
        if (check == true) {
            return;
        }
        
        int Zip = parseBarCode(barcode);
        if (Zip == -1) {
            System.out.println("Invalid sequence.");
            return;
        }
        this.Zip = Zip;
    }
    
    public String GetBarCode() {
        int code2 = Zip;
        String barcode = "";
        for (int a = 0; a < 5; a++) {
            switch(code2 % 10) {
                case 0 -> barcode = "11000" + barcode;
                case 1 -> barcode = "00011" + barcode;
                case 2 -> barcode = "00101" + barcode;
                case 3 -> barcode = "00110" + barcode;
                case 4 -> barcode = "01001" + barcode;
                case 5 -> barcode = "01010" + barcode;
                case 6 -> barcode = "01100" + barcode;
                case 7 -> barcode = "10001" + barcode;
                case 8 -> barcode = "10010" + barcode;
                default -> barcode = "10100" + barcode;
            }
            code2/=10;
        }
        barcode = "1" + barcode + "1";
        return barcode;
    }
    
    private int parseBarCode(String barcode) {
        
        barcode = barcode.substring(1,barcode.length() - 1);
        int code = 0;
        while (barcode.length() > 0 && code != -1) {
            String sequence = barcode.substring(0, 5);
            code*=10;
            switch (sequence) {
                case "11000" -> {}
                case "00011" -> code+=1;
                case "00101" -> code+=2;
                case "00110" -> code+=3;
                case "01001" -> code+=4;
                case "01010" -> code+=5;
                case "01100" -> code+=6;
                case "10001" -> code+=7;
                case "10010" -> code+=8;
                case "10100" -> code+=9;
                default -> code = -1;
            }
            barcode = barcode.substring(5);
        }
        return code;
    }
}


    
