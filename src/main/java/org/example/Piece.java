package org.example;

import java.util.LinkedList;

public abstract class Piece {
    enum color {
        white, black
    }

    // xp is actual point in the board e.g. 0 and 1
    // x and y are coordinates in pixels multiplies by 64 e.g. 0 and 64
    private int xP, x;
    private int yP, y;

    // can be white or black no others possibilities
    private color pieceColor;

    // list of all pieces placed on the board
    private LinkedList<Piece> piecesOnTheBoard;

    // piece that needs to be killed
    private Piece pieceToBeKilled;

    // name of the pieces uses only for loading .png
    private String name;

    // those methods inheritance class need to override
    public abstract void move(int xP, int yP);
    public abstract boolean checkIfMoveIsLegal(int xP, int yP);

    public void movePiece(int xP, int yP) {
        setPieceToBeKilled(eliminatePiece(xP, yP));

        this.set_xP(xP);
        this.set_yP(yP);
        this.setX((xP * 64));
        this.setY((yP * 64));

        if (getPieceToBeKilled() != null) {
            getPieceToBeKilled().kill();
        }
    }

    public Piece getObject() {
        return this;
    }

    public void set_xP(int xP_in) {
        this.xP = xP_in;
    }
    public int get_xP() {
        return xP;
    }
    public void set_yP(int yP_in) {
        this.yP = yP_in;
    }
    public int get_yP() {
        return yP;
    }
    public void setX(int x_in) {
        this.x = get_xP() * 64;
        //System.out.println("this.x" + this.x);
    }

    public int getX() {
        return x;
    }

    public void setY(int y_in) {
        this.y = get_yP() * 64;
        //System.out.println("this.y" + this.y);
    }

    public int getY() {
        return y;
    }


    public void setName(String name_in) {
        this.name = name_in;
    }

    public String getName() {
        return this.name;
    }

    public void setPiecesOnTheBoard(LinkedList<Piece> piecesOnTheBoard_in) {
        this.piecesOnTheBoard = piecesOnTheBoard_in;
    }

    public LinkedList<Piece> getPiecesOnTheBoard() {
        return this.piecesOnTheBoard;
    }

    public void setPieceColor(color color_in) {
        this.pieceColor = color_in;
    }

    public color getPieceColor() {
        return this.pieceColor;
    }

    public void setPieceToBeKilled(Piece p_in) {
        pieceToBeKilled = p_in;
    }

    public Piece getPieceToBeKilled() {
        return pieceToBeKilled;
    }

    public Piece eliminatePiece(int xP, int yP) {
        for (Piece p : piecesOnTheBoard) {
            if (p != null) {
                if (p.get_xP() == xP && p.get_yP() == yP && p.getObject() != this) {
                    pieceToBeKilled = p;
                }
            }
        }
        if (pieceToBeKilled != null) {
            return pieceToBeKilled;
        }
        return null;
    }

    public boolean isThereAlreadyOpPiece(int xP, int yP) {

        for (Piece p : this.getPiecesOnTheBoard()) {
            if (p.get_xP() == xP && p.get_yP() == yP && p.getPieceColor() != this.getPieceColor()) {
                return true;
            }
        }
        return false;
    }

    public boolean isThereAlreadyOpPieceSColor(int xP, int yP) {

        for (Piece p : this.getPiecesOnTheBoard()) {
            if (p.get_xP() == xP && p.get_yP() == yP && p.getPieceColor() == this.getPieceColor()) {
                return true;
            }
        }
        return false;
    }

    public void kill() {
        System.out.println("I do remove this piece => " + this.name);
        piecesOnTheBoard.remove(this);
        System.out.println("piecesOnTheBoard.size();" + piecesOnTheBoard.size());
    }
}








//import com.sun.jdi.connect.spi.TransportService;
//
//import java.util.LinkedList;
//
//public class Piece {
//    int xp, x;
//    int yp, y;
//    boolean isWhite;
//    LinkedList<Piece> piecesOnTheBoard;
//    Piece pieceToBeKilled;
//    String name;
//
//    public Piece(int xp, int yp, boolean isWhite,String n, LinkedList<Piece> ps) {
//        this.xp = xp;
//        this.yp = yp;
//        x = xp * 64;
//        y = yp * 64;
//
//        pieceToBeKilled = null;
//
//        System.out.println(xp);
//        System.out.println(yp);
//
//        System.out.println(x);
//        System.out.println(y);
//
//        this.isWhite = isWhite;
//        this.piecesOnTheBoard=ps;
//        name=n;
//        ps.add(this);
//    }
//
//    public void move(int xp,int yp){
//        for (Piece p : piecesOnTheBoard) {
//
//            if (p != null) {
//                System.out.println("Inside move method");
//
//                System.out.println("xp : " + xp);
//                System.out.println("yp :" + yp);
//
//                System.out.println(" name : " + p.name);
//                System.out.println("p.xp : " + p.xp);
//                System.out.println("y.yp :" + p.yp);
//
//                if (p.xp == xp && p.yp == yp) {
//                    System.out.println("Supposed to kill u");
//                    pieceToBeKilled = p;
//                }
//            }
//        }
//        this.xp=xp;
//        this.yp=yp;
//        x = xp * 64;
//        y = yp * 64;
//        if (pieceToBeKilled != null) {
//            pieceToBeKilled.kill();0
//        }
//        pieceToBeKilled = null;
//    }
//    public void kill(){
//        System.out.println("I do remove this piece => " + this.name);
//        piecesOnTheBoard.remove(this);
//        System.out.println("piecesOnTheBoard.size();" + piecesOnTheBoard.size());
//    }
//}