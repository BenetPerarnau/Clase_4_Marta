package Ex5;

public class TestArrayReales {

	public static void main(String[] args){
		
		ArrayReales a=new ArrayReales();
		
		a.asigna();//rellenar array
		a.imprimir();//imprimir para poder comprobar si hace bien el max min....
		System.out.println("Numero maximo => "+a.maximo());
		System.out.println("Numero minimo => "+a.minimo());
		System.out.println("Media => "+a.media());
		System.out.println("Sumatorio  => "+a.sumatorio());
		
	}
}
