import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    boolean WhitePlaying=true;
    public Board(){
        this.SetupBoard();
    }

    Piece [][] Squares=new Piece[8][8];


    private void SetupBoard(){
        for (int i=0;i<8;i++) {
            Squares[6][i] = (new Pawn(new Square(6,i,this), 0));
        }

        Squares[7][3]=(new Queen(new Square(7,3,this),0));
        Squares[7][4]=(new King(new Square(7,4,this),0));
        Squares[7][0]=(new Rook(new Square(7,0,this),0));
        Squares[7][7]=(new Rook(new Square(7,7,this),0));
        Squares[7][2]=(new Bishop(new Square(7,2,this),0));
        Squares[7][5]=(new Bishop(new Square(7,5,this),0));
        Squares[7][1]=(new Knight(new Square(7,1,this),0));
        Squares[7][6]=(new Knight(new Square(7,6,this),0));

        //  Adding Black Pieces

        for (int i=0;i<8;i++) {
            Squares[1][i] = (new Pawn(new Square(1,i,this), 1));
        }

        Squares[0][3]=(new Queen(new Square(0,3,this),1));
        Squares[0][4]=(new King(new Square(0,4,this),1));
        Squares[0][0]=(new Rook(new Square(0,0,this),1));
        Squares[0][7]=(new Rook(new Square(0,7,this),1));
        Squares[0][2]=(new Bishop(new Square(0,2,this),1));
        Squares[0][5]=(new Bishop(new Square(0,5,this),1));
        Squares[0][1]=(new Knight(new Square(0,1,this),1));
        Squares[0][6]=(new Knight(new Square(0,6,this),1));

    }


    public int getrow(String position){
        int row = Integer.parseInt(position.substring(1));

        return Math.abs(8-row);
    }
    public int getcolumn(String position){
        String loc = position.substring(0,1).toUpperCase();
        int index=0 ;
        String [] charc= {"A","B","C","D","E","F","G","H"};
        for (int i=0 ; i<charc.length;i++){
            if(loc.equals(charc[i])){
                index=i;
            }

        }
        return index;

    }

    public boolean IsGameEnded(){
        int black =0;
        int white =0;
        for (int row=0;row<8;row++){
            for (int col=0 ;col<8;col++){
                if(Squares[row][col]!=null){
                    if(Squares[row][col].getcolor()==0){
                        white++;
                    }else if (Squares[row][col].getcolor()==1){
                        black++;
                    }
                }
            }
        }



        if(black !=0 && white !=0){
            return false;
        }else
            return true;
    }

    public Piece getFrom(String from){

        if(Squares[getrow(from)][getcolumn(from)]!=null) {

            return Squares[getrow(from)][getcolumn(from)];
        }else
            return null;
    }
    public Piece getFrom( Square from){
        if(Squares[from.getRow()][from.getColumn()]!=null) {

            return Squares[from.getRow()][from.getColumn()];
        }else
            return null;
    }
    public void PrintBoard() {



        System.out.println("    A   B   C   D   E   F   G   H");
        System.out.println("  --------------------------------");
        for (int row = 7; row >=0; row--) {
            System.out.print(row+ 1 + " ");
            for (int col =0; col < 8; col++) {
                if (Squares[Math.abs(7-row)][col]!=null) {
                    System.out.print("|");
                    System.out.print(" "+Squares[Math.abs(7-row)][col]+" " );
                }else {
                    System.out.print("|");
                    System.out.print("   ");

                }
                if (col ==7){
                    System.out.print("| "+(row+ 1));
                }


            }
            System.out.println();
            System.out.println("  ---------------------------------");
        }
        System.out.println("    A   B   C   D   E   F   G   H");

    }

}
