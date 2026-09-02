
public class main {

	public static void main(String[] args) {
		 
		HiloPar HPar = new HiloPar("Hilo Par 1");
	    HiloPar Himpar = new HiloPar("Hilo Impar 1");
	    HiloImpar HPar2 =new HiloImpar("Hilo Par 2");
	    HiloImpar Himpar2 =new HiloImpar("Hilo Impar 2");
	     
	     //Iniciamos los hilos a la misma vez
	     
	     HPar.start();
	     Himpar.start();
	     HPar2.start();
	     Himpar2.start();
	     	//controlamos con un try catch y nos aseguramos que termine uno a la vez con un join. 
	     try {
	    	 HPar.join();
	    	 Himpar.join();
	    	 HPar2.join();
	    	 Himpar2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	     //Por ultimo imprimimos los datos. 
	     System.out.println("\n");
	     System.out.println("Todos los hilos han terminado. La suma de todos es:");
	     System.out.println("Suma de los números pares: " + HiloPar.getSumaPares());
	     System.out.println("Suma de los números impares: " + HiloImpar.getSumaImpares());
	     System.out.println("Suma total (pares + impares): " + (HiloPar.getSumaPares() + HiloImpar.getSumaImpares()));
	  
	     
	}

	}

