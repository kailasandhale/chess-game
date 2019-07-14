package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Piece {
    private boolean alive;
    private Square position;
    protected boolean isValidMove(Board board, Square source, Square dest){
        if(source.equals(dest)){
            return false;
        }
        return source.isValid() && dest.isValid();
    }
}
