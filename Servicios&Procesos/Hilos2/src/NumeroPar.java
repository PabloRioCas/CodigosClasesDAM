public class NumeroPar implements Runnable {

    @Override
    public void run() {
         // Esto sincroniza la sección crítica
            int suma = 0;
            System.out.println("Números pares:");
            
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {  // Verifica si el número es par
                    System.out.println(i);
                    suma += i;  // Agrega el número par a la suma
                }
            }
            
            System.out.println("Suma de números pares: " + suma);
        }
    }
