
public class main {

	public static void main(String[] args) {
		
		NumeroPar numeroPar1 = new NumeroPar();
        NumeroPar numeroPar2 = new NumeroPar();
        NumeroImpar numeroImpar1 = new NumeroImpar();
        NumeroImpar numeroImpar2 = new NumeroImpar();

        // Creo los hilos
        Thread hiloPar1 = new Thread(numeroPar1);
        Thread hiloPar2 = new Thread(numeroPar2);
        Thread hiloImpar1 = new Thread(numeroImpar1);
        Thread hiloImpar2 = new Thread(numeroImpar2);

        // inicio los hilos
        hiloPar1.start();
        hiloPar2.start();
        hiloImpar1.start();
        hiloImpar2.start();
    }


	}
