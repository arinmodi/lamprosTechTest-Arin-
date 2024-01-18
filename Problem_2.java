import java.util.*;

public class Problem_2 {

    public static void main(String[] args) {
        // inputs
        int[] input = new int[] { 5, 2, 5, 3, 5, 3, 1 };
        int k = 2;

        List<Integer> ans = solution(input, k);

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static List<Integer> solution(int[] arr, int k) {
        // list to store answers
        List<Integer> ans = new ArrayList<>();

        // edge case
        if (k > arr.length) {
            return ans;
        }

        // map to store counts
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // priority queue for sorting purpose according to count
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });

        // adding counts of numbers to priority queue in form of array
        for (int keys : map.keySet()) {
            pq.add(new int[]{ keys, map.get(keys) });
        }

        // poping elements with heighest count and adding it to the ans
        while (k != 0) {
            ans.add(pq.remove()[0]);
            k--;
        }

        return ans;
    }

}
