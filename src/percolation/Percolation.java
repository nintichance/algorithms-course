import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private int[][] grid;
  private final int sizeOfGrid;
  private final WeightedQuickUnionUF weightedQuickUnionUF;
  private int numOfOpenSites;
  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be greater than 0");
    }
    sizeOfGrid = n;
    weightedQuickUnionUF = new WeightedQuickUnionUF(sizeOfGrid*sizeOfGrid);
    grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = -1;
      }
    }
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    int rowOffset = row - 1;
    int colOffset = col - 1;
    validate(rowOffset, colOffset);
    int p = mapCellValueToUnionFindModel(rowOffset, colOffset);
    if (!isOpen(rowOffset, colOffset)) {
      numOfOpenSites += 1;
      grid[rowOffset][colOffset] = p;
      callConnectOpenAdjacents(rowOffset, colOffset, p);
      grid[rowOffset][colOffset] = weightedQuickUnionUF.find(p);
    } else {
      callConnectOpenAdjacents(rowOffset, colOffset, p);
      grid[rowOffset][colOffset] = weightedQuickUnionUF.find(p);
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    validate(row, col);
    if (grid[row][col] != -1){
      return true;
    } else {
      return false;
    }
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    validate(row, col);
    int connection = 0;
    for (int i = 0; i < sizeOfGrid; i++) {
      if (grid[row][col] == grid[0][i]) {
        connection += 1;
      }
    }
    if (connection > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean percolates() {
    int connection = 0;
    for (int i = 0; i < sizeOfGrid; i++) {
      if (isFull(sizeOfGrid-1, i) && grid[sizeOfGrid-1][i] > -1) {
        connection += 1;
      }
    }
    if (connection > 0) {
      return true;
    } else {
      return false;
    }
  }

  public int numberOfOpenSites() {
    return numOfOpenSites;
  }


  // private methods
  private int mapCellValueToUnionFindModel(int row, int col) {
    return sizeOfGrid * row + col;
  }

  private void validate(int row, int col) {
    if (row < 0 || col < 0) {
      System.out.println("Row in error:" + row);
      System.out.println("Col in error:" + row);
      throw new IllegalArgumentException("row or column must be greater than 0");
    }
  }

  private void connectOpenAdjacents(int row, int col, int p) {
    validate(row, col);
    if (isOpen(row, col)) {
      int q = mapCellValueToUnionFindModel(row, col);
      weightedQuickUnionUF.union(p, q);
      grid[row][col] = weightedQuickUnionUF.find(q);
    }
  }

  private void callConnectOpenAdjacents(int row, int col, int p) {
    if (row == 0 && col == 0) {
      connectOpenAdjacents((row+1),col,p);
      connectOpenAdjacents(row,(col+1),p);
    } else if (row == sizeOfGrid-1 && col == sizeOfGrid-1) {
      connectOpenAdjacents(row, (col - 1), p);
      connectOpenAdjacents((row - 1), col, p);
    } else if (col == sizeOfGrid-1 && row == 0) {
      connectOpenAdjacents(row, (col - 1), p);
      connectOpenAdjacents((row + 1), col, p);
    } else if(row == sizeOfGrid-1 && col == 0){
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents(row, (col + 1), p);
    }else if (row == 0 && col > 0 && col < sizeOfGrid) {
      connectOpenAdjacents((row + 1), col, p);
      connectOpenAdjacents(row, (col + 1), p);
      connectOpenAdjacents(row, (col - 1), p);
    } else if (col == 0 && row > 0 && row < sizeOfGrid){
      connectOpenAdjacents(row, (col + 1), p);
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents((row + 1), col, p);
    } else if (row == sizeOfGrid-1 && col > 0 && col < sizeOfGrid) {
      connectOpenAdjacents((row - 1), col, p);
      connectOpenAdjacents(row, (col + 1), p);
      connectOpenAdjacents(row, (col - 1), p);
    } else if (col == sizeOfGrid-1 && row > 0 && row < sizeOfGrid) {
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
}









