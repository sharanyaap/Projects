package example;

import example.model.Dog;
import example.model.Point;

/**
 * Created by sharanya.p on 11/28/2016.
 */
public class IntegerExample {

    public static void main(String args[]){
        Integer i = new Integer(3);
        foo(i);

        if (i.equals(3)) { //true
            System.out.println( "Java passes by value." );
        } else if (i.equals(5)) {
            System.out.println( "Java passes by reference." );
        }

        Point pnt1 = new Point(0,0,"pnt1");
        Point pnt2 = new Point(0,0,"pnt2");
        System.out.println("X: " + pnt1.getX() + " Y: " +pnt1.getY() + " String: "+ pnt1.getStr());
        System.out.println("X: " + pnt2.getX() + " Y: " +pnt2.getY() + " String: "+ pnt2.getStr());
        System.out.println(" ");
        tricky(pnt1,pnt2);
        System.out.println("X: " + pnt1.getX() + " Y:" + pnt1.getY() + " String: "+ pnt1.getStr());
        System.out.println("X: " + pnt2.getX() + " Y: " +pnt2.getY() + " String: "+ pnt2.getStr());
    }

    public static void foo(Integer d) {
        d.equals(3);

        d = new Integer(5);
        d.equals(5); // true
        System.out.println(d.toString());
    }

    public static void tricky(Point arg1, Point arg2)
    {
        arg1.setX(100);
        arg1.setY(100);
        arg1.setStr("changed");
        Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }
}
