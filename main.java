import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Board Chess = new Board();
        Scanner reader = new Scanner(System.in);
        Chess.PrintBoard();

        //Game Started
       while (!Chess.IsGameEnded()){
            System.out.println("It is "+ (Chess.WhitePlaying ? "White": "Black")+ "'s Turn");
            Piece piece =null;
            do {
                System.out.println("Enter the location of the piece: ");
                String from= reader.next();

                piece = Chess.getFrom(from);
                if (piece != null){

                }
            }while(piece == null || piece.getcolor() !=(Chess.WhitePlaying ? 0 : 1));
            String To =null;
            do{
                System.out.println("Enter the new location of the piece: ");
                To = reader.next();


            }while(!piece.canMove(To,Chess));

            piece.move(To,Chess);

            Chess.PrintBoard();
            if(!Chess.IsGameEnded()) {
                Chess.WhitePlaying = !Chess.WhitePlaying;
            }
        }
        System.out.printf((Chess.WhitePlaying ? "White": "Black")+" won the game!!");

    }
}
