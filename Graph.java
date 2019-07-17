# Graph

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    private static void DFSHelper(LinkedList<Integer> graph[], int start, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;
        stack.push(start);
        System.out.print(start + " ");
        for (int i = 0; i < graph[start].size(); i++) {
            int to = graph[start].get(i);
            if (!visited[to]) {
                DFSHelper(graph, to, visited, stack);
            }
        }
    }

    public static void DFS(LinkedList<Integer> graph[], int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        DFSHelper(graph, start, visited, stack);
    }

    public static void BFS(LinkedList<Integer> graph[], int start) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int at = q.remove();
            visited[at] = true;
            System.out.print(at + " ");
            for (int i = 0; i < graph[at].size(); i++) {
                int to = graph[at].get(i);
                if (!visited[to]) {
                    q.add(to);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v, e;
        Scanner scanner = new Scanner(System.in);
        v = scanner.nextInt();
        e = scanner.nextInt();
        LinkedList<Integer> graph[] = new LinkedList[v + 1];
        int x, y;
        for (int i = 0; i < v; i++) {
            graph[i] = new LinkedList();
        }
        for (int i = 0; i < e; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            graph[x].add(y);
            //graph[y].add(x);
        }
        BFS(graph, 2);
        System.out.println();
        DFS(graph, 2);
    }
}
