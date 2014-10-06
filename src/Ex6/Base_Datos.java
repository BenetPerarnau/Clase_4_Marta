package Ex6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Base_Datos {

	
	public static ArrayList<String[]> bbdd2=new ArrayList<String[]>();//leer archivo
	public static ArrayList<Vehiculo[]> bbdd=new ArrayList<Vehiculo[]>();//poliformismo
	public static ArrayList<Coche[]> coches=new ArrayList<Coche[]>();
	public static ArrayList<Camion[]> camiones=new ArrayList<Camion[]>();
	public static ArrayList<Microbus[]> microbuses=new ArrayList<Microbus[]>();
	public static ArrayList<Vehiculo_Carga[]> cargas=new ArrayList<Vehiculo_Carga[]>();
	
	public static ArrayList<String[]> leer_bbdd(){
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
				 
			for(int i=0; i<bbdd2.size(); i++){
				System.out.println("aki0");
				if(bbdd2.get(i)[5].equalsIgnoreCase("Camion")){
					System.out.println("aki1");
					bbdd.get(i)[0]=new Camion(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]));//peta aki
					System.out.println("aki2");
					Camion c=(Camion) bbdd.get(i)[0];
					camiones.get(i)[0]=c;
					System.out.println("aki3");
					
				}else if(bbdd2.get(i)[5].equalsIgnoreCase("Coche")){			
					
					bbdd.get(i)[0]=new Coche(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
					Coche c=(Coche) bbdd.get(i)[0];
					coches.get(i)[0]=c;
					
				}else if(bbdd2.get(i)[5].equalsIgnoreCase("Microb")){
					
					bbdd.get(i)[0]=new Microbus(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
					Microbus c=(Microbus) bbdd.get(i)[0];
					microbuses.get(i)[0]=c;
					
				}else{//Vehíedculos de carga
					
					bbdd.get(i)[0]=new Vehiculo_Carga(bbdd2.get(i)[0], Integer.parseInt(bbdd2.get(i)[2]), Integer.parseInt(bbdd2.get(i)[4]));
					
					Vehiculo_Carga c=(Vehiculo_Carga) bbdd.get(i)[0];
					cargas.get(i)[0]=c;
					
				}
			}
		}catch(Exception e){
			System.out.println("Error en cargar el archivo");			
		}
		
		return bbdd2;
	}
	
	public static void Escribir_Bbdd(ArrayList<String[]> bbdd2, ArrayList<Coche[]> coches_n,ArrayList<Camion[]> camiones_n,ArrayList<Microbus[]> microbuses_n,ArrayList<Vehiculo_Carga[]> cargas_n){
		
		FileWriter fichero=null;
		PrintWriter pw=null;
		try{
		fichero=new FileWriter("src/Ex6/datos.txt");
		pw=new PrintWriter(fichero);
				//	     0;        1;     2;   3;   4;    5;
				//matricula;precio_dia;dias;total;op;tipo_coche;
		for(int i=0; i<bbdd2.size(); i++){//imprimira lo que ya teniamos en la BBDD
			
			if(bbdd2.get(i)[5].equalsIgnoreCase("Coche")){
				pw.println(coches.get(i)[0].matricula+";"+coches.get(i)[0].precio_dia+";"+coches.get(i)[0].dias_alquiler+";"+coches.get(i)[0].precio_alquiler+";"+coches.get(i)[0].plazas+"Coche;");
			}else if(bbdd2.get(i)[5].equalsIgnoreCase("Camion")){
				pw.println(camiones.get(i)[0].matricula+";"+camiones.get(i)[0].precio_dia+";"+camiones.get(i)[0].dias_alquiler+";"+camiones.get(i)[0].precio_alquiler+";null;Camion;");
			}else if(bbdd2.get(i)[5].equalsIgnoreCase("Microb")){
				pw.println(microbuses.get(i)[0].matricula+";"+microbuses.get(i)[0].precio_dia+";"+microbuses.get(i)[0].dias_alquiler+";"+microbuses.get(i)[0].precio_alquiler+";"+microbuses.get(i)[0].plazas+"Microb;");
			}else{//de carga
				pw.println(cargas.get(i)[0].matricula+";"+cargas.get(i)[0].precio_dia+";"+cargas.get(i)[0].dias_alquiler+";"+cargas.get(i)[0].precio_alquiler+";"+cargas.get(i)[0].Pma+"V.Carga;");
			}	
		}
		for(int i=0; i<coches_n.size(); i++){
			pw.println(coches_n.get(i)[0].matricula+";"+coches_n.get(i)[0].precio_dia+";"+coches_n.get(i)[0].dias_alquiler+";"+coches_n.get(i)[0].precio_alquiler+";"+coches_n.get(i)[0].plazas+"Coche;");
		}
		for(int i=0; i<camiones_n.size(); i++){
			pw.println(camiones_n.get(i)[0].matricula+";"+camiones_n.get(i)[0].precio_dia+";"+camiones_n.get(i)[0].dias_alquiler+";"+camiones_n.get(i)[0].precio_alquiler+";null;Camion;");
		}
		for(int i=0; i<microbuses_n.size(); i++){
			pw.println(microbuses_n.get(i)[0].matricula+";"+microbuses_n.get(i)[0].precio_dia+";"+microbuses_n.get(i)[0].dias_alquiler+";"+microbuses_n.get(i)[0].precio_alquiler+";"+microbuses_n.get(i)[0].plazas+"Microb;");
		}
		for(int i=0; i<cargas_n.size(); i++){
			pw.println(cargas_n.get(i)[0].matricula+";"+cargas_n.get(i)[0].precio_dia+";"+cargas_n.get(i)[0].dias_alquiler+";"+cargas_n.get(i)[0].precio_alquiler+";"+cargas_n.get(i)[0].Pma+"V.Carga;");
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
	
	
	
}
