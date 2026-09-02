class NumeroPar implements Runnable {
    @Override
    public void run() {
        int suma = 0;
        synchronized (System.out) { // Bloqueo sincronizado para evitar interferencias en la impresion de datos. 
            System.out.println("Números pares:");
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    suma += i;
                }
            }
            System.out.println("Suma de números pares: " + suma);
        }
    }
}
