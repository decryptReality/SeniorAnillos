package anillos;

import anillos.bestias.Orco;

public class Heroe extends Personaje
{
    public Heroe(String nombre, int vida) 
    {
        super(nombre, vida);
    }

    @Override
    public int ataque() 
    {
        int num1 = Extras.dado(100);
        int num2 = Extras.dado(100);
        int potencia = num1 > num2 ? num1 : num2;
        return potencia;
    }
    
    @Override
    protected void danio(Personaje personaje) 
    {
        
        if(personaje instanceof Orco)
        {
            int ataqueOrco = personaje.ataque();
            System.out.println("  (" + ataqueOrco + ") " + personaje.getNombre() + ", (" + resistencia + ") " + nombre);
            if((int)(0.90 * resistencia) < ataqueOrco)
            {
                super.danio(ataqueOrco);
            }
        }
        else
        {
            super.danio(personaje);
        }
    }
}
