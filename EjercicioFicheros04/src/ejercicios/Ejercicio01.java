package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio01 {

	public static void main(String[] args) {
		int letraA = 97;
		int saltoLinea = 10;
		try {
			File ficheroA = new File("FicheroEj1A.txt");
			ficheroA.createNewFile();
			File ficheroB = new File("FicheroEj1B.txt");
			ficheroB.createNewFile();
			RandomAccessFile ralfA = new RandomAccessFile(ficheroA, "rw");
			RandomAccessFile ralfB = new RandomAccessFile(ficheroB, "rw");
			
			ralfA.write(letraA);
			for(int i=0; i<5;i++) {
				ralfB.write(letraA);
				ralfB.write(saltoLinea);
			}
			ralfA.close();
			ralfB.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
