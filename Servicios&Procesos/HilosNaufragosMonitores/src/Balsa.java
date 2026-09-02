public class Balsa implements Runnable {

    private int capacidad; 
    private int numeroBalsa; 
    private ZonaRescate zonaRescate; // Monitor para gestionar rescates

    public Balsa(int capacidad, int numeroBalsa, ZonaRescate zonaRescate) {
        this.capacidad = capacidad;
        this.numeroBalsa = numeroBalsa;
        this.zonaRescate = zonaRescate;
    }

    @Override
    public void run() {
        try {
            // Retraso inicial aleatoria para forzar que la primera barca que entra sea una aleatoria y no siempre la primera
            Thread.sleep((int) (Math.random() * 1000));

            while (true) {
                Naufrago[] rescatados = zonaRescate.rescatar(capacidad);
                if (rescatados.length == 0) {
                    break; // No hay más náufragos por rescatar
                }

                synchronized (System.out) {
                    System.out.printf(
                        "\n========== Evento en Zona de Rescate ==========\n" +
                        "Balsa %d ha entrado en la zona de rescate.\n" +
                        "Capacidad de la balsa: %d náufragos.\n",
                        numeroBalsa, capacidad
                    );

                    System.out.printf(
                        "Balsa %d está rescatando a %d náufragos: ",
                        numeroBalsa, rescatados.length
                    );

                    for (Naufrago naufrago : rescatados) {
                        System.out.printf("Náufrago %d ", naufrago.getNumeroNaufrago());
                    }
                    System.out.println();

                   

                    System.out.printf(
                        "Balsa %d ha completado el rescate y ha salido de la zona.\n" +
                        "===============================================\n",
                        numeroBalsa
                    );
                    // Simular el tiempo de rescate
                    Thread.sleep(2500);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}