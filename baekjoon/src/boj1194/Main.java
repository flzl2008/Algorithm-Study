package boj1194;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //init
    char arr[][]; Queue<State> queue = new LinkedList<State>(); boolean visit[][][][][][][][]; int n, m; int dx[] = {0, 1, 0, -1}; int dy[] = {1, 0, -1, 0}; int cnt = 0; int flag = 1; arr = new char[50][50]; visit = new boolean[50][50][2][2][2][2][2][2]; Scanner s = new Scanner(System.in); String input[]; String line; Point start = new Point();

    //input
    input = s.nextLine().split(" "); n = Integer.parseInt(input[0]); m = Integer.parseInt(input[1]); for (int i = 0; i < n; i++) {
      input = s.nextLine().split(""); for (int j = 0; j < m; j++) {
        arr[i][j] = input[j].charAt(0); if (arr[i][j] == '0') {
          start.setLocation(i, j);
        }
      }
    }

    HashMap<Character, Integer> keys = new HashMap<Character, Integer>(); keys.put('a', 0); keys.put('b', 0); keys.put('c', 0); keys.put('d', 0); keys.put('e', 0); keys.put('f', 0); queue.offer(new State(new HashMap<>(keys), new Point(start))); visit[start.x][start.y][keys.get('a')][keys.get('b')][keys.get('c')][keys.get('d')][keys.get('e')][keys.get('f')] = true;
    //bfs
    while (queue.size() > 0) {
      while (flag-- > 0) {
        State temp = queue.poll(); for (int i = 0; i < 4; i++) {
          if (temp.now.x + dx[i] >= 0 && temp.now.x + dx[i] < n && temp.now.y + dy[i] >= 0 && temp.now.y + dy[i] < m && arr[temp.now.x + dx[i]][temp.now.y + dy[i]] != '#') {
            if (arr[temp.now.x + dx[i]][temp.now.y + dy[i]] >= 'a' && arr[temp.now.x + dx[i]][temp.now.y + dy[i]] <= 'f') {
              int original = temp.keys.get(arr[temp.now.x + dx[i]][temp.now.y + dy[i]]); temp.keys.replace(arr[temp.now.x + dx[i]][temp.now.y + dy[i]], 1); if (visit[temp.now.x + dx[i]][temp.now.y + dy[i]][temp.keys.get('a')][temp.keys.get('b')][temp.keys.get('c')][temp.keys.get('d')][temp.keys.get('e')][temp.keys.get('f')] == false) {
                queue.offer(new State(new HashMap<>(temp.keys), new Point(temp.now.x + dx[i], temp.now.y + dy[i]))); visit[temp.now.x + dx[i]][temp.now.y + dy[i]][temp.keys.get('a')][temp.keys.get('b')][temp.keys.get('c')][temp.keys.get('d')][temp.keys.get('e')][temp.keys.get('f')] = true;
              } temp.keys.replace(arr[temp.now.x + dx[i]][temp.now.y + dy[i]], original);
            } else if (arr[temp.now.x + dx[i]][temp.now.y + dy[i]] >= 'A' && arr[temp.now.x + dx[i]][temp.now.y + dy[i]] <= 'F' && visit[temp.now.x + dx[i]][temp.now.y + dy[i]][temp.keys.get('a')][temp.keys.get('b')][temp.keys.get('c')][temp.keys.get('d')][temp.keys.get('e')][temp.keys.get('f')] == false) {
              if (temp.keys.get(Character.toLowerCase(arr[temp.now.x + dx[i]][temp.now.y + dy[i]])) == 1) {
                queue.offer(new State(new HashMap<>(temp.keys), new Point(temp.now.x + dx[i], temp.now.y + dy[i]))); visit[temp.now.x + dx[i]][temp.now.y + dy[i]][temp.keys.get('a')][temp.keys.get('b')][temp.keys.get('c')][temp.keys.get('d')][temp.keys.get('e')][temp.keys.get('f')] = true;
              }
            } else if (arr[temp.now.x + dx[i]][temp.now.y + dy[i]] == '1') {
              System.out.println(cnt + 1); System.exit(0);
            } else {
              if (visit[temp.now.x + dx[i]][temp.now.y + dy[i]][temp.keys.get('a')][temp.keys.get('b')][temp.keys.get('c')][temp.keys.get('d')][temp.keys.get('e')][temp.keys.get('f')] == false) {
                queue.offer(new State(new HashMap<>(temp.keys), new Point(temp.now.x + dx[i], temp.now.y + dy[i]))); visit[temp.now.x + dx[i]][temp.now.y + dy[i]][temp.keys.get('a')][temp.keys.get('b')][temp.keys.get('c')][temp.keys.get('d')][temp.keys.get('e')][temp.keys.get('f')] = true;
              }
            }
          }
        }
      } flag = queue.size(); cnt++;
    }
    //impossible
    System.out.println(-1);
  }
}

class State {
  HashMap<Character, Integer> keys;
  Point now;

  public State(HashMap<Character, Integer> keys, Point now) {
    this.keys = keys; this.now = now;
  }
}
