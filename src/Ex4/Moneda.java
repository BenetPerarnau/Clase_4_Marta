package Ex4;

public class Moneda extends Sorteo {

	
	
	String premio;//cara o cruz
	
	public Moneda(int maxNumLanzamientos){
		this.maxNumLanzaminetos=maxNumLanzamientos;
		this.numLanzaminetos=0;
		int aux=(int)(Math.random()*2);// 0 o 1 si es 0=> Cara si es 1 => Cruz
		if(aux==0){
			this.premio="Cara";
		}else{
			this.premio="Cruz";
		}
	}
	
	
	public int lanzar() {
		int valor=-1;
		if(this.numLanzaminetos<this.maxNumLanzaminetos){
			this.numLanzaminetos++;//incrementar 1 lanzamiento
			int aux=(int)(Math.random()*2);// 0 o 1 si es 0=> Cara si es 1 => Cruz
			String aleatorio="";
			if(aux==0){
				aleatorio="Cara";
			}else{
				aleatorio="Cruz";
			}
			if(aleatorio.equalsIgnoreCase(this.premio)){
				System.out.println("Lanzamiento con premio");
				valor=0;
			}else{
				valor=-1;
			}
		}else if(this.numLanzaminetos==this.maxNumLanzaminetos){
			System.out.println("Agotados los lanzamientos");
			valor=-1;
		}
		return valor;
	}

}
