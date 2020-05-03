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
////        for(int i=0;i<totalTrials;i++){
////
            percolation = new Percolation(n);

            while(percolation.percolates() != true){
                System.out.println("CALLING...");
                percolation.open(StdRandom.uniform(n), StdRandom.uniform(n));
            }
        System.out.println(percolation.numOfOpenSites);
//////            callPercolation(n, i);
//////            double ratioOfSites = 0;
////            if(percolation.percolates() == true){
//////                ratioOfSites = numOfOpenSites/totalNumOfSites;
//////                collectionOfTrials[0] = ratioOfSites;
//////                numOfOpenSites = 0;
////            }
//////        }
//        System.out.println(numOfOpenSites);
    }

        // test client (see below)
//    public static void main(String[] args){
//        PercolationStats percStats = new PercolationStats(3, 10);
////        System.out.println("MEAN" + percStats.mean());
//    }

//    private void callPercolation(int n, int i){
//        collectionOfTrials = new double[totalTrials];
//        while(percolation.percolates() != true){
//            System.out.println("CALLING...");
//            percolation.open(StdRandom.uniform(n), StdRandom.uniform(n));
//            numOfOpenSites+=1.0;
//        }
//    }

// sample mean of percolation threshold
    public double mean(){
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

    public static void main(String[] args){
        Percolation perc = new Percolation(3);
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));

        System.out.println("ONE");
        System.out.println(perc.percolates());
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("TWO");
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("THREE");
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("FOUR");
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("FIVE");
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("SIX");
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("SEVEN");
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("EIGHT");
        perc.open(StdRandom.uniform(3), StdRandom.uniform(3));
        System.out.println("0---[0][0]:" + perc.grid[0][0]);
        System.out.println("1---[0][1]:" + perc.grid[0][1]);
        System.out.println("2---[0][2]:" + perc.grid[0][2]);
        System.out.println("3---[1][0]:" + perc.grid[1][0]);
        System.out.println("4---[1][1]:" + perc.grid[1][1]);
        System.out.println("5---[1][2]:" + perc.grid[1][2]);
        System.out.println("6---[2][0]:" + perc.grid[2][0]);
        System.out.println("7---[2][1]:" + perc.grid[2][1]);
        System.out.println("8---grid[2][2]:" + perc.grid[2][2]);
        System.out.println(perc.percolates());
        System.out.println("NINE");
    }


}