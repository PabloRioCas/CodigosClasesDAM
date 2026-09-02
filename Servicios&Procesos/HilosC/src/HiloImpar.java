
public class HiloImpar extends Thread {
	private static int sumaImpares = 0;
	private String nombre;


	public HiloImpar(String nombre) {
		super();
		this.nombre = nombre;
	}


	public static int getSumaImpares() {
		return sumaImpares;
	}


	public String getNombre() {
		return nombre;
	}


	public static void setSumaImpares(int sumaImpares) {
		HiloImpar.sumaImpares = sumaImpares;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
    public void run() {
        
        System.out.println(this.nombre + " Se esta ejecutando");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
            System.out.print(i + " ");
            sumaImpares += i;
            }
        }
        
    }
}
