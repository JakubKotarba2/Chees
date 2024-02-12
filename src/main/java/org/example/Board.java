package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board {

    public Board(JFrame frame_in) throws  IOException{
        piecesOnTheBoard = new LinkedList<>();
        loadImagines();
        drawBoard(frame_in);
            initializePieces();
        boardMouseEvent = new MouseEvent(frame);
    }

    public void drawBoard(JFrame frame_in) {
        this.frame = frame_in;
        Pattern blackPawn = Pattern.compile("bPawn.*");
        Pattern whitePawn = Pattern.compile("wPawn.*");
        frame.setBounds(350, 180, 512, 512);
        frame.setUndecorated(true);
        JPanel pn= new JPanel(){
            @Override
            public void paint(Graphics g) {
                boolean white=true;
                for(int y= 0;y<8;y++) {
                    for(int x= 0;x<8;x++) {
                        if(white) {
                            g.setColor(new Color(235,235, 208));
                        }else{
                            g.setColor(new Color(119, 148, 85));

                        }
                        g.fillRect(x*64, y*64, 64, 64);
                        white=!white;
                    }
                    white=!white;
                }
                for(Piece p: piecesOnTheBoard) {
                    int ind=0;
                    if(p.getName().equalsIgnoreCase("bKing30") || p.getName().equalsIgnoreCase("wKing37")){
                        ind=0;
                    }
                    if(p.getName().equalsIgnoreCase("bQueen40") || p.getName().equalsIgnoreCase("wQueen47")){
                        ind=1;
                    }
                    if (p.getName().equalsIgnoreCase("bBishop20") || p.getName().equalsIgnoreCase("bBishop50") ||
                            p.getName().equalsIgnoreCase("wBishop27") || p.getName().equalsIgnoreCase("wBishop57")) {
                        ind=2;
                    }
                    if (p.getName().equalsIgnoreCase("bKnight10") || p.getName().equalsIgnoreCase("bKnight60") ||
                            p.getName().equalsIgnoreCase("wKnight17") || p.getName().equalsIgnoreCase("wKnight67")){
                        ind=3;
                    }
                    if (p.getName().equalsIgnoreCase("bRook00") || p.getName().equalsIgnoreCase("bRook07") ||
                            p.getName().equalsIgnoreCase("wRook70") || p.getName().equalsIgnoreCase("wRook77")) {
                        ind=4;
                    }

                    Matcher b_matcher = blackPawn.matcher(p.getName());
                    Matcher w_matcher = whitePawn.matcher(p.getName());
                    if(b_matcher.matches() || w_matcher.matches()){
                        ind=5;
                    }
                    if(p.getPieceColor() != Piece.color.white){
                        ind+=6;
                    }
                    g.drawImage(imgs[ind], p.getX(), p.getY(), this);
                }
            }
        };
        frame.add(pn);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    public void loadImagines() throws IOException {
        BufferedImage all= ImageIO.read(new File("chess.png"));
        imgs = new Image[12];
        int ind=0;
        for(int y=0;y<400;y+=200){
            for(int x=0;x<1200;x+=200){
                imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
    }

    public void initializePieces() {

        // black Pieces
        Rook bRook00 = new Rook(0, 0, "bRook00", Piece.color.black,  piecesOnTheBoard);
        Rook bRook07 = new Rook(7, 0, "bRook07", Piece.color.black,  piecesOnTheBoard);

        Knight bKnight10 = new Knight(1, 0, "bKnight10", Piece.color.black,  piecesOnTheBoard);
        Knight wKnight60 = new Knight(6, 0, "bKnight60", Piece.color.black,  piecesOnTheBoard);

        Bishop bBishop20 = new Bishop(2, 0, "bBishop20", Piece.color.black,  piecesOnTheBoard);
        Bishop bBishop50 = new Bishop(5, 0, "bBishop50", Piece.color.black,  piecesOnTheBoard);

        King bKing30 = new King(3, 0, "bKing30", Piece.color.black,  piecesOnTheBoard);
        Queen bQueen40 = new Queen(4, 0, "bQueen40", Piece.color.black,  piecesOnTheBoard);

        Pawn bPawn10 = new Pawn(0, 1, "bPawn10", Piece.color.black,  piecesOnTheBoard);
        Pawn bPawn11 = new Pawn(1, 1, "bPawn11", Piece.color.black,  piecesOnTheBoard);
        Pawn bPawn12 = new Pawn(2, 1, "bPawn12", Piece.color.black,  piecesOnTheBoard);
        Pawn bPawn13 = new Pawn(3, 1, "bPawn13", Piece.color.black,  piecesOnTheBoard);
        Pawn bPawn14 = new Pawn(4, 1, "bPawn14", Piece.color.black,  piecesOnTheBoard);
        Pawn bPawn15 = new Pawn(5, 1, "bPawn15", Piece.color.black,  piecesOnTheBoard);
        Pawn bPawn16 = new Pawn(6, 1, "bPawn16", Piece.color.black,  piecesOnTheBoard);
        Pawn bPawn17 = new Pawn(7, 1, "bPawn17", Piece.color.black,  piecesOnTheBoard);

        // White Pieces
        Rook wRook70 = new Rook(0, 7, "wRook70", Piece.color.white,  piecesOnTheBoard);
        Rook wRook77 = new Rook(7, 7, "wRook77", Piece.color.white,  piecesOnTheBoard);

        Knight wKnight17 = new Knight(1, 7, "wKnight17", Piece.color.white,  piecesOnTheBoard);
        Knight wKnight67 = new Knight(6, 7, "wKnight67", Piece.color.white,  piecesOnTheBoard);

        Bishop wBishop27 = new Bishop(2, 7, "wBishop27", Piece.color.white,  piecesOnTheBoard);
        Bishop wBishop57 = new Bishop(5, 7, "wBishop57", Piece.color.white,  piecesOnTheBoard);

        King wKing37 = new King(3, 7, "wKing37", Piece.color.white,  piecesOnTheBoard);
        Queen wQueen47 = new Queen(4, 7, "wQueen47", Piece.color.white,  piecesOnTheBoard);

        Pawn wPawn60 = new Pawn(0, 6, "bPawn06", Piece.color.white,  piecesOnTheBoard);
        Pawn wPawn61 = new Pawn(1, 6, "bPawn16", Piece.color.white,  piecesOnTheBoard);
        Pawn wPawn62 = new Pawn(2, 6, "bPawn16", Piece.color.white,  piecesOnTheBoard);
        Pawn wPawn63 = new Pawn(3, 6, "bPawn16", Piece.color.white,  piecesOnTheBoard);
        Pawn wPawn64 = new Pawn(4, 6, "bPawn16", Piece.color.white,  piecesOnTheBoard);
        Pawn wPawn65 = new Pawn(5, 6, "bPawn16", Piece.color.white,  piecesOnTheBoard);
        Pawn wPawn66 = new Pawn(6, 6, "bPawn16", Piece.color.white,  piecesOnTheBoard);
        Pawn wPawn67 = new Pawn(7, 6, "bPawn16", Piece.color.white,  piecesOnTheBoard);
    }

    public LinkedList<Piece> getPiecesOnTheBoard() {
        return piecesOnTheBoard;
    }

    public static Piece getPiece(int x, int y) {
        int xP = x / 64;
        int yP = y / 64;
        for (Piece p : piecesOnTheBoard) {
            if (p.get_xP() == xP && p.get_yP() == yP) {
                return p;
            }
        }
        return null;
    }

    private static LinkedList<Piece> piecesOnTheBoard;
    private Graphics graphics;
    JFrame frame;
    Image imgs[];
    MouseEvent boardMouseEvent;

}






//        Piece brook=new Piece(0, 0, false, "rook", piecesOnTheBoard);
//        Piece bkinght=new Piece(1, 0, false, "knight", piecesOnTheBoard);
//        Piece bbishop=new Piece(2, 0, false, "bishop", piecesOnTheBoard);
//        Piece bqueen=new Piece(3, 0, false, "queen", piecesOnTheBoard);
//        Piece bking=new Piece(4, 0, false, "king", piecesOnTheBoard);
//        Piece bbishop2=new Piece(5, 0, false, "bishop", piecesOnTheBoard);
//        Piece bkight2=new Piece(6, 0, false, "knight", piecesOnTheBoard);
//        Piece brook2=new Piece(7, 0, false, "rook", piecesOnTheBoard);
//        Piece bpawn1=new Piece(1, 1, false, "pawn", piecesOnTheBoard);
//        Piece bpawn2=new Piece(2, 1, false, "pawn", piecesOnTheBoard);
//        Piece bpawn3=new Piece(3, 1, false, "pawn", piecesOnTheBoard);
//        Piece bpawn4=new Piece(4, 1, false, "pawn", piecesOnTheBoard);
//        Piece bpawn5=new Piece(5, 1, false, "pawn", piecesOnTheBoard);
//        Piece bpawn6=new Piece(6, 1, false, "pawn", piecesOnTheBoard);
//        Piece bpawn7=new Piece(7, 1, false, "pawn", piecesOnTheBoard);
//        Piece bpawn8=new Piece(0, 1, false, "pawn", piecesOnTheBoard);
//



//        Piece wrook=new Piece(0, 7, true, "rook", piecesOnTheBoard);
//        Piece wkinght=new Piece(1, 7, true, "knight", piecesOnTheBoard);
//        Piece wbishop=new Piece(2, 7, true, "bishop", piecesOnTheBoard);
//        Piece wqueen=new Piece(3, 7, true, "queen", piecesOnTheBoard);
//        Piece wking=new Piece(4, 7, true, "king", piecesOnTheBoard);
//        Piece wbishop2=new Piece(5, 7, true, "bishop", piecesOnTheBoard);
//        Piece wkight2=new Piece(6, 7, true, "knight", piecesOnTheBoard);
//        Piece wrook2=new Piece(7, 7, true, "rook", piecesOnTheBoard);
//        Piece wpawn1=new Piece(1, 6, true, "pawn", piecesOnTheBoard);
//        Piece wpawn2=new Piece(2, 6, true, "pawn", piecesOnTheBoard);
//        Piece wpawn3=new Piece(3, 6, true, "pawn", piecesOnTheBoard);
//        Piece wpawn4=new Piece(4, 6, true, "pawn", piecesOnTheBoard);
//        Piece wpawn5=new Piece(5, 6, true, "pawn", piecesOnTheBoard);
//        Piece wpawn6=new Piece(6, 6, true, "pawn", piecesOnTheBoard);
//        Piece wpawn7=new Piece(7, 6, true, "pawn", piecesOnTheBoard);
//        Piece wpawn8=new Piece(0, 6, true, "pawn", piecesOnTheBoard);





//public class Board {
//
//    public Board(String string) {
//
//    }
//
//    int rows, columns = 8;
//    private final Square[][] board;
//
//    Board() {
//        board = new Square[rows][columns];
//    }
//}











//public class Board {
//
//    Board() {
//        String[] w_pawn_indv_names_tmp = {"W_One", "W_Two", "W_Three", "W_Four", "W_Five", "W_Six", "W_Seven", "W_Eight"};
//        String[] b_pawn_indv_names_tmp = {"B_One", "B_Two", "B_Three", "B_Four", "B_Five", "B_Six", "B_Seven", "B_Eight"};
//        this.w_pawn_indv_names = w_pawn_indv_names_tmp;
//        this.b_pawn_indv_names = b_pawn_indv_names_tmp;
//        initializePieces();
//    }
//
//    void initializePieces() {
//        m_num_square = 8;
//        m_board = new Piece[m_num_square][m_num_square];
//
//        Pawn white_pawn_1 = new Pawn("Wpawn one");
//        Pawn white_pawn_2 = new Pawn("Wpawn two");
//        Pawn white_pawn_3 = new Pawn("Wpawn three");
//        Pawn white_pawn_4 = new Pawn("Wpawn four");
//        Pawn white_pawn_5 = new Pawn("Wpawn five");
//        Pawn white_pawn_6 = new Pawn("Wpawn six");
//        Pawn white_pawn_7 = new Pawn("Wpawn seven");
//        Pawn white_pawn_8 = new Pawn("Wpawn eight");
//
//        whiteTable[0] = white_pawn_1;
//        whiteTable[1] = white_pawn_2;
//        whiteTable[2] = white_pawn_3;
//        whiteTable[3] = white_pawn_4;
//        whiteTable[4] = white_pawn_5;
//        whiteTable[5] = white_pawn_6;
//        whiteTable[6] = white_pawn_7;
//        whiteTable[7] = white_pawn_8;
//
//        Pawn black_pawn_1 = new Pawn("Bpawn one");
//        Pawn black_pawn_2 = new Pawn("Bpawn two");
//        Pawn black_pawn_3 = new Pawn("Bpawn three");
//        Pawn black_pawn_4 = new Pawn("Bpawn four");
//        Pawn black_pawn_5 = new Pawn("Bpawn five");
//        Pawn black_pawn_6 = new Pawn("Bpawn six");
//        Pawn black_pawn_7 = new Pawn("Bpawn seven");
//        Pawn black_pawn_8 = new Pawn("Bpawn eight");
//
//        blackTable[0] = black_pawn_1;
//        blackTable[1] = black_pawn_2;
//        blackTable[2] = black_pawn_3;
//        blackTable[3] = black_pawn_4;
//        blackTable[4] = black_pawn_5;
//        blackTable[5] = black_pawn_6;
//        blackTable[6] = black_pawn_7;
//        blackTable[7] = black_pawn_8;
//
//        for (int i = 0; i < m_num_square; i++) {
//            m_board[1][0] = whiteTable[i];
//            m_board[6][0] = blackTable[i];
//        }
//    }
//
//    Piece[][] getSquareArray() {
//        return m_board;
//    }
//
//    boolean getTurn(boolean haveUJMM) {
//        return haveUJMM? false : true;
//    }
//
//    Piece[][] m_board;
//    Pawn[] whiteTable;
//    Pawn[] blackTable;
//    int m_num_square;
//    String[] w_pawn_indv_names;
//    String[] b_pawn_indv_names;
//}
