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
that had been changed.

/******************************************************************************
 *  Which input files did you use to test your program? Mark the
 *  ones where your answers agreed with our reference solutions and
 *  the ones where it disagreed. How long (in seconds) did your program
 *  take to solve each instance? How many vertices did it examine
 *  on average per shortest path query?
 *****************************************************************************/

Input file                Running Time (seconds)     Vertices    Agreed?
------------------------------------------------------------------------
usa-1000long.txt            20.786                     44537.0  Yes
usa-5000short.txt           11.83                       2466.0  Yes
usa-50000short.txt          76.43                       2488.0  Yes


/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
All bugs should have been resolved to the best of my knowledge.
/******************************************************************************
 *  List whatever help (if any) that you received.
 *****************************************************************************/
N/A

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
Certain aspects of the A* algorithm as described in the Sedgewick text provided needed to be 
changed for the code to run properly. I found that it did not run properly with the final negative 
term in the adjusted priority function, nor did it run properly with the adjusted distance. I found
which pieces worked through process of elimination, and it still results in a marked reduced runtime
compared to the naive method.

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
 I think some of the texts were slightly misleading for this assignment, but it did result in 
 me reading a lot closer than I normally would have. I likely learned a lot from my struggle, which I enjoyed.
