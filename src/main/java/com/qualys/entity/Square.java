package com.qualys.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Square {
    private int x;
    private int y;
    public boolean isValid(){
        return (x >= 0 && x <= 7) || (y >= 0 && y <= 7);
    }

    public Square getNeighbour(int horizontal, int vertical) {
        return new Square(getX() + horizontal, getY() + vertical);
    }

}
