/*************************************************************************
 *  Dijkstra's algorithm.
 *
 *************************************************************************/

import java.awt.Color;
import java.util.ArrayList;


public class Dijkstra {
    private static double INFINITY = Double.MAX_VALUE;
    private static double EPSILON  = 0.000001;
    private ArrayList<Integer> visited = new ArrayList<Integer>();
    private int runs = 0;
    private int examined = 0;


    private EuclideanGraph G;
    private double[] dist;
    private int[] pred;

    public Dijkstra(EuclideanGraph G) {
        this.G = G;
    int V = G.V();
    dist = new double[V];
    pred = new int[V];
    for (int v = 0; v < V; v++) {
        dist[v] = INFINITY;
        pred[v] = -1;
    }
    }

    // return shortest path distance from s to d
    public double distance(int s, int d) {
        dijkstra(s, d);
        return dist[d];
    }

    // print shortest path from s to d  (interchange s and d to print in right order)
    public void showPath(int d, int s) {
        dijkstra(s, d);
        if (pred[d] == -1) {
            System.out.println(d + " is unreachable from " + s);
            return;
        }
        for (int v = d; v != s; v = pred[v])
            System.out.print(v + "-");
        System.out.println(s);
    }

    // plot shortest path from s to d
    public void drawPath(int s, int d) {
        dijkstra(s, d);
        if (pred[d] == -1) return;
        Turtle.setColor(Color.red);
        for (int v = d; v != s; v = pred[v])
            G.point(v).drawTo(G.point(pred[v]));
        Turtle.render();
    }
    public double returnAverage(){
        return examined/runs *1.0;
    }

    // Dijkstra's algorithm to find shortest path from s to d
    private void dijkstra(int s, int d) {
        int vertices = 0;
        //tracking visited vertices
        int V = G.V();

        for (int v : visited) {
            dist[v] = INFINITY;
            pred[v] = -1;
        }
        //reset source node
        dist[s] = 0.0;
        pred[s] = s;
        
        // clear visited
        visited.clear();
        //add source node
        visited.add(s);
        

        // priority queue
        IndexPQ pq = new IndexPQ(V);

        // set distance of source
        dist[s] = 0.0; //changed accord to section 21.5 -- changed back because introduced error
        pred[s] = s;
        //clears visited
        visited.clear();
        //only inserting source to start
        pq.insert(s, dist[s]);
        //add source to visited
        visited.add(s);

        // run Dijkstra's algorithm
        while (!pq.isEmpty()) {

            int v = pq.delMin();
            vertices++;

            //// System.out.println("process " + v + " " + dist[v]);
            /// Change 1, Part 1: stopping if we have found shortest path
            if(v == d) break;
            // v not reachable from s so stop
            //if (pred[v] == -1) break;

            // scan through all nodes w adjacent to v
            IntIterator i = G.neighbors(v);
            while (i.hasNext()) {
                int w = i.next();
                if (dist[v] + G.distance(v, w) < dist[w] - EPSILON) {
                    //adding to visited to handle reinitialization
                    dist[w] = dist[v] + G.distance(v, w); //had to eliminate subtraction because it also introduced an error
                    pred[w] = v;
                    //only inserted if not in the PQ; changed otherwise
                    if (pq.contains(w)) {
                        pq.change(w, dist[w]);
                    } else {
                        pq.insert(w, dist[w]);
                    }
                    //adding to visited
                    visited.add(w);
    
                    //// System.out.println("    lower " + w + " to " + dist[w]);
                }
            }
        }
        runs++;
        examined+=vertices;
    
    }}
