package boj13567;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    //init
    Scanner s = new Scanner(System.in);
    int m, n;
    String temp[];
    Robot r = new Robot(0, 0, 1);

    //input && go
    temp = s.nextLine().split(" ");
    m = Integer.parseInt(temp[0]);
    n = Integer.parseInt(temp[1]);
    for (int i = 0; i < n; i++) {
      temp = s.nextLine().split(" ");
      if (temp[0].equals("MOVE")) {
        r.move(Integer.parseInt(temp[1]));
      } else {
        r.turn(Integer.parseInt(temp[1]));
      }
      //confirm
      if (r.getX() >= m || r.getY() >= m || r.getX() < 0 || r.getY() < 0) {
        System.out.println(-1);
        return;
      }
    }
    System.out.format("%d %d", r.getX(), r.getY());
  }
}

class Robot {

  private int x;
  private int y;
  private int dir;

  public Robot(int x, int y, int dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void turn(int dir) {
    if (dir == 0) { //turn right
      this.dir--;
      if (this.dir < 0) {
        this.dir = 3;
      }
    } else {  //turn left
      this.dir++;
      this.dir %= 4;
    }
  }

  public void move(int d) {
    if (this.dir == 0) {  //north
      this.y += d;
    } else if (this.dir == 1) {  //east
      this.x += d;
    } else if (this.dir == 2) {  //south
      this.y -= d;
    } else {  //west
      this.x -= d;
    }
  }
}
