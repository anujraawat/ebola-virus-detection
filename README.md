# ebola-virus-detection
Given a country having cities in the form of a matrix of dimensions m*n where each cell in the
matrix represents a city having values 0, 1 or 2, has the following meaning:
0: Boundary or obstruction between the two adjacent cities
1: Cities not affected by Ebola
2: Cities affected by Ebola
So we need to determine the minimum time in which all the cities get affected by Ebola
epidemic.
Constraint:  An affected city at index [i,j] can affect other unaffected cities at indexes [i-1,j],
[i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is not possible to affect every city then
simply return -1.
