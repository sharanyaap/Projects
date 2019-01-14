package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 10/29/2018.
 */
public class SNT {

    SN root;

    public static void main(String[] args) {

    }


}

class SN {
    SN children[] = new SN[256];
    List<Integer> indexes;

    public SN() {
        for (int i = 0; i < 256; i++)
            children[i] = null;
        indexes = new ArrayList<>();
    }

    public void insert(String str, int index) {
        indexes.add(index);
        if (index < str.length()) {
            // Find the first character
            char cIndex = str.charAt(0);
            if (children[cIndex] == null) {
                children[cIndex] = new SN();
            }
            children[index].insert(str.substring(1), index + 1);
        }
    }

    public List<Integer> search(String str) {
        if (str.length() == 0)
            return indexes;
        char cIndex = str.charAt(0);
        if (children[cIndex] != null)
            return children[cIndex].search(str.substring(1));
        else
            return null;
    }
}
