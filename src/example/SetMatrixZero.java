package example;

import java.util.ArrayList;

/**
 * Created by sharanya.p on 1/15/2018.
 */
public class SetMatrixZero {

    public static void main(String[] args) {
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        int[][] matrix = {{1, 0, 1}, {1, 1, 1}, {1, 1, 1}};
        setMatrixZero.setZeroes(matrix);
        System.out.println(matrix);
    }


    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        //set first row and column zero or not
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        //mark zeros on first row and column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //use mark to set elements
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //set first column and row
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }

    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        //set first row and column zero or not
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(0) == 0) {
                firstColumnZero = true;
                break;
            }
        }

        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 0) {
                firstRowZero = true;
                break;
            }
        }

        //mark zeros on first row and column
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        //use mark to set elements
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(0).size(); j++) {
                if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }

        //set first column and row
        if (firstColumnZero) {
            for (int i = 0; i < a.size(); i++)
                a.get(i).set(0, 0);
        }

        if (firstRowZero) {
            for (int i = 0; i < a.get(0).size(); i++)
                a.get(0).set(i, 0);
        }

    }
}
