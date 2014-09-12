import java.io.*;

public class projecteuler81 {
    public static void main(String[] args) throws IOException {
        int size = 80;
        // really is size = 80, use size-- for ease of use with arrays
        size--;
        int[][] arr = new int[80][80];
        int starti = 0;

        BufferedReader br = new BufferedReader(new FileReader("euler81.txt"));
        for (int row  = 0; row < size + 1; row++) {
            String s = br.readLine();
            for (int entry = 0; entry < size; entry++){
                arr[row][entry] = Integer.parseInt(s.substring(starti, s.indexOf(",", starti)));
                starti = s.indexOf(",", starti) + 1;
            }
            arr[row][size] = Integer.parseInt(s.substring(starti));
            starti = 0;
        }

        int[][] minroute = new int[size + 1][size + 1];
        minroute[size][size] = arr[size][size];

        for(int i = size - 1; i >= 0; i--) {
            minroute[size][i] = minroute[size][i+1] + arr[size][i];
            minroute[i][size] = minroute[i+1][size] + arr[i][size];
        }

        for(int layer = 1; layer <= size; layer++) {
            for(int col = size - 1; col > size - layer; col--) {
                minroute[col][size - layer] = (minroute[col][size-layer + 1] < minroute[col + 1][size-layer]) ?
                                              (minroute[col][size-layer + 1] + arr[col][size - layer]) :
                                              (minroute[col + 1][size-layer] + arr[col][size - layer]);

                minroute[size - layer][col] = (minroute[size-layer + 1][col] < minroute[size-layer][col + 1]) ?
                                              (minroute[size-layer + 1][col] + arr[size - layer][col]) :
                                              (minroute[size-layer][col + 1] + arr[size - layer][col]);
            }

            minroute[size - layer][size - layer] = (minroute[size-layer + 1][size-layer] < minroute[size-layer][size-layer + 1]) ?
                                                   (minroute[size-layer + 1][size-layer] + arr[size - layer][size - layer]) :
                                                   (minroute[size-layer][size-layer + 1] + arr[size - layer][size - layer]);
        }

        System.out.println("MIN ROUTE SUM IS " + minroute[0][0]);
    }
}
