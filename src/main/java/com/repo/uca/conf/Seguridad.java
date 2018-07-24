/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repo.uca.conf;

/**
 *
 * @author mel_e
 */
public class Seguridad 
{    
    public static String obtenerToken()
    {
        int contador = 0;
        String token = "";
        int vminAZ = 64;
        int vmaxAZ = 91;

        int vminaz = 96;
        int vmaxaz = 123;

        System.out.println((int) 'a' + " , " + (int) 'z');
        System.out.println((int) 'A' + " , " + (int) 'Z');
        while (contador < 10) {
            int lMayuscula = (int) Math.floor(Math.random() * (vminAZ - vmaxAZ + 1) + vmaxAZ);
            int lMinuscula = (int) Math.floor(Math.random() * (vminaz - vmaxaz + 1) + vmaxaz);
            int digito = (int) Math.floor(Math.random() * (47 - 58 + 1) + 58);
            int[] randAsscii = {lMayuscula, lMinuscula, digito};
            int v1 = (int) (Math.random() * 3);

            token += Character.toString((char) randAsscii[v1]);
            contador += 1;
        }
        return token;
    }
}
