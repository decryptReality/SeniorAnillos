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

    int bestiasVivas()
    {    
        int vivos = 0;
        for(int i = 0; i < elementos; i = i + 1)
        {
            if(0 < bestias[i].getVida())
            {
                vivos = vivos + 1;
            }
        }
        return vivos;
    }

    int heroesVivos()
    {
        int vivos = 0;
    
        for(int i = 0; i < elementos; i = i + 1)
        {
            if(0 < heroes[i].getVida())
            {
                vivos = vivos + 1;
            }
        }
        return vivos;
    }

    boolean ejecutar(boolean empiezaBestias)
    {
        int bestias = 0;
        int heroes = 0;
        while (bestias != 0 | heroes != 0)
        {
            if(empiezaBestias)
            {
                turno(true);
                turno(false);
            }
            else
            {
                turno(false);
                turno(true);
            }
            bestias = bestiasVivas();
            heroes = heroesVivos();
        }
        return bestias > heroes ? true : false;
    }

    void turno(boolean esTurnoBestias)
    {
        if (esTurnoBestias)
        {
            for (int i = 0; i < elementos; i = i + 1) 
            {
                if(0 < heroes[i].getVida())
                {
                    heroes[i].danio(bestias[i]);
                }
            }
        }
        else
        {
            for (int i = 0; i < elementos; i = i + 1) 
            {
                if(0 < heroes[i].getVida())
                {
                    bestias[i].danio(heroes[i]);
                }
            }
        }
    }
    void ataque(Bestia bestia, Heroe heroe)
    {
        heroe.danio(bestia);
    }
    void ataque(Heroe heroe, Bestia bestia)
    {
        bestia.danio(heroe);
    }

}
