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
        adjMat[end][start] = value;
    }

    public void displayAdjMat() {
        char[]letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.print("  ");
        for (int i = 0; i < numberVertex; i++)
            System.out.print(letters[i] + " ");
        System.out.println();
        for (int i = 0; i < numberVertex; i++) {
            System.out.print(letters[i] + " ");
            for (int j = 0; j < numberVertex; j++) {
                System.out.print(adjMat[i][j] + " ");
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
        if (adjMat[vertex][vertex] != 0)
            cost[vertex] = adjMat[vertex][vertex];
        printResult();
    }

    private void printResult(){
        System.out.print("  ");
        for (int i = 0; i < numberVertex; i++) {
            System.out.print(cost[i] + " ");
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

public class Lab10 {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        //0 = a
        //1 = b
        //2 = c
        //3 = d
        //4 = e
        //5 = f
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(0, 4, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 4, 1);
        graph.displayAdjMat();
        System.out.println();
        graph.findWay(1);
    }
}
