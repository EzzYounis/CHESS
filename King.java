public class King extends Piece{
    public King(Square location,int color) {
        super(location,color);
    }
    public String toString() {
        if (getcolor() == 0) {
            return "K";

        } else
            return "k";
    }
    public boolean canMove(String Destination,Board board){
        Square newS= new Square(board.getrow(Destination),board.getcolumn(Destination),board);

        int newRow=newS.getRow();
        int newColumn=newS.getColumn();
        int row=getLocation().getRow();
        int column=getLocation().getColumn();

        if (board.Squares[newRow][newColumn]!=null) {
            if(board.Squares[newRow][newColumn].getcolor()==getcolor()){
                return false;
            }
        }
        if(Math.abs(newRow-row)==1&&Math.abs(column-newColumn)==1){//The king can only move one step
            return true;
         }
        if (Math.abs(newRow-row)==1&&Math.abs(column-newColumn)==0){
            return true;
        }
        if (Math.abs(newRow-row)==0&&Math.abs(column-newColumn)==1){
            return true;
        }
        return false;
    }
}
