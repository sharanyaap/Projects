package example;

/**
 * Created by sharanya.p on 1/5/2018.
 */
public class Base {

    private String baseStr;

    public Base() {
    }

    public Base(String baseStr) {
        this.baseStr = baseStr;
    }

    public void testMtd() {
        System.out.println("Inside Base :: " + baseStr);
    }

}

class Derived extends Base {

    private String derivedStr;

    public Derived(String derivedStr) {
        this.derivedStr = derivedStr;
    }

    @Override
    public void testMtd() {
        System.out.println("Inside Derived :: " + derivedStr);
    }

}

class Test {
    public static void main(String[] args) {
        Base b = new Derived("derived");
        Base b1 = new Base("base");
        Derived d = (Derived) b;
        d.testMtd();
        d = (Derived) b1;
        d.testMtd();
    }
}
