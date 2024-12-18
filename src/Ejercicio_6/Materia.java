package Ejercicio_6;

import java.util.Scanner;

public class Materia {
	private String sigla;
	private String nombre;
	
	public Materia(String sigla, String nombre) {
		super();
		this.sigla = sigla;
		this.nombre = nombre;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void leer() {
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr. Datos: sigla, nombre");
		sigla = lee.next();
		nombre = lee.next();
	}

	public String toString() {
		return "Materia [sigla=" + sigla + ", nombre=" + nombre + "]";
	}
	
	public void mostrar() {
		System.out.println(toString());
	}
	
}
