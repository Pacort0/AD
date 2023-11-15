package ejercicios;

import java.io.*;

public class Ejercicio02 {

	public static void main(String[] args) {
		int letraA = 97;
		int letraE = 101;
		String linea;
		try {
			File ficheroOriginal = new File("FicheroEj4.txt");
			RandomAccessFile ralf = new RandomAccessFile(ficheroOriginal, "rw");
			for(int i = letraA; i<=letraE; i++) {
				ralf.writeChar(i);
				ralf.writeChars("\n");
			}
			escribeInverso(ralf);
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
			
			byte letra;
			int posicion = 0;
			int posicionFicheroOG = (int)ralf.length()-3;

			while(posicionFicheroOG > 0) {
				ralf.seek(posicionFicheroOG);
				ficheroInverso.seek(posicion);
				letra = ralf.readByte();
				ficheroInverso.writeChar((int)letra);
				posicion += 2;
				posicionFicheroOG -= 2;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
