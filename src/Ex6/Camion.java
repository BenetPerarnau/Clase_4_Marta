package Ex6;

public class Camion extends Vehiculo {

	public Camion(String matricula, int dias_alquiler){
		
		super (matricula, dias_alquiler);
	}
	public  double get_precio_alquiler(){
		this.precio_alquiler=((dias_alquiler*precio_dia)+40); //50€ cada dia mas 40€ al total
		return precio_alquiler;
	}
}
