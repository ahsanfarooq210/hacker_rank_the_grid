import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);

        int T = cin.nextInt();
        for (int set = 0; set < T; set++)
        {
            int R = cin.nextInt();
            int C = cin.nextInt();
            cin.nextLine(); //Skip end-of-line character to get to the grid

            String[] grid = new String[R];
            for (int i = 0; i < R; i++)
                grid[i] = cin.nextLine();

            int r = cin.nextInt();
            int c = cin.nextInt();
            cin.nextLine();
            String[] subgrid = new String[r];
            for (int i = 0; i < r; i++)
                subgrid[i] = cin.nextLine();

            boolean found = false;
            for (int i = 0; !found && i < R - r + 1; i++)
            { //iterates over "top rows" for the subgrid.
                for (int j = 0; !found && j < C - c + 1; j++)
                { //iterates over "left-cols" for the subgrid.
                    // System.err.println("Now checking "+ grid[i].substring(j, j+c));
                    if (subgrid[0].equals(grid[i].substring(j, j + c)))
                    { //We've found a first row!  so, let's check all the rows below
                        System.err.println("We found a substring at row=" + i + ", col=" + j);
                        found = true;
                        for (int k = i + 1; found && k < r + i; k++)
                        {
                            System.err.println("  The substring = " + grid[k].substring(j, j + c));
                            found &= subgrid[k - i].equals(grid[k].substring(j, j + c));
                        }
                    }
                }
            }

            System.out.println(found ? "YES" : "NO");

        }
    }
}