package anillos;

import java.util.Random;

public class Extras 
{
    private static Random random = new Random();

    public static int dado(int inf, int sup)
    {
        return random.nextInt(sup + 1) + inf;
    }
    public static int dado(int sup)
    {
        return random.nextInt(sup + 1);
    }
}
