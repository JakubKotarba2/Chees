package org.example;

import java.util.LinkedList;

public class Pawn extends Piece{
    Pawn(int xP_in, int yP_in, String name_in, color color_in , LinkedList<Piece> pieceOnTheBoard_in) {

        set_xP(xP_in);
        set_yP(yP_in);
        setX(xP_in);
        setY(yP_in);
        setName(name_in);
        setPieceColor(color_in);
        setPiecesOnTheBoard(pieceOnTheBoard_in);
        pieceOnTheBoard_in.add(this);
        setPieceToBeKilled(null);
        isFirstMove = true;
    }

    public void move(int xP, int yP) {
        movePiece(xP, yP);
        isFirstMove = false;
    }

    public boolean checkIfMoveIsLegal(int xP, int yP) {

        if (isFirstMove) {
            if (this.getPieceColor() == Piece.color.white) {
                if (isThereAlreadyOpPiece(xP, yP)) {
                    return allowWhitePawnDiagonally(xP, yP);
                }else {
                    return allowWhitePawnForward2(xP, yP);
                }
            } else {
                if (isThereAlreadyOpPiece(xP, yP)) {
                    return allowBlackPawnDiagonally(xP, yP);
                }else {
                    return allowBlackPawnForward2(xP, yP);
                }
            }
        }
        else {
            if (this.getPieceColor() == Piece.color.white) {
                if (isThereAlreadyOpPiece(xP, yP)) {
                    return allowWhitePawnDiagonally(xP, yP);
                } else {
                    return allowWhitePawnForward(xP, yP);
                }
            } else {
                if (isThereAlreadyOpPiece(xP, yP)) {
                    System.out.println("Here");
                    return allowBlackPawnDiagonally(xP, yP);
                } else {
                    System.out.println("Here2");
                    return allowBlackPawnForward(xP, yP);
                }
            }
        }
    }


    public boolean allowWhitePawnForward2(int xP, int yP) {
        if (this.get_xP() == xP && ((this.get_yP() - 1) == yP || (this.get_yP() - 2) == yP)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean allowBlackPawnForward2(int xP, int yP) {
        if (this.get_xP() == xP && ((this.get_yP() + 1) == yP || (this.get_yP() + 2) == yP)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean allowWhitePawnDiagonally(int xP, int yP) {
        if ((this.get_xP() == xP || this.get_xP() + 1 == xP || this.get_xP() - 1 == xP)
                && ((this.get_yP() - 1) == yP)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean allowWhitePawnForward(int xP, int yP) {
        if (this.get_xP() == xP && ((this.get_yP() - 1) == yP)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean allowBlackPawnDiagonally(int xP, int yP) {
        if ((this.get_xP() == xP || this.get_xP() + 1 == xP || this.get_xP() - 1 == xP)
                && ((this.get_yP() + 1) == yP)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean allowBlackPawnForward(int xP, int yP) {
        if (this.get_xP() == xP && ((this.get_yP() + 1) == yP)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFirstMove;
}
