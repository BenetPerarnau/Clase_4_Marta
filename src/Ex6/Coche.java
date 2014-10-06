package Ex6;

public class Coche extends Vehiculo{
protected int plazas;
	
	public Coche(String matricula, int dias_alquiler, int plazas){
		super (matricula,dias_alquiler);
		this.plazas=plazas;
	}
	public double get_precio_alquiler(){
		this.precio_alquiler=(dias_alquiler*precio_dia)+(dias_alquiler*(plazas*1.5)); //1.5 por plaza i dia
		return precio_alquiler;
	}
	protected int getPlazas() {
		return plazas;
	}
	protected void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
}
