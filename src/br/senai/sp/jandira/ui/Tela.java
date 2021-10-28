package br.senai.sp.jandira.ui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

import br.senai.sp.jandira.model.CalculoTabuada;

public class Tela {

	public void iniciar() {
		
		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(600,500);
		tela.setTitle("Tabuada");
		tela.setLayout(null);
		
		// fontes
		
		Font font = new Font("Monospace", Font.BOLD,30);
		
		// Cores
		
		Color azul = new Color(21, 39, 255);
		Color verde = new Color(83, 235, 108);
		Color vermelho = new Color(245, 16, 21);
		Color branco = new Color(255, 255, 255);

		
		JLabel lblTabuada = new JLabel();
		lblTabuada.setText("Tabuada");
		lblTabuada.setBounds(40, 30, 150, 30);
		lblTabuada.setFont(font);
		lblTabuada.setForeground(azul);
		
	
		JLabel lblMultiplicando = new JLabel();
		lblMultiplicando.setText("multiplicando: ");
		lblMultiplicando.setBounds(40, 100, 150, 30);
		
		
		JTextField txtMultiplicando = new JTextField();
		txtMultiplicando.setText("5");
		txtMultiplicando.setBounds(170, 95, 100, 40);
		
		
		JLabel lblMaximoMultiplicador = new JLabel();
		lblMaximoMultiplicador.setText("Maximo multiplicador:");
		lblMaximoMultiplicador.setBounds(40, 175, 150, 30);
		
		
		JTextField txtMaximoMultiplicador = new JTextField();
		txtMaximoMultiplicador.setText("5");
		txtMaximoMultiplicador.setBounds(170, 170, 100, 40);
		
		
		JButton btnCalcular = new JButton();
		btnCalcular.setText("CALCULAR");
		btnCalcular.setBounds(40, 250, 250, 50);
		btnCalcular.setBackground(verde);
		btnCalcular.setForeground(branco);
		
		
		JButton btnDel = new JButton();
		btnDel.setBounds(40, 320, 250, 50);
		btnDel.setText("LIMPAR");
		btnDel.setBackground(vermelho);
		btnDel.setForeground(branco);
		
		JLabel lblResultado = new JLabel();
		lblResultado.setText("Resultado: ");
		lblResultado.setBounds(300, 90, 150, 30);
		lblResultado.setForeground(azul);

		
		
		// JList
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 130, 200, 240);
		
		DefaultListModel<String> tabuada = new DefaultListModel();

		
		JList<String> listResultados = new JList();
		listResultados.setModel(tabuada);
		scrollPane.getViewport().add(listResultados);
		
		
		tela.getContentPane().add(lblResultado);
		tela.getContentPane().add(lblTabuada);
		tela.getContentPane().add(btnDel);
		tela.getContentPane().add(scrollPane);
		tela.getContentPane().add(lblMultiplicando);
		tela.getContentPane().add(txtMultiplicando);
		tela.getContentPane().add(lblMaximoMultiplicador);
		tela.getContentPane().add(txtMaximoMultiplicador);
		tela.getContentPane().add(btnCalcular);
		
		
		tela.setVisible(true);
		
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CalculoTabuada calculoTabuada = new CalculoTabuada();
				
				calculoTabuada.setMultiplicando(txtMultiplicando.getText());
				calculoTabuada.setMaximoMultiplicador(txtMaximoMultiplicador.getText());
				
//				listResultados.setModel(calculoTabuada.getModel());
				
				int contador = 0;
				
				while(contador <= calculoTabuada.getMaximoMultiplicador()) {
					
					String strResultado = calculoTabuada.getMultiplicando() + " X " + contador + " = " + calculoTabuada.calcular(contador);
			
					tabuada.addElement(strResultado);	
					
					contador++;
					
				}
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tabuada.removeAllElements();
				txtMultiplicando.requestFocus();
			}
		});
		
	
		
		
	}
}
