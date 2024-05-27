public class Queen extends Piece {
    public Queen(Square location,int color) {
        super(location,color);

    }
    public String toString() {
        if (getcolor() == 0) {
            return "Q";

        } else
            return "q";
    }
    public boolean canMove(String Destination,Board board){
        Square s=new Square(board.getrow(Destination),board.getcolumn(Destination),board);
        return getLocation().moveVerticallyOrHorizontally(s,getcolor())||getLocation().MoveDiagonally(s,getcolor());

    }
}
