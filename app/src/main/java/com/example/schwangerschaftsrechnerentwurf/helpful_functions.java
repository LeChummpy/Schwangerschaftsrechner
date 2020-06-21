package com.example.schwangerschaftsrechnerentwurf;

public class helpful_functions {
    public static boolean checkWetherStringContainsSigns(String input){
        char[] input_charlist = input.toCharArray();
        for (char i : input_charlist) {
            if ( !(i == ' ') ) return true;
            }
        return false;
    }
}

