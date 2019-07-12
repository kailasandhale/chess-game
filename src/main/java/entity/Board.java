package entity;

public class Board {
    private Square [][] squares= new Square[8][8];
    public Board(){
        for(int horizontalIndex = 0 ; horizontalIndex < 8; horizontalIndex++){
            initialiseColumn(horizontalIndex);
        }
    }

    public Square getSquare(int horizontalIndex, int verticalIndex){
        return squares[horizontalIndex][verticalIndex];
    }

    private void initialiseColumn(int horizontalIndex) {
        for(int verticalIndex = 0 ; verticalIndex < 8; verticalIndex++){
            squares[horizontalIndex][verticalIndex] = new Square();
        }
    }
}
