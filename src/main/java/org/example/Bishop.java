package org.example;

import java.util.LinkedList;

public class Bishop extends Piece {

    public Bishop(int xP_in, int yP_in, String name_in, Piece.color color_in , LinkedList<Piece> pieceOnTheBoard_in) {

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

        int dX, dY;

        dX = Math.abs(this.get_xP() - xP);
        dY = Math.abs(this.get_yP() - yP);

        if (dX == dY) {
            return true;
        }
        return false;
    }

    // implementation method move for rock
    public void move(int xP,int yP) {
        movePiece(xP, yP);
    }

}
