package ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
	public static void main(String[] args) {
		File ficheroLeer = new File("palabras.txt");
		
		try {
			// new File("C:\\Users\\frodriguez\\palabrasSeparadas.txt").createNewFile(); Para crear un documento en tu ordenador
			FileReader fr = new FileReader(ficheroLeer); //Creamos un filereader 
			BufferedReader br = new BufferedReader(fr); //Creamos un bufferedreader para leer el fichero
			BufferedWriter bw = new BufferedWriter(new FileWriter("palabrasSeparadas.txt")); //Creamos un bufferedwriter para escribir
																							//en el nuevo fichero
			//Leemos la primera línea
			String linea = br.readLine();
			List<String> palabras = encuentraMayus(linea); //Llamamos a una función que nos devuelve una lista con 
														   //las palabras separadas
			for (String palabra:palabras) { //Por cada palabra de la lista
				bw.write(palabra + "\n"); //Escribimos la palabra con un espacio
			}
			
			br.close(); //Cerramos los bufferedReaders y Writers
			bw.flush();
			bw.close();
		
			//Excepciones
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Función que separa las palabras de la línea leída
	 * @param linea Recibe la línea que leemos del fichero
	 * @return Devuelve una lista con las palabras separas
	 */
	private static List<String> encuentraMayus(String linea) {
		List<String> palabras = new ArrayList<String>(); //Creamos una lista de strings
		char[] letras = linea.toCharArray(); //Creamos un array de chars a partir de la línea leída
		String palabra = ""; //Palabra donde iremos guardando cada palabra que creemos
		
		for (int i = 0; i<letras.length; i++) { //Recorremos el array de chars
			if (Character.isUpperCase(letras[i])) { //Si el caracter es mayúsculas
				if(!palabra.equals("")) { //Si alguna palabra ha sido escrita
					palabras.add(palabra); //Añadimos la palabra a la lista 
					palabra = ""; //Reseteamos la palabra
				}
				palabra += letras[i]; //Añadimos la letra mayúscula a la palabra
			} else { //Si es minúscula
				palabra += letras[i]; //Añadimos la letra a la palabra
			}
		}
		
		return palabras; //Devolvemos la lista de palabras
	}
}
