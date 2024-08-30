package entities;

import java.util.ArrayList;

public class Aviao {
	public static ArrayList< Aviao > aviaos = new ArrayList<Aviao>();
	
	
	public Aviao(String registro, String modelo, int capacidade) {
		this.registro = registro;
		this.modelo = modelo;
		this.capacidade = capacidade;
	}
	
		
	
	
	private String registro;
	public String getRegistro() {
		return registro;
	}
	private String modelo;
	public String getModelo() {
		return modelo;
	}
	private int capacidade;
	public int getCapacidade() {
		return capacidade;
	}
	
	
	
	//(registro, modelo e capacidade)
}
