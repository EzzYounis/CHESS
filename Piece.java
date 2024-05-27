public abstract class Piece {
    private int color; // 0 for white 1 for black
    private Square location;




    public Piece(Square Location, int color) {
        this.color = color;
        this.location=Location;

    }


    public void move(String to,Board board){

    Square s= new Square(board.getrow(to),board.getcolumn(to),board);
        board.Squares[s.getRow()][s.getColumn()]= board.Squares[location.getRow()][location.getColumn()];
        board.Squares[location.getRow()][location.getColumn()]=null;
        board.getFrom(to).location=s;


    }
    public int getcolor(){
        return color;
    }
    public Square getLocation(){
        return location;
    }

    public abstract boolean canMove(String NewS, Board board);

}
