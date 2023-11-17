 package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio03 {

	public static void main(String[] args) {
		int letraA = 97;
		int letraE = 101;
		int saltoLinea = 10;
		int numero1 = 49;
		int posicion = 1;
		try {
			File ficheroOriginal = new File("FicheroNormal2.txt");
			ficheroOriginal.createNewFile();
			RandomAccessFile ralf = new RandomAccessFile(ficheroOriginal, "rw");
			
			for(int i = letraA; i<=letraE; i++) {
				ralf.write(i);
				ralf.write(numero1);
				ralf.write(saltoLinea);
				numero1++;
			}
			
			escribeInverso(ralf);
			ralf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void escribeInverso(RandomAccessFile ralf) {
		try {
			File ficheroReverso = new File("FicheroReverso2.txt");
			ficheroReverso.createNewFile();
			RandomAccessFile ficheroInverso = new RandomAccessFile(ficheroReverso, "rw");
			
			int letra;
			int posicionFicheroOG = (int)ralf.length()-4;

			while(posicionFicheroOG >=0) {
				ralf.seek(posicionFicheroOG);
				letra = ralf.readByte();
				ficheroInverso.write(letra);
				posicionFicheroOG++;
				letra = ralf.readByte();
				ficheroInverso.write(letra);
				posicionFicheroOG++;
				posicionFicheroOG-=4;
			}
			ficheroInverso.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
