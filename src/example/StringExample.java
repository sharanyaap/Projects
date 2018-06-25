package example;

import example.model.Dog;

/**
 * Created by sharanya.p on 11/28/2016.
 */
public class StringExample {

    public static void main(String args[]){
        Dog aDog = new Dog("Max");
        foo(aDog);

        if (aDog.getName().equals("Max")) { //true
            System.out.println( "Java passes by value." );
        } else if (aDog.getName().equals("Fifi")) {
            System.out.println( "Java passes by reference." );
        } else if (aDog.getName().equals("TestMax")) {
            System.out.println( "Java TestMax" );
        }

        String s = "StringEx";
        System.out.println("Before s : "+ s);
        subStringEx(s);
        System.out.println("After s : "+ s);
    }

    public static void subStringEx(String str){
        str = str.substring(0,4);
        System.out.println("Inside subStringEx s : "+ str);
    }

    public static void foo(Dog d) {
        d.getName().equals("Max"); // true

       /* d = new Dog("Fifi");
        d.getName().equals("Fifi"); // true*/

        d.setName("TestMax");
        d.getName().concat("TestMax");
        System.out.println(d.getName());
    }
}
