import java.util.Arrays;
import java.util.Scanner;

public class Task62 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++)
            a[i] = scanner.nextInt();
        Arrays.sort(a);

        int time = findTime(a[0], n);
        for (int k = 0; k < m; k++) {
            for (int i = n - 1; i > 0; i--) {
                int tmpTime = findTime(a[k], i);
                int tmpN = i;
                for (int j = 0; j < m; j++) {
                    if(j != k)
                        tmpN += findPieces(a[j], tmpTime);
                }
                if (tmpN >= n && tmpTime < time)
                    time = tmpTime;
            }
        }
        System.out.println(time);
    }

    public static int findTime(int eatTime, int pieces){
        return eatTime * (pieces * 2 - 1);
    }

    public static int findPieces(int eatTime, int timeLimit){
        int result = 0;
        int tmp = findTime(eatTime, 1);
        for (int i = 2; tmp <= timeLimit; i++) {
            result++;
            tmp = findTime(eatTime, i);
        }
        return result;
    }

}
