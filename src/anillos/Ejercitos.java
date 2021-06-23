package anillos;

import java.util.Random;

import anillos.bestias.Orco;
import anillos.bestias.Trasgo;
import anillos.heroes.Elfo;
import anillos.heroes.Hobbit;
import anillos.heroes.Humano;

public class Ejercitos 
{
    int elementos;
    Bestia[] bestias = {};
    Heroe[] heroes;

    Bestia getBestia(int caso, int indice)
    {
        if(caso == 0)
        {
            return new Orco("Orco" + indice);
        }
        if(caso == 1)
        {
            return new Trasgo("Trasgo" + indice);
        }
        return null;
    }

    Heroe getHeroe(int caso, int indice)
    {
        if(caso == 0)
        {
            return new Elfo("Elfo" + indice);
        }
        if(caso == 1)
        {
            return new Hobbit("Hobbit" + indice);
        }
        if(caso == 2)
        {
            return new Humano("Humano" + indice);
        }
        return null;
    }

    void generarEjercitos()
    {
        for(int i = 0; i < elementos; i = i + 1)
        {
            bestias[i] = getBestia(Extras.dado(1), i);
            heroes[i] = getHeroe(Extras.dado(2), i);
        }
    }
    
    Ejercitos(int elementos)
    {
        this.elementos = elementos;
        bestias = new Bestia[this.elementos];
        heroes = new Heroe[this.elementos];
    }

    void turno(Bestia bestia, Heroe heroe)
    {
        heroe.danio(bestia);
    }
    void turno(Heroe heroe, Bestia bestia)
    {
        bestia.danio(heroe);
    }

}
