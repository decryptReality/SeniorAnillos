package anillos;

public class Bestia extends Personaje
{
    public Bestia(String nombre, int vida) 
    {
        super(nombre, vida);
    }

    @Override
    public int ataque() 
    {
        return Extras.dado(90);
    }
}
