package ejercicios;

import java.io.*;

public class EjercicioA {

	public static void main(String[] args) {
		String ficheroNombre = "C:\\Users\\frodriguez"; //Ruta del fichero principal
		File ficheroLectura = new File("ficheroArbol"); //Fichero cuyas rutas queremos calcar
		String linea = ""; //Aquí guardaremos las líneas que leamos del fichero a copiar

		try {
			FileReader fr = new FileReader(ficheroLectura);
			BufferedReader br = new BufferedReader(fr);

			linea = br.readLine(); //Leemos y guardamos la primera línea
			
			while (linea != null) { //Mientras haya contenido en la línea
				String[] elementos = linea.split("/"); //Dividimos la línea leída por '/'
				
				switch (elementos.length) { //Según la cantidad de elementos que tenga cada ruta
				case 1: //Si tiene un elemento
					new File(ficheroNombre, linea).mkdir(); //Creamos un directorio a partir de la primera línea
					break;
				case 2: //Si tiene dos elementos
					new File(ficheroNombre+ "/" + elementos [0], elementos[1]).mkdir(); //Creamos un directiorio en la ruta especificada
					break;
				case 3: //Si tiene tres elementos
					//Creamos un fichero en la ruta especificada
					new File(ficheroNombre+ "/" + elementos [0] + "/" + elementos[1], elementos[2]).createNewFile();
					break;
				} 
				//Leemos otra línea
				linea = br.readLine();
			}
			br.close(); //Cerramos el fichero
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
