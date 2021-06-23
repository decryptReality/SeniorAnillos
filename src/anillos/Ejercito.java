package anillos;

import java.util.Random;

import anillos.bestias.Orco;
import anillos.bestias.Trasgo;
import anillos.heroes.Elfo;
import anillos.heroes.Hobbit;
import anillos.heroes.Humano;

public class Ejercito 
{
    int elementos;
    Random random = new Random();
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

    }
    Ejercito(int elementos)
    {
        this.elementos = elementos;
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
