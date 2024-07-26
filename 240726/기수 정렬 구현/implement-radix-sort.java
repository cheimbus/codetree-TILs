import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());

        String[] sArr = bf.readLine().split(" ");
        int[] iArr = new int[sArr.length];
        for(int i = 0; i < sArr.length; i++) {
            iArr[i] = Integer.parseInt(sArr[i]);
        }

        int k = getMaxLeng(iArr);

        radixSort(iArr, k);
        
        StringBuffer sb = new StringBuffer();
        for(int i : iArr) {
            sb.append(i).append(" ");
        }
        sb.setLength(sb.length() -1);

        System.out.println(sb);
    }

    public static void radixSort(int[] arr, int k) {
        for(int pos = 0; pos < k; pos ++) {
            List<List<Integer>> newArr = new ArrayList<>(10);
            for(int i = 0; i < 10; i++) {
                newArr.add(new ArrayList<>());
            }

            for(int num : arr) {
                int digit = getDigit(num, pos);
                newArr.get(digit).add(num);
            }

            int idx = 0;
            for(List<Integer> bucket : newArr) {
                for(int num : bucket) {
                    arr[idx++] = num;
                }
            }
        }
    }

    public static int getDigit(int num, int pos) {
        return (num / (int) Math.pow(10, pos)) % 10;
    }

    public static int getMaxLeng(int[] arr) {
        int max = 0;
        for(int i : arr) {
            max = Math.max(max, i);
        }
        return Integer.toString(max).length();
    }
}