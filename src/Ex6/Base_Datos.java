package Ex6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Base_Datos {

	
	public static ArrayList<String[]> bbdd2=new ArrayList<String[]>();//leer archivo
	public static Vehiculo[] bbdd;//poliformismo
	public static ArrayList<Coche> coches=new ArrayList<Coche>();
	public static ArrayList<Camion> camiones=new ArrayList<Camion>();
	public static ArrayList<Microbus> microbuses=new ArrayList<Microbus>();
	public static ArrayList<Vehiculo_Carga> cargas=new ArrayList<Vehiculo_Carga>();
	 
	
	public static Vehiculo[] leer_bbdd(){
		bbdd2.clear();
		coches.clear();
		camiones.clear();
		cargas.clear();
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
				 
			bbdd=new Vehiculo[bbdd2.size()];//poliformismo

					
			for(int i=0; i<bbdd2.size(); i++){
				if(bbdd2.get(i)[5].equalsIgnoreCase("Camion")){
					bbdd[i]=new Camion(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]));//peta aki
					Camion c=(Camion) bbdd[i];
					camiones.add(c);
					
				}else if(bbdd2.get(i)[5].equalsIgnoreCase("Coche")){			
					
					bbdd[i]=new Coche(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
					Coche c=(Coche) bbdd[i];
					coches.add(c);
					
				}else if(bbdd2.get(i)[5].equalsIgnoreCase("Microb")){
					
					bbdd[i]=new Microbus(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
					Microbus c=(Microbus) bbdd[i];
					microbuses.add(c);
					
				}else{//Vehíedculos de carga
					
					bbdd[i]=new Vehiculo_Carga(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
					Vehiculo_Carga c=(Vehiculo_Carga) bbdd[i];
					cargas.add(c);
					
				}
			}
		}catch(Exception e){
			System.out.println("Error en cargar el archivo");			
		}
		
		return bbdd;
	}
	
	public static void Escribir_Bbdd( ArrayList<Coche> coches_n,ArrayList<Camion> camiones_n,ArrayList<Microbus> microbuses_n,ArrayList<Vehiculo_Carga> cargas_n){
		
		FileWriter fichero=null;
		PrintWriter pw=null;
		try{
		fichero=new FileWriter("src/Ex6/datos.txt",true);
		pw=new PrintWriter(fichero);
				//	     0;        1;     2;   3;   4;    5;
				//matricula;precio_dia;dias;total;op;tipo_coche;
		pw.println();
		if(!(coches_n.isEmpty())){
		for(int i=0; i<coches_n.size(); i++){
			pw.println(coches_n.get(i).matricula+";"+coches_n.get(i).precio_dia+";"+coches_n.get(i).dias_alquiler+";"+coches_n.get(i).precio_alquiler+";"+coches_n.get(i).plazas+";Coche;");
		}
		}
		if(!(camiones_n.isEmpty())){
		for(int i=0; i<camiones_n.size(); i++){
			pw.println(camiones_n.get(i).matricula+";"+camiones_n.get(i).precio_dia+";"+camiones_n.get(i).dias_alquiler+";"+camiones_n.get(i).precio_alquiler+";null;Camion;");
		}
		}
		if(!(microbuses_n.isEmpty())){

		for(int i=0; i<microbuses_n.size(); i++){
			pw.println(microbuses_n.get(i).matricula+";"+microbuses_n.get(i).precio_dia+";"+microbuses_n.get(i).dias_alquiler+";"+microbuses_n.get(i).precio_alquiler+";"+microbuses_n.get(i).plazas+";Microb;");
		}
		}
		if(!(cargas_n.isEmpty())){
		for(int i=0; i<cargas_n.size(); i++){
			pw.println(cargas_n.get(i).matricula+";"+cargas_n.get(i).precio_dia+";"+cargas_n.get(i).dias_alquiler+";"+cargas_n.get(i).precio_alquiler+";"+cargas_n.get(i).Pma+";V.Carga;");
		}
		}
		pw.close();
		
		}catch(Exception e){
			System.out.println("Error en añadir Vehiculo en la BBDD");
		}
		
	}
	
	public static void imprimir_lista(){
		Base_Datos.leer_bbdd();
		System.out.println("Lista de vehiculos en alquiler:");
		System.out.println("TIPO\tMATRICULA  P.DIA  PLAZAS/PMA");
		for(int i=0; i<bbdd2.size(); i++){
			System.out.println(bbdd2.get(i)[5].toUpperCase()+"\t"+bbdd2.get(i)[0]+"  "+bbdd2.get(i)[1]+"    "+bbdd2.get(i)[4]);
		}
	}
	/*
000001-DSF;50;0;0;null;Camion;
000002-SDF;50;0;0;null;Camion;
000003-RRR;50;0;0;null;Camion;
000004-GFB;50;0;0;5;Coche;
000005-TRY;50;0;0;5;Coche;
000006-NVB;50;0;0;5;Coche;
000007-RTE;50;0;0;20;Microb;
000008-HGF;50;0;0;20;Microb;
000009-KTD;50;0;0;5000;V.Carga;
000010-THG;50;0;0;5000;V.Carga;
	 */
	
	
}
