package tests;

import java.util.ArrayList;

public class messaround {
    
    public static void main(String[] args) {
        ArrayList<String> s1 = new ArrayList<>();
        s1.add("e");
        s1.add("F");

        ArrayList<String> s2 = new ArrayList<>();

        for(String s: s1){
            s2.add(s);
        }

        s2.add("FFFF");

        System.out.println(s1);
        System.out.println(s2);


        ArrayList<Integer> i1 = new ArrayList<>();
        ArrayList<Integer> i2 = new ArrayList<>();

        i1.add(1);
        i1.add(2);

        for (int i: i1){
            i2.add(i);
        }

        i2.add(3);
        i1.add(3333);

        System.out.println(i1);
        System.out.println(i2);

    }
}
