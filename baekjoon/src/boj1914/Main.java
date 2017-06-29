package boj1914;

import java.util.*;
import java.math.*;
public class Main {
  public static void hano(int s,int e,int n){
    if(n==0) return;
    hano(s,6-(s+e),n-1);
    System.out.println(s+" "+e);
    hano(6-(s+e),e,n-1);
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    BigInteger result=new BigInteger("2");
    result=result.pow(n);
    System.out.println(result.subtract(BigInteger.ONE));
 /*   if(n<21){

    }*/
    hano(1,3,n);
  }
}