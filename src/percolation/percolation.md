


  //does it percolate?
  //check if there is a path of connected components
  //from the top of the grid ([1][N])
  //to the bottom of the GRID ([N-1][N])

  //openSites
  //open each adjacent site to the current element
  //when a connection is formed, the root of the second element
  //becomes the root of the first element on the first go around
  //when a connection is formed between elements within a connected component
  //the root of the smaller connected component
  //points to the root of the larger connected component
  //whenever traversing connected components
  //set the current element's root to its grandparent root
  //the site is blocked if the root of the element is itself
  




//
//
//
//
//
//  public Percolation(int n)
//  {
//    if (n <= 0) throw new IllegalArgumentException("Argument must be greater than 0");
//  }
//
//  // opens the site (row, col) if it is not open already
//  public void open(int row, int col)
//    id = new id[N][N]
//  {
//    if(!isOpen(row, col)){
//      id[row][col] = 1;
//    }
//  }
//
//  //is the site (row, col) open?
//  public boolean isOpen(int row, int col)
//
//  //is the site (row, col) full?
//  public boolean isFull(int row, int col)
//
//  //returns the number of open sites
//  public int numberOfOpenSites()
//
//  //does the system percolate?
//  public boolean percolates()
//
//  //test client (optional)
//  public static void main (String[] args)
//}

//Throw an IllegalArgumentException if any argument to open(), isOpen(), isFull() is outside ist prescribed range
//Throw an IllegalArgumentException in the constructor if n <= 0
// /Performance requirements.  The constructor should take time proportional to n2; all methods should take constant time plus a constant number of calls to the union–find methods union(), find(), connected(), and count().
d