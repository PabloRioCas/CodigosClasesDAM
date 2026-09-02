
public class HiloPar extends Thread {
	private String nombre;
	private static int sumaPares =0;
	
	 public HiloPar(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public static int getSumaPares() {
		return sumaPares;
	}

	public static void setSumaPares(int sumaPares) {
		HiloPar.sumaPares = sumaPares;
	}

	@Override
	    public void run() {
	        System.out.println(this.nombre +" Se esta ejecutando");
	        for (int i = 1; i <= 10; i++) {
	            if (i % 2 == 0) {
	                System.out.print(i + " ");
	                sumaPares += i;
	                
	            }
	        }	        
	    }
}
