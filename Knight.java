public class Knight extends Piece {
    public Knight(Square location,int color) {
        super(location,color);
    }
    public String toString() {
        if (getcolor() == 0) {
            return "N";

        } else
            return "n";
    }
    public boolean canMove(String destination,Board board){
        Square Destination=new Square(board.getrow(destination),board.getcolumn(destination),board);
        if (board.Squares[Destination.getRow()][Destination.getColumn()]!=null) { //attacking friend (not acceptable)
            if(board.Squares[Destination.getRow()][Destination.getColumn()].getcolor()==getcolor()){
                return false;
            }
        }
        if (Math.abs(Destination.getColumn()-getLocation().getColumn())==2 &&Math.abs(Destination.getRow()-getLocation().getRow())==1){
            return true;
        }
        if (Math.abs(Destination.getColumn()-getLocation().getColumn())==1 &&Math.abs(Destination.getRow()-getLocation().getRow())==2){
            return true;
        }
        return false;
    }
}
