package anillos;

import java.util.Random;
import java.util.Scanner;

public class Extras 
{
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    static int dado(int inf, int sup)
    {
        return random.nextInt(sup + 1) + inf;
    }
    public static int dado(int sup)
    {
        return random.nextInt(sup + 1);
    }
}
