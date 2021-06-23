package anillos;

public class Personaje 
{  
    protected String nombre;
    protected int vida;
    protected int resistencia;

    public Personaje(String nombre, int vida) 
    {
        this.nombre = nombre;
        this.vida = vida;
        resistencia = Extras.dado(60, 70);
    }

    public int ataque()
    {
        return 0;
    }

    protected void danio(int ataque)
    {
        vida = vida - ataque;
    }

    protected void danio(Personaje personaje)
    {
        if(resistencia < personaje.ataque())
        {
            danio(personaje.ataque());
        }
    }
}