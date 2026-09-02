public class main {
    public static void main(String[] args) {
        int numNaufragos = 10;
        final int numBalsas = 3;

        // Se crean los naufragos
        Naufrago[] naufragos = new Naufrago[numNaufragos];
        for (int i = 0; i < numNaufragos; i++) {
            naufragos[i] = new Naufrago(i + 1);
        }

        // Se crea la zona de rescate
        ZonaRescate zonaRescate = new ZonaRescate(naufragos);

        //Se crean e inician las balsas
        Thread[] balsas = new Thread[numBalsas];
        for (int i = 0; i < numBalsas; i++) {
            int capacidad = (int) (Math.random() * 5) + 1;
            balsas[i] = new Thread(new Balsa(capacidad, i + 1, zonaRescate));
            balsas[i].start();
        }

        //Esperar a que las balsas terminen de rescatar
        for (Thread balsa : balsas) {
            try {
                balsa.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nFin del rescate.");
    }
}
