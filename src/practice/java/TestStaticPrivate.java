package practice.java;

/**
 * Created by sharanya.p on 12/3/2018.
 */
public class TestStaticPrivate {

    public static void testMethd1() {
        System.out.println("testMethod1");
    }

    public static void main(String[] args) {
        TestStaticPrivate testStaticPrivate = new Child1();
        testStaticPrivate.testMethd1();
    }

}

class Child1 extends TestStaticPrivate {
    public static void testMethd1() {
        System.out.println("testMethod 1 from Child");
    }
}
