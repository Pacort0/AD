package ejercicios;

import java.io.*;

public class Ejercicio02 {

	public static void main(String[] args) {
		int letraA = 97;
		int letraE = 101;
		int saltoLinea = 10;
		try {
			File ficheroOriginal = new File("FicheroNormal.txt");
			RandomAccessFile ralf = new RandomAccessFile(ficheroOriginal, "rw");
			for(int i = letraA; i<=letraE; i++) {
				ralf.write(i);
				ralf.write(saltoLinea);
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
			File ficheroReverso = new File("FicheroReversoEj4.txt");
			RandomAccessFile ficheroInverso = new RandomAccessFile(ficheroReverso, "rw");
			
			int letra;
			int posicion = 0;
			int posicionFicheroOG = (int)ralf.length()-2;

			while(posicionFicheroOG >=0) {
				ralf.seek(posicionFicheroOG);
				ficheroInverso.seek(posicion);
				letra = ralf.readByte();
				ficheroInverso.write(letra);
				posicion++;
				posicionFicheroOG--;
			}
			ficheroInverso.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
