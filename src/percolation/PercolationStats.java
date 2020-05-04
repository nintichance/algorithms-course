import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    final private int totalTrials;
    final private double[] collectionOfTrials;
    private Percolation percolation;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        totalTrials = trials;
        final double totalNumOfSites;
        totalNumOfSites = n*n;
        collectionOfTrials = new double[totalTrials];

        for (int i=0;i<totalTrials;i++) {
            percolation = new Percolation(n);
            callPercolation(n);
            double ratioOfSites = 0;
            if (percolation.percolates() == true) {
                ratioOfSites = percolation.numberOfOpenSites()/totalNumOfSites;
                collectionOfTrials[i] = ratioOfSites;
            }
        }
    }

//         test client (see below)
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(10, 100);
        System.out.println(percolationStats.mean());
        System.out.println(percolationStats.stddev());
        System.out.println(percolationStats.confidenceHi());
        System.out.println(percolationStats.confidenceLo());
        percolationStats.mean();
    }


    private void callPercolation(int n) {
        while (percolation.percolates() != true) {
            percolation.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
        }
    }

// sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(collectionOfTrials);
    }

// sample standard deviation of percolation threshold
    public double stddev(){
       return StdStats.stddev(collectionOfTrials);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - 1.96 * Math.sqrt(squaredStddev() / totalTrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() + 1.96 * Math.sqrt(squaredStddev() / totalTrials));
    }

    private double squaredStddev(){
        return stddev() * stddev();
    }

}