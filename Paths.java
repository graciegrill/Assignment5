/*************************************************************************
  *  Compilation:  javac Paths.java
  *  Execution:    java Paths file < input.txt
  *  Dependencies: EuclideanGraph.java Dijkstra.java In.java StdIn.java
  *
  *  Reads in a map from a file, and repeatedly reads in two integers s
  *  and d from standard input, and prints the shortest path from s
  *  to d to standard output.
  *
  ****************************************************************************/
 
 
  public class Paths {
    public static class Stopwatch { 

        private final long start;
    
        /**
         * Initializes a new stopwatch.
         */
        public Stopwatch() {
            start = System.currentTimeMillis();
        } 
    
    
        /**
         * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
         *
         * @return elapsed CPU time (in seconds) since the stopwatch was created
         */
        public double elapsedTime() {
            long now = System.currentTimeMillis();
            return (now - start) / 1000.0;
        }
    
    } 
 
    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();

        // read in the graph from a file
        In graphin = new In(args[0]);
        EuclideanGraph G = new EuclideanGraph(graphin);
        System.err.println("Done reading the graph " + args[0]);
        System.err.println("Enter query pairs from stdin");

        // read in the s-d pairs from standard input
        Dijkstra dijkstra = new Dijkstra(G);
        while(!StdIn.isEmpty()) {
            int s = StdIn.readInt();
            int d = StdIn.readInt();
            dijkstra.showPath(s, d);
            System.out.println();
        }
        double time = timer.elapsedTime();
        System.out.println(time+" seconds have elapsed");
        System.out.println(dijkstra.returnAverage()+" average vertices have been examined per call");
    }
}