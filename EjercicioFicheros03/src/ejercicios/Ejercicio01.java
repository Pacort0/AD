package ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio01 {

	public static void main(String[] args) {
		try {
			//Fichero a leer
			FileReader fr = new FileReader("C:\\Users\\frodriguez\\git\\repository\\EjercicioFicheros02\\palabrasSeparadas.txt");
			BufferedReader br = new BufferedReader(fr);
			//Fichero en el que escribiremos
			BufferedWriter bw = new BufferedWriter(new FileWriter("palabrasSeparadasOrdenadas.txt"));
			//Lista en la que guardaremos y ordenadoremos las palabras del texto a leer 
			List<String> palabras = new ArrayList<String>();
			
			String linea = br.readLine(); //Leemos la primera linea
			while(linea!=null) { //Mientras la línea leída no sea null
				palabras.add(linea); //Añadimos la palabra leída a la lista
				linea = br.readLine(); //Leemos la siguiente línea
			}
			
			palabras.sort(null); //Ordenamos las palabras (se le pasa por parámetros un criterio de comparación o 'Comparator')
			//Si el comparador se deja en null, se usará la interfaz 'Comparable' y se ordenarán por orden alfabético
		
			for (String palabra:palabras) { //Por cada palabra de la lista
				bw.write(palabra + "\n"); //Escribimos la palabra con un espacio
				System.out.println("Donete");
			}
			br.close(); //Cerramos los bufferedReaders y Writers
			bw.flush();
			bw.close();
			
		} catch (FileNotFoundException e) { //Excepciones
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
