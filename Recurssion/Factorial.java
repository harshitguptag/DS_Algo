import java.util.*;

public class Factorial 
{
  public static void main(String[] args) throws Exception 
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int f = factorial(n);
    System.out.println(f);
  }

  public static int factorial(int n) 
  {
    if(n == 0)
    {
      return 1;
    }
    int fm1 = factorial(n - 1);
    int f = fm1 * n;
    return f;
  }
}


                        