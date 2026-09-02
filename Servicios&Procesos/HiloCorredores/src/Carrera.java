import java.util.Random;

public class Carrera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread corredor1 = new Thread(new Corredor("Corredor 1"));
		Thread corredor2 = new Thread(new Corredor("Corredor 2"));
		Thread corredor3 = new Thread(new Corredor("Corredor 3"));

		corredor1.start();
		corredor2.start();
		corredor3.start();
		
	}

}

class Corredor implements Runnable {
	private String nombre;
	private int distanciaRecorrida = 0;
	private static final int META = 100;
	private static boolean hayGanador = false;
	
	public Corredor (String nombre) {
		this.nombre = nombre;
	}
	public void run() {
        Random random = new Random();

        while (!hayGanador && distanciaRecorrida < META) {
            // Avanzar una distancia aleatoria entre 1 y 10 metros
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;

            System.out.printf("%s ha avanzado %d metros (Total: %d metros)%n",
                    nombre, avance, distanciaRecorrida);

            // Verificar si alcanzó la meta
            if (distanciaRecorrida >= META && !hayGanador) {
                hayGanador = true;
                System.out.printf("¡%s ha ganado la carrera!%n", nombre);
            }

            // Pausa para simular el tiempo de avance
            try {
                Thread.sleep(500); // 500 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
