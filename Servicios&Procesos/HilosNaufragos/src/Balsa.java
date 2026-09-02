import java.util.concurrent.Semaphore;

public class Balsa implements Runnable {

	int capacidad;
	int numeroBalsa;
	private Semaphore accesoZona;

	protected Balsa(int capacidad, int numero, Semaphore accesoZona) {
		this.capacidad = capacidad;
		this.numeroBalsa = numero;
		this.accesoZona = accesoZona;
	}

	protected int getCapacidad() {
		return capacidad;
	}

	protected void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	protected int getNumero() {
		return numeroBalsa;
	}

	protected void setNumero(int numero) {
		this.numeroBalsa = numero;
	}

	
	@Override
	public void run() {
	    try {
	        accesoZona.acquire();
	        System.out.println("\n========== Zona de Rescate ==========");
	        System.out.printf("Balsa %d ha accedido a la zona de rescate.%n", numeroBalsa);
	        System.out.printf("Balsa %d está rescatando a %d náufragos.%n", numeroBalsa, capacidad);
	        System.out.printf("Balsa %d ha terminado de rescatar.%n", numeroBalsa);
	        Thread.sleep(2500); 
	        System.out.println("======================================\n");
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    } finally {
	        accesoZona.release();
	    }
	}
}
