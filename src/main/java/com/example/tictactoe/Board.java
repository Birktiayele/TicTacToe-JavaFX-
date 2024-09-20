package com.example.tictactoe;

import java.io.Serializable;

public class Board implements Serializable {
    int[][] cells;
    int rows;
    int columns;
    public Board(int rows, int columns, int defaultValue){
        this.rows=rows;
        this.columns=columns;
        cells=new int[rows][columns];

    }
    public void clickAt(int rowIndex, int columnIndex){
        for(int i=0; i<rows; i++){
            cells[i][columnIndex] = (cells[i][columnIndex] + 1);
        }
        for(int j=0; j<columns; j++) {
            if(j != columnIndex){
                cells[rowIndex][j] = (cells[rowIndex][j] + 1) ;
            }
        }
    }

}
