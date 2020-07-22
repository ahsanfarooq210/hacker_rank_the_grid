import java.util.Scanner;

public class MainClass
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int set=0;set<t;set++)
        {
            int R=in.nextInt();
            int C=in.nextInt();
            in.nextLine();

            String[] grid=new String[R];
            for(int i=0;i<R;i++)
            {
                grid[i]=in.nextLine();
            }

            int r=in.nextInt();
            int c=in.nextInt();
            in.nextLine();
            String[] subgrid =new String[r];

            for(int i=0;i<r;i++)
            {
                subgrid[i]=in.nextLine();
            }

            boolean found=false;
            for(int i=0;!found&&i<R-r+1;i++)
            {
                for(int j=0;!found&&j<C-c+1;j++)
                {
                    if(subgrid[0].equals(grid[i].substring(j,j+c)))
                    {
                        found=true;
                        for(int k=i+1;found&&k<r+i;k++)
                        {
                            found&=subgrid[k-i].equals(grid[k].substring(j,j+c));
                        }
                    }
                }
            }
            System.out.println(found?"YES":"NO");
        }
    }
}
