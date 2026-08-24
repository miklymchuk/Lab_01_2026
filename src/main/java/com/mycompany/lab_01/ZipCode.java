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
    int code = 0;
    public ZipCode(int code) {
        if (code > 99999) {
            System.out.println("The integer has too many digits.");
            return;
        }
        this.code = code;
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
        for (int a = 0; a < barcode.length() - 1; a++) {
            if (barcode.charAt(a) != '0' && barcode.charAt(a) != '1') {
                System.out.println("Character" + barcode.charAt(a) + "must be '0' or '1'.");
                return;
            }
            
        }
        barcode = barcode.substring(1,barcode.length() - 1);
        int code = 0;
        while (barcode.length() > 0 && code != -1) {
            String sequence = barcode.substring(0, 5);
            code*=10;
            switch (sequence) {
                case "11000":;
                case "00011":code+=1;return;
                case "00101":code+=2;return;
                case "00110":code+=3;return;
                case "01001":code+=4;return;
                case "01010":code+=5;return;
                case "01100":code+=6;return;
                case "10001":code+=7;return;
                case "10010":code+=8;return;
                case "10100":code+=9;return;
                default:System.out.println("Invalid sequence.");code = -1;
            }
            barcode = barcode.substring(5);
        }
        if (code == -1) {
            return;
        }
        this.code = code;
    }
}
    
