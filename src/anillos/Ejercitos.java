package anillos;

import java.util.Scanner;

import anillos.bestias.Orco;
import anillos.bestias.Trasgo;
import anillos.heroes.Elfo;
import anillos.heroes.Hobbit;
import anillos.heroes.Humano;

public class Ejercitos 
{

    public static void main(String[] args) 
    {
        Ejercitos ejercitos = new Ejercitos(5);
        ejercitos.turnos(true);
    }

    static Scanner scanner = new Scanner(System.in);
    int elementos;
    Bestia[] bestias = {};
    Heroe[] heroes;

    Ejercitos(int elementos)
    {
        this.elementos = elementos;
        bestias = new Bestia[this.elementos];
        heroes = new Heroe[this.elementos];
        generarEjercitos();
    }

    void generarEjercitos()
    {
        for(int i = 0; i < elementos; i = i + 1)
        {
            bestias[i] = generarBestia(Extras.dado(1), i);
            heroes[i] = generarHeroe(Extras.dado(2), i);
        }
        System.out.println("[?] Ejercito de bestias:");
        for(int i = 0; i < elementos; i = i + 1)
        {
            System.out.println("(" + bestias[i].getVida() +","+ bestias[i].getResistencia() + ") " + bestias[i].getNombre());
        }
        System.out.println("\n[?] Ejercito de heroes:");
        for(int i = 0; i < elementos; i = i + 1)
        {
            System.out.println("(" + heroes[i].getVida() +","+ heroes[i].getResistencia() + ") " + heroes[i].getNombre());
        }
    }

    Bestia generarBestia(int caso, int indice)
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

    Heroe generarHeroe(int caso, int indice)
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

    void turnos(Boolean empiezaBestia)
    {
        int salir = 0;
        int bestiasVivas = elementos;
        int heroesVivos = elementos;
        while(bestiasVivas != 0 | heroesVivos != 0 & salir != -1)
        {
            if (empiezaBestia) 
            {
                System.out.println("\n[?] Turno de ejercito de bestias");
                turnoBestia();
                bestiasVivas = bestiasVivas();
                heroesVivos = heroesVivos();
                if(0 != bestiasVivas | 0 != heroesVivos)
                {
                    System.out.println("\n[?] Turno de ejercito de heroes");
                    turnoHeroe();
                    bestiasVivas = bestiasVivas();
                    heroesVivos = heroesVivos();
                }
            } 
            else 
            {
                System.out.println("[?] Turno de ejercito de heroes");
                turnoHeroe();
                bestiasVivas = bestiasVivas();
                heroesVivos = heroesVivos();
                if(0 != bestiasVivas | 0 != heroesVivos)
                {
                    System.out.println("[?] Turno de ejercito de bestias");
                    turnoBestia();
                    bestiasVivas = bestiasVivas();
                    heroesVivos = heroesVivos();
                }
            }
            System.out.println("Ingrese -1 para salir o 1 para continuar");
            salir = scanner.nextInt();
        }
        System.out.println("Bestias vivas: " + bestiasVivas);
        System.out.println("Heroes vivos: " + heroesVivos);
        String ganador = bestiasVivas > heroesVivos ? "bestias" : "heroes";
        System.out.println("[?] Ganaron: " + ganador);
    }

    void turnoBestia()
    {
        for (int i = 0; i < elementos; i = i + 1) 
        {
            // si ambos tienen vida
            if(0 < bestias[i].getVida() & 0 < heroes[i].getVida())
            {
                System.out.println(bestias[i].getNombre() + " ataca a " + heroes[i].getNombre());
                // heroe rescibe danio de bestia
                heroes[i].danio(bestias[i]);
            }
            else
            {
                // si la bestia tiene vida y el heroe no
                if(0 < bestias[i].getVida())
                {
                    // en [i+1,elementos-1] de heroes se busca uno con vida
                    for (int j = i + 1; j < elementos; j = j + 1) 
                    {
                        if (0 < heroes[j].getVida()) 
                        {
                            System.out.println(bestias[i].getNombre() + " ataca a " + heroes[j].getNombre());
                            // y se ataca
                            heroes[j].danio(bestias[i]);
                            break;
                        }
                    }
                }
            }
        }
    }

    void turnoHeroe()
    {
        for (int i = 0; i < elementos; i = i + 1) 
        {
            // si ambos tienen vida
            if(0 < heroes[i].getVida() & 0 < bestias[i].getVida())
            {
                System.out.println(heroes[i].getNombre() + " ataca a " + bestias[i].getNombre());
                // bestia recibe danio de heroe
                bestias[i].danio(heroes[i]);
            }    
            else 
            {
                // si heroe tiene vida y bestia no
                if (0 < heroes[i].getVida()) 
                {
                    // en [i+1,elementos-1] de bestias se busca uno con vida
                    for (int j = i + 1; j < elementos; j = j + 1) 
                    {
                        if (0 < bestias[j].getVida()) 
                        {
                            System.out.println(heroes[i].getNombre() + " ataca a " + bestias[j].getNombre());
                            // bestia recibe danio de heroe
                            bestias[j].danio(heroes[i]);
                            break;
                        }
                    }
                }
            }
        }
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

}
