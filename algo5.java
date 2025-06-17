import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class algo5 {
    public static int BFS(int first_node, List<Integer>[] adjencyList, int[] blockedCity) {

        boolean[] visited = new boolean[adjencyList.length];
        visited[0] = true;
        int connected = 0;

        for (int i = 0; i < adjencyList.length; i++) {
            if (blockedCity[i] == 0 && visited[i] == false) {
                visited[i] = true;
                connected++;
            }
        }

        return connected;

    }

    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);
        // int input = scanner.nextInt();
        int n = 4;
        List<Integer>[] adjencyList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjencyList[i] = new ArrayList<>();

        }
        int[] blockedCity = new int[n + 1];

        adjencyList[3].add(4);
        adjencyList[4].add(3);
        adjencyList[2].add(3);
        adjencyList[3].add(2);
        adjencyList[1].add(2);
        adjencyList[2].add(1);

        blockedCity[1] = 0;
        blockedCity[2] = 1;
        blockedCity[3] = 1;
        blockedCity[4] = 0;

        System.out.println("maximum number of cities " + BFS(n, adjencyList, blockedCity));

        // scanner.close();

    }
}
