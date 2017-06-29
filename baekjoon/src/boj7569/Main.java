package boj7569;

import java.util.*;

public class Main {

  public static void main(String args[]) {
    //init
    int[][][] map = new int[101][101][101];
    int[][][] visit = new int[101][101][101];
    int[][] queue = new int[3][1000001];
    int h, m, n;
    int front = 0, rear = 0;
    int day = -1;
    int to_cnt = 0;  //tomato count
    int dh[] = {0, 0, 0, 0, -1, 1};  //east , south, west, north, upside, downside
    int dy[] = {0, 1, 0, -1, 0, 0};  //east , south, west, north, upside, downside
    int dx[] = {1, 0, -1, 0, 0, 0};  //east , south, west, north, upside, downside
    Scanner s = new Scanner(System.in);
    //input
    m = s.nextInt();
    n = s.nextInt();
    h = s.nextInt();
    for (int k = 0; k < h; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          map[k][i][j] = s.nextInt();
          if (map[k][i][j] == 1) {
            queue[0][rear] = k; //height
            queue[1][rear] = i; //vertical
            queue[2][rear++] = j; //horizen
            visit[k][i][j] = 1;
          } else if (map[k][i][j] == 0) {
            to_cnt++;
          }
        }
      }
    }
    //bfs
    while (front < rear) {
      int r = rear; //dayflag
      while (front < r) {  //oneday loop
        int temp_h = queue[0][front];
        int temp_y = queue[1][front];
        int temp_x = queue[2][front++];
        for (int direction = 0; direction < 6; direction++) {
          //rule
          if (temp_h + dh[direction] >= 0 && temp_h + dh[direction] < h
              && temp_y + dy[direction] >= 0 && temp_y + dy[direction] < n
              && temp_x + dx[direction] >= 0 && temp_x + dx[direction] < m
              && map[temp_h + dh[direction]][temp_y + dy[direction]][temp_x + dx[direction]] == 0
              && visit[temp_h + dh[direction]][temp_y + dy[direction]][temp_x + dx[direction]]
              == 0) {
            queue[0][rear] = temp_h + dh[direction]; //height
            queue[1][rear] = temp_y + dy[direction]; //vertical
            queue[2][rear++] = temp_x + dx[direction]; //horizen
            visit[temp_h + dh[direction]][temp_y + dy[direction]][temp_x
                + dx[direction]] = 1; //visit
            to_cnt--;
          }
        }
      }
      day++;
    }
    //output
    if (to_cnt > 0) {
      System.out.println(-1);
    } else {
      System.out.println(day);
    }
  }
}