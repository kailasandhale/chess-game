package entity;

public class King extends Piece {
    public King(boolean isAlive, Square square){
        super(isAlive,square);
    }

    @Override
    public boolean isValidMove(Board board, Square source, Square dest){
       if(!super.isValidMove(board,source,dest)){
           return false;
       }
        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return horizontalDiff <= 1 && verticalDiff <= 1 && horizontalDiff + verticalDiff >= 1;
    }
}
