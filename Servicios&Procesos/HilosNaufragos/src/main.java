import java.util.concurrent.Semaphore;

public class main {

	public static void main(String[] args) {
		int numNaufragos = 10; //declaro el numero de naufragos
		final int numBalsas = 3; // declaro el numero constante de balsas
		Semaphore accesoZona = new Semaphore (1); //declaro que solo 1 balsa a la vez puede acceder usando un semaforo
		
		Naufrago[] naufragos = new Naufrago [numNaufragos]; //creo a los naufragos
		for (int i = 0; i < numNaufragos; i++) {
			naufragos [i] = new Naufrago (i + 1);		
		}
		
		Thread[] balsas = new Thread[numBalsas]; //creo las balsas con una capacidad aleatoria entre 1 y 5 y las inicio
        for (int i = 0; i < numBalsas; i++) {
            int capacidad = (int) (Math.random() * 5) + 1; 
            balsas[i] = new Thread(new Balsa(capacidad ,i + 1 , accesoZona));
            balsas[i].start();
        }
        
        for (Thread balsa : balsas) {
            try {
                balsa.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }
        }

        System.out.println("Todos los náufragos han sido rescatados.");
    }

}
