package entity;

import lombok.Getter;

@Getter
public abstract class Piece {
    private boolean alive;
    protected boolean isValidMove(Square source, Square dest){
        if(!source.isValid() || !dest.isValid()){
            return false;
        }
        return true;
    }
}
