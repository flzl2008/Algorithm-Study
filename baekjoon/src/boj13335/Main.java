package boj13335;

import java.util.Scanner;

public class Main {

  static int[] queue;
  static int[] truck;
  static int n, w, L;
  static int tCount;
  static int count;
  static int front, rear;

  public static void main(String[] args) {
    //init
    Scanner s = new Scanner(System.in);
    truck = new int[1000001];
    queue = new int[1000001];

    //input
    String input[] = s.nextLine().split(" ");
    n = Integer.parseInt(input[0]);
    w = Integer.parseInt(input[1]);
    L = Integer.parseInt(input[2]);
    input = s.nextLine().split(" ");
    for (int i = 0; i < n; i++) {
      truck[i] = Integer.parseInt(input[i]);
    }
    front = 0;
    rear = w;

    //go
    while (front < rear) {
      count++;
      front++;
      if (calcWeight()) {
        queue[rear++] = truck[tCount++];
      } else {
        queue[rear++] = 0;
      }
    }
  }

  public static boolean calcWeight() {
    int sum = 0;
    for (int i = front; i < rear; i++) {
      sum += queue[i];
    }
    if (tCount >= n && sum == 0) {
      System.out.println(count);
      System.exit(0);
    }
    if (sum + truck[tCount] <= L) {
      return true;
    } else {
      return false;
    }
  }
}
