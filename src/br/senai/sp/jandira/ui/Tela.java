package br.senai.sp.jandira.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		tela.setSize(600,600);
		tela.setTitle("Tabuada");
		tela.setLayout(null);
		
		JLabel lblMultiplicando = new JLabel();
		lblMultiplicando.setText("multiplicando: ");
		lblMultiplicando.setBounds(40, 100, 150, 30);
		
		
		JTextField txtMultiplicando = new JTextField();
		txtMultiplicando.setText("00");
		txtMultiplicando.setBounds(130, 95, 100, 40);
		
		
		JLabel lblMaximoMultiplicador = new JLabel();
		lblMaximoMultiplicador.setText("Maximo multiplicador:");
		lblMaximoMultiplicador.setBounds(40, 175, 150, 30);
		
		
		JTextField txtMaximoMultiplicador = new JTextField();
		txtMaximoMultiplicador.setText("5");
		txtMaximoMultiplicador.setBounds(170, 170, 100, 40);
		
		
		JButton btnCalcular = new JButton();
		btnCalcular.setText("CALCULAR");
		btnCalcular.setBounds(40, 250, 250, 50);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JList<String> lstResultados = new JList();
		lstResultados.setBounds(40, 350, 250, 200);
		
		scrollPane.setViewportView(lstResultados);
		lstResultados.setLayoutOrientation(JList.VERTICAL);
		
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CalculoTabuada calculoTabuada = new CalculoTabuada();
				
				calculoTabuada.setMultiplicando(txtMultiplicando.getText());
				calculoTabuada.setMaximoMultiplicador(txtMaximoMultiplicador.getText());
				
				calculoTabuada.calcular();
				lstResultados.setModel(calculoTabuada.getModel());
				
			}
		});
		
		
	
		
		tela.getContentPane().add(scrollPane);
		tela.getContentPane().add(lstResultados);
		tela.getContentPane().add(lblMultiplicando);
		tela.getContentPane().add(txtMultiplicando);
		tela.getContentPane().add(lblMaximoMultiplicador);
		tela.getContentPane().add(txtMaximoMultiplicador);
		tela.getContentPane().add(btnCalcular);
		
		tela.setVisible(true);
		
		
		
		
	}
}
