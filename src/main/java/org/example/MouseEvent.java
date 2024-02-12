package org.example;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvent {

    MouseEvent(JFrame frame) {
        this.frame = frame;
        selectedPiece = null;
        canWhiteMove = true;
        handleMouseEvent();
    }
    public void handleMouseEvent() {
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                    if (selectedPiece != null) {
                        if (canWhiteMove && selectedPiece.getPieceColor() == Piece.color.white) {
                        selectedPiece.setX(e.getX());
                        selectedPiece.setY(e.getY());
                        frame.repaint();
                    }
                        if (!canWhiteMove && selectedPiece.getPieceColor() == Piece.color.black) {
                            selectedPiece.setX(e.getX());
                            selectedPiece.setY(e.getY());
                            frame.repaint();
                        }
                }
            }

            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                frame.repaint();
            }
        });

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                System.out.println("canWhiteMove: " + canWhiteMove);
                System.out.println("Board.getPiece(e.getX(), e.getY()).getPieceColor(): " + Board.getPiece(e.getX(), e.getY()).getPieceColor());

                if (canWhiteMove && Board.getPiece(e.getX(), e.getY()).getPieceColor() == Piece.color.white) {
                    System.out.println("In white");
                    selectedPiece = Board.getPiece(e.getX(), e.getY());
                }

                if (!canWhiteMove && Board.getPiece(e.getX(), e.getY()).getPieceColor() == Piece.color.black) {
                    System.out.println("In black");
                    selectedPiece = Board.getPiece(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {

//                System.out.println("Return X clicked point: " + e.getX());
//                System.out.println("Return Y clicked point: " + e.getY());
//                System.out.println("Return X actually point x: " + selectedPiece.x);
//                System.out.println("Return Y actually point y: " + selectedPiece.y);

//                System.out.println("Return Y actually point xP: " + selectedPiece.yp);
//                System.out.println("Return Y actually point yP: " + selectedPiece.xp);

                System.out.println("canWhiteMove: " + canWhiteMove);
                if (canWhiteMove && selectedPiece.getPieceColor() == Piece.color.white && selectedPiece.checkIfMoveIsLegal(e.getX() / 64, e.getY() / 64)) {
                    selectedPiece.getObject().move(e.getX() / 64, e.getY() / 64);
                    frame.repaint();
                    canWhiteMove = false;
                }
                if (!canWhiteMove && selectedPiece.getPieceColor() == Piece.color.black && selectedPiece.checkIfMoveIsLegal(e.getX() / 64, e.getY() / 64)) {
                    selectedPiece.getObject().move(e.getX() / 64, e.getY() / 64);
                    frame.repaint();
                    canWhiteMove = true;
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                frame.repaint();
            }
        });
    }
    private JFrame frame;
    private Piece selectedPiece;
    private boolean canWhiteMove;
}
