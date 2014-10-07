package Ex4;

public class TestSorteo {
	
	public static void main(String[] args){
		
		Dado a=new Dado(5);
		byte cont=0;
		for(int i=0; i<7; i++){ //pq el enunciado dice que tires 7 veces
		if(a.lanzar()==0){
			cont++;
		}
		}
		System.out.println("Total de premios usando dados => "+cont);
		
		Moneda b=new Moneda(5);
		cont=0;
		for(int i=0; i<7; i++){ //pq el enunciado dice que tires 7 veces
		if(b.lanzar()==0){
			cont++;
		}
		}
		System.out.println("Total de premios usando Monedas => "+cont);
		
	}

}
