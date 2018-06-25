package example;

import java.util.Scanner;

/**
 * Created by sharanya.p on 1/14/2018.
 */
public class UniverseOfPolygons {

    private int squareCount;
    private int rectangleCount;
    private int polygonCount;

    public UniverseOfPolygons() {
        this.squareCount = 0;
        this.rectangleCount = 0;
        this.polygonCount = 0;
    }

    public void addNewPolygon(int a, int b, int c, int d) {
        if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
            polygonCount += 1;
            return;
        }

        if (b == d && a == c) {
            if (a == b) {
                squareCount++;
            } else {
                rectangleCount += 1;
            }
        } else {
            polygonCount++;
        }
    }

    public int getSquareCount() {
        return squareCount;
    }

    public int getRectangleCount() {
        return rectangleCount;
    }

    public int getPolygonCount() {
        return polygonCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        UniverseOfPolygons universeOfPolygons = new UniverseOfPolygons();
        int count = 0;
        while (in.hasNextInt() && count < 3) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            count++;
            universeOfPolygons.addNewPolygon(a, b, c, d);
        }
        System.out.println(universeOfPolygons.getSquareCount() + " " +
                universeOfPolygons.getRectangleCount() + " " +
                universeOfPolygons.getPolygonCount());
    }

}
