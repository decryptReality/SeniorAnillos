package anillos;

public class Ejecucion 
{
    public static void main(String[] args) 
    {
        Ejercitos ejercitos = new Ejercitos(3);
        ejercitos.turnos(Extras.moneda());
    }
    
}
