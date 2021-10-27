package br.senai.sp.jandira.model;

import javax.swing.DefaultListModel;

public class CalculoTabuada {

	private DefaultListModel<String> model = new DefaultListModel();
	private int multiplicando;
	private int maximoMultiplicador;
	
	public DefaultListModel<String> getModel(){
		return this.model;
	}
	
	public void setMultiplicando(String multiplicando) {
		this.multiplicando = Integer.parseInt(multiplicando);
	}
	
	public int getMultiplicando() {
		return this.multiplicando;
	}
	
	public void setMaximoMultiplicador(String maximoMultiplicador) {
		this.maximoMultiplicador = Integer.parseInt(maximoMultiplicador);
	}
	
	public int getMaximoMultiplicador() {
		return this.maximoMultiplicador;
	}
	
	public void calcular() {
				
		int contador = 0;
		
		while(contador <= maximoMultiplicador) {
			
			int resultado = multiplicando * contador;
			
			String strResultado = multiplicando + " X " + contador + " = " + resultado;
			System.out.println(strResultado);
			
			model.addElement(strResultado);
			
			contador++;
			
		}
		
	}
	
}

