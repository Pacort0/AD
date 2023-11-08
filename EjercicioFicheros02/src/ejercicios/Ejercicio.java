package ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
	public static void main(String[] args) {
		File ficheroLeer = new File("palabras.txt");
		
		try {
			new File("C:\\Users\\frodriguez\\palabrasSeparadas.txt").createNewFile();
			FileReader fr = new FileReader(ficheroLeer);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\frodriguez\\palabrasSeparadas.txt"));
					
			String linea = br.readLine();
			List<String> palabras = encuentraMayus(linea);
			for (String palabra:palabras) {
				bw.write(palabra);
				bw.write("\n");
			}
			
			br.close();
			bw.flush();
			bw.close();
			
			System.out.println(palabras);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static List<String> encuentraMayus(String linea) {
		List<String> palabras = new ArrayList<String>();
		char[] letras = linea.toCharArray();
		String palabra = "";
		
		for (int i = 0; i<letras.length; i++) {
			if (Character.isUpperCase(letras[i])) {
				if(!palabra.equals("")) {
					palabras.add(palabra);
					palabra = "";
				}
				palabra += letras[i];
			} else {
				palabra += letras[i];
			}
		}
		
		return palabras;
	}
}
