import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import percolation.Percolation;
import java.util.ArrayList;
import java.util.function.ToDoubleFunction;

public class PercolationStats {

    private double totalNumOfSites;
    private int totalTrials;
    public double[] collectionOfTrials;
    private Percolation percolation;

    //need to run the percolation method until the system percolates CHECK
    //when the system percolates, I need to return the ratio of open sites to total number of sites
    //after N amount of trials has been run, find the average ratio of open sites to total number of sites

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        totalTrials = trials;
        totalNumOfSites = n*n;
        for(int i=0;i<totalTrials;i++){
            percolation = new Percolation(n);
            collectionOfTrials = new double[totalTrials];

            callPercolation(n, i);
            double ratioOfSites = 0;
            if(percolation.percolates() == true){
                System.out.println("NUM" + percolation.numOfOpenSites);
                System.out.println("TOTAL" + totalNumOfSites);
                ratioOfSites = percolation.numOfOpenSites/totalNumOfSites;
                System.out.println("RATIO" + ratioOfSites);
                collectionOfTrials[i] = ratioOfSites;
            }
        }
        System.out.println(percolation.numOfOpenSites);
    }

//         test client (see below)
    public static void main(String[] args){
        PercolationStats percStats = new PercolationStats(3, 10);
        System.out.println("MEAN" + percStats.mean());
    }

    private void callPercolation(int n, int i){
        while(percolation.percolates() != true){
//            System.out.println("CALLING...");
            percolation.open(StdRandom.uniform(n), StdRandom.uniform(n));
        }
    }

// sample mean of percolation threshold
    public double mean(){
        System.out.println("COL1" + collectionOfTrials[0]);
        System.out.println("COL2" + collectionOfTrials[1]);
        System.out.println("COL3" + collectionOfTrials[2]);
        System.out.println("COL4" + collectionOfTrials[3]);
        System.out.println("COL5" + collectionOfTrials[4]);
        System.out.println("COL6" + collectionOfTrials[5]);
        System.out.println("COL7" + collectionOfTrials[6]);
        System.out.println("COL8" + collectionOfTrials[7]);
        System.out.println("COL9" + collectionOfTrials[8]);
        System.out.println("COL10" + collectionOfTrials[9]);
        return StdStats.mean(collectionOfTrials);
    }

// sample standard deviation of percolation threshold
    public double stddev(){
       return StdStats.stddev(collectionOfTrials);
    }
//
//    // low endpoint of 95% confidence interval
//    public double confidenceLo()
//
//    // high endpoint of 95% confidence interval
//    public double confidenceHi()
//

//     test client (optional)
//
//    public static void main(String[] args){
//        Percolation perc = new Percolation(3);
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//
//        System.out.println("ONE");
//        System.out.println(perc.percolates());
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("TWO");
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("THREE");
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("FOUR");
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("FIVE");
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("SIX");
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("SEVEN");
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("EIGHT");
//        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
//        System.out.println("0---[0][0]:" + perc.grid[0][0]);
//        System.out.println("1---[0][1]:" + perc.grid[0][1]);
//        System.out.println("2---[0][2]:" + perc.grid[0][2]);
//        System.out.println("3---[1][0]:" + perc.grid[1][0]);
//        System.out.println("4---[1][1]:" + perc.grid[1][1]);
//        System.out.println("5---[1][2]:" + perc.grid[1][2]);
//        System.out.println("6---[2][0]:" + perc.grid[2][0]);
//        System.out.println("7---[2][1]:" + perc.grid[2][1]);
//        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
//        System.out.println(perc.percolates());
//        System.out.println("NINE");
//    }


}