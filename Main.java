package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 4;
        printAllBalancedKimenet(n);

    }

    public static void printAllBalancedKimenet(int n){
        List<String> lehetsegesKimenetelek = new ArrayList<>();
        char[] kimenetel = new char[2*n];
        generateAllLehetsegesKimenet(lehetsegesKimenetelek, kimenetel,0, 0,0,n);
        for(String str : lehetsegesKimenetelek) {
            System.out.println(str);
        }
        //System.out.println(lehetsegesKimenetelek.size());
    }

   /* public static void generateAllLehetsegesKimenet(List<String> kimenetelek, char[] kimenetel, int i) {

        if (i == kimenetel.length) {
            kimenetelek.add(new String(kimenetel));
        } else {
            kimenetel[i] = '(';
            generateAllLehetsegesKimenet(kimenetelek, kimenetel, i + 1);
            kimenetel[i] = ')';
            generateAllLehetsegesKimenet(kimenetelek, kimenetel, i + 1);
        }
    }*/

    public static void generateAllLehetsegesKimenet(List<String> kimenetelek, char[] kimenetel, int i, int nyito, int zaro, int n){
        if(i==kimenetel.length){
            kimenetelek.add(new String(kimenetel));
        } else {
            if (i == 0) {
                kimenetel[i] = '(';
                generateAllLehetsegesKimenet(kimenetelek, kimenetel, i+1, nyito+1, zaro, n);
            } else {
                if(zaro<nyito && zaro < n){
                    kimenetel[i] = ')';
                    generateAllLehetsegesKimenet(kimenetelek, kimenetel, i+1, nyito, zaro+1, n);
                }
                if(nyito < n){
                    kimenetel[i] = '(';
                    generateAllLehetsegesKimenet(kimenetelek, kimenetel, i+1, nyito+1, zaro, n);
                }
            }
        }
    }

    // csak '(' kezdodhet
    // csak akkor lehet '(' ha nyitottZarojelekSzama < n
    // csak akkor lehet ')' ha nyitottZarojelekSzama > zartZarojelek szama, valamint zartZarojelekSzama < n

  /*  public static boolean isMegfeleloenBalanced(String str, int n){
        int nyitottZarojelekSzama = 0;
        int zartZarojelekSzama = 0;
        boolean isMegfeleloenBalanced = true;
        if (str.length() == n*2) {
            for(int i=0; i<str.length(); i++){
                if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                    if(i==0){
                        if(str.charAt(i) != '('){
                            isMegfeleloenBalanced = false;
                        } else {
                            nyitottZarojelekSzama++;
                        }
                    } else if(str.charAt(i) == '('){
                        nyitottZarojelekSzama++;
                        if(nyitottZarojelekSzama > n){
                            // nincs egyensulyban
                            isMegfeleloenBalanced = false;
                        }

                    } else if(str.charAt(i) == ')'){
                        zartZarojelekSzama++;
                        if(zartZarojelekSzama > nyitottZarojelekSzama){
                            // nincs egyensulyban
                            isMegfeleloenBalanced = false;
                        }
                        if(zartZarojelekSzama > n){
                            // tobb zart zarojel mint lehetseges
                            isMegfeleloenBalanced = false;
                        }
                    }
                } else {
                    // zarojeltol kulonbozo karakter szerepelne benne
                    isMegfeleloenBalanced = false;
                }

            }
        } else {
            // ha tobb karakterbol allna mint N*2
            isMegfeleloenBalanced = false;
        }
        return isMegfeleloenBalanced;
    }*/
}
