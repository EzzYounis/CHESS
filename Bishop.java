public class Bishop extends Piece{
    public Bishop(Square location,int color) {
        super(location,color);
    }
    public String toString() {
        if (getcolor() == 0) {
            return "B";

        } else
            return "b";
    }
    public boolean canMove(String Destination,Board board){
        Square s= new Square(board.getrow(Destination),board.getcolumn(Destination),board);
        return getLocation().MoveDiagonally(s,getcolor());

    }



}
