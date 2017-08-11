package boj14502;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ping2 on 2017-08-01.
 */
public class Main {

  static int n, m;
  static int arr[][];

  public static void main(String[] args) {
    //init
    int d1X, d1Y, d2X, d2Y, d3X, d3Y;  //벽3개의 좌표
    int mmax = 0;
    int secureArea = 0;
    String input[];
    Scanner s = new Scanner(System.in);
    Queue<Point> queue = new LinkedList<Point>();

    //input
    input = s.nextLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);

    arr = new int[8][8];
    for (int i = 0; i < n; i++) {
      input = s.nextLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(input[j]);
        if (arr[i][j] == 0) {
          secureArea++;
        } else if (arr[i][j] == 2) {
          queue.offer(new Point(i, j));
        }
      }
    }

    //go
    for (d1X = 0; d1X < n; d1X++) {
      for (d1Y = 0; d1Y < m; d1Y++) {
        if ((arr[d1X][d1Y] != 0)) {
          continue;
        }
        for (d2X = 0; d2X < n; d2X++) {
          for (d2Y = 0; d2Y < m; d2Y++) {
            if ((arr[d2X][d2Y] != 0) || (d1X == d2X && d1Y == d2Y)) {
              continue;
            }
            for (d3X = 0; d3X < n; d3X++) {
              for (d3Y = 0; d3Y < m; d3Y++) {
                if ((arr[d3X][d3Y] != 0) || (d3X == d2X && d3Y == d2Y) || (d3X == d1X
                    && d3Y == d1Y)) {
                  continue;
                }
                mmax = Math.max(mmax,
                    bfs(new Point(d1X, d1Y), new Point(d2X, d2Y), new Point(d3X, d3Y),
                        new LinkedList(queue), secureArea));
              }
            }
          }
        }
      }
    }
    System.out.println(mmax);
  }

  public static int bfs(Point d1, Point d2, Point d3, Queue<Point> queue, int secureArea) {
    //init
    int visit[][] = new int[8][8];
    int tempArr[][] = new int[8][8];
    int dx[] = {0, 1, 0, -1};
    int dy[] = {1, 0, -1, 0};

    //copy
    for (int i = 0; i < n; i++) {
      System.arraycopy(arr[i], 0, tempArr[i], 0, m);
    }

    //doorCreate
    tempArr[d1.x][d1.y] = 1;
    tempArr[d2.x][d2.y] = 1;
    tempArr[d3.x][d3.y] = 1;
    secureArea -= 3;

    //search
    while (queue.peek() != null) {
      Point temp = queue.poll();
      for (int i = 0; i < 4; i++) {
        if (temp.x + dx[i] < n && temp.x + dx[i] >= 0 && temp.y + dy[i] < m && temp.y + dy[i] >= 0
            //range
            && tempArr[temp.x + dx[i]][temp.y + dy[i]] == 0 //condition
            && visit[temp.x + dx[i]][temp.y + dy[i]] == 0) {
          visit[temp.x + dx[i]][temp.y + dy[i]] = 1;
          tempArr[temp.x + dx[i]][temp.y + dy[i]] = 2;
          queue.add(new Point(temp.x + dx[i], temp.y + dy[i]));
          secureArea--;
        }
      }
    }
    return secureArea;
  }
}
