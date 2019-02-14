package practice.sort;

/**
 * Created by sharanya.p on 10/24/2018.
 */
public class NutsNBolts {

    public static void main(String[] args) {
        // Nuts and bolts are represented as array of characters
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        NutsNBolts nutsNBolts = new NutsNBolts();
        // Method based on quick sort which matches nuts and bolts
        nutsNBolts.matchPairs(nuts, bolts, 0, 5);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        System.out.println();
        printArray(bolts);

    }

    public void matchPairs(char nuts[], char bolts[], int low, int high) {
        if (low < high) {
            int pivot = partition(nuts, low, high, bolts[high]);
            partition(bolts, low, high, pivot);
            matchPairs(nuts, bolts, low, pivot - 1);
            matchPairs(nuts, bolts, pivot + 1, high);
        }
    }

    public int partition(char in[], int low, int high, int pivot) {
        int i = low - 1;
        char temp;
        for (int j = low; j < high; j++) {
            if (in[j] < in[pivot]) {
                i++;
                temp = in[i];
                in[i] = in[j];
                in[j] = temp;
            }
        }
        temp = in[i + 1];
        in[pivot] = in[i + 1];
        in[i + 1] = temp;
        return i + 1;
    }


    // Method to print the array
    private static void printArray(char[] arr) {
        for (char ch : arr) {
            System.out.print(ch + " ");
        }
        System.out.print("n");
    }

    /*void matchPairs(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            int pivot = partition(nuts, low, high, bolts[high]);
            partition(bolts, low, high, nuts[pivot]);
            matchPairs(nuts, bolts, low, pivot - 1);
            matchPairs(nuts, bolts, pivot + 1, high);

        }
    }

    int partition(char[] nuts, int low, int high, char pivot) {
        int i = low;
        char temp1, temp2 ;
        for (int j = low; j < high; j++) {
            if (nuts[i]<pivot){
                temp1 = nuts[j];
                nuts[j]=nuts[i];
                nuts[i]=temp1;
                i++;
            }else if (nuts[i]==pivot){
                temp1 = nuts[j];
                nuts[j] = nuts[high];
                nuts[high] = temp1;
                j--;
            }
        }
        temp2 = nuts[i];
        nuts[i]=nuts[high];
        nuts[high]= temp2;
        return i;
    }*/


}
