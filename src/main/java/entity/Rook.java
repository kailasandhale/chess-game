package entity;

public class Rook extends Piece {

    public Rook(boolean alive, Square position) {
        super(alive, position);
    }

    @Override
    protected boolean isValidMove(Board board, Square source, Square dest) {
        if(!super.isValidMove(board, source, dest)){
            return false;
        }
        return source.getX() == dest.getX() || source.getY() == dest.getY();
    }
}
