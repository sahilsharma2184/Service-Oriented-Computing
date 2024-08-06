import java.util.*;
public class fibonacci
{
    public static void main(String[] args)
    {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter till where you need fibonacci series\n");
    int limit=sc.nextInt();
    int f=0;
    int s=1;

    System.out.print("Fibonacci Series is\n");
    System.out.print(f + " " + s + " ");
    for(int i=2;i<=limit;i++)
    {
        int nextno=f+s;
        f=s;
        s=nextno;
        System.out.print(nextno + " ");
    }

    sc.close();
    }
    
}