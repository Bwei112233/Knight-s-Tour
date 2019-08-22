package com.brandon.game.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Board extends JPanel {
    public int[][] board;
    private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private final static Dimension TILE_PANEL_DIMENTSION = new Dimension(10,10);
    private final JFrame frame;
    public Board()
    {
        final JMenuBar jMenuBar = new JMenuBar();
        frame = new JFrame("Knight's Tour");
        populateMenuBar(jMenuBar);
        frame.setJMenuBar(jMenuBar);
        frame.setVisible(true);
        frame.setSize(new Dimension(600, 600));
    }
    private void populateMenuBar(JMenuBar menuBar){
        menuBar.add(createFileMenu());

    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem openPGN = new JMenuItem("Load PGN");
        openPGN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("PGN loaded");
            }
        });
        fileMenu.add(openPGN);
        return fileMenu;
    }

//    private class BoardPanel extends JPanel{
//         List<TilePanel> boardTiles;
//        public BoardPanel(){
//            super(new GridLayout(8,8));
//            this.boardTiles = new ArrayList<>();
//            for(int i = 0; i < 8; i++){
//                TilePanel tilePanel = new TilePanel();
//                this.boardTiles.add(tilePanel);
//                add(tilePanel);
//            }
//            setPreferredSize(BOARD_PANEL_DIMENSION);
//            validate();
//        }
//    }
//    private class TilePanel extends JPanel{
//        private final int tileId;
//        public TilePanel(BoardPanel boardPanel, int tileID){
//            super(new GridBagLayout());
//            this.tileId = tileID;
//            Board.this.setPreferredSize(TILE_PANEL_DIMENTSION);
////            assignTileColor();
//            Board.this.validate();
//        }
//    }
}
