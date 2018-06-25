package example.model;

/**
 * Created by sharanya.p on 11/29/2016.
 */
class A {
    static int i = 10;
     String str = "A";

    A(){
        System.out.println("Const A"+str);
    }

     void myPrint(){
        System.out.println("Hi"+i+"  "+str);
    }
}
class B extends A {
    static int i = 20;
     String str = "B";

    B(){
        System.out.println("Const B"+str);
    }

     void  myPrint(){
        System.out.println("Hi"+i+"  "+str);
    }
}
public class MainCls
{
    public static void main(String[] args)
    {
        A a = new B();
        a.myPrint();
        System.out.println(a.str);
    }
}
