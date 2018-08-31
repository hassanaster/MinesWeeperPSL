/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class MinesweeperTest {
    
    public MinesweeperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Minesweeper.
     */
    @Test
    public void testFillGrid() {
        int h, w, m;
        h=5;
        w=6;
        m=4;
        String matriz [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        matriz = MinesweeperOne.fillGrid(h,w,m);
    }
    
    public void testPointGrid() {
        int h, w;
        h=5;
        w=6;
        String matriz [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        MinesweeperOne.pointGrid(matriz,h,w);
    }
    
    public void testWriteGrid() {
        int h, w;
        h=5;
        w=6;
        String matriz [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        MinesweeperOne.pointGrid(matriz,h,w);
    }
    
    public void testOpenSquare() {
        int h, w, m, r, c;
        h=5;
        w=6;
        m=4;
        r=3;
        c=5;
        String matriz [][] = new String [h][w];
        String matrizPlay [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        matriz = MinesweeperOne.fillGrid(h,w,m);
        MinesweeperOne.pointGrid(matriz,h,w);
        matrizPlay = MinesweeperOne.openSquare(matrizPlay,matriz,r,c,h,w);
    }
    
    public void testOpenMine() {
        int h, w, r, c, m;
        h=5;
        w=6;
        r=3;
        c=5;
        m=4;
        boolean open;
        String matriz [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        matriz = MinesweeperOne.fillGrid(h,w,m);
        MinesweeperOne.pointGrid(matriz,h,w);
        open = MinesweeperOne.openMine(matriz,h,w);
    }
    
    public void testResultGrid() {
       int h, w, r, c, m;
        h=5;
        w=6;
        r=3;
        c=5;
        m = 10;
        String matriz [][] = new String [h][w];
        String matrizPlay [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        matriz = MinesweeperOne.fillGrid(h,w,m);
        MinesweeperOne.pointGrid(matriz,h,w);
        matrizPlay = MinesweeperOne.resultGrid(matriz, matrizPlay,h,w);
    }
    
    public void testCompleteGrid() {
        int h, w, r, c, m;
        h=5;
        w=6;
        r=3;
        c=5;
        m=4;
        boolean complete;
        String matriz [][] = new String [h][w];
        String matrizPlay [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        matriz = MinesweeperOne.fillGrid(h,w,m);
        MinesweeperOne.pointGrid(matriz,h,w);
        complete = MinesweeperOne.completeGrid(matriz, matrizPlay, h,w);
    }
    
    public void testIsNotMark() {
        int h, w, r, c, m;
        h=5;
        w=6;
        r=3;
        c=5;
        m=4;
        boolean isNotMark;
        String matriz [][] = new String [h][w];
        String matrizPlay [][] = new String [h][w];
        Minesweeper MinesweeperOne = new Minesweeper();
        matriz = MinesweeperOne.fillGrid(h,w,m);
        MinesweeperOne.pointGrid(matriz,h,w);
        isNotMark = MinesweeperOne.isNotMark(matrizPlay, r,c);
    }
    
}
