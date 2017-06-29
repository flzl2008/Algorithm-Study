package boj2747;

import java.util.Scanner;

/**
 * Created by ping2 on 2017-05-02.
 */
public class Main {

  static int arr[] = new int[46];
  static int n;

  public static int dp(int cnt) {
    if (cnt == 1) {
      return 1;
    }
    if (arr[cnt] == -1) {
      return arr[cnt] = dp(cnt - 1) + dp(cnt - 2);
    } else {
      return arr[cnt];
    }
  }

  public static void main(String[] args) {
    //init
    for (int i = 0; i < arr.length; i++) {
      arr[i] = -1;
    }
    arr[0] = 0;
    Scanner s = new Scanner(System.in);
    //input
    n = s.nextInt();
    //output
    System.out.println(dp(n));
  }
}
