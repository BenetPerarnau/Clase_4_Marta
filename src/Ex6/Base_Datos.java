package Ex6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Base_Datos {
	
	public static ArrayList<Vehiculo> flota;
	 	
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
			//matricula;precio_dia;dias;total;op;tipo_coche;   //op=> Plazas op=> PMA
			
			flota=new ArrayList<Vehiculo>();
			
			while((linea=br.readLine())!=null){
			 String[] vehiculo=linea.split(";");
			 if (vehiculo[5].equals("Coche")){
				 
				 flota.add(new Coche(vehiculo[0], Integer.parseInt(vehiculo[2]), Integer.parseInt(vehiculo[4])));
			 
			 }else if(vehiculo[5].equals("Camion")){
			
				 flota.add(new Camion(vehiculo[0], Integer.parseInt(vehiculo[2]))); 
			
			 }else if(vehiculo[5].equals("Microb")){
				 
				 flota.add(new Microbus(vehiculo[0], Integer.parseInt(vehiculo[2]),Integer.parseInt(vehiculo[4])));
			 
			 }else {
				 
				 flota.add(new Vehiculo_Carga(vehiculo[0], Integer.parseInt(vehiculo[2]),Integer.parseInt(vehiculo[4])));	 
			 }
			
			fr.close();
			
			}
		}catch(Exception e){
			System.out.println("Error en cargar el archivo");			
		}
		
		return flota;
	}
	
	public static void Escribir_Bbdd(ArrayList<Vehiculo> flota){
		
		FileWriter fichero=null;
		PrintWriter pw=null;
		try{
		fichero=new FileWriter("src/Ex6/datos.txt");
		pw=new PrintWriter(fichero);
				//	     0;        1;     2;   3;   4;    5;
				//matricula;precio_dia;dias;total;op;tipo_coche;
		for(int i=0; i<flota.size(); i++){
			if(flota.get(i) instanceof Coche ){
				Coche a=(Coche) flota.get(i);
				pw.println(a.matricula+";"+a.precio_dia+";"+a.dias_alquiler+";"+a.precio_alquiler+";"+a.plazas+";Coche;");
			}else if(flota.get(i) instanceof Camion){
				Camion a=(Camion)flota.get(i);
				pw.println(a.matricula+";"+a.precio_dia+";"+a.dias_alquiler+";"+a.precio_alquiler+";null;Camion;");
			}else if(flota.get(i) instanceof Vehiculo_Carga){
				Vehiculo_Carga a=(Vehiculo_Carga) flota.get(i);
				pw.println(a.matricula+";"+a.precio_dia+";"+a.dias_alquiler+";"+a.precio_alquiler+";"+a.Pma+";V.Carga;");
				
			}else{
				Microbus a=(Microbus) flota.get(i);
				pw.println(a.matricula+";"+a.precio_dia+";"+a.dias_alquiler+";"+a.precio_alquiler+";"+a.plazas+";Microb;");
			}
		}
		
		pw.close();
		
		}catch(Exception e){
			System.out.println("Error en añadir Vehiculo en la BBDD");
		}
		
	}
	
	public static void imprimir_lista(){
		
		if(flota.size()==0){Base_Datos.leer_bbdd();}
		
		System.out.println("Lista de vehiculos en alquiler:");
		System.out.println("TIPO\tMATRICULA   P.DIA  PLAZAS/PMA");
		
		for(int i=0; i<flota.size(); i++){
			if(flota.get(i) instanceof Coche ){
				Coche a=(Coche) flota.get(i);
				System.out.println("COCHE\t"+a.matricula+"  "+a.precio_dia+"\t"+a.plazas);
			}else if(flota.get(i) instanceof Camion){
				System.out.println("CAMION\t"+flota.get(i).matricula+"  "+flota.get(i).precio_dia);
			}else if(flota.get(i) instanceof Vehiculo_Carga){
				Vehiculo_Carga a=(Vehiculo_Carga) flota.get(i);
				System.out.println("V.CARGA\t"+a.matricula+"  "+a.precio_dia+"\t"+a.Pma);
			}else{
				Microbus a=(Microbus) flota.get(i);
				System.out.println("M.BUS\t"+a.matricula+"  "+a.precio_dia+"\t"+a.plazas);
			}
		}
	}	
}
