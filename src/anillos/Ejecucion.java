package anillos;

import java.util.Scanner;

public class Ejecucion 
{
    public static void main(String[] args) 
    {
        ingresarElementos();
    }
    
    static void ingresarElementos()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese la cantidad de elementos para cada ejercito:");
        int elementos = scanner.nextInt();
        Ejercitos ejercitos = new Ejercitos(elementos);
        ejercitos.turnos(Extras.moneda());
    }
}
