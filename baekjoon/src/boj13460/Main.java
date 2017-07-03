package boj13460;

import java.awt.Point;
import java.util.Scanner;

public class Main {

  public static void main(String args[]) {

    //init
    Scanner s = new Scanner(System.in);
    String inputLine;
    int n, m;
    char map[][] = new char[10][10];
    boolean visit[][][][] = new boolean[10][10][10][10];
    Point redQue[] = new Point[5000];
    Point blueQue[] = new Point[5000];
    Point goal = new Point();
    int front = 0;
    int rear = 1;
    int flag;
    int cnt = 0;
    Point nowRed;
    Point nowBlue;
    Point tempRed;
    Point tempBlue;
    int success = 11; //성공했을때의 인덱스중 가장 작은값저장

    //input
    n = s.nextInt();
    m = s.nextInt();
    for (int i = 0; i < n; i++) {
      inputLine = s.next();
      for (int j = 0; j < m; j++) {
        map[i][j] = inputLine.charAt(j);
        if (map[i][j] == 'R') {
          redQue[0] = new Point(i, j);  //위치만 저장
          map[i][j] = '.'; //위치 저장했으면 .으로 만들어서 지워줌
        } else if (map[i][j] == 'B') {
          blueQue[0] = new Point(i, j); //위치만 저장
          map[i][j] = '.'; //위치 저장했으면 .으로 만들어서 지워줌
        } else if (map[i][j] == 'O') {
          goal = new Point(i, j);
        }
      }
    }
    visit[redQue[0].x][redQue[0].y][blueQue[0].x][blueQue[0].y] = true;
    //bfs
    while (cnt < 10 && front < rear) {
      cnt++;
      flag = rear;
      while (front < flag) {  //한개의 cnt동안에 쌓인 rear만큼 반복
        //pop
        nowRed = redQue[front];
        nowBlue = blueQue[front++];

        //left
        tempRed = left(map, new Point(nowRed), nowBlue);
        tempBlue = left(map, new Point(nowBlue), tempRed);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && tempRed.x == goal.x
            && tempRed.y == goal.y) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        tempRed = left(map, new Point(tempRed), tempBlue);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && (tempRed.x == goal.x
            && tempRed.y == goal.y)) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y)
            && visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] == false) {
          visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] = true;
          //push
          redQue[rear] = new Point(tempRed);
          blueQue[rear++] = new Point(tempBlue);
        }

        //right
        tempRed = right(map, new Point(nowRed), nowBlue);
        tempBlue = right(map, new Point(nowBlue), tempRed);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && tempRed.x == goal.x
            && tempRed.y == goal.y) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        tempRed = right(map, new Point(tempRed), tempBlue);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && tempRed.x == goal.x
            && tempRed.y == goal.y) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y)
            && visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] == false) {
          visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] = true;
          //push
          redQue[rear] = new Point(tempRed);
          blueQue[rear++] = new Point(tempBlue);
        }

        //up
        tempRed = up(map, new Point(nowRed), nowBlue);
        tempBlue = up(map, new Point(nowBlue), tempRed);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && tempRed.x == goal.x
            && tempRed.y == goal.y) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        tempRed = up(map, new Point(tempRed), tempBlue);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && tempRed.x == goal.x
            && tempRed.y == goal.y) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y)
            && visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] == false) {
          visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] = true;
          //push
          redQue[rear] = new Point(tempRed);
          blueQue[rear++] = new Point(tempBlue);
        }

        //down
        tempRed = down(map, new Point(nowRed), nowBlue);
        tempBlue = down(map, new Point(nowBlue), tempRed);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && tempRed.x == goal.x
            && tempRed.y == goal.y) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        tempRed = down(map, new Point(tempRed), tempBlue);
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y) && tempRed.x == goal.x
            && tempRed.y == goal.y) {  //빨간공만 들어갔을때
          success = Math.min(cnt, success);
          continue;
        }
        if (!(tempBlue.x == goal.x && tempBlue.y == goal.y)
            && visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] == false) {
          visit[tempRed.x][tempRed.y][tempBlue.x][tempBlue.y] = true;
          //push
          redQue[rear] = new Point(tempRed);
          blueQue[rear++] = new Point(tempBlue);
        }

      }
    }
    if (success < 11) //10번안에 성공했을경우
    {
      System.out.println(success);
    } else   //10번안에 성공하지 못한경우
    {
      System.out.println(-1);
    }
  }

  public static Point left(char arr[][], Point temp, Point temp2) {
    while (arr[temp.x][temp.y - 1] != '#' && (!(temp2.x == temp.x && temp2.y == temp.y - 1)
        || arr[temp.x][temp.y - 1] == 'O')) { //#아니고 red와 blue겹치지 않거나 또는 O일때
      temp.y--;
      if (arr[temp.x][temp.y] == 'O') {
        return temp;
      }
    }
    return temp;
  }

  public static Point right(char arr[][], Point temp, Point temp2) {
    while (arr[temp.x][temp.y + 1] != '#' && (!(temp2.x == temp.x && temp2.y == temp.y + 1)
        || arr[temp.x][temp.y + 1] == 'O')) { //#아니고 red와 blue겹치지 않거나 또는 O일때
      temp.y++;
      if (arr[temp.x][temp.y] == 'O') {
        return temp;
      }
    }
    return temp;
  }

  public static Point up(char arr[][], Point temp, Point temp2) {
    while (arr[temp.x - 1][temp.y] != '#' && (!(temp2.x == temp.x - 1 && temp2.y == temp.y)
        || arr[temp.x - 1][temp.y] == 'O')) { //#아니고 red와 blue겹치지 않거나 또는 O일때
      temp.x--;
      if (arr[temp.x][temp.y] == 'O') {
        return temp;
      }
    }
    return temp;
  }

  public static Point down(char arr[][], Point temp, Point temp2) {
    while (arr[temp.x + 1][temp.y] != '#' && (!(temp2.x == temp.x + 1 && temp2.y == temp.y)
        || arr[temp.x + 1][temp.y] == 'O')) { //#아니고 red와 blue겹치지 않거나 또는 O일때
      temp.x++;
      if (arr[temp.x][temp.y] == 'O') {
        return temp;
      }
    }
    return temp;
  }
}