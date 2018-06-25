package example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 1/12/2018.
 */
public class NonReapeatingC {

    final static int MAX_CHAR = 256;

    public static void main(String[] args) {
        findFirstNonRepeating();
    }

    static void findFirstNonRepeating(){
        boolean[] repeated = new boolean[MAX_CHAR];
        List<Character> inDLL = new ArrayList<>();

        String stream = "geeksforgeeksandgeeksquizfor";

        for (int i = 0; i < stream.length(); i++){
            if (!repeated[stream.charAt(i)]){
                if (inDLL.contains(stream.charAt(i))) {
                    repeated[stream.charAt(i)] = true;
                    inDLL.remove((Character) stream.charAt(i));
                }else{
                    inDLL.add(stream.charAt(i));
                }
            }
        }

        // Print the current first non-repeating character from
        // stream
        if(inDLL.size() != 0)
        {
            System.out.print("First non-repeating character so far is ");
            System.out.println(inDLL.get(0));
        }

    }
}
