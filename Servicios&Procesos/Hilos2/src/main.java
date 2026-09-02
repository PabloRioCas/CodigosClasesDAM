
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NumeroPar numeroPar = new NumeroPar();
        NumeroImpar numeroImpar = new NumeroImpar();
        
        // Crear los objetos Thread para cada uno
        Thread hiloPar1 = new Thread(numeroPar);
        Thread hiloPar2 = new Thread(numeroPar);
        Thread hiloImpar1 = new Thread(numeroImpar);
        Thread hiloImpar2 = new Thread(numeroImpar);
        
        // Iniciar los hilos
        hiloPar1.start();
        try {
            hiloPar1.join();  // Espera que hiloPar1 termine antes de continuar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        hiloPar2.start();
        try {
            hiloPar2.join();  // Espera que hiloPar1 termine antes de continuar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hiloImpar1.start();
        try {
            hiloImpar1.join();  // Espera que hiloImpar1 termine antes de continuar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        hiloImpar2.start();
        try {
            hiloImpar2.join();  // Espera que hiloImpar1 termine antes de continuar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

}
