 package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio03 {

	public static void main(String[] args) {
		int letraA = 97; //letra A en ASCII
		int letraE = 101; //letra E en ASCII
		int saltoLinea = 10; //salto de linea en ASCII 
		int numero1 = 49; //numero 1 en ASCII
		try {
			File ficheroOriginal = new File("FicheroNormal2.txt");
			ficheroOriginal.createNewFile();
			RandomAccessFile ralf = new RandomAccessFile(ficheroOriginal, "rw");
			
			//Escribimos las letras con un número detrás
			for(int i = letraA; i<=letraE; i++) { 
				ralf.write(i);
				ralf.write(numero1);
				ralf.write(saltoLinea);
				numero1++;
			}
			//Escribimos el fichero en inverso
			escribeInverso(ralf);
			ralf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método que le da la vuelta al fichero original y lo escribe en el fichero nuevo
	 * @param ralf RandomAccessFile con los datos del fichero original
	 */
	private static void escribeInverso(RandomAccessFile ralf) {
		try {
			File ficheroReverso = new File("FicheroReverso2.txt");
			ficheroReverso.createNewFile();
			RandomAccessFile ficheroInverso = new RandomAccessFile(ficheroReverso, "rw");
			
			int letra; //Variable donde guardaremos cada letra
			//Variable que usaremos para mover el puntero del fichero a donde nos convenga
			//Inicializamos a la posición de la primera letra, o longitud del fichero menos el salto de línea y el número
			int posicionFicheroOG = (int)ralf.length()-3; 
			
			//Bucle for para iterar el fichero original desde la primera letra por el final, restando 5 en cada iteración
			for(;posicionFicheroOG>=0;posicionFicheroOG-=5) {
				
				ralf.seek(posicionFicheroOG); //Cambiamos el puntero del fichero original a la primea letra por el final
				letra = ralf.readByte(); //Leemos la letra en esa posición
				ficheroInverso.write(letra); //Escribimos la letra en el fichero nuevo
				
				posicionFicheroOG++; //Aumentamos la posicion del puntero en un valor para acceder a la posicion del numero
				letra = ralf.readByte(); //Leemos el numero
				ficheroInverso.write(letra); //Escribimos el número
				
				posicionFicheroOG++; //Aumentamos la posicion del puntero en un valor para acceder a la posicion del salto de linea
				letra = ralf.readByte(); //Leemos y escribimos el salto de línea
				ficheroInverso.write(letra);
			}
			ficheroInverso.close(); //Cerramos el fichero
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
