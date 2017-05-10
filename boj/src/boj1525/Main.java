package boj1525;

import java.util.*;

public class Main {

  public static int[][] decodeHash(String h) {
    int idx = 0;
    int arr[][] = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        arr[i][j] = h.charAt(idx++) - '0';
      }
    }
    return arr;
  }

  public static int[] zeroLocate(int[][] arr) {
    int[] zero = new int[2];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (arr[i][j] == 0) {
          zero[0] = i; //y
          zero[1] = j; //x
        }
      }
    }
    return zero;
  }

  public static String swapHash(String h, int a_idx, int b_idx) {
    StringBuilder sb = new StringBuilder(h);
    char tmp = h.charAt(a_idx);
    sb.setCharAt(a_idx, sb.charAt(b_idx));
    sb.setCharAt(b_idx, tmp);
    return sb.toString();
  }

  public static void main(String args[]) {
    // init
    int cnt = -1;
    Scanner s = new Scanner(System.in);
    String hashcode = "";
    HashMap<String, Integer> visit = new HashMap<String, Integer>();
    int[][] map = new int[3][3];
    Queue<String> queue = new LinkedList<String>();
    int dy[] = {0, 1, 0, -1}; // east, south, west, north
    int dx[] = {1, 0, -1, 0}; // east, south, west, north
    // input
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        hashcode += s.next();
      }
    }
    queue.add(hashcode);
    visit.put(hashcode, 1);
    // bfs
    while (!queue.isEmpty()) {
      int r = queue.size();
      cnt++;
      while (r > 0) {
        r--;
        String temp = queue.remove();
        int temp_idx[] = new int[2];
        if (temp.equals("123456780")) {
          System.out.println(cnt);
          return;
        }
        map = decodeHash(temp);
        temp_idx = zeroLocate(map);  //zero locate
        for (int direction = 0; direction < 4; direction++) {
          if (temp_idx[0] + dy[direction] >= 0 && temp_idx[0] + dy[direction] < 3
              && temp_idx[1] + dx[direction] >= 0
              && temp_idx[1] + dx[direction] < 3) {
            hashcode = swapHash(temp, (temp_idx[0] * 3) + temp_idx[1],
                (temp_idx[0] + dy[direction]) * 3 + (temp_idx[1] + dx[direction]));
            if (!visit.containsKey(hashcode)) {
              visit.put(hashcode, 1);
              queue.add(hashcode);
            }

          }
        }
      }
    }
    System.out.println(-1);
  }
}