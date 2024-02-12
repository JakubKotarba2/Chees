package org.example;

import java.util.LinkedList;

public class Rook extends Piece {

    public Rook(int xP_in, int yP_in, String name_in, Piece.color color_in , LinkedList<Piece> pieceOnTheBoard_in) {

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
        if (this.get_xP() != xP && this.get_yP() != yP && isThereAlreadyOpPieceSColor(xP, yP)){
            return false;
        }
        if (isThereAlreadyOpPieceSColor(xP, yP)) {
            return false;
        }
        return true;
    }

    // implementation method move for rock
    public void move(int xP,int yP) {
        movePiece(xP, yP);
    }
}









//        System.out.println("this.xP" + this.get_xP());
//        System.out.println("this.yP" + this.get_yP());
//        System.out.println("this.xP" + this.xP);
//        System.out.println("this.yP" + this.yP);
//        System.out.println("this.x" + this.x);
//        System.out.println("this.y" + this.y);
//        System.out.println("this.getX()" + this.getX());
//        System.out.println("this.getY()" + this.getY());
//        System.out.println("xP" + xP);
//        System.out.println("yP" + yP);