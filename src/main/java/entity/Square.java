package entity;

public class Square {
    private int x;
    private int y;
    public boolean isValid(){
        return (x >= 0 && x <= 7) || (y >= 0 && y <= 7);
    }
}
