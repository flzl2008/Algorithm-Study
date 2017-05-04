package boj2294;

import java.util.Scanner;

public class Main {

  static int arr[] = new int[10001];
  static int[] d = new int[101];

  public static void main(String[] args) {
    //init
    int n, k;
    Scanner s = new Scanner(System.in);
    //input
    n = s.nextInt();
    k = s.nextInt();
    for (int i = 1; i <= k; i++) {
      arr[i] = -1;
    }
    for (int i = 0; i < n; i++) {
      d[i] = s.nextInt();
    }
    //dp
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= k; j++) {
        if (j - d[i] >= 0 && (arr[j] == -1 || arr[j] >= arr[j - d[i]] + 1) && arr[j - d[i]] != -1) {
          arr[j] = arr[j - d[i]] + 1;
        }
      }
    }
    //output
    System.out.println(arr[k]);
  }
}