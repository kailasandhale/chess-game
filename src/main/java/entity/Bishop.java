package entity;

public class Bishop extends Piece {
    public Bishop(boolean alive, Square position) {
        super(alive, position);
    }

    @Override
    protected boolean isValidMove(Board board, Square source, Square dest) {
        if(!super.isValidMove(board, source, dest)){
            return false;
        }
        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return  horizontalDiff == verticalDiff;
    }
}