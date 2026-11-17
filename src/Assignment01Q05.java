public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {  
            return 0; // Starting point is the same as the destination
        }
        if (m[i][j] == 1) {
            return 1; // Direct path exists
        }
        int n = m.length; 
         int[] dist = new int[n];
         for (int k = 0; k < n; k++) {
                dist[k] = -1;
            }
         dist[i] = 0; 
          boolean changed = true;
         while (changed) {
             changed = false;
               for (int u = 0; u < n; u++) {
                 if (dist[u] != -1) {
                       for (int v = 0; v < n; v++) {
                           if (m[u][v] == 1 && (dist[v] == -1 || dist[u] + 1 < dist[v])) {
                             dist[v] = dist[u] + 1;
                              changed = true;
                         }
                     }
                 }
              }
         }
         if (dist[j] != -1) {
                return dist[j];
         }
          return -1;
 
         }
    

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}