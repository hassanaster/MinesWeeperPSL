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
        Scanner enterString = new Scanner(System.in);
        Scanner enterStringUno= new Scanner(System.in);
        //height contain how many rows the user wants for the grid
        int height;
        //weight contain how many colums the user wants for the grid
        int weight; 
        //mines contain the number of mines the user wants in the grid
        int mines;
        //If user want to keep playing another round.
        boolean c = true;
        //When the game finish (User win or lost)
        boolean finish;
        while (c){
            finish = true;
            //We ask the the INITIAL information
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
                System.out.print(" \n\n");
                
                //This while control each position and action the user chooses
                while(finish){
                    System.out.print("We need the number of the row that you wanna choose: \n");
                    int row = enter.nextInt();
                    System.out.print("We need the number of the column that you wanna choose: \n");
                    int column = enter.nextInt();
                    System.out.print("Enter U if you wanna see what it is in the position or P if you think it is a mine:  \n");
                    String action = enterString.nextLine();
                    if (row<height&&column<weight){ 
                        if(action.equals("U")){
                            //Here the code look if in this position when user open it is a mine or not, the first case open a mine
                            if(openMine(grid,row,column)){
                                System.out.print("You opened a mine, look how the complete grid is:  \n\n");
                                resultGrid(grid, gridPlay, height, weight);
                                writeGrid(gridPlay, height, weight);
                                System.out.print(" \n\n");
                                System.out.print("Do you want to keep playing? Please, Mark Y if you wanna Keep or N if you don't: \n");
                                action = enterStringUno.nextLine();
                                if(action.equals("N")) {
                                    System.exit(0);
                                }else {
                                    if(action.equals("Y")) {
                                       finish = false;
                                       System.out.print(" \n\n");
                                    }else {
                                        System.out.print(" You didn't mark a right answer, remember they are CAPITAL Letters - Y or N- for that the game is close. \n\n"); 
                                        System.exit(0);
                                    } 
                                } 
                            }else{
                                System.out.print(action+" ENTRO CUANDO NO ES UNA MINA FILA" + row+" columna"+column+ " \n");
                                gridPlay = openSquare(gridPlay, grid, row, column, height, weight);
                                System.out.print(" \n\n");
                                writeGrid(gridPlay, height, weight);
                            } 
                        }else{
                            if(action.equals("P")) { 
                            gridPlay[row][column]="P";
                            writeGrid(gridPlay, height, weight);
                            System.out.print(" \n\n");
                            //Verificar si el juego está completo o no, si está completo desplegar matriz y cambiar finish a false, sino seguir.
                            }else {
                               System.out.print(" You didn't mark a right answer, remember they are CAPITAL Letters - U or P- \n\n"); 
                            } 
                        } 
                    }else{
                        System.out.print("Remember the numbers of row and column should be less than height and weight respectively. Please enter the information again.  \n\n");
                    } 
                } 
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
    
    //Method when user choose U and it isn't a mine -- FALTA
    private static String [][] openSquare(String matrizPlay[][], String matriz[][], int r, int c, int h, int w){
        int mina = 0;
     
        //Verified if the square is up it has a mine
        if (r-1 >= 0){  
            if(openMine(matriz,r-1,c)){
                mina++;
                 System.out.print(mina+" \n");
            } 
        }
        
        //Verified if the square is at right it has a mine
        if (c+1 < w){
            if(openMine(matriz,r,c+1)){
                mina++;
                System.out.print(mina+" \n");
            } 
        }
        
        //Verified if the square is down it has a mine
        if (r+1 < h){
            if(openMine(matriz,r+1,c)){
                mina++;
                System.out.print(mina+" \n");
            } 
        }
        
        //Verified if the square is at left it has a mine
        if (c-1 >= 0){
            if(openMine(matriz,r,c-1)){
                mina++;
                System.out.print(mina+" \n");
            } 
        }
        
        //Verified if the square is up-right it has a mine
        if (r-1 >= 0 && c+1 < w){
            if(openMine(matriz,r-1,c+1)){
                mina++;
                System.out.print(mina+" \n");
            } 
        }
        
        //Verified if the square is down-right it has a mine
        if (r+1 < h && c+1 < w){
            if(openMine(matriz,r+1,c+1)){
                mina++;
                System.out.print(mina+" \n");
            } 
        }
        
        //Verified if the square is up-left it has a mine
        if (r-1 >= 0 && c-1 >= 0){
            if(openMine(matriz,r-1,c-1)){
                mina++;
                System.out.print(mina+" \n");
            } 
        }
        
        //Verified if the square is down-left it has a mine
        if (r+1 < h && c-1 >= 0){
            if(openMine(matriz,r+1,c-1)){
                mina++;
                System.out.print(mina+" \n");
            } 
        }
        
        if(mina!=0){
            matrizPlay[r][c]=String.valueOf(mina);
            System.out.print("Entro para salir porque tiene :"+mina+" minas \n");
        }else{
            matrizPlay[r][c]="-";
            //OutofBounds
            if (r - 1 >= 0) {
               matrizPlay = openSquare(matrizPlay, matriz, r-1, c, h, w);
            }

            //OutofBounds
            if (c + 1 < w) {
                matrizPlay = openSquare(matrizPlay, matriz,r, c+1, h, w);
            }

            //OutofBounds
            if (r + 1 < h) {
                matrizPlay = openSquare(matrizPlay, matriz, r+1, c, h, w);
            }

            //OutofBounds
            if (c - 1 >= 0) {
                matrizPlay = openSquare(matrizPlay, matriz, r, c-1, h, w);
            }

            //OutofBounds
            if (r - 1 >= 0 && c + 1 < w) {
                matrizPlay = openSquare(matrizPlay, matriz, r-1, c+1, h, w);
            }

            //OutofBounds
            if (r + 1 < h && c + 1 < w) {
               matrizPlay = openSquare(matrizPlay, matriz, r+1, c+1, h, w);
            }

            //OutofBounds
            if (r - 1 >= 0 && c - 1 >= 0) {
                matrizPlay = openSquare(matrizPlay,  matriz, r-1, c-1, h, w);
            }

            //OutofBounds
            if (r + 1 < h && c - 1 >= 0) {
                matrizPlay = openSquare(matrizPlay, matriz, r+1, c-1, h, w);
            }
        }
       return matrizPlay;
    }
    
    //This method tells if the square that user opened is a mine or no
    private static boolean openMine(String matriz[][], int r, int c){
        if(matriz[r][c].equals("*")){
            return true;
        }else{
            return false;
        } 
    } 
    
    //Result grid, join both grids, the play grid with the mine grid
    private static String [][] resultGrid(String matrizMine [][], String matrizPlay [][],  int h, int w){ 
        for (int i=0; i<h; i++){
             for (int j=0; j<w; j++){
                if(matrizPlay[i][j].equals(".")&&matrizMine[i][j].equals("*")){
                    matrizPlay[i][j]="*";
                } 
            }
        }
        return matrizPlay;
    }
}
