public class Pawn extends Piece {
    boolean intialLocation = true;

    public Pawn(Square Location, int color) {
        super(Location, color);
    }

    public String toString() {
        if (getcolor() == 0) {
            return "P";

        } else
            return "p";
    }

    public void move(String To,Board board) {
        Square to =new Square(board.getrow(To),board.getcolumn(To),board);
        if (to.IsAtLastRow(getcolor())){
            to.putNewQueen(getcolor());
            board.Squares[getLocation().getRow()][getLocation().getColumn()]=null;

        }else {
            super.move(To ,board);
        }

        if (intialLocation){
            intialLocation=false;
        }


    }

    public  boolean canMove(String NewS, Board board) {
        Square newS=new Square(board.getrow(NewS),board.getcolumn(NewS),board);
        boolean validmove = false;

        int rowDistance = getLocation().getRowDistance(newS);
        if (getLocation().isSameColumn(newS)) {
            if (getcolor() == 0 && rowDistance > 0 && rowDistance <= 2) {
                if (rowDistance == 2) {
                    if (intialLocation) { //it the first move for the pawn it can move twice
                        Square between = new Square(getLocation().getRow()-1,getLocation().getColumn(),board);
                        validmove = newS.IsEmpty() && between.IsEmpty();

                    }
                }else {
                    validmove = newS.IsEmpty();
                }
                return validmove;
                } else if (getcolor() == 1 && rowDistance < 0 && rowDistance>= -2) {
                    if (rowDistance == -2) {
                        if (intialLocation) {
                            Square between= new Square(getLocation().getRow()+1,getLocation().getColumn(),board);
                            validmove = newS.IsEmpty()&&between.IsEmpty();

                        }
                    } else {
                        return validmove = newS.IsEmpty();
                    }
                }
            } else if (getLocation().isNeighborColumn(newS)==true) {
                if (getcolor() == 0 && rowDistance == 1) {
                    validmove = !newS.IsEmpty() && board.getFrom(NewS).getcolor() == 1;
                } else if (getcolor() == 1 && rowDistance == -1) {
                    validmove = !newS.IsEmpty() && board.getFrom(NewS).getcolor() == 0;
                }

            }


        return validmove;
    }








}
