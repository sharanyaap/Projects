package example.model;

/**
 * Created by sharanya.p on 11/28/2016.
 */
public class Point {

    private Integer x;

    private Integer y;

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Point(Integer x, Integer y, String str){
        this.x = x;
        this.y = y;
        this.str = str;
    }

}
