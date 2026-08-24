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
            System.out.print("The integer has too many digits.");
        }
        this.code = code;
    }
    public ZipCode(String code) {
        
    }
}
    
