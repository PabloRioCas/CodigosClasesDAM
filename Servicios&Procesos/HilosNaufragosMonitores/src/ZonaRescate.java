import java.util.LinkedList;
import java.util.Queue;

public class ZonaRescate {
    private Queue<Naufrago> naufragos; // utilizamos FIFO para que los primeros naufragos en ser agregados seran los primeros en ser rescatados

    public ZonaRescate(Naufrago[] naufragosArray) {
        naufragos = new LinkedList<>();
        for (Naufrago naufrago : naufragosArray) {
            naufragos.add(naufrago);
        }
    }

    public synchronized Naufrago[] rescatar(int capacidad) {
        while (naufragos.isEmpty()) {
            notifyAll(); // Notificar a todas las balsas que ya no hay náufragos
            return new Naufrago[0]; // No hay más náufragos por rescatar
        }

        int rescatar = Math.min(capacidad, naufragos.size());
        Naufrago[] rescatados = new Naufrago[rescatar];

        for (int i = 0; i < rescatar; i++) {
            rescatados[i] = naufragos.poll();
        }

        // Notificar si ya no quedan naufragos
        if (naufragos.isEmpty()) {
            notifyAll();
        }

        return rescatados;
    }
}