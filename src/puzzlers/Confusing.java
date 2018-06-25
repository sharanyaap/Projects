package puzzlers;

/**
 * Created by sharanya.p on 4/4/2018.
 */
public class Confusing {

    private Confusing(Object o){
        System.out.println("Object");
    }

    private Confusing(double[] array){
        System.out.println("Array");
    }

    private Confusing(int i){
        System.out.println("int");
    }

    private Confusing(Integer i){
        System.out.println("Integer");
    }

    public static void main(String[] args) {
        new Confusing(1);
        new Confusing(Integer.valueOf(1));
        new Confusing("f");
    }


}
