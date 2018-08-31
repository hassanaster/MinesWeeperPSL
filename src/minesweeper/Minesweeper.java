/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Minesweeper {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //object Scanner to take the results for each number we need
        Scanner enter = new Scanner(System.in);
        //height contain how many rows the user wants for the grid
        int height;
        //height contain how many colums the user wants for the grid
        int weight; 
        //mines contain the number of mines the user wants in the grid
        int mines;
        boolean c = true;
        while (c){
            //We ask the enter dates
            System.out.print("Welcome to Minesweeper \n");
            System.out.print("Enter the height of the grid:  \n");
            height = enter.nextInt();
            System.out.print("Enter the weight of the grid:  \n");
            weight = enter.nextInt();
            System.out.print("Enter the number of mines you want in the grid:  \n");
            mines = enter.nextInt();
            
            //This "if" is to validate the number of mines don't exceed the 60% of the grid size, because it will be really full, no change to choose a nice position
            //Validate too the grid has minimum 2 squares or empty spaces
            if(((mines)<=(height*weight*0.6))&&(height*weight)>1) {
                //We start the rounds
                //Deploy the matrix
                String grid [][];  
                String gridPlay[][]= new String [height][weight];
                grid = fillGrid(height,weight,mines);
                pointGrid(grid,height,weight);
                pointGrid(gridPlay,height,weight);
                writeGrid(gridPlay,height,weight);
                System.out.print(" \n\n");
                writeGrid(grid,height,weight);
            }else{
                System.out.print("The number of mine exceed the 60% of the grid size, please enter again the dates. \n\n");
            }
        } 
        
    }
    
    //Method that make a random grid with the details that user sent, receive 3 ints, h = height, w = weight, m = number of mines; and return the initial grid
    private static String [][] fillGrid(int h, int w, int m){
        String grid [][] = new String [h][w];  
        int j;
        int k;
        for (int i=0; i<m; i++){
             j = (int) (Math.random()*h);
             k = (int) (Math.random()*w);
             if (grid[j][k] == null){
                grid[j][k] = "*";
             }else{
                 i--;
             }
        }
        return grid;
    }
    
    //Method that fills with . the grid in empty position
    private static void pointGrid(String matriz[][], int h, int w){
        for (int i=0; i<h; i++){
           
           for (int j=0; j<w; j++){
                if(matriz[i][j] == null){
                    matriz[i][j] = "." ;
                }
            }
        }
    }
    
    //Method that write the grid in the console view
    private static void writeGrid(String matriz[][], int h, int w){
        for (int i=0; i<h; i++){
           
           for (int j=0; j<w; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.print(" \n");
        }
    }
    
}
