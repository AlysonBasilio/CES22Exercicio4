import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class InterfaceGrafica implements ActionListener {
	static CalculatorEngine engine;
	static int MAX = 100;
	private static int cont;
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	JFrame interfaceFrame;
	JPanel interfacePanel;
	JTextArea equacao;
	JTextArea resultado;
	JButton botao0, botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9;
	JButton igual, soma, multiplica, divide, subtrai;
	String m;
	
	public InterfaceGrafica() {
		//Cria e organiza janela.
		interfaceFrame = new JFrame("Calculadora do Zina");
		interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interfaceFrame.setSize(new Dimension(500, 400));
		m="";
		//Cria e constroi o painel.
		interfacePanel = new JPanel(new GridBagLayout());
				
		//Adiciona o widgets.
		adicionaWidgets();

		//Marca padrao do botao
		interfaceFrame.getRootPane().setDefaultButton(igual);

		//Adiciona o painel na janela
		interfaceFrame.getContentPane().add(interfacePanel, BorderLayout.CENTER);

		//Exibe a janela.
		interfaceFrame.pack();
		interfaceFrame.setVisible(true);
	}

	/**
	 * Cria e adciona o widgets.
	 */
	private void adicionaWidgets() {
				
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			//altura natural, largura maxima.
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		//Adiciona widgets para container.
		equacao = new JTextArea();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		interfacePanel.add(equacao, c);
		
		c.gridwidth=1;
		
		soma = new JButton("+");
		c.gridx = 3;
		c.gridy = 4;
		interfacePanel.add(soma, c);
		soma.addActionListener(this);
		
		botao7 = new JButton("7");
		c.gridx = 0;
		c.gridy = 1;
		interfacePanel.add(botao7, c);
		botao7.addActionListener(this);
		
		botao8 = new JButton("8");
		c.gridx = 1;
		c.gridy = 1;
		interfacePanel.add(botao8, c);
		botao8.addActionListener(this);
		
		botao9 = new JButton("9");
		c.gridx = 2;
		c.gridy = 1;
		interfacePanel.add(botao9, c);
		botao9.addActionListener(this);
		
		subtrai = new JButton("-");
		c.gridx = 3;
		c.gridy = 1;
		interfacePanel.add(subtrai, c);
		subtrai.addActionListener(this);
				
		botao4 = new JButton("4");
		c.gridx = 0;
		c.gridy = 2;
		interfacePanel.add(botao4, c);
		botao4.addActionListener(this);
		
		botao5 = new JButton("5");
		c.gridx = 1;
		c.gridy = 2;
		interfacePanel.add(botao5, c);
		botao5.addActionListener(this);
		
		botao6 = new JButton("6");
		c.gridx = 2;
		c.gridy = 2;
		interfacePanel.add(botao6, c);
		botao6.addActionListener(this);
		
		multiplica = new JButton("*");
		c.gridx = 3;
		c.gridy = 2;
		interfacePanel.add(multiplica, c);
		multiplica.addActionListener(this);
		
		botao1 = new JButton("1");
		c.gridx = 0;
		c.gridy = 3;
		interfacePanel.add(botao1, c);
		botao1.addActionListener(this);
		
		botao2 = new JButton("2");
		c.gridx = 1;
		c.gridy = 3;
		interfacePanel.add(botao2, c);
		botao2.addActionListener(this);
		
		botao3 = new JButton("3");
		c.gridx = 2;
		c.gridy = 3;
		interfacePanel.add(botao3, c);
		botao3.addActionListener(this);
		
		divide = new JButton("/");
		c.gridx = 3;
		c.gridy = 3;
		interfacePanel.add(divide, c);
		divide.addActionListener(this);
		
		igual = new JButton("=");
		c.gridx = 3;
		c.gridy = 0;
		interfacePanel.add(igual, c);
		igual.addActionListener(this);
		
		botao0 = new JButton("0");
		c.gridx = 1;
		c.gridy = 4;
		interfacePanel.add(botao0, c);
		botao0.addActionListener(this);
		
		resultado = new JTextArea();
		c.ipady = 40; //faz o componente no alto.
		c.gridwidth = 4;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 5;
		resultado.setLineWrap(true);
		resultado.setEditable(false);
		interfacePanel.add(resultado,c);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == botao0){
			engine.digit(0);
			m+='0';
			equacao.setText(m);
		}
		if(event.getSource() == botao1){
			engine.digit(1);
			m+='1';
			equacao.setText(m);
		}
		if(event.getSource() == botao2){
			engine.digit(2);
			m+='2';
			equacao.setText(m);
		}
		if(event.getSource() == botao3){
			engine.digit(3);
			m+='3';
			equacao.setText(m);
		}
		if(event.getSource() == botao4){
			engine.digit(4);
			m+='4';
			equacao.setText(m);
		}
		if(event.getSource() == botao5){
			engine.digit(5);
			m+='5';
			equacao.setText(m);
		}
		if(event.getSource() == botao6){
			engine.digit(6);
			m+='6';
			equacao.setText(m);
		}
		if(event.getSource() == botao7){
			engine.digit(7);
			m+='7';
			equacao.setText(m);
		}
		if(event.getSource() == botao8){
			engine.digit(8);
			m+='8';
			equacao.setText(m);
		}
		if(event.getSource() == botao9){
			engine.digit(9);
			m+='9';
			equacao.setText(m);
		}
		if(event.getSource() == soma){
			engine.add();
			m+='+';
			equacao.setText(m);
		}
		if(event.getSource() == subtrai){
			engine.subtract();
			m+='-';
			equacao.setText(m);
		}
		if(event.getSource() == divide){
			engine.divide();
			m+='/';
			equacao.setText(m);
		}
		if(event.getSource() == multiplica){
			engine.multiply();
			m+='*';
			equacao.setText(m);
		}
		if(event.getSource() == igual){
			try {
				engine.compute();
				resultado.setText(""+engine.display());
				m="";
				engine.clear();
			} catch (DivideByZeroError e) {
				System.out.println("Erro: Divisão por zero.");
			}
		}
	}

	/**
	 * Cria um GUI e o exibe. Para thread safety,
	 * este metodo podera invocar para uma thread 
	 * de disparo de evento(event-dispatching thread).
	 */
	private static void criaExibeGUI() {
		//Faz com se tenha janelas com decoracoes agradaveis.
		JFrame.setDefaultLookAndFeelDecorated(true);
		InterfaceGrafica gui = new InterfaceGrafica();
	}

	public static void main(String[] args) {
		//Agenda um trabalho para o event-dispatching thread:
		//cria e exibe uma aplicacao GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				engine = new CalculatorEngine();
				criaExibeGUI();
			}
		});
	}
}