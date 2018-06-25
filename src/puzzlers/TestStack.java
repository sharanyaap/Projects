package puzzlers;

/**
 * Created by sharanya.p on 4/4/2018.
 */
public class TestStack {

    public static void main(String[] args) {
        TestStack testStack = new TestStack();
        testStack.testStack();
    }

    private void testStack() {
        try {
            System.out.println("try");
            testStack();
        } finally {
            System.out.println("finally");
            testStack();
        }
    }

}
