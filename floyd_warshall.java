package tp1;

import java.util.Arrays;

public class floyd_warshall {

    public static void floyds(int[][] graph) {
        int n = graph.length;
        int INF = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        System.out.println("la matrice des PCC:");
        printMatrix(graph);
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[5][5];
        int INF = Integer.MAX_VALUE;
        
        for (int i = 0; i < 5; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        graph[0][1] = 9;
        graph[0][2] = 3;
        graph[0][3] = -3;
        graph[1][0] = 4;
        graph[1][2] = 4;
        graph[2][3] = 7;
        graph[2][4] = 2;
        graph[3][4] = 10;
        graph[4][0] = 2;
        graph[4][1] = -4;

        System.out.println("la matrice des poids:");
        printMatrix(graph);

        floyds(graph);
    }
}
