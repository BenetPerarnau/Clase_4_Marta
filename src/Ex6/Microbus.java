package Ex6;

public class Microbus extends Vehiculo {
	protected int plazas;
	public Microbus(String matricula, int dias_alquiler, int plazas){
		super(matricula,dias_alquiler);
		this.plazas=plazas;
		
	}
public double get_precio_alquiler(){
	this.precio_alquiler=(dias_alquiler*precio_dia)+(2*plazas);
		return precio_alquiler;
	}
protected int getPlazas() {
	return plazas;
}
protected void setPlazas(int plazas) {
	this.plazas = plazas;
}

}
