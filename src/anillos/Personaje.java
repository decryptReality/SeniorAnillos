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
        System.out.println("  [!] ("+ vida + ",-" + ataque + ") " + nombre);
    }

    protected void danio(Personaje personaje)
    {
        int ataque = personaje.ataque();
        System.out.println("  " + personaje.getNombre() + ": " + ataque + ", " + nombre + ": " + resistencia);
        if(resistencia < ataque)
        {
            danio(ataque);
        }
    }    

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getResistencia() {
        return resistencia;
    }
}