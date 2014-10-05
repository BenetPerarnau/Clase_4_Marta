package Ex6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Base_Datos {

	public static ArrayList<Vehiculo> bbdd=new ArrayList<Vehiculo>();
	public static ArrayList<String[]> bbdd2=new ArrayList<String[]>();
	
	public static ArrayList<Vehiculo> leer_bbdd(){
	
		File fichero=null;
		FileReader fr=null;
		BufferedReader br=null;
		try{
			
			fichero=new File("src/Ex6/datos.txt");
			fr=new FileReader(fichero);
			br=new BufferedReader(fr);
			
			String linea="";
			
			//     0;        1;     2;   3;   4;    5;
			//matricula;precio_dia;dias;total;op;tipo_coche;
			//op=> Plazas op=> PMA
			
			while((linea=br.readLine())!=null){
			bbdd2.add(linea.split(";"));	
			}
			fr.close();
	
			Camion a=null;

			for(int i=0; i<bbdd2.size(); i++){
				
				if(bbdd2.get(i)[5].equalsIgnoreCase("Camion")){
					
					a=new Camion(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]));
					
				}else if(bbdd2.get(i)[5].equalsIgnoreCase("Coche")){
					
					Coche b=new Coche(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
				}else if(bbdd2.get(i)[5].equalsIgnoreCase("Microbuses")){
					
					Microbus c=new Microbus(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
				}else{//Vehíedculos de carga
					
					Vehiculo_Carga d=new Vehiculo_Carga(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
				}
			}
			System.out.println(a.matricula);
			
		}catch(Exception e){
			System.out.println("Error en cargar el archivo");
			
		}
		
		return null;
	}
	
	
	
}
