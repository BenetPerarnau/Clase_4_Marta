package Ex4;

public class Dado extends Sorteo {
	
	int premio;


	
	public Dado(int maxNumLanzamientos){
		this.maxNumLanzaminetos=maxNumLanzamientos;
		this.numLanzaminetos=0;
		this.premio=(int)(Math.random()*6+1);// de 1 a 6
	}

	public int lanzar() {
		int valor=-1;
		if(this.numLanzaminetos<this.maxNumLanzaminetos){
			this.numLanzaminetos++;
			int aleatorio=(int)(Math.random()*6+1);
			if(aleatorio==this.premio){
				System.out.println("Lanzamiento con premio");
				valor=0;
			}else{
				valor=1;
			}
		}else if(this.numLanzaminetos==this.maxNumLanzaminetos){
			System.out.println("Agotados los lanzamientos");
			valor=-1;
		}
		return valor;
	}
	
}
