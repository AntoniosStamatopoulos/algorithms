import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Graph {
    static class Node {
        int v;
        Node next;
        boolean isBlocked;

        Node(int v, Node t) {
            this.v = v;
            this.next = t;
            this.isBlocked = false;
        }
    }

    public static int DFS(Node[] S, int v) {
        boolean[] marked = new boolean[S.length];
        ArrayList<Integer> list = new ArrayList<>();
        return Collections.max(DFSH(S, v, marked, list, 1));
    }

    public static ArrayList<Integer> DFSH(Node[] S, int k, boolean[] marked, ArrayList<Integer> list, int count) {
        if (S[k].isBlocked) {
            count = 1;
        }
        marked[k] = true;
        for (Node t = S[k]; t != null; t = t.next) {
            if (!marked[t.v]) {
                count++;
                DFSH(S, t.v, marked, list, count);
            }
        }
        list.add(count);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = N - 1;
        Node adj[] = new Node[N];
        for (int i = 0; i < M; i++) {
            int k = scanner.nextInt();
            int j = scanner.nextInt();
            adj[j] = new Node(k, adj[j]);
            adj[k] = new Node(j, adj[k]);
        }
        for (int i = 0; i < N; i++) {
            int l = scanner.nextInt();
            if (l == 1) {
                adj[i].isBlocked = true;
            }
        }
        System.out.println(DFS(adj, 0));
        scanner.close();
    }
}