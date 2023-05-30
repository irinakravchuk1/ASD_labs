package com.company;

class Graph {
    private int[][]adjMat;
    private int[]cost;
    private int[]visited;

    private final int INF = Integer.MAX_VALUE;
    private int numberVertex;

    public Graph(int size) {
        adjMat = new int[size][size];
        cost = new int[size];
        visited = new int[size];
        for (int i = 0; i < size; i++) {
            //visited[i] = 0;
            for (int j = 0; j < size; j++) {
                adjMat[i][j] = 0;
            }
        }
        numberVertex = size;
    }

    public void addEdge(int start, int end, int value) {
        adjMat[start][end] = value;
    }

    public void displayAdjMat() {
        for (int i = 0; i < numberVertex; i++) {
            for (int j = 0; j < numberVertex; j++) {
                System.out.print(adjMat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void findWay(int vertex){
        for (int i = 0; i < numberVertex; i++) {
            cost[i]=INF;
        }
        cost[vertex] = 0;
        deikstra(vertex);
        printResult();
    }

    private void printResult(){
        for (int i = 0; i < numberVertex; i++) {
            if (cost[i] != INF && cost[i] != 0)
                System.out.print(cost[i] + "\t");
            else
                System.out.print("_\t");
        }
        System.out.println();
    }
    private int minDist(){
        int minDistance = INF;
        int index = -1;
        for (int i = 0; i < numberVertex; i++) {
            if (minDistance > cost[i] && visited[i] == 0){
                minDistance = cost[i];
                index = i;
            }
        }
        return index;
    }
    private void deikstra(int start){
        for (int i = 0; i < numberVertex; i++) {
            if (adjMat[start][i] > 0 && cost[i] > (adjMat[start][i] + cost[start]) ){
                cost[i] = adjMat[start][i] + cost[start];
            }
        }
        int j = minDist();
        if (j  == -1 )
            return;
        visited[j] = 1;
        deikstra(j);
    }
}

public class Lab11 {
    public static void main(String[] args) {
        Graph graph = new Graph(12);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 7);

        graph.addEdge(1, 4, 8);

        graph.addEdge(2, 1, 9);
        graph.addEdge(2, 3, 1);

        graph.addEdge(3, 4, 10);

        graph.addEdge(5, 4, 5);
        graph.addEdge(5, 6, 5);

        graph.addEdge(6, 7, 5);
        graph.addEdge(6, 11, 4);

        graph.addEdge(7, 9, 3);
        graph.addEdge(7, 11, 10);

        graph.addEdge(8, 7, 2);
        graph.addEdge(8, 2, 3);
        graph.addEdge(8, 3, 4);
        graph.addEdge(8, 9, 4);

        graph.addEdge(9, 3, 5);
        graph.addEdge(9, 10, 1);

        graph.addEdge(10, 3, 2);
        graph.addEdge(10, 4, 5);

        graph.addEdge(11, 10, 9);
        graph.addEdge(11, 5, 4);

        graph.displayAdjMat();
        System.out.println();
        graph.findWay(10);
    }
}
