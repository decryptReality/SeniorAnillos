package anillos.bestias;

import anillos.Bestia;
import anillos.Personaje;
import anillos.heroes.Hobbit;

public class Trasgo extends Bestia 
{
    public Trasgo(String nombre) 
    {
        super(nombre, 325);
    }

    @Override
    protected void danio(Personaje personaje) 
    {
        if(personaje instanceof Hobbit)
        {
            int ataqueHobbit = personaje.ataque() - 5;
            System.out.println("  (" + ataqueHobbit + ") " + personaje.getNombre() + ", (" + resistencia + ") " + nombre);
            if(resistencia < ataqueHobbit)
            {
                danio(ataqueHobbit);
            }
        }
        else
        {
            super.danio(personaje);
        }
    }
}
