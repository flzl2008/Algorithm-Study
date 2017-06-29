package boj11047;

import java.util.*;

/**
 * Created by ping2 on 2017-05-02.
 */
public class Main {

  public static void main(String args[]) {
    //init
    Scanner s = new Scanner(System.in);
    int arr[] = new int[10];
    int n, k;
    int coin = 0;
    //input
    n = s.nextInt();
    k = s.nextInt();
    for (int i = 0; i < n; i++) {
      arr[i] = s.nextInt();
    }
    //process
    for (int i = n - 1; i >= 0; i--) {
      coin += k / arr[i];
      k %= arr[i];
    }
    //output
    System.out.println(coin);
  }
}
