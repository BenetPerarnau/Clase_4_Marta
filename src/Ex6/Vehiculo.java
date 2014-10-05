package Ex6;

public abstract class  Vehiculo {
	
	protected String matricula;
	protected int dias_alquiler;
	protected static double precio_dia=50; //50E dia aqluiler siempre
	protected double precio_alquiler;
	
	public Vehiculo(String matricula, int dias_alquiler){
		this.matricula=matricula;
		this.dias_alquiler=dias_alquiler;
	}
	public abstract double get_precio_alquiler();//cada subclase tiene que implementarlo

	protected String getMatricula() {
		return matricula;
	}
	protected void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	protected int getDias_alquiler() {
		return dias_alquiler;
	}
	protected void setDias_alquiler(int dias_alquiler) {
		this.dias_alquiler = dias_alquiler;
	}
	protected static double getPrecio_dia() {
		return precio_dia;
	}
	protected static void setPrecio_dia(double precio_dia) {
		Vehiculo.precio_dia = precio_dia;
	}
	protected double getPrecio_alquiler() {
		return precio_alquiler;
	}
	protected void setPrecio_alquiler(double precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}
}

