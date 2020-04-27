package percolation;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import javax.annotation.processing.SupportedSourceVersion;

public class Percolation {
  private static int[][] grid;
  static int sizeOfGrid;
  static int numOfOpenSites;
  private WeightedQuickUnionUF weightedQuickUnionUF;
  private int currentRow;
  private int currentCol;

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n){
    currentRow = 0;
    currentCol = 0;
    if (n <= 0) {
      throw new IllegalArgumentException("n must be greater than 0");
    }
    sizeOfGrid = n;
    weightedQuickUnionUF= new WeightedQuickUnionUF(sizeOfGrid*sizeOfGrid);
    grid = new int[n][n];
    for (int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        grid[i][j] = -1;
      }
    }
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col){
    currentRow = row;
    currentCol = col;
    int p = mapCellValueToUnionFindModel(row, col);
    if(!isOpen(row, col)) {
      numOfOpenSites += 1;
      grid[row][col] = p;
      try{
        callConnectOpenAdjacents(row, col, p);
        grid[row][col] = weightedQuickUnionUF.find(p);
      }catch(Exception e){
        System.out.println(e);
      }
    } else{
      try{
        callConnectOpenAdjacents(row, col, p);
        grid[row][col] = weightedQuickUnionUF.find(p);
      }catch(Exception e){
        System.out.println(e);
      }
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col){
    validate(row, col);
    if (grid[row][col] != -1){
      return true;
    }else{
      return false;
    }
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col){
    int connection = 0;
     for(int i=0; i<sizeOfGrid; i++){
      if(grid[currentRow][currentCol] == grid[0][i]){
        connection+=1;
      }
     }
     if(connection>0){
       return true;
     }else{
       return false;
     }
  }

  // returns the number of open sites
  public int numberOfOpenSites(){
    return numOfOpenSites;
  }


  public boolean percolates(){
    if(currentRow == sizeOfGrid-1){
      System.out.println("GETS HERE");
      boolean isPercolated = isFull(currentRow, currentCol);
      return isPercolated;
    }else{
      return false;
    }
  }

  //private methods
  private int mapCellValueToUnionFindModel(int row,int col){
    return sizeOfGrid*row+col;
  }

  private void validate(int row, int col){
    if (row < 0 || col < 0){
      System.out.println("Row in error:" + row);
      System.out.println("Col in error:" + row);
      throw new IllegalArgumentException("row or column must be greater than 0");
    }
  }

  private void connectOpenAdjacents(int row, int col, int p){
    validate(row, col);
    if(isOpen(row, col)){
      int q = mapCellValueToUnionFindModel(row, col);
      weightedQuickUnionUF.union(p, q);
      grid[row][col] = weightedQuickUnionUF.find(q);
    }
  }

  private void callConnectOpenAdjacents(int row, int col, int p){
    if (row==0 && col==0){
      connectOpenAdjacents((row+1),col,p);
      connectOpenAdjacents(row,(col+1),p);
    } else if(row==sizeOfGrid-1 && col==sizeOfGrid-1) {
      connectOpenAdjacents(row, (col - 1), p);
      connectOpenAdjacents((row - 1), col, p);
    } else if(col==sizeOfGrid-1 && row==0){
      connectOpenAdjacents(row, (col - 1), p);
      connectOpenAdjacents((row + 1), col, p);
    } else if(row==sizeOfGrid-1 && col==0){
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents(row, (col + 1), p);
    }else if(row==0 && col>0 && col<sizeOfGrid) {
      connectOpenAdjacents((row + 1), col, p);
      connectOpenAdjacents(row, (col + 1), p);
      connectOpenAdjacents(row, (col - 1), p);
    } else if(col==0 && row>0 && row<sizeOfGrid){
      connectOpenAdjacents(row, (col + 1), p);
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents((row + 1), col, p);
    } else if(row==sizeOfGrid-1 && col>0 && col < sizeOfGrid) {
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents(row, (col + 1), p);
      connectOpenAdjacents(row, (col - 1), p);
    } else if(col==sizeOfGrid-1 && row>0 && row<sizeOfGrid){
      connectOpenAdjacents(row, (col - 1), p);
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents((row + 1), col, p);
    } else {
      connectOpenAdjacents(row, (col - 1), p);
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents((row + 1), col, p);
      connectOpenAdjacents(row, (col + 1), p);
    }
  }

//  private static void printStatements(){
//    System.out.println("0---[0][0]:" + grid[0][0]);
//    System.out.println("1---[0][1]:" + grid[0][1]);
//    System.out.println("2---[0][2]:" + grid[0][2]);
//    System.out.println("3---[1][0]:" + grid[1][0]);
//    System.out.println("4---[1][1]:" + grid[1][1]);
//    System.out.println("5---[1][2]:" + grid[1][2]);
//    System.out.println("6---[2][0]:" + grid[2][0]);
//    System.out.println("7---[2][1]:" + grid[2][1]);
//    System.out.println("8---grid[2][2]:" + grid[2][2]);
//  }
//  // test client (optional)
//  public static void main(String[] args){
//    Percolation perc = new Percolation(3);
//    perc.open(0,0);
//
//    System.out.println("ONE");
//    System.out.println(perc.percolates());
//    perc.open(2,2);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("TWO");
//    perc.open(1,0);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("THREE");
//    perc.open(2,1);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("FOUR");
//    perc.open(0,2);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("FIVE");
//    perc.open(2,0);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("SIX");
//    perc.open(0,1);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("SEVEN");
//    perc.open(1,2);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("EIGHT");
//    perc.open(1,1);
//    printStatements();
//    System.out.println(perc.percolates());
//    System.out.println("NINE");
//    printStatements();
//
//  }

}









