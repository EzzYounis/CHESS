public class Rook extends Piece{
    public Rook(Square location,int color) {
        super(location,color);
    }
    public String toString() {
        if (getcolor() == 0) {
            return "R";

        } else
            return "r";
    }

    public boolean canMove(String destination,Board board){
        Square s=new Square(board.getrow(destination),board.getcolumn(destination),board);
        return getLocation().moveVerticallyOrHorizontally(s,getcolor());
    }


}
