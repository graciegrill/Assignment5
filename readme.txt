/******************************************************************************
 *  readme.txt template                                                   
 *  Map
 *****************************************************************************/

Name(s): Grace Frizzell    
OS: Windows      
Compiler: javac  
Editor: VS Code    
Hours: 6      


/******************************************************************************
 *  Explain your overall approach.
 *****************************************************************************/
I essentially read the attached texts, applying the second suggested change -- shifting to a version of 
A*. For this, I initialized the wt[s] at the beginning of the algorithm to distance(s,d) as opposed to 
0.0 and changed the priority to dist[w] = dist[v] + G.distance(v, w)-G.distance(v,d) as suggested in the
Sedgewick text. I then added a stopping condition if v == d, in which case a path had been found.
I also created a visited arraylist to add visited vertices and then only re-initialize those vertices
that had been changed. Finally, I changed the priority queue to a IndexMinPQ from a Sedgewick text at
the suggestion of the project description.

/******************************************************************************
 *  Which input files did you use to test your program? Mark the
 *  ones where your answers agreed with our reference solutions and
 *  the ones where it disagreed. How long (in seconds) did your program
 *  take to solve each instance? How many vertices did it examine
 *  on average per shortest path query?
 *****************************************************************************/

Input file                Running Time (seconds)     Vertices    Agreed?
------------------------------------------------------------------------
usa-1000long.txt
usa-5000short.txt
usa-50000short.txt


/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/

/******************************************************************************
 *  List whatever help (if any) that you received.
 *****************************************************************************/
N/A

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
I had to adjust the way vertices were inserted and changed within the priority queue as 
certain conditions were creating infinite loops, but I addressed these issues in my code.

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
