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
				ralf.write(saltoLinea);
			}
			ralf.seek(0);
			while(ralf.getFilePointer() < ralf.length()) {
				ralf.seek(posicion);
				ralf.write(numero1);
				posicion+=2;
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
