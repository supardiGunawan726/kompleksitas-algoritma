import java.util.ArrayList;
import java.util.List;

public class CircuitHamilton {
    public static void main(String[] args) {
        String[] nodes = {"A", "B", "C", "D", "E", "F"};

        int[][] graph = {
            {0, 5, 7, 4, 3, 2},
            {5, 0, 2, 5, 6, 6},
            {7, 2, 0, 6, 4, 10},
            {4, 6, 6, 0, 3, 4},
            {3, 6, 4, 3, 0, 4},
            {2, 6, 10, 4, 4, 0},
        };

        List<Integer> bestRoute = null;
        int shortestDistance = Integer.MAX_VALUE;

        int n = nodes.length;
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }

        do {
            int currentDistance = 0;
            List<Integer> currentRoute = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                int from = permutation[i];
                int to = permutation[i + 1];
                currentDistance += graph[from][to];
                currentRoute.add(from);
            }

            int lastNode = permutation[n - 1];
            currentDistance += graph[lastNode][permutation[0]];
            currentRoute.add(lastNode);
            
            if (currentDistance < shortestDistance) {
              shortestDistance = currentDistance;
              bestRoute = new ArrayList<>(currentRoute);
            }
        } while (nextPermutation(permutation));

        // Menampilkan best route dalam bentuk alfabet
        List<String> bestRouteAlphabet = new ArrayList<>();
        for (int index : bestRoute) {
            bestRouteAlphabet.add(nodes[index]);
        }
        bestRouteAlphabet.add(nodes[0]);

        System.out.println("\nShortest Route (Alphabet): " + bestRouteAlphabet);
        System.out.println("Shortest Distance: " + shortestDistance);

        for (int i = 0; i < bestRoute.size(); i++){
          int node = bestRoute.get(i);
          int from = node;
          int to = bestRoute.get(i + 1 < bestRoute.size() ? i + 1 : 0);
          String fromNode = bestRouteAlphabet.get(i);
          String toNode = i + 1 < bestRoute.size() ? bestRouteAlphabet.get(i + 1) : bestRouteAlphabet.get(0);
          System.out.println(fromNode + " => " + toNode + " : " + graph[from][to] + " bobot");
        }
    }

    // Generate next permutation
    public static boolean nextPermutation(int[] array) {
        int n = array.length;
        int i = n - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = n - 1;
        while (array[j] <= array[i]) {
            j--;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        return true;
    }
}
