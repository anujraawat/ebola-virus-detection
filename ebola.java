import java.util.LinkedList; 
import java.util.Queue; 

public class Ebola  
{ 
    public final static int R = 3; 
    public final static int C = 5; 
      
    static class Ele 
    { 
        int x = 0; 
        int y = 0; 
        Ele(int x,int y) 
        { 
            this.x = x; 
            this.y = y; 
        } 
    } 
      
    static boolean isValid(int i, int j) 
    { 
        return (i >= 0 && j >= 0 && i < R && j < C); 
    }
    
    static boolean isDelim(Ele temp) 
    { 
        return (temp.x == -1 && temp.y == -1); 
    } 
      
    static boolean checkAll(int arr[][]) 
    { 
         for (int i=0; i<R; i++) 
               for (int j=0; j<C; j++) 
                  if (arr[i][j] == 1) 
                     return true; 
         return false; 
    } 
      
    static int isEbola(int arr[][]) 
    { 
        Queue<Ele> Q = new LinkedList<>(); 
        Ele temp;  
        int ans = 0; 
        
        for (int i=0; i < R; i++) 
           for (int j=0; j < C; j++) 
               if (arr[i][j] == 2) 
                   Q.add(new Ele(i,j)); 
                  
        Q.add(new Ele(-1,-1)); 
          
        while(!Q.isEmpty()) 
        { 
            boolean flag = false; 
              
            while(!isDelim(Q.peek())) 
            { 
                temp = Q.peek(); 
                  
                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1) 
                { 
                    if(!flag) 
                    { 
                        ans++; 
                        flag = true; 
                    } 
                    
                    arr[temp.x+1][temp.y] = 2;
                    temp.x++; 
                    Q.add(new Ele(temp.x,temp.y)); 
                      
                    temp.x--; 
                } 
                  
                if (isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1) 
                 { 
                        if (!flag) 
                        { 
                            ans++; 
                            flag = true; 
                        } 
                        arr[temp.x-1][temp.y] = 2; 
                        temp.x--; 
                        Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue 
                        temp.x++; 
                 } 
                  
                if (isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1)
                { 
                        if(!flag) 
                        { 
                            ans++; 
                            flag = true; 
                        } 
                        arr[temp.x][temp.y+1] = 2; 
                        temp.y++; 
                        Q.add(new Ele(temp.x,temp.y)); 
                        temp.y--; 
                    } 
                   
                if (isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1)  
                { 
                        if (!flag) 
                        { 
                            ans++; 
                            flag = true; 
                        } 
                        arr[temp.x][temp.y-1] = 2; 
                        temp.y--; 
                        Q.add(new Ele(temp.x,temp.y)); 
                 } 
                 Q.remove(); 
                   
            } 
            Q.remove(); 
              
            if (!Q.isEmpty())  
            { 
                Q.add(new Ele(-1,-1)); 
            }              
             
        }
        
        return (checkAll(arr))? -1: ans; 
          
    } 
      
    public static void main(String[] args)  
    { 
        int arr[][] = { {2, 1, 0, 2, 1}, 
                        {1, 0, 1, 2, 1}, 
                        {1, 0, 0, 2, 1}};
        System.out.println("For the given country, the cities are repesented in the form of matrix given below");
        System.out.println("{2, 1, 0, 2, 1}");
        System.out.println("{1, 0, 1, 2, 1}");
        System.out.println("{1, 0, 0, 2, 1}");
        
        int ans = isEbola(arr); 
        if(ans == -1) 
            System.out.println("All cities cannot be affected"); 
        else
            System.out.println("Time required for all cities to get affected = " + ans); 
    } 
  
} 
