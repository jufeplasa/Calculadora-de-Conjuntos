package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	private static Scanner sc;
	private static List<String> UniversalSet= new ArrayList<String>();
	
	public static void main(String args[]) throws IOException {
		sc=new Scanner(System.in);
		
		Set<String> a = new HashSet<String>();
		crearConjuntos(a);
		
		Set<String> b = new HashSet<String>();
		crearConjuntos(b);
		System.out.println(a);
		System.out.println(b);
		boolean continuar=true;
		while(continuar) {
			int opcion;
			System.out.println("Que operacion desea ejecutar : ");
			System.out.println("1 Union");
			System.out.println("2 Interseccion ");
			System.out.println("3 Diferencia");
			System.out.println("4 Diferencia simetrica");
			System.out.println("5 Salir");
			opcion=sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			
			case 1:
				unionC(a, b);
				break;
			case 2:
				interseccionC(a, b);
				break;
			case 3:
				diferencia(a, b, "A-B");
				diferencia(b, a,"B-A");
				break;
			case 4:
				diferenciaSimetrica(a, b);
				break;
			case 5:
				continuar=false;
				break;
			}
		}
	}
	
	public static void crearConjuntos(Set<String> set) throws IOException {
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));

		String [] setElement;
		System.out.println ("Escriba elementos para el conjunto, separados por espacio:");
		
		String values=br.readLine();
		setElement=values.split("\\ ");
		for(int i=0;i<setElement.length;i++) {
			set.add(setElement[i]);
			for(int j=0;j<=UniversalSet.size();j++) {
				if(UniversalSet.isEmpty()) {
					UniversalSet.add(setElement[i]);
					j=UniversalSet.size()+1;
				}
				else if(UniversalSet.get(j).equalsIgnoreCase(setElement[i])==false) {
					UniversalSet.add(setElement[i]);
					j=UniversalSet.size()+1;
				}
			}
		}
		
	}

	public static void unionC(Set<String> A, Set<String> B) {
		Set<String> union = new HashSet<String>(A);
		union.addAll(B);
		System.out.print(" Union of the two Sets ");
		System.out.println(union);
	}

	public static void interseccionC(Set<String> A, Set<String> B) {

		Set<String> interseccion = new HashSet<String> (A);
		interseccion.addAll(B);
		for(int i=0; i<UniversalSet.size();i++) {
			if(A.contains(UniversalSet.get(i))==false || B.contains(UniversalSet.get(i))==false ) {
				interseccion.remove(UniversalSet.get(i));
			}
		}
		System.out.print("La interseccion de los conjuntos es :");
		System.out.println(interseccion);
	}

	public static void diferencia(Set<String> conjunto1, Set<String> conjunto2, String operation) {
		Set<String> diferencia = new HashSet<String> ();
		for(int i=0; i<UniversalSet.size();i++) {
			if(conjunto1.contains(UniversalSet.get(i)) && conjunto2.contains(UniversalSet.get(i))==false ) {
				diferencia.add(UniversalSet.get(i));
			}
		}
	
		
		System.out.print(operation+"  es :");
		System.out.println(diferencia);
	}
	
	public static void diferenciaSimetrica(Set<String> A, Set<String> B) {
		Set<String> diferenciaS = new HashSet<String> (A);
		diferenciaS.addAll(B);
		for(int i=0; i<UniversalSet.size();i++) {
			if(A.contains(UniversalSet.get(i)) && B.contains(UniversalSet.get(i)) ) {
				diferenciaS.remove(UniversalSet.get(i));
			}
		}
		System.out.print("La diferencia simetrica de los conjuntos es :");
		System.out.println(diferenciaS);
		
	}

	public static List<String> getUniversalSet() {
		return UniversalSet;
	}

}
