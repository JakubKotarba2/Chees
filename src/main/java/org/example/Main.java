package org.example;

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        JFrame frame1 = new JFrame();

        Object[] options = {"Yes", "No"};

        int n = JOptionPane.showOptionDialog(frame1,
                "Would you like start chess game", "Maybe some chess?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (n != 1) {
            Board board = new Board(frame);
        }
    }














//    public static  LinkedList<Piece> ps=new LinkedList<>();
//    public static Piece selectedPiece = null;

//        BufferedImage all=ImageIO.read(new File("chess.png"));
//        Image imgs[]=new Image[12];
//        int ind=0;
//        for(int y=0;y<400;y+=200){
//            for(int x=0;x<1200;x+=200){
//                imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
//                ind++;
//            }
//        }
//        Piece brook=new Piece(0, 0, false, "rook", ps);
//        Piece bkinght=new Piece(1, 0, false, "knight", ps);
//        Piece bbishop=new Piece(2, 0, false, "bishop", ps);
//        Piece bqueen=new Piece(3, 0, false, "queen", ps);
//        Piece bking=new Piece(4, 0, false, "king", ps);
//        Piece bbishop2=new Piece(5, 0, false, "bishop", ps);
//        Piece bkight2=new Piece(6, 0, false, "knight", ps);
//        Piece brook2=new Piece(7, 0, false, "rook", ps);
//        Piece bpawn1=new Piece(1, 1, false, "pawn", ps);
//        Piece bpawn2=new Piece(2, 1, false, "pawn", ps);
//        Piece bpawn3=new Piece(3, 1, false, "pawn", ps);
//        Piece bpawn4=new Piece(4, 1, false, "pawn", ps);
//        Piece bpawn5=new Piece(5, 1, false, "pawn", ps);
//        Piece bpawn6=new Piece(6, 1, false, "pawn", ps);
//        Piece bpawn7=new Piece(7, 1, false, "pawn", ps);
//        Piece bpawn8=new Piece(0, 1, false, "pawn", ps);
//
//        Piece wrook=new Piece(0, 7, true, "rook", ps);
//        Piece wkinght=new Piece(1, 7, true, "knight", ps);
//        Piece wbishop=new Piece(2, 7, true, "bishop", ps);
//        Piece wqueen=new Piece(3, 7, true, "queen", ps);
//        Piece wking=new Piece(4, 7, true, "king", ps);
//        Piece wbishop2=new Piece(5, 7, true, "bishop", ps);
//        Piece wkight2=new Piece(6, 7, true, "knight", ps);
//        Piece wrook2=new Piece(7, 7, true, "rook", ps);
//        Piece wpawn1=new Piece(1, 6, true, "pawn", ps);
//        Piece wpawn2=new Piece(2, 6, true, "pawn", ps);
//        Piece wpawn3=new Piece(3, 6, true, "pawn", ps);
//        Piece wpawn4=new Piece(4, 6, true, "pawn", ps);
//        Piece wpawn5=new Piece(5, 6, true, "pawn", ps);
//        Piece wpawn6=new Piece(6, 6, true, "pawn", ps);
//        Piece wpawn7=new Piece(7, 6, true, "pawn", ps);
//        Piece wpawn8=new Piece(0, 6, true, "pawn", ps);
//
//        JFrame frame = new JFrame();
//        frame.setBounds(10, 10, 512, 512);
//        frame.setUndecorated(true);
//        JPanel pn=new JPanel(){
//            @Override
//            public void paint(Graphics g) {
//                boolean white=true;
//                for(int y= 0;y<8;y++){
//                    for(int x= 0;x<8;x++){
//                        if(white){
//                            g.setColor(new Color(235,235, 208));
//                        }else{
//                            g.setColor(new Color(119, 148, 85));
//
//                        }
//                        g.fillRect(x*64, y*64, 64, 64);
//                        white=!white;
//                    }
//                    white=!white;
//                }
//                for(Piece p: ps) {
//                    int ind=0;
//                    if(p.name.equalsIgnoreCase("king")){
//                        ind=0;
//                    }
//                    if(p.name.equalsIgnoreCase("queen")){
//                        ind=1;
//                    }
//                    if(p.name.equalsIgnoreCase("bishop")){
//                        ind=2;
//                    }
//                    if(p.name.equalsIgnoreCase("knight")){
//                        ind=3;
//                    }
//                    if(p.name.equalsIgnoreCase("rook")){
//                        ind=4;
//                    }
//                    if(p.name.equalsIgnoreCase("pawn")){
//                        ind=5;
//                    }
//                    if(!p.isWhite){
//                        ind+=6;
//                    }
//                    g.drawImage(imgs[ind], p.x, p.y, this);
//                }
//            }
//
//        };
//        frame.add(pn);
//
//        frame.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                if (selectedPiece != null) {
//                    selectedPiece.xp = e.getX();
//                    selectedPiece.yp = e.getY();
//                    frame.repaint();
//                }
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                frame.repaint();
//            }
//        });
//        frame.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                selectedPiece = getPiece(e.getX(), e.getY());
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                selectedPiece.move(e.getX()/64, e.getY()/64);
//                frame.repaint();
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                frame.repaint();
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
//
//        frame.setDefaultCloseOperation(3);
//        frame.setVisible(true);
//
//    }
//    public static Piece getPiece(int x, int y) {
//        int xP = x / 64;
//        int yP = y / 64;
//        for (Piece p : ps) {
//            if (p.xp == xP && p.yp == yP) {
//                return p;
//            }
//        }
//        return null;
//    }
}
