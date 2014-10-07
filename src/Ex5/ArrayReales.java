package Ex5;

public class ArrayReales implements Estadisticas {
	
	double[] array;
	
	public void asigna(){
		array=new double[5];
		for(int i=0; i<array.length; i++){
			array[i]=Math.random()*101;
		}
	}

	
	public double maximo() {
		double max=0;
		for(int i=0; i<array.length; i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		return max;
	}

	
	public double minimo() {
		double min=100;//maximo valor posible que dipondran los valores del array
		for(int i=0; i<array.length; i++){
			if(array[i]<min){
				min=array[i];
			}
		}
		return min;
	}

	
	public double media() {
		double media=0;
		for(int i=0; i<array.length; i++){
			media+=array[i];
		}
		return media/array.length;
	}

	
	public double sumatorio() {
		double suma=0;
		for(int i=0; i<array.length; i++){
			suma+=array[i];
		}
		return suma;
	}

	public void imprimir() {
		for(int i=0; i<array.length; i++){
			if(i<array.length-1){
				System.out.print(array[i]+",");
			}else{
				System.out.println(array[i]);
			}
			
		}
		
	}
	

}
