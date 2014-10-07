package Ex3;

public abstract class Empleado {
	
	protected static double sueldobase=1000;
	
	public Empleado(double incremento){
		sueldobase=1000+incremento;
	}

	public double getSueldoBase(){
	
		return sueldobase;
	}

}
