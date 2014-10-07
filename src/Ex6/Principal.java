package Ex6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	private static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList <Vehiculo> array;
	public static void main(String[] args) {
		
		byte op=0;
		do{
			System.out.println("1. Cargar datos de inicio");
			System.out.println("2. Añadir Vehiculo");
			System.out.println("3. Obtener precio de Alquiler");
			System.out.println("4. Salir");
			try{
				System.out.print("Introduce la op => ");
				op=Byte.parseByte(stdin.readLine());
			}catch(Exception e){
				System.out.println("Valor fuera de rango");
			}
			switch (op){
			case 1:// Cargar datos
				array=Base_Datos.leer_bbdd();
				Base_Datos.imprimir_lista();
				break;
			case 2: //añadir vehiculo
				byte op1=0;
				do{
					System.out.println("Añadir Vehiculo:");
					System.out.println("1) Coche");
					System.out.println("2) Camion");
					System.out.println("3) Microbus");
					System.out.println("4) Vehiculo de Carga");
					try{
					System.out.print("Que deseas añadir => ");
					op1=Byte.parseByte(stdin.readLine());
					}catch(Exception e){
						System.out.println("Valor fuera de rango");
					}			
				}while(op1<1 || op1>4);
				
				String matricula="";
				int dias_alquiler=0;
				try{
				System.out.print("Introduce la matricula del vehiculo => ");
				matricula=stdin.readLine();
				dias_alquiler=0;
				}catch(Exception e){
					System.out.println("Valor fuera de rango");
				}
				switch(op1){
				case 1://coche
					int plazas=0;
					try{
						System.out.print("Introduce el numero de plazas => ");
						plazas=Integer.parseInt(stdin.readLine());
					}catch(Exception e){
						System.out.println("valor fuera de rango");
					}
					
					array.add(new Coche(matricula,dias_alquiler,plazas));
					
					Base_Datos.Escribir_Bbdd( array);
					
					break;
				case 2://Camion
					
					array.add(new Camion(matricula,dias_alquiler));
					
					Base_Datos.Escribir_Bbdd(array);
					
					break;
				case 3://Microbus
					
					plazas=0;
					try{
						System.out.print("Introduce el numero de plazas => ");
						plazas=Integer.parseInt(stdin.readLine());
					}catch(Exception e){
						System.out.println("valor fuera de rango");
					}
					
					array.add(new Microbus(matricula, dias_alquiler, plazas));
					
					Base_Datos.Escribir_Bbdd( array);
					
					break;
				case 4://Vehiculo de carga
					int pma=0;
					try{
						System.out.print("Introduce el PMA => ");
						pma=Integer.parseInt(stdin.readLine());
					}catch(Exception e){
						System.out.println("valor fuera de rango");
					}
					
					array.add(new Vehiculo_Carga(matricula, dias_alquiler, pma));
					
					Base_Datos.Escribir_Bbdd(array);
					
					break;
					default:
						break;
				}
				break;
			case 3://obtener alquiler
				
				matricula="";
				array=Base_Datos.leer_bbdd();
				Base_Datos.imprimir_lista();
				
				try{
					System.out.print("Introduce la matricula => ");
					matricula=stdin.readLine();
					
				}catch(Exception e){
					System.out.println("Valor fuera de rango");
				}
				boolean encontrado=false;
				for(int i=0; i<array.size(); i++){
					if(array.get(i).matricula.equalsIgnoreCase(matricula)){
						boolean entra=false;
						int dias=0;
						do{
						try{
							System.out.print("Dias que lo tendra alquilado => ");
							dias=Integer.parseInt(stdin.readLine());
							entra=true;
						}catch(Exception e){
							System.out.println("Valor fuera de rango");
							entra=false;
						}
						}while(entra==false);
						array.get(i).dias_alquiler=dias;
						if(array.get(i) instanceof Coche){
							Coche a=(Coche)array.get(i);
						System.out.println("El alquiler sube a => "+a.getPrecio_alquiler()+"€");
						}else if(array.get(i) instanceof Camion){
							Camion a=(Camion)array.get(i);
							System.out.println("Precio dia => "+a.precio_dia);
							System.out.println("Dias => "+a.dias_alquiler);
							System.out.println("El alquiler sube a => "+a.get_precio_alquiler()+"€");
						}else if(array.get(i) instanceof Vehiculo_Carga){
							Vehiculo_Carga a=(Vehiculo_Carga)array.get(i);
							System.out.println("El alquiler sube a => "+a.get_precio_alquiler()+"€");
						}else{
							Microbus a=(Microbus) array.get(i);
							System.out.println("El alquiler sube a => "+a.get_precio_alquiler()+"€");
							encontrado=true;
						}
					}
				}
				if(encontrado==false){
					System.out.println("La matricula introducida ("+matricula+") no corresponde a ningun vehiculo.");
				}
				
				break;
			case 4: //salir
				
				break;
				default:
					System.out.println("La op => "+op+", no contempla ninguna acción.");
					break;
			}
			
		}while(op!=4);

	}

}
