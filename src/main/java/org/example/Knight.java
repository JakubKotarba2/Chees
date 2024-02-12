package org.example;

import java.util.LinkedList;

public class Knight extends Piece {

    public Knight(int xP_in, int yP_in, String name_in, Piece.color color_in , LinkedList<Piece> pieceOnTheBoard_in) {
        set_xP(xP_in);
        set_yP(yP_in);
        setX(xP_in);
        setY(yP_in);
        setName(name_in);
        setPieceColor(color_in);
        setPiecesOnTheBoard(pieceOnTheBoard_in);
        pieceOnTheBoard_in.add(this);
        setPieceToBeKilled(null);
    }

    public boolean checkIfMoveIsLegal(int xP, int yP) {

        if (isThereAlreadyOpPieceSColor(xP, yP)) {
            return false;
        }

        if (this.get_xP() == xP + 2 && this.get_yP() == yP + 1) {
            return true;
        }else if(this.get_xP() == xP + 1 && this.get_yP() == yP + 2) {
            return true;
        }else if(this.get_xP() == xP - 2 && this.get_yP() == yP + 1) {
            return true;
        }else if(this.get_xP() == xP - 1 && this.get_yP() == yP + 2) {
            return true;
        }else if(this.get_xP() == xP - 2 && this.get_yP() == yP - 1) {
            return true;
        }else if(this.get_xP() == xP - 1 && this.get_yP() == yP - 2) {
            return true;
        }else if(this.get_xP() == xP + 2 && this.get_yP() == yP - 1) {
            return true;
        }else if(this.get_xP() == xP + 1 && this.get_yP() == yP - 2) {
            return true;

        }else {
            return false;
        }
    }

    // implementation method move for rock
    public void move(int xP,int yP) {
        movePiece(xP, yP);
    }

}