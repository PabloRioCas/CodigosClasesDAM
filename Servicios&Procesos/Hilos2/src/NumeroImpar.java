public class NumeroImpar implements Runnable {

    @Override
    public void run() {
       // Esto sincroniza la sección crítica
            int suma = 0;
            System.out.println("Números impares:");
            
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {  // Verifica si el número es impar
                    System.out.println(i);
                    suma += i;  // Agrega el número impar a la suma
                }
            }
            
            System.out.println("Suma de números impares: " + suma);
        }
    }
