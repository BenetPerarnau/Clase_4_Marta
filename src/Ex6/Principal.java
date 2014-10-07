package Ex6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	private static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<Coche> coches=new ArrayList<Coche>();
	public static ArrayList<Camion> camiones=new ArrayList<Camion>();
	public static ArrayList<Microbus> microbuses=new ArrayList<Microbus>();
	public static ArrayList<Vehiculo_Carga> cargas=new ArrayList<Vehiculo_Carga>();
	public static void main(String[] args) {
		Vehiculo[] array;
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
				break;
			case 2: //añadir vehiculo
				byte op1=0;
				coches.clear();
				camiones.clear();
				microbuses.clear();
				cargas.clear();
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
					Coche a=new Coche(matricula, dias_alquiler, plazas);
					coches.add(a);
					Base_Datos.Escribir_Bbdd( coches, camiones, microbuses, cargas);
					break;
				case 2://Camion
					Camion b=new Camion(matricula,dias_alquiler);
					camiones.add(b);
					Base_Datos.Escribir_Bbdd( coches, camiones, microbuses, cargas);
					break;
				case 3://Microbus
					plazas=0;
					try{
						System.out.print("Introduce el numero de plazas => ");
						plazas=Integer.parseInt(stdin.readLine());
					}catch(Exception e){
						System.out.println("valor fuera de rango");
					}
					Microbus c=new Microbus(matricula, dias_alquiler, plazas);
					microbuses.add(c);
					Base_Datos.Escribir_Bbdd( coches, camiones, microbuses, cargas);
					break;
				case 4://Vehiculo de carga
					int pma=0;
					try{
						System.out.print("Introduce el PMA => ");
						pma=Integer.parseInt(stdin.readLine());
					}catch(Exception e){
						System.out.println("valor fuera de rango");
					}
					Vehiculo_Carga d=new Vehiculo_Carga(matricula, dias_alquiler, pma);
					cargas.add(d);
					Base_Datos.Escribir_Bbdd(coches, camiones, microbuses, cargas);
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
				
				for(int i=0; i<array.length; i++){
					if(array[i].matricula.equalsIgnoreCase(matricula)){
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
						array[i].dias_alquiler=dias;
						System.out.println("El alquiler sube a => "+array[i].get_precio_alquiler()+"€");
					}
				}
				break;
			case 4: //salir
				
				break;
				default:
					
					break;
			}
			
		}while(op!=4);
		/*
		Coche a=new Coche("3241324-GND",10,5);
		
			System.out.println("Precio Coche => "+a.get_precio_alquiler());
			System.out.println("Dias en alquiler => "+a.getDias_alquiler());
		
		Microbus b=new Microbus("414312-XCZ",10,19);
		
			System.out.println("Precio Microbus => "+b.get_precio_alquiler());
		
		Camion c=new Camion("324324-RQE",10);
			
			System.out.println("Precio camion => "+c.get_precio_alquiler());
		
		Vehiculo_Carga d=new Vehiculo_Carga("23141-SDS",2,5000);
			
			System.out.println("Precio Vehiculo de carga => "+d.get_precio_alquiler());
			*/
	}

}
