package Ex6;

final class Vehiculo_Carga extends Vehiculo{
	
	protected int Pma;
	public Vehiculo_Carga(String matricula, int dias_alquiler, int pma){
		super(matricula,dias_alquiler);
		this.Pma=pma;
	}
	public double get_precio_alquiler(){
		this.precio_alquiler=(dias_alquiler*precio_dia)+(20*Pma);
		return precio_alquiler;
	}
	protected int getPma() {
		return Pma;
	}
	protected void setPma(int pma) {
		Pma = pma;
	}

}
