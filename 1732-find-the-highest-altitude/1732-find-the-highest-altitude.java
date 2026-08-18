import java.util.*;

class Solution {
    static int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;

        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            highest = Math.max(highest, altitude);
        }

        return highest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            gain[i] = sc.nextInt();
        }

        System.out.println(largestAltitude(gain));
    }
}