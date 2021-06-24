package anillos.bestias;

import anillos.Bestia;
import anillos.Extras;
import anillos.Personaje;
import anillos.heroes.Elfo;

public class Orco extends Bestia 
{

    public Orco(String nombre) 
    {
        super(nombre, 300);
    }
    
    @Override
    protected void danio(Personaje personaje)
    {
        if(personaje instanceof Elfo)
        {
            int ataqueElfo = Extras.dado(1,10) + personaje.ataque();
            if(resistencia < ataqueElfo)
            {
                danio(ataqueElfo);
            }
        }
        else
        {
            super.danio(personaje);
        }
    }
}
