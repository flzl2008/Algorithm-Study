package boj13565;

import java.util.Scanner;

public class Main {

  static int arr[][] = new int[1001][1001];
  static int visit[][] = new int[1001][1001];
  static int dX[] = {1, 0, -1, 0};
  static int dY[] = {0, 1, 0, -1};
  static int n, m;

  public static void main(String args[]) {
    String temp[];
    Scanner s = new Scanner(System.in);

    //input
    temp = s.nextLine().split(" ");
    m = Integer.parseInt(temp[0]);
    n = Integer.parseInt(temp[1]);
    for (int j = 0; j < m; j++) {
      temp = s.nextLine().split("");
      for (int i = 0; i < n; i++) {
        arr[j][i] = Integer.parseInt(temp[i]);
      }
    }
    for (int i = 0; i < n; i++) {
      if (arr[0][i] == 0) {
        dfs(0, i);
      }
    }
    System.out.println("NO");
  }

  public static void dfs(int tempY, int tempX) {
    //dfs
    visit[tempY][tempX] = 1;
    for (int i = 0; i < 4; i++) {
      if (tempY + dY[i] >= 0 && tempY + dY[i] < m && tempX + dX[i] >= 0 && tempX + dX[i] < n
          && arr[tempY + dY[i]][tempX + dX[i]] == 0 && visit[tempY + dY[i]][tempX + dX[i]] == 0) {
        if (tempY + dY[i] == m - 1) {
          System.out.println("YES");
          System.exit(0);
        }
        dfs(tempY + dY[i], tempX + dX[i]);
      }
    }
  }
}
