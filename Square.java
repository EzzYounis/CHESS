

import javax.sound.sampled.FloatControl;

public  class Square {

    private int row;
    private int column;


    Board board;


    public Square(int row ,int column, Board board) {

        this.board = board;
        this.row=row;
        this.column=column;


    }

    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public boolean moveVerticallyOrHorizontally(Square Destination,int color) {

        if (board.Squares[Destination.row][Destination.column]!=null) { //attacking friend (not acceptable)
            if(board.Squares[Destination.row][Destination.column].getcolor()==color){
                return false;
            }
        }
        if (this.column != Destination.column && this.row != Destination.row) {//It did not move either horizontally or vertically
            return false;
        }
        int rowDiff;
        int colDiff;
        if(this.column > Destination.column){
            colDiff=-1;
        }else {
            colDiff=1;
        }

        if (this.row>Destination.row){
            rowDiff=-1;
        }else  {
            rowDiff=1;
        }
        if (this.row!=Destination.row) {

            for (int rowmove = rowDiff+ this.row; rowmove != Destination.row;rowmove+=rowDiff) {
                if (board.Squares[rowmove][this.column] != null) {
                    return false;
                }

            }
        }

        if (this.column!=Destination.column){
            for (int colmove = colDiff + this.column; colmove != Destination.column;colmove+=colDiff) {
                if (board.Squares[this.row][colmove] != null) {
                    return false;
                }

            }
        }
        return true;
    }



    public boolean IsAtLastRow(int color){
        if (color == 0 && row ==0){ // if the color is white
            return true;
        }else if ( color ==1 && row ==7 ){ //if the color is black
            return true;
        }else
            return false;
    }
    public void putNewQueen(int color){
        Queen q =new Queen(this,color);
        board.Squares[row][column]=q;

    }

    public Boolean IsEmpty(){
        if (board.Squares[row][column] == null) {
            return true;
        } else
            return false;

    }

    public boolean isNeighborColumn(Square location){
        if(Math.abs(this.column-location.column)==1){
            return true;
        }else
            return false;
    }



    public int getRowDistance(Square destination){
        return  this.row-destination.row;
    }
    public boolean isSameColumn(Square destination){
        return column == destination.column;
    }
    public boolean MoveDiagonally(Square destination,int color){
        int colDiff; // A variable to know which direction is the piece moving
        int rowDiff;

        int newRow =destination.row;
        int newColumn= destination.column;
        if(Math.abs(row-newRow)!=Math.abs(column-newColumn)||this.row==newRow||column==newColumn ){//not moving diagonally
            return false;
        }


        if(row<newRow){
            rowDiff=1;
        }else{
            rowDiff=-1;
        }
        if (column<newColumn){
            colDiff=1;
        }else {
            colDiff=-1;
        }


        if (board.Squares[newRow][newColumn]!=null) {
            if(board.Squares[newRow][newColumn].getcolor()==color){
                return false;
            }
        }
        int colmove= colDiff+column; //the column movement
        for (int rowmove = rowDiff + row; rowmove != newRow; rowmove += rowDiff) {
            if (board.Squares[rowmove ][colmove ] != null) {
                return false; //there is another piece on its way so it cannot move
            }
            colmove += colDiff;
        }
        return true;

    }

}
