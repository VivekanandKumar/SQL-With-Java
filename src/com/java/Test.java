package com.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class Test {



    public static void main(String[] args) {
        String s = "My Name is Vivekanand Kumar";
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        for (Character c : set){
            System.out.print(c);
        }
    }
}
