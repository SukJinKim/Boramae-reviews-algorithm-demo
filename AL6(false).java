import java.util.*;

public class Main {
    public static String[] words;
    public static boolean[] used;
    public static ArrayList<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while (C-- > 0) {
            int N = sc.nextInt();
            words = new String[N];
            used = new boolean[N];
            result = new ArrayList<>();

            for (int n = 0; n < N; n++) {
                words[n] = sc.next();
            }

            if (findCircuit(0)) {
                for (String word : result) {
                    System.out.print(word + " ");
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static boolean findCircuit(int count) {
        if (count == words.length) {
            return isValidCircuit();
        }

        for (int i = 0; i < words.length; i++) {
            if (!used[i]) {
                used[i] = true;
                result.add(words[i]);
                if (findCircuit(count + 1)) {
                    return true;
                }
                result.remove(result.size() - 1);
                used[i] = false;
            }
        }

        return false;
    }

    public static boolean isValidCircuit() {
        for (int i = 0; i < result.size() - 1; i++) {
            String current = result.get(i);
            String next = result.get(i + 1);
            if (current.charAt(current.length() - 1) != next.charAt(0)) {
                return false;
            }
        }
        String first = result.get(0);
        String last = result.get(result.size() - 1);
        return last.charAt(last.length() - 1) == first.charAt(0);
    }
}