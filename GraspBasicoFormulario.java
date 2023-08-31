package janela;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import eletrica.TabelaEletrica;
import eletrica.VetorPostoTarifario;
import grasp.EquipamentoCandidato;
import grasp.InOut;
import grasp.ListaCandidatoRestrito;
import grasp.No;

public class GraspBasicoFormulario extends JFrame {

	private JLabel 	postoTarifarioPonta, 
					postoTarifarioIntermediario, 
					postoTarifarioForaPonta,
					equipamentoResidencial,
					totalPostoTarifarioPonta, 
					totalTempoComputacional,
					totalPostoTarifarioIntermediario, 
					totalPostoTarifarioForaPonta,
					totalPostoTarifario;
	
	private JButton graspReativo,
					algoritmoGenetico,
					metaheuristicaHibrida;
	
	private JButton detalhamento;
	
	JButton csv;
	JButton relatorio;
	JButton resumo;
	
	String [] colunaTabelaEquipamentoCompleta;
	String [][] dadoTabelaEquipamentoCompleta;
	
	// quantidade de aparelhos (quantidade de linha)
	int linha = 0;
			
	int coluna = 0;
	
	//ForaPonta
	//painelJScrollPaneTabelaForaPonta
	
	
	private JTable tabelaEquipamento,
				   tabelaForaPonta,
				   tabelaIntermediario,
				   tabelaPonta;

	
	private DefaultTableModel modeloTabela;
	
	private JScrollPane painelJScrollPaneTabelaEquipamento,
						painelJScrollPaneTabelaForaPonta,
						painelJScrollPaneTabelaIntermediario,
						painelJScrollPaneTabelaPonta;

	public JScrollPane scrollPane;
	
	public Container   container;

	
	public int x, y, largura, altura;
	
	public int xPostoTarifario, yPostoTarifario, larguraPostoTarifario, alturaPostoTarifario;
	
	public JTextField totalForaPonta, totalIntermediario, totalPonta, totalTempoComputacionalGrasp;
	
	public static final double FORA_PONTA_DINHEIRO    = 0.56634;

	public static final double INTERMEDIARIO_DINHEIRO = 0.81626;
	
	public static final double PONTA_DINHEIRO  		  = 1.22498;

	public double foraPontaDinheiro, intermediarioDinheiro, pontaDinheiro;
	
	public long tempoComputacionalInicio, tempoComputacionalFim;
	
	String detalhamentoAplicacao = new String();
	
	JCheckBox selecionarEquipamentoEscalonado;
	
	public void setPostoTarifarioPonta(JLabel _postoTarifarioPonta) {
		
		this.postoTarifarioPonta = _postoTarifarioPonta;
	
	}

	public JLabel getPostoTarifarioPonta() {
		
		return this.postoTarifarioPonta;

	}

	public void setPostoTarifarioIntermediario(JLabel _postoTarifarioIntermediario) {
		
		this.postoTarifarioIntermediario = _postoTarifarioIntermediario;
		
	}

	public void setPostoTarifarioForaPonta(JLabel _postoTarifarioForaPonta) {
	
		this.postoTarifarioForaPonta = _postoTarifarioForaPonta;
	
	}
	
	public JLabel getPostoTarifarioIntermediario() {
		
		return this.postoTarifarioIntermediario;
		
	}

	public JLabel getPostoTarifarioForaPonta() {

		return this.postoTarifarioForaPonta;

	}
	
	public void setTotalPostoTarifarioPonta(JLabel _totalPostoTarifarioPonta) {
		
		this.totalPostoTarifarioPonta = _totalPostoTarifarioPonta;
		
	}
	
	public JLabel getTotalPostoTarifarioPonta() {
		
		return this.totalPostoTarifarioPonta;
		
	}

	public void setTotalPostoTarifarioIntermediario(JLabel _totalPostoTarifarioIntermediario) {
		
		this.totalPostoTarifarioIntermediario = _totalPostoTarifarioIntermediario;
		
	}

	public JLabel getTotalPostoTarifarioIntermediario() {
		
		return this.totalPostoTarifarioIntermediario;
		
	}

	public void setTotalPostoTarifarioForaPonta(JLabel _totalPostoTarifarioForaPonta) {
		
		this.totalPostoTarifarioForaPonta = _totalPostoTarifarioForaPonta;
		
	}

	public JLabel getTotalPostoTarifarioForaPonta() {
		
		return this.totalPostoTarifarioForaPonta;
		
	}
	
	public void setTotalPostoTarifario(JLabel _totalPostoTarifario) {
		
		this.totalPostoTarifario = _totalPostoTarifario;
	
	}

	public JLabel getTotalPostoTarifario() {
		
		return this.totalPostoTarifario;
	
	}

	public void setEquipamentoResidencial(JLabel _equipamentoResidencial) {
		
		this.equipamentoResidencial = _equipamentoResidencial;
		
	}

	public JLabel getEquipamentoResidencial() {
		
		return this.equipamentoResidencial;
		
	}

	public void setDetalhamento(JButton _detalhamento) {
		
		this.detalhamento = _detalhamento;
	
	}

	public JButton getDetalhamento() {
		
		return detalhamento;
	
	}

	public void setGraspReativo(JButton _graspReativo) {
		
		this.graspReativo = _graspReativo;
		
	}

	public JButton getGraspReativo() {
		
		return this.graspReativo;
	
	}

	public void setAlgoritmoGenetico(JButton _algoritmoGenetico) {
		
		this.algoritmoGenetico = _algoritmoGenetico;
	
	}

	public JButton getAlgoritmoGenetico() {
		
		return this.algoritmoGenetico;
		
	}

	public void setMetaheuristicaHibrida(JButton _metaheuristicaHibrida) {
		
		this.metaheuristicaHibrida = _metaheuristicaHibrida;
		
	}

	public JButton getMetaheuristicaHibrida() {
		
		return this.metaheuristicaHibrida;
		
	}
	
	public void setTabelaEquipamento(JTable _tabelaEquipamento) {
		
		this.tabelaEquipamento = _tabelaEquipamento;
		
	}
	
	public JTable getTabelaEquipamento() {
		
		return this.tabelaEquipamento;
		
	}
	
	public JTable getTabelaForaPonta() {
	
		return tabelaForaPonta;
	
	}

	public void setTabelaForaPonta(JTable tabelaForaPonta) {
	
		this.tabelaForaPonta = tabelaForaPonta;
	
	}
	
	public void setTabelaIntermediario(JTable _tabelaIntermediario) {
		
		this.tabelaIntermediario = _tabelaIntermediario;
		
	}
	
	public JTable getTabelaIntermediario() {
		
		return this.tabelaIntermediario;
		
	}
	
	public void setTabelaPonta(JTable _tabelaPonta) {
		
		this.tabelaPonta = _tabelaPonta;
		
	}

	public JTable getTabelaPonta() {
		
		return this.tabelaPonta;
		
	}

	public void setModeloTabela(DefaultTableModel _modeloTabela) {
		
		this.modeloTabela = _modeloTabela;
		
	}

	public DefaultTableModel getModeloTabela() {
		
		return this.modeloTabela;
		
	}
	
	public void setPainelJScrollPaneTabelaEquipamento(JScrollPane _painelJScrollPaneTabelaEquipamento) {
		
		this.painelJScrollPaneTabelaEquipamento = _painelJScrollPaneTabelaEquipamento;
		
	}

	public JScrollPane getPainelJScrollPaneTabelaEquipamento() {
		
		return this.painelJScrollPaneTabelaEquipamento;
		
	}
	
	public void setPainelJScrollPaneTabelaForaPonta(JScrollPane _painelJScrollPaneTabelaForaPonta) {
		
		this.painelJScrollPaneTabelaForaPonta = _painelJScrollPaneTabelaForaPonta;
		
	}
	
	public JScrollPane getPainelJScrollPaneTabelaForaPonta() {
		
		return this.painelJScrollPaneTabelaForaPonta;
		
	}
	
	public void setPainelJScrollPaneTabelaIntermediario(JScrollPane _painelJScrollPaneTabelaIntermediario) {
		
		this.painelJScrollPaneTabelaIntermediario = _painelJScrollPaneTabelaIntermediario;
		
	}

	public JScrollPane getPainelJScrollPaneTabelaIntermediario() {
		
		return this.painelJScrollPaneTabelaIntermediario;
		
	}
		
	public void setPainelJScrollPaneTabelaPonta(JScrollPane _painelJScrollPaneTabelaPonta) {
		
		this.painelJScrollPaneTabelaPonta = _painelJScrollPaneTabelaPonta;
		
	}
	
	public JScrollPane getPainelJScrollPaneTabelaPonta() {
		
		return this.painelJScrollPaneTabelaPonta;
		
	}

	public void setTotalForaPonta(JTextField _totalForaPonta) {
		
		this.totalForaPonta = _totalForaPonta;
		
	}

	public JTextField getTotalForaPonta() {
		
		return this.totalForaPonta;
		
	}

	public void setTotalIntermediario(JTextField _totalIntermediario) {
		
		this.totalIntermediario = _totalIntermediario;
		
	}

	public JTextField getTotalIntermediario() {
		
		return this.totalIntermediario;
		
	}

	public void setTotalPonta(JTextField _totalPonta) {
		
		this.totalPonta = _totalPonta;
		
	}

	public JTextField getTotalPonta() {
		
		return this.totalPonta;
		
	}

	public GraspBasicoFormulario (EquipamentoConfigurado _equipamentoConfigurado, double [] _totalResumo) {
		
		//JOptionPane.showMessageDialog(null, "O valor de Alfa está fixo em 0.50");
		
		JOptionPane.showMessageDialog(null, 
				"O valor de Alfa está fixo em 0.50", 
		        "Alfa fixo"
		        ,1);
		
		/**
		 * Tempo computacional
		 */
		tempoComputacionalInicio = System.currentTimeMillis();
		
		/**
		 * Aplicação do grasp básico
		 */
		aplicarGraspBasico(_equipamentoConfigurado);		
		
		tempoComputacionalFim = System.currentTimeMillis() - tempoComputacionalInicio;
		
		System.out.println(_equipamentoConfigurado.toString());
		
		this.equipamentoResidencial 	 = new JLabel("Características do(s) Equipamento(s)");
		this.equipamentoResidencial.setFont(new Font ("Tahome", Font.BOLD, 13));
		
		this.postoTarifarioForaPonta 	 = new JLabel("Fora de Ponta");  
		this.postoTarifarioForaPonta.setFont(new Font ("Tahome", Font.BOLD, 12));
		
		this.postoTarifarioIntermediario = new JLabel("Intermediário");
		this.postoTarifarioIntermediario.setFont(new Font ("Tahome", Font.BOLD, 12));
		
		this.postoTarifarioPonta 		 = new JLabel("Ponta");
		this.postoTarifarioPonta.setFont(new Font ("Tahome", Font.BOLD, 12));
		
		/** label do total dos postos tarifários */
		this.totalPostoTarifario 	 		  = new JLabel("Posto Tarifário");
		this.totalPostoTarifario.setFont(new Font ("Tahome", Font.BOLD, 13));
		
		this.totalPostoTarifarioForaPonta 	  = new JLabel("Fora de Ponta");  
		this.totalPostoTarifarioIntermediario = new JLabel("Intermediário"); 
		this.totalPostoTarifarioPonta 		  = new JLabel("Ponta");
		
		/** conteúdo do total dos postos tarifários*/
		this.totalForaPonta		= new JTextField();
		this.totalIntermediario = new JTextField();
		this.totalPonta			= new JTextField();		
		
		this.totalTempoComputacionalGrasp = new JTextField();
		
		detalhamento 			= new JButton("Detalhamento");
		graspReativo 			= new JButton("GRASP Reativo");
		algoritmoGenetico 		= new JButton("Algoritmo Genético");
		metaheuristicaHibrida 	= new JButton("Metaheurística Híbrida");				
		
		// painel do cabeçalho
		JPanel cabecalhoEquipamento, 
		
			   cabecalhoPostoTarifario,
			   
			   cabecalhoEquipamentoEspecificoForaPonta,
			   
			   cabecalhoEquipamentoEspecificoIntermediario,
			   
			   cabecalhoEquipamentoEspecificoPonta; 
		
		cabecalhoEquipamento = new JPanel();

		cabecalhoEquipamento.setBorder( new TitledBorder( "" ) );
		// redistribui os botões com um espaço maior entre o painel
		cabecalhoEquipamento.setLayout( new FlowLayout(FlowLayout.CENTER) );
		cabecalhoEquipamento.setBounds(10, 0, 349, 50);

        //graspBasico.setPreferredSize(new Dimension(170, 25));
		cabecalhoEquipamento.add(this.equipamentoResidencial);
		
		cabecalhoPostoTarifario = new JPanel();

		cabecalhoPostoTarifario.setBorder( new TitledBorder( "" ) );
		cabecalhoPostoTarifario.setLayout( new FlowLayout(FlowLayout.CENTER) );
		cabecalhoPostoTarifario.setBounds(362, 0, 619, 40);
		
		//graspBasico.setPreferredSize(new Dimension(170, 25));
		cabecalhoPostoTarifario.add(this.totalPostoTarifario);

		cabecalhoEquipamentoEspecificoForaPonta = new JPanel();

		cabecalhoEquipamentoEspecificoForaPonta.setBorder(new TitledBorder(""));
		cabecalhoEquipamentoEspecificoForaPonta.setLayout(new FlowLayout(FlowLayout.CENTER));
		cabecalhoEquipamentoEspecificoForaPonta.setBounds(362, 25, 204, 25);
		
        //graspBasico.setPreferredSize(new Dimension(170, 25));
		cabecalhoEquipamentoEspecificoForaPonta.add(this.postoTarifarioForaPonta);
		
		cabecalhoEquipamentoEspecificoIntermediario = new JPanel();

		cabecalhoEquipamentoEspecificoIntermediario.setBorder(new TitledBorder(""));
		cabecalhoEquipamentoEspecificoIntermediario.setLayout(new FlowLayout(FlowLayout.CENTER));
		cabecalhoEquipamentoEspecificoIntermediario.setBounds(569, 25, 204, 25);

		cabecalhoEquipamentoEspecificoIntermediario.add(this.postoTarifarioIntermediario);
		
		cabecalhoEquipamentoEspecificoPonta = new JPanel();

		cabecalhoEquipamentoEspecificoPonta.setBorder(new TitledBorder(""));
		cabecalhoEquipamentoEspecificoPonta.setLayout(new FlowLayout(FlowLayout.CENTER));
		cabecalhoEquipamentoEspecificoPonta.setBounds(777, 25, 204, 25);
		
		cabecalhoEquipamentoEspecificoPonta.add(this.postoTarifarioPonta);
		
		//this.modeloTabela = new DefaultTableModel();
		
		/** #################################################### */
		/** ##################### TABELA 1 ##################### */
		/** #################################################### */
				
		String [] colunaTabelaEquipamento,
		
				  colunaTabelaEquipamentoForaPonta,
				  
				  colunaTabelaEquipamentoIntermediario,
				  
				  colunaTabelaEquipamentoPonta;
		
				   
		
		String [][] dadoTabelaEquipamento,
		
					dadoTabelaEquipamentoForaPonta,
					
					dadoTabelaEquipamentoIntermediario,
					
					dadoTabelaEquipamentoPonta;
				
							
		linha = verificarQuantidadeCheckboxMarcado(_equipamentoConfigurado);
		
		coluna = 10;
		
		colunaTabelaEquipamentoCompleta = new String[coluna];
		
		colunaTabelaEquipamento = colunaTabelaEquipamentoCompleta();
		
		dadoTabelaEquipamentoCompleta = new String [linha][coluna];
				
		dadoTabelaEquipamentoCompleta = dadoTabelaCompleta(_equipamentoConfigurado);
		
		
		coluna = 4;
		
		colunaTabelaEquipamento = colunaTabelaEquipamento();
		
		dadoTabelaEquipamento = new String [linha][coluna];
				
		dadoTabelaEquipamento = dadoEquipamentoTabela(dadoTabelaEquipamentoCompleta, linha);
				
		//dadoTabelaEquipamento = dadoTabelaEquipamento();
		
		//this.modeloTabela.setColumnIdentifiers(colunaTabela);
		//this.tabelaEquipamento = new JTable( this.getModeloTabela() );
		
		this.setTitle("Aplicação de Metaheurística GRASP Básico");
		
		this.setLayout(null);
		
		//altura = 200;
		
		//############ colocado		
		altura = ( 200 + ( (linha) * 25 ) );  
		
		//this.setBounds(200, 200, 1000, 190);
		this.setBounds(200, 225, 1005, altura);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// não permite maximizar ou alterar o tamanho do formulário/frame
		this.setResizable(false);
		
		// No topo da tela
		this.setLocation(310, 0);

		this.tabelaEquipamento = new JTable( dadoTabelaEquipamento, colunaTabelaEquipamento);
		
		//############ colocado		
		altura = (25 + ( (linha) * 25 ) );
		
		x = 10;	y = 50;	largura = 350;	//altura = 50;
		
		this.tabelaEquipamento.setBounds(x, y, largura, altura);
		
		// TABELA 1: largura da 1ª coluna
		this.tabelaEquipamento.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		// TABELA 1: largura da 2ª coluna
		this.tabelaEquipamento.getColumnModel().getColumn(1).setPreferredWidth(150);
		
		// TABELA 1: largura da 3ª coluna
		this.tabelaEquipamento.getColumnModel().getColumn(2).setPreferredWidth(85);
		
		// TABELA 1: largura da 4ª coluna
		this.tabelaEquipamento.getColumnModel().getColumn(3).setPreferredWidth(85);
	
		this.painelJScrollPaneTabelaEquipamento = new JScrollPane(); 
		
		this.painelJScrollPaneTabelaEquipamento.setBounds(x, y, largura, altura);
		
		this.painelJScrollPaneTabelaEquipamento.setViewportView( this.getTabelaEquipamento() );
		
		// Coluna da tabela no centro
		this.getContentPane().add(this.painelJScrollPaneTabelaEquipamento, BorderLayout.CENTER);
		
		/** Altera a letra e o tamanho das colunas */
		//JTableHeader theader = tabelaEquipamento.getTableHeader();
		//theader.setBackground(new Color(181, 181, 181));
		//theader.setFont(new Font ("Tahome", Font.BOLD, 12));		
		JTableHeader theader = tabelaEquipamento.getTableHeader();
		theader.setBackground(new Color(240, 255, 255));
		//198, 226, 255
		//240, 255, 255
		theader.setFont(new Font ("Tahome", Font.BOLD, 12));
		
		
		this.tabelaEquipamento.setDefaultRenderer(Object.class, new RenderTable());
		
		this.tabelaEquipamento.setRowHeight(25);
		
		postoTarifarioForaPonta 	= new JLabel("Fora de Ponta");
		
		/** #################################################### */
		/** ##################### TABELA 2 ##################### */
		/** #################################################### */
		
		coluna = 2;
		
		colunaTabelaEquipamentoForaPonta = new String[coluna];
				
		colunaTabelaEquipamentoForaPonta = colunaPostoTarifario();
		
		dadoTabelaEquipamentoForaPonta = dadoPostoTarifarioForaPonta(dadoTabelaEquipamentoCompleta, linha);
		
		this.tabelaForaPonta = new JTable( dadoTabelaEquipamentoForaPonta, colunaTabelaEquipamentoForaPonta);
		
		x = largura + 12;		
		
		largura = largura - 145;	
		
		//altura = 50;

		//############ colocado
		altura = (25 + ( (linha) * 25 ) );
		
		this.tabelaForaPonta.setBounds(x, y, largura, altura);
		
		// TABELA 2: largura da 1ª coluna
		this.tabelaForaPonta.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		// TABELA 2: largura da 2ª coluna
		this.tabelaForaPonta.getColumnModel().getColumn(1).setPreferredWidth(100);
	
		this.painelJScrollPaneTabelaForaPonta = new JScrollPane(); 
		
		this.painelJScrollPaneTabelaForaPonta.setBounds(x, y, largura, altura);
		
		this.painelJScrollPaneTabelaForaPonta.setViewportView( this.getTabelaForaPonta() );
		
		// colunas da tabela no centro
		this.getContentPane().add(this.painelJScrollPaneTabelaForaPonta, BorderLayout.CENTER);
		
		/** Altera a letra e o tamanho das colunas */
		theader = tabelaForaPonta.getTableHeader();
		theader.setBackground(new Color(240, 255, 255));
		theader.setFont(new Font ("Tahome", Font.BOLD, 12));
		
		this.tabelaForaPonta.setDefaultRenderer(Object.class, new RenderTable());
		
		this.tabelaForaPonta.setRowHeight(25);
		
		/** #################################################### */
		/** ##################### TABELA 3 ##################### */
		/** #################################################### */
		
		coluna = 2;
		
		colunaTabelaEquipamentoIntermediario = new String[coluna];
				
		colunaTabelaEquipamentoIntermediario = colunaPostoTarifario();
		
		dadoTabelaEquipamentoIntermediario = dadoPostoTarifarioIntermediario(dadoTabelaEquipamentoCompleta, linha);
		
		this.tabelaIntermediario = new JTable( dadoTabelaEquipamentoIntermediario, colunaTabelaEquipamentoIntermediario);				
		
		x = 350 + largura + 14;
		
		//altura = 50;
		//############ colocado
		altura = (25 + ( (linha) * 25 ) );
		
		this.tabelaIntermediario.setBounds(x, y, largura, altura);
		
		// TABELA 3: largura da 1ª coluna
		this.tabelaIntermediario.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		// TABELA 3: largura da 2ª coluna
		this.tabelaIntermediario.getColumnModel().getColumn(1).setPreferredWidth(100);
	
		this.painelJScrollPaneTabelaIntermediario = new JScrollPane(); 
		
		this.painelJScrollPaneTabelaIntermediario.setBounds(x, y, largura, altura);
		
		this.painelJScrollPaneTabelaIntermediario.setViewportView( this.getTabelaIntermediario() );
		
		// colunas da tabela no centro
		this.getContentPane().add(this.painelJScrollPaneTabelaIntermediario, BorderLayout.CENTER);

		/** Altera a letra e o tamanho das colunas */
		theader = tabelaIntermediario.getTableHeader();
		theader.setBackground(new Color(240, 255, 255));
		theader.setFont(new Font ("Tahome", Font.BOLD, 12));
		
		this.tabelaIntermediario.setDefaultRenderer(Object.class, new RenderTable());
		
		this.tabelaIntermediario.setRowHeight(25);
		
		/** #################################################### */
		/** ##################### TABELA 4 ##################### */
		/** #################################################### */
		
		coluna = 2;
		
		colunaTabelaEquipamentoPonta = new String[coluna];
				
		colunaTabelaEquipamentoPonta = colunaPostoTarifario();
		
		dadoTabelaEquipamentoPonta = dadoPostoTarifarioPonta(dadoTabelaEquipamentoCompleta, linha);
		
		this.tabelaPonta = new JTable( dadoTabelaEquipamentoPonta, colunaTabelaEquipamentoPonta);				
		
		x = 557 + largura + 15;			
		
		//altura = 50;
		//############ colocado
		altura = (25 + ( (linha) * 25 ) );

		
		this.tabelaPonta.setBounds(x, y, largura, altura);
		
		// TABELA 4: largura da 1ª coluna
		this.tabelaPonta.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		// TABELA 4: largura da 2ª coluna
		this.tabelaPonta.getColumnModel().getColumn(1).setPreferredWidth(100);
	
		this.painelJScrollPaneTabelaPonta = new JScrollPane(); 
		
		this.painelJScrollPaneTabelaPonta.setBounds(x, y, largura, altura);
		
		this.painelJScrollPaneTabelaPonta.setViewportView( this.getTabelaPonta() );
		
		// colunas da tabela no centro
		this.getContentPane().add(this.painelJScrollPaneTabelaPonta, BorderLayout.CENTER);

		/** Altera a letra e o tamanho das colunas */
		theader = tabelaPonta.getTableHeader();
		theader.setBackground(new Color(240, 255, 255));
		theader.setFont(new Font ("Tahome", Font.BOLD, 12));
		
		this.tabelaPonta.setDefaultRenderer(Object.class, new RenderTable());
		
		this.tabelaPonta.setRowHeight(25);		
		
		JPanel conteudoPNL = new JPanel();
        conteudoPNL.setBorder( new TitledBorder( "Aplicar Metaheurística" ) );
        
      //############ colocado
      y = (95 + ( (linha) * 25 ) );
      		
        
        // redistribui os botões com um espaço maior entre o painel
        //conteudoPNL.setLayout( new FlowLayout(FlowLayout.CENTER, 70, 0) );
      	conteudoPNL.setLayout( new FlowLayout() );
        conteudoPNL.setBounds(10, y + 3, 522, 55);
        
        //conteudoPNL.add(detalhamento);
        graspReativo.setPreferredSize(new Dimension(163, 25));
        conteudoPNL.add(graspReativo);
        algoritmoGenetico.setPreferredSize(new Dimension(163, 25));
        conteudoPNL.add(algoritmoGenetico);
        metaheuristicaHibrida.setPreferredSize(new Dimension(163, 25));
        conteudoPNL.add(metaheuristicaHibrida);
		
		/** Rótulos dos equipamentos residenciais */
		equipamentoResidencial.setBounds(125, 25, 200, 30);
		
		xPostoTarifario 	  = 425;	yPostoTarifario = 25; 
		larguraPostoTarifario = 100; 	alturaPostoTarifario = 30;
		
		/** Rótulos dos postos tarifários */
		this.postoTarifarioForaPonta.setBounds(xPostoTarifario, 
											   yPostoTarifario, 
											   larguraPostoTarifario, 
											   alturaPostoTarifario);
		
		xPostoTarifario 	  = 630; 	yPostoTarifario 	 = 25;	
		larguraPostoTarifario = 100;	alturaPostoTarifario = 30;
		
		this.postoTarifarioIntermediario.setBounds(xPostoTarifario, 
				   								   yPostoTarifario, 
				   								   larguraPostoTarifario, 
				   								   alturaPostoTarifario);
		
		xPostoTarifario 	  = 860; 	yPostoTarifario 	 = 25;	
		larguraPostoTarifario = 100;	alturaPostoTarifario = 30;
		
		this.postoTarifarioPonta.setBounds(xPostoTarifario, 
				   						   yPostoTarifario, 
				   						   larguraPostoTarifario, 
				   						   alturaPostoTarifario);

		xPostoTarifario 	  = 189;	//yPostoTarifario = 75;
		//############ colocado
		yPostoTarifario = (75 + ( (linha) * 25 ) );

		
		larguraPostoTarifario = 170; 	alturaPostoTarifario = 20;
		
		this.totalTempoComputacionalGrasp.setHorizontalAlignment(JTextField.CENTER);
		this.totalTempoComputacionalGrasp.setEditable(false);
		this.totalTempoComputacionalGrasp.setBackground(new Color(248, 248, 255));
		this.totalTempoComputacionalGrasp.setBounds(xPostoTarifario, 
 				  									yPostoTarifario, 
 				  									larguraPostoTarifario, 
 				  									alturaPostoTarifario);
		
		this.totalTempoComputacionalGrasp.setText( Double.toString(tempoComputacionalFim) );
		
		/** Rótulos dos conteúdos dos tais referente aos postos tarifários */
		
		xPostoTarifario 	  = 463;	//yPostoTarifario = 75;
		//############ colocado
		yPostoTarifario = (75 + ( (linha) * 25 ) );

		
		larguraPostoTarifario = 103; 	alturaPostoTarifario = 20;
		
		this.totalForaPonta.setBounds(xPostoTarifario, 
				   					  yPostoTarifario, 
				   					  larguraPostoTarifario, 
				   					  alturaPostoTarifario);
		
		//this.totalForaPonta.setText("0,00");
		this.totalForaPonta.setHorizontalAlignment(JTextField.CENTER);
		this.totalForaPonta.setEditable(false);
		
		
		xPostoTarifario 	  = 670; 	//yPostoTarifario 	 = 75;	
		larguraPostoTarifario = 103;	alturaPostoTarifario = 20;
		
		//############ colocado
		yPostoTarifario = (75 + ( (linha) * 25 ) );

		this.totalIntermediario.setBounds(xPostoTarifario, 
				   						  yPostoTarifario, 
				   						  larguraPostoTarifario, 
				   						  alturaPostoTarifario);
		
		//this.totalIntermediario.setText("0,00");
		this.totalIntermediario.setHorizontalAlignment(JTextField.CENTER);
		this.totalIntermediario.setEditable(false);;
		
		xPostoTarifario 	  = 878; 	//yPostoTarifario 	 = 75;
		//############ colocado
		yPostoTarifario = (75 + ( (linha) * 25 ) );
		
		larguraPostoTarifario = 103;	alturaPostoTarifario = 20;
		
		//this.totalPonta.setText("0,00"); 
		this.totalPonta.setHorizontalAlignment(JTextField.CENTER);
		this.totalPonta.setEditable(false);
		this.totalPonta.setBackground(new Color(248, 248, 255));
		
		
		this.totalPonta.setBounds(xPostoTarifario, 
				   				  yPostoTarifario, 
				   				  larguraPostoTarifario, 
				   				  alturaPostoTarifario);
				
		
		/** Rótulos dos totais quanto aos postos tarifários */
		this.totalPostoTarifario 	 		  = new JLabel("Posto Tarifário");
		this.totalPostoTarifarioForaPonta 	  = new JLabel("Total");  
		this.totalPostoTarifarioIntermediario = new JLabel("Total"); 
		this.totalPostoTarifarioPonta 		  = new JLabel("Total");
		
		/** Rótulo do total quanto ao tempo computacional */
		this.totalTempoComputacional = new JLabel("Tempo Computacional (ms)");
		
		x = 10;	
		//y = 65;	
		largura = 165;	altura = 40;
		
		//############ colocado
		y = (65 + ( (linha) * 25 ) );
		
		this.totalTempoComputacional.setBounds(x, y, largura, altura);
		

		x = 130;	
		//y = 65;	
		largura = 165;	altura = 40;
		
		//############ colocado
		y = (65 + ( (linha) * 25 ) );
		
		//this.totalPostoTarifario.setBounds(x, y, largura, altura);
		
		x = 395;
		
		this.totalPostoTarifarioForaPonta.setBounds(x, y, largura, altura);

		x = 605;
		this.totalPostoTarifarioIntermediario.setBounds(x, y, largura, altura);
		
		x = 813;
		this.totalPostoTarifarioPonta.setBounds(x, y, largura, altura);

		
		/** Adicionando os rótulos no formulário*/
		this.add(cabecalhoEquipamento);
		this.add(cabecalhoEquipamentoEspecificoForaPonta);
		this.add(cabecalhoEquipamentoEspecificoIntermediario);
		this.add(cabecalhoEquipamentoEspecificoPonta);
		//this.add(this.getPostoTarifarioPonta());
		//this.add(this.getPostoTarifarioIntermediario());
		//this.add(this.getPostoTarifarioForaPonta());
		
		this.add(this.totalTempoComputacional);		
		
		this.add(this.getTotalPostoTarifario());
		this.add(this.getTotalPostoTarifarioForaPonta());		
		this.add(this.getTotalPostoTarifarioIntermediario());
		this.add(this.getTotalPostoTarifarioPonta());
		
		this.add(cabecalhoPostoTarifario);
		
		this.add(this.getTotalForaPonta());
		this.add(this.getTotalIntermediario());
		this.add(this.getTotalPonta());
		
		this.add(this.totalTempoComputacionalGrasp);
		
		
		
		/** Adicionando os botões no formulário */
		//this.add(this.getGraspBasico());
		//this.add(this.getGraspReativo());
		//this.add(this.getAlgoritmoGenetico());
		//this.add(this.getMetaheuristicaHibrida());
		
		this.add(conteudoPNL);
		
		this.add(this.getPainelJScrollPaneTabelaEquipamento());
		
		this.add(this.getPainelJScrollPaneTabelaForaPonta());
		
		this.add(this.getPainelJScrollPaneTabelaIntermediario());
		
		this.add(this.getPainelJScrollPaneTabelaPonta());
		
		this.setVisible(true);
		
		
		JPanel exportarPNL = new JPanel();
		exportarPNL.setBorder( new TitledBorder( "Exportar" ) );
        
        //############ colocado
        y = (95 + ( (linha) * 25 ) );
      		
        
        // redistribui os botões com um espaço maior entre o painel
        exportarPNL.setLayout( new FlowLayout());
        exportarPNL.setBounds(540, y + 3, 165, 55);		
		
		
		csv = new JButton(".CSV");		
		csv.setBounds(10, 700, 50, 50);
		
		csv.setPreferredSize(new Dimension(70, 25));
        exportarPNL.add(csv);
		
		
		csv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String nomeArquivo = "1comAplicacaoMetaheuristicaGraspBasico.csv";
				
				try {
					
					escreveArquivoEmCsv(nomeArquivo, _equipamentoConfigurado);
					
					Desktop.getDesktop().open(new File(nomeArquivo));
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
								
			}
		});

		relatorio = new JButton(".PDF");		
		
		relatorio.setBounds(400, 700, 50, 50);
		
		relatorio.setPreferredSize(new Dimension(70, 25));
        exportarPNL.add(relatorio);
		
		this.add(exportarPNL);
		
		relatorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JOptionPane.showMessageDialog(null, "Arquivo no formato PDF criado com sucesso!");
				
				try {
					
					String arquivoPDF = "C:\\Ifes\\workspace\\RespostaDemanda\\1relatorioGraspBasico.pdf";
					
					Document documento = new Document();
					
					PdfWriter.getInstance(documento, new FileOutputStream(arquivoPDF));
					
					documento.open();
					
					documento.setPageSize(PageSize.A4);
					
					Paragraph paragrafo = new Paragraph("Com aplicação de metaheurística GRASP Básico" + "\n\n");
					
					paragrafo.setAlignment(Element.ALIGN_CENTER);
										
					documento.add(paragrafo);

					int quantidadeColuna = colunaTabelaEquipamentoCompleta().length;
					//String [][] dadoTabelaEquipamentoCompleta;
					
					 
					PdfPCell celula1 	= new PdfPCell(new Paragraph("Nº"));
					celula1.setHorizontalAlignment(Element.ALIGN_CENTER); 
					celula1.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula2 	= new PdfPCell(new Paragraph("Aparelho"));
					celula2.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula2.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula3 	= new PdfPCell(new Paragraph("Deslocável"));
					celula3.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula3.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula4 	= new PdfPCell(new Paragraph("Potência [kW]"));
					celula4.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula4.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula5 	= new PdfPCell(new Paragraph("Tempo de uso [h]"));
					celula5.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula5.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula6 	= new PdfPCell(new Paragraph("Consumo [kWh]"));
					celula6.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula6.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula7 	= new PdfPCell(new Paragraph("Tempo de uso [h]"));
					celula7.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula7.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula8 	= new PdfPCell(new Paragraph("Consumo [kWh]"));
					celula8.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula8.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula9 	= new PdfPCell(new Paragraph("Tempo de uso [h]"));
					celula9.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula9.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula10 	= new PdfPCell(new Paragraph("Consumo [kWh]"));
					celula10.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula10.setBackgroundColor(new BaseColor(181, 181, 181));
										
					
					
					PdfPTable tabela0 = new PdfPTable(4);
					
					PdfPCell celula01 	= new PdfPCell(new Paragraph("Equipamento Residencial"));
					celula01.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula01.setBackgroundColor(new BaseColor(181, 181, 181));
					
					
					PdfPCell celula02 	= new PdfPCell(new Paragraph("Fora de Ponta"));
					celula02.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula02.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula03 	= new PdfPCell(new Paragraph("Intermediário"));
					celula03.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula03.setBackgroundColor(new BaseColor(181, 181, 181));
					
					PdfPCell celula04 	= new PdfPCell(new Paragraph("Ponta"));
					celula04.setHorizontalAlignment(Element.ALIGN_CENTER);
					celula04.setBackgroundColor(new BaseColor(181, 181, 181));
					
					tabela0.setWidthPercentage(100);
					
					tabela0.addCell(celula01);
					tabela0.addCell(celula02);
					tabela0.addCell(celula03);
					tabela0.addCell(celula04);
					
					float[] columnWidths0 = new float[]{112f, 52f, 52f, 52f};
					tabela0.setWidths(columnWidths0);
									
					PdfPTable tabela = new PdfPTable(quantidadeColuna);
					
					//tabela.setTotalWidth(351);
					
					tabela.setWidthPercentage(100);
					
					tabela.addCell(celula1);
					tabela.addCell(celula2);
					tabela.addCell(celula3);
					tabela.addCell(celula4);
					tabela.addCell(celula5);
					tabela.addCell(celula6);
					tabela.addCell(celula7);
					tabela.addCell(celula8);
					tabela.addCell(celula9);
					tabela.addCell(celula10);
					
					//tamanho de cada celula
					float[] columnWidths = new float[]{10f, 39f, 34f, 29f,23f,29f,23f,29f,23f,29f};
					tabela.setWidths(columnWidths);
					
					String conteudoCelula = new String();
					Paragraph paragrafoCedula;
					
					for (int i = 0; i < linha ; i++) {
						
						
						
						for (int j = 0; j < quantidadeColuna; j++) {
							
							if (j == 0) {
								
								///////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
							
								celula1 = new PdfPCell( paragrafoCedula );
							
								celula1.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula1.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula1.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula1);
							
							}
							
							if (j == 1) {
							

//								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
																
								celula2 = new PdfPCell(paragrafoCedula);
								
								celula2.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula2.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula2.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula2);
								
								
							}
							
							if (j == 2) {
								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
								celula3 = new PdfPCell(paragrafoCedula);
								
								celula3.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula3.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula3.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula3);
								
							}
							
							if (j == 3) {

								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
								celula4 = new PdfPCell(paragrafoCedula);
								
								celula4.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula4.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula4.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula4);
								
							}

							if (j == 4) {

								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
								celula5 = new PdfPCell(paragrafoCedula);
								
								celula5.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula5.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula5.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula5);
								
							}
							
							if (j == 5) {

								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////			
								celula6 = new PdfPCell(paragrafoCedula);
								
								celula6.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula6.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula6.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula6);
								
							}
							
							if (j == 6) {

								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
								celula7 = new PdfPCell(paragrafoCedula);
								
								celula7.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula7.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula7.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula7);
								
							}
							
							if (j == 7) {

								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////		
								celula8 = new PdfPCell(paragrafoCedula);
								
								celula8.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula8.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula8.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula8);
								
							}
							
							if (j == 8) {

								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
								celula9 = new PdfPCell(paragrafoCedula);
								
								celula9.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula9.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula9.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula9);
								
							}
							
							if (j == 9) {

								/////////////////////////////////////////////////////////
								conteudoCelula	 = dadoTabelaEquipamentoCompleta[i][j];
								paragrafoCedula = new Paragraph(new Phrase(11F, conteudoCelula, 
										FontFactory.getFont(FontFactory.TIMES_ROMAN, 11F)));
								///////////////////////////////////////////////////////////
								celula10 = new PdfPCell(paragrafoCedula);
								
								celula10.setHorizontalAlignment(Element.ALIGN_CENTER);
								
								// muda cor da linha
								if (i%2 == 0) {
									celula10.setBackgroundColor(new BaseColor(245, 245, 245));
									
								}
								else{
									
									celula10.setBackgroundColor(new BaseColor(232, 232, 232));
									
								}
								
								tabela.addCell(celula10);
								
							}
							
							
													
						}
						
					}
					
					documento.add(tabela0);
					
					documento.add(tabela);
					
					
					
					PdfPTable tabelaTotal = new PdfPTable(7);
					
					PdfPCell celula001 	= new PdfPCell(new Paragraph("CONDENSAÇÃO"));
					celula001.setHorizontalAlignment(Element.ALIGN_CENTER);
					// muda cor da linha
					if (linha%2 == 1) {
						
						celula001.setBackgroundColor(new BaseColor(232, 232, 232));
												
					}
					else{
						
						celula001.setBackgroundColor(new BaseColor(245, 245, 245));
						
						
					}				
										
					PdfPCell celula002 	= new PdfPCell(new Paragraph("Total"));
					celula002.setHorizontalAlignment(Element.ALIGN_CENTER);
					// muda cor da linha
					if (linha%2 == 1) {
						
						celula002.setBackgroundColor(new BaseColor(232, 232, 232));
												
					}
					else{
						
						celula002.setBackgroundColor(new BaseColor(245, 245, 245));
						
						
					}
					
					
					PdfPCell celula003 	= new PdfPCell(new Paragraph(totalForaPonta.getText()));
					celula003.setHorizontalAlignment(Element.ALIGN_CENTER);
					// muda cor da linha
					if (linha%2 == 1) {
						
						celula003.setBackgroundColor(new BaseColor(232, 232, 232));
												
					}
					else{
						
						celula003.setBackgroundColor(new BaseColor(245, 245, 245));
						
						
					}
					
					PdfPCell celula004 	= new PdfPCell(new Paragraph("Total"));
					celula004.setHorizontalAlignment(Element.ALIGN_CENTER);
					// muda cor da linha
					if (linha%2 == 1) {
						
						celula004.setBackgroundColor(new BaseColor(232, 232, 232));
												
					}
					else{
						
						celula004.setBackgroundColor(new BaseColor(245, 245, 245));
						
						
					}
					PdfPCell celula005 	= new PdfPCell(new Paragraph(totalIntermediario.getText()));
					celula005.setHorizontalAlignment(Element.ALIGN_CENTER);
					// muda cor da linha
					if (linha%2 == 1) {
						
						celula005.setBackgroundColor(new BaseColor(232, 232, 232));
												
					}
					else{
						
						celula005.setBackgroundColor(new BaseColor(245, 245, 245));
						
						
					}
										
					PdfPCell celula006 	= new PdfPCell(new Paragraph("Total"));
					celula006.setHorizontalAlignment(Element.ALIGN_CENTER);
					// muda cor da linha
					if (linha%2 == 1) {
						
						celula006.setBackgroundColor(new BaseColor(232, 232, 232));
												
					}
					else{
						
						celula006.setBackgroundColor(new BaseColor(245, 245, 245));
						
						
					}
					
					PdfPCell celula007 	= new PdfPCell(new Paragraph(totalPonta.getText()));
					celula007.setHorizontalAlignment(Element.ALIGN_CENTER);
					// muda cor da linha
					if (linha%2 == 1) {
						
						celula007.setBackgroundColor(new BaseColor(232, 232, 232));
												
					}
					else{
						
						celula007.setBackgroundColor(new BaseColor(245, 245, 245));
						
						
					}
					
					
					tabelaTotal.setWidthPercentage(100);
					
					tabelaTotal.addCell(celula001);
					tabelaTotal.addCell(celula002);
					tabelaTotal.addCell(celula003);
					tabelaTotal.addCell(celula004);
					tabelaTotal.addCell(celula005);
					tabelaTotal.addCell(celula006);
					tabelaTotal.addCell(celula007);
					
					
					float[] columnWidthsTotal = new float[]{112f, 23f, 29f, 23f, 29f, 23f, 29f};

					tabelaTotal.setWidths(columnWidthsTotal);

					documento.add(tabelaTotal);
					
					
					
					documento.close();
					
					Desktop.getDesktop().open(new File(arquivoPDF));
					
				} 
				catch (DocumentException de) {
					
					de.printStackTrace();
					
				}
				catch (IOException ioe) {
					
					ioe.printStackTrace();
					
				}
								
			}
		});
		
		selecionarEquipamentoEscalonado = new JCheckBox("Selecionar Equipamento Escalonado");
		selecionarEquipamentoEscalonado.setBounds(720 -4, y , 300, 25);
		
		selecionarEquipamentoEscalonado.setVisible(false);
		
		selecionarEquipamentoEscalonado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {

					//this.getTableCellRendererComponentEscalonad
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
			
		});

		this.add(selecionarEquipamentoEscalonado);
		
		resumo = new JButton("Resumo");		
		
		resumo.setBounds(720, y + 23 + 3, 120, 25);
		
		//resumo.setPreferredSize(new Dimension(70, 25));
        exportarPNL.add(resumo);
		
		this.add(resumo);
		
        resumo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ResumoEquipamentoMetaheuristicaGraspBasico resumoEquipamentoMetaheuristicaGraspBasico;
				
				double totalForaPonta, totalIntermediario, totalPonta;
				
				Locale br = new Locale("pt", "Brazil");
				
				NumberFormat formatoNumero = NumberFormat.getInstance(br);
				
				
				try {

					Number numeroDouble = formatoNumero.parse(getTotalForaPonta().getText());
					
					totalForaPonta 			= numeroDouble.doubleValue();

					numeroDouble = formatoNumero.parse(getTotalIntermediario().getText());
					
					totalIntermediario 		= numeroDouble.doubleValue();

					numeroDouble = formatoNumero.parse(getTotalPonta().getText());
					
					totalPonta 				= numeroDouble.doubleValue();

					foraPontaDinheiro 		= (totalForaPonta * FORA_PONTA_DINHEIRO);

					intermediarioDinheiro 	= (totalIntermediario * INTERMEDIARIO_DINHEIRO);

					pontaDinheiro 			= (totalPonta * PONTA_DINHEIRO);

					resumoEquipamentoMetaheuristicaGraspBasico = new ResumoEquipamentoMetaheuristicaGraspBasico( _totalResumo, 
							
																			 totalForaPonta,
						
																			 totalIntermediario,
																		
																			 totalPonta,																																		

																			 foraPontaDinheiro,
																		 
																			 intermediarioDinheiro,
																		 
																			 pontaDinheiro,
																			 
																			 (double)tempoComputacionalFim
						);

					// desabilita este formulário ao abrir outro
					GraspBasicoFormulario.this.setEnabled(true);

					resumoEquipamentoMetaheuristicaGraspBasico.setVisible(true);
									
					//throw new UnsupportedOperationException("not supported yet.");

					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
			}
			
		});

        detalhamento.setPreferredSize(new Dimension(163, 25));
        
        detalhamento.setBounds(860, y + 23 + 3, 120, 25);
        
        detalhamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {

					Detalhamento janelaDetalhamento = new Detalhamento(_equipamentoConfigurado, detalhamentoAplicacao);

					janelaDetalhamento.setVisible(true);

					// desabilita o formulário ao abrir outro

					GraspBasicoFormulario.this.setEnabled(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
			
		});
        
        this.add(detalhamento);
    	
        
        if (verificarQuantidadeCheckboxMarcado(_equipamentoConfigurado) >= 25 ) {

        	int aumentoTamanhoTela = 0;
        	
        	aumentoTamanhoTela = verificarQuantidadeCheckboxMarcado(_equipamentoConfigurado) - 25;
        	
        	aumentoTamanhoTela = aumentoTamanhoTela * 25;
        	
        	getContentPane().setLayout(new BorderLayout()); 
        	Container scrollPane = new Container();// 
        	//container1 = getContainer(); 
        	
        	
        	
        	
        	
        	scrollPane.add(cabecalhoEquipamento);
        	scrollPane.add(cabecalhoEquipamentoEspecificoForaPonta);
        	scrollPane.add(cabecalhoEquipamentoEspecificoIntermediario);
        	scrollPane.add(cabecalhoEquipamentoEspecificoPonta);
        	
    		
    		scrollPane.add(this.getTotalPostoTarifario());
    		scrollPane.add(this.getTotalPostoTarifarioForaPonta());
    		scrollPane.add(this.getTotalPostoTarifarioIntermediario());
    		scrollPane.add(this.getTotalPostoTarifarioPonta());
    		
    		
    		scrollPane.add(cabecalhoPostoTarifario);
    		
    		
    		scrollPane.add(this.getTotalForaPonta());
    		scrollPane.add(this.getTotalIntermediario());
    		scrollPane.add(this.getTotalPonta());
    		
    		

    		scrollPane.add(conteudoPNL);
    		
    		
    		scrollPane.add(this.getPainelJScrollPaneTabelaEquipamento());
    		
    		
    		scrollPane.add(this.getPainelJScrollPaneTabelaForaPonta());
    		
    		
    		scrollPane.add(this.getPainelJScrollPaneTabelaIntermediario());
    		
    		
    		scrollPane.add(this.getPainelJScrollPaneTabelaPonta());
    		
    		scrollPane.add(exportarPNL);
    		
    		scrollPane.add(resumo);    		
    		
    		scrollPane.add(detalhamento);    	    		
    						
    		this.setBounds(0, 0, this.getWidth() + 20, this.getHeight());
    		
    		scrollPane.setPreferredSize(new Dimension(this.getWidth() - 50, this.getHeight() - 35 + aumentoTamanhoTela)); 
        	
    		JScrollPane scroll = new JScrollPane(scrollPane);
    		
    		getContentPane().add(scroll, BorderLayout.CENTER);
    		
        }
        
        //this.add(detalhamento); 
			
	}
		
	public void escreveArquivoEmCsv(String _nomeArquivo, EquipamentoConfigurado _equipamentoConfigurado) throws FileNotFoundException {
		
		try (PrintWriter escreverCsv = new PrintWriter(_nomeArquivo)){
			
			String [] colunaTabela = new String [10];

			int quantidadeLinha = verificarQuantidadeCheckboxMarcado(_equipamentoConfigurado);
			
			String [][] dadoTabelaCompleta = new String[quantidadeLinha][10];
			
			dadoTabelaCompleta = dadoTabelaCompleta(_equipamentoConfigurado);
			
			colunaTabela = colunaTabelaEquipamentoCompleta();
			
			for (int i = 0; i < colunaTabela.length; i++) {
				
				if (i == (colunaTabela.length - 1)) {
					
					escreverCsv.write( colunaTabela[i] + ",\n");
					
				}
				else {
				
					escreverCsv.write( colunaTabela[i] + ",");
					
				}			
				
			}
			
			for (int i = 0; i < quantidadeLinha; i++) {
				
				for (int j = 0; j < 10; j++) {
				
					if (j == 9){
					
						// caso o número seja formatado com vírgula, é substituído por ponto
						escreverCsv.write( dadoTabelaCompleta[i][j].replaceAll( "," , "." ) + ",\n");
						
					}
					else {
						
						// caso o número seja formatado com vírgula, é substituído por ponto
						escreverCsv.write( dadoTabelaCompleta[i][j].replaceAll( "," , "." ) + ",");
						
					}
					
				}
								
			}
			
			escreverCsv.write( "\n");
			escreverCsv.write( "" + ","); escreverCsv.write( "" + ",");
			escreverCsv.write( "" + ","); escreverCsv.write( "" + ",");
			escreverCsv.write( "Total Fora de Ponta: " + ",");
			// caso o número seja formatado com vírgula, é substituído por ponto
			escreverCsv.write( this.totalForaPonta.getText().replaceAll( "," , "." ) + ",");
			escreverCsv.write( "Total Intermediário: " + ",");
			// caso o número seja formatado com vírgula, é substituído por ponto
			escreverCsv.write( this.totalIntermediario.getText().replaceAll( "," , "." ) + ",");
			escreverCsv.write( "Total Ponta: " + ",");
			// caso o número seja formatado com vírgula, é substituído por ponto
			escreverCsv.write( this.totalPonta.getText().replaceAll( "," , "." ) + ",");
			
			
			JOptionPane.showMessageDialog(null, "Arquivo no formato CSV gerado com sucesso!");
			
		}
		catch (Exception e) {
			
			System.out.println("Erro ao escrever o arquivo");
			
			e.printStackTrace();
			
		}
		
	};
		
	public String [] colunaTabelaEquipamento(){
		
		String [] nomeColuna = {"Nº", "Aparelho", "Deslocável", "Potência [kW]"};
		
		return nomeColuna;
		
	}
	
	public static String [] colunaTabelaEquipamentoCompleta(){
		
		String [] nomeColuna = {"Nº", "Aparelho", "Deslocável", "Potência [kW]", "Tempo de uso [h]", "Consumo [kWh]", "Tempo de uso [h]", "Consumo [kWh]", "Tempo de uso [h]", "Consumo [kWh]"};
		
		return nomeColuna;
		
	}
	
	public String [][] dadoTabelaCompleta(EquipamentoConfigurado _equipamentoConfigurado) {
		
		int quantidadeCheckboxMarcado = verificarQuantidadeCheckboxMarcado(_equipamentoConfigurado);
		
		//colunas da tabela: "Nº", "Aparelho", "Deslocável", "Potência [kW]", "Tempo de uso [h]", "Consumo [kWh]", "Tempo de uso [h]", "Consumo [kWh]", "Tempo de uso [h]", "Consumo [kWh]"
		int quantidadeColunaTabela = 10;
		
		String [][] matrizDado = new String[quantidadeCheckboxMarcado][quantidadeColunaTabela];
		
		DecimalFormat formatarDecimal = new DecimalFormat("#,###,##0.00");
		
		/** número do equipamento: apenas na 1ª coluna */
		for (int i = 0; i < quantidadeCheckboxMarcado; i++) {
		
			for (int j = 0; j < 1; j++) {
				
				if (j == 0) {
				
					matrizDado[i][j] = Integer.toString( i+1 );
					
				}
				
			}
			
		}
		
		int indiceMatrizDados = 0;
		
		/** nome do aparelho: 2ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 1; j < 2; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {

					matrizDado[indiceMatrizDados][j] = _equipamentoConfigurado.getTabelaEletrica()[i].getNomeTipoEquipamento();

					indiceMatrizDados++;
					
				}				

			}
		
		}
		
		indiceMatrizDados = 0;
		
		/** equipamento deslocável/não deslocável: 3ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 2; j < 3; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
					
					if (_equipamentoConfigurado.getTabelaEletrica()[i].isEquipamentoDeslocavel()) {
					
						matrizDado[indiceMatrizDados][j] = "sim";
					
						indiceMatrizDados++;
						
					}
					else {
					
						matrizDado[indiceMatrizDados][j] = "não";
						
						indiceMatrizDados++;
						
					}
					
				}				

			}
		
		}	
		
		indiceMatrizDados = 0;
		
		/** potência em kW do equipamento: 4ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
						
			for (int j = 3; j < 4; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
					
					matrizDado[indiceMatrizDados][j] = formatarDecimal.format( (double)  _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw()  );
					
					indiceMatrizDados++;
					
				}				

			}
		
		}	
		
		indiceMatrizDados = 0;

		/** Tempo de uso em horas para cada equipamento fora ponta: 5ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 4; j < 5; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
					
					matrizDado[indiceMatrizDados][j] = Integer.toString( _equipamentoConfigurado.getVetorPostoTarifario().getVetorPostoTarifario()[i].getForaPonta());
					
					indiceMatrizDados++;
					
				}				

			}
		
		}	
		
		indiceMatrizDados = 0;
		
		double tempoConsumoForaPonta, potenciaForaPonta, totalForaPonta;
		
		tempoConsumoForaPonta = 0; 
		
		potenciaForaPonta = 0; 
		
		totalForaPonta = 0;		
		
		/** "Consumo em kWh para cada equipamento": 6ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 5; j < 6; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
			
					tempoConsumoForaPonta = (double) _equipamentoConfigurado.getVetorPostoTarifario().getVetorPostoTarifario()[i].getForaPonta();
					
					potenciaForaPonta 	 = (double) _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();					
					
					matrizDado[indiceMatrizDados][j] = formatarDecimal.format( (double) tempoConsumoForaPonta * (double) potenciaForaPonta) ;
					
					totalForaPonta = (double) totalForaPonta + ( (double) tempoConsumoForaPonta * (double) potenciaForaPonta);
					
					indiceMatrizDados++;
					
				}				

			}
		
		}
		
		//atualiza o total do Posto Tarifário Fora de Ponta
		this.totalForaPonta.setText( formatarDecimal.format( (double)totalForaPonta) );
		this.totalForaPonta.setBackground(new Color(248, 248, 255));
		
		indiceMatrizDados = 0;
		
		/** Tempo de uso em horas para cada equipamento intermediário: 7ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 6; j < 7; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
					
					matrizDado[indiceMatrizDados][j] = Integer.toString( _equipamentoConfigurado.getVetorPostoTarifario().getVetorPostoTarifario()[i].getIntermediario());
					
					indiceMatrizDados++;
					
				}				

			}
		
		}	
		
		indiceMatrizDados = 0;
		
		double tempoConsumoIntermediario, potenciaIntermediario, totalIntermediario;
		
		tempoConsumoIntermediario = 0; 
		
		potenciaIntermediario = 0; 
		
		totalIntermediario = 0;
		
		/** Consumo em kWh para cada equipamento no posto tarifário intermediário : 8ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 7; j < 8; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
			
					tempoConsumoIntermediario = (double) _equipamentoConfigurado.getVetorPostoTarifario().getVetorPostoTarifario()[i].getIntermediario();
					
					potenciaIntermediario     = (double) _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
					matrizDado[indiceMatrizDados][j] = formatarDecimal.format( (double) tempoConsumoIntermediario * (double)potenciaIntermediario) ;
					
					totalIntermediario = (double) totalIntermediario + ((double) tempoConsumoIntermediario * (double)potenciaIntermediario);
					
					indiceMatrizDados++;
					
				}				

			}
		
		}
		
		//atualiza o total do Posto Tarifário Intermediário
		this.totalIntermediario.setText( formatarDecimal.format( (double)totalIntermediario) );
		this.totalIntermediario.setBackground(new Color(248, 248, 255));
		
		indiceMatrizDados = 0;

		/** Tempo de uso em horas para cada equipamento no posto tarifário Ponta: 9ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 8; j < 9; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
					
					matrizDado[indiceMatrizDados][j] = Integer.toString( _equipamentoConfigurado.getVetorPostoTarifario().getVetorPostoTarifario()[i].getPonta());
					
					indiceMatrizDados++;
					
				}				

			}
		
		}	
		
		indiceMatrizDados = 0;
		
		double tempoConsumoPonta, potenciaPonta, totalPonta;
		
		tempoConsumoPonta = 0;
		
		potenciaPonta  = 0; 
		
		totalPonta = 0;
		
		/** Consumo em kWh para cada equipamento no posto tarifário Ponta: 10ª coluna */ 
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			for (int j = 9; j < 10; j++) {

				if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
			
					tempoConsumoPonta = (double) _equipamentoConfigurado.getVetorPostoTarifario().getVetorPostoTarifario()[i].getPonta();
					
					potenciaPonta  	  = (double) _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
					matrizDado[indiceMatrizDados][j] = formatarDecimal.format( (double) tempoConsumoPonta * (double)potenciaPonta) ;
					
					totalPonta = totalPonta + ( (double) tempoConsumoPonta * (double)potenciaPonta); 
					
					indiceMatrizDados++;
					
				}				

			}
		
		}
		
		//atualiza o total do Posto Tarifário Intermediário
		this.totalPonta.setText( formatarDecimal.format( (double)totalPonta) );				
	
		return matrizDado;
		
	}
	
	public String [][] dadoEquipamentoTabela(String [][] _dadoTabelaEquipamentoCompleta, int _linha){
	
		int coluna = 4;
		
		String [][] dadoEquipamentoTabela = new String [_linha][coluna];
		
		for (int i = 0; i < _linha; i++) {
		
			for (int j = 0; j < 1; j++) {
				
				dadoEquipamentoTabela[i][j] = _dadoTabelaEquipamentoCompleta[i][j];
				
			}
			
		}
		
		for (int i = 0; i < _linha; i++) {
			
			for (int j = 1; j < 2; j++) {
				
				dadoEquipamentoTabela[i][j] = _dadoTabelaEquipamentoCompleta[i][j];
				
			}
			
		}
		
		for (int i = 0; i < _linha; i++) {
			
			for (int j = 2; j < 3; j++) {
				
				dadoEquipamentoTabela[i][j] = _dadoTabelaEquipamentoCompleta[i][j];
				
			}
			
		}
		
		for (int i = 0; i < _linha; i++) {
			
			for (int j = 3; j < 4; j++) {
				
				dadoEquipamentoTabela[i][j] = _dadoTabelaEquipamentoCompleta[i][j];
				
			}
			
		}
		
		return dadoEquipamentoTabela;
		
	}
		
	public static int verificarQuantidadeCheckboxMarcado(EquipamentoConfigurado _equipamentoConfigurado){
								
		int contaQuantidadeCheckboxMarcado = 0;
		
		// monta vetor de nomes dos equipamentos
		for (int i = 0; i < _equipamentoConfigurado.getTabelaEletrica().length; i++) {
			
			if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1 ) {
								
				contaQuantidadeCheckboxMarcado++;
				
			}				
			
		}
				
		return contaQuantidadeCheckboxMarcado;		
		
	}
	
	public String [][]  dadoTabelaEquipamento() {
		
		String [][] dados = { 
		{"1", "Churrasqueira elétrica"	   , "sim", "3,00"}
			};
		
		return dados;
		
	}
	
	public String [] colunaPostoTarifario(){
		
		String [] nomeColuna = {"Tempo de uso [h]", "Consumo [kWh]"};
		
		return nomeColuna;
		
	}
		
	public String[][] dadoPostoTarifarioForaPonta(String[][] _dadoTabelaEquipamentoCompleta, int _linha) {
		
		int coluna = 2;

		String[][] dadoEquipamentoTabela = new String[_linha][coluna];

		for (int i = 0; i < _linha; i++) {

			for (int j = 4; j < 6; j++) {

				dadoEquipamentoTabela[i][j - 4] = _dadoTabelaEquipamentoCompleta[i][j];

			}

		}
		
		return dadoEquipamentoTabela;

	}
	
	public String[][] dadoPostoTarifarioIntermediario(String[][] _dadoTabelaEquipamentoCompleta, int _linha) {

		int coluna = 2;

		String[][] dadoEquipamentoTabela = new String[_linha][coluna];

		for (int i = 0; i < _linha; i++) {

			for (int j = 6; j < 8; j++) {

				dadoEquipamentoTabela[i][j - 6] = _dadoTabelaEquipamentoCompleta[i][j];

			}

		}
		
		return dadoEquipamentoTabela;

	}

	public String[][] dadoPostoTarifarioPonta(String[][] _dadoTabelaEquipamentoCompleta, int _linha) {

		int coluna = 2;

		String[][] dadoEquipamentoTabela = new String[_linha][coluna];

		for (int i = 0; i < _linha; i++) {

			for (int j = 8; j < 10; j++) {

				dadoEquipamentoTabela[i][j - 8] = _dadoTabelaEquipamentoCompleta[i][j];

			}

		}
		
		return dadoEquipamentoTabela;

	}
	
	public String [][] dadoPostoTarifarioIntermediario(){
		
		String [][] dados = { 
				
				{"1", "3,00"}				
				};
				
		return dados;
		
	}

	public String [][] dadoPostoTarifarioPonta(){
		
		String [][] dados = { 
				{"2", "6,00"}
					};
				
		return dados;
		
	}

	public class RenderTable implements TableCellRenderer{
		
		public Component getTableCellRendererComponent (JTable jtable, Object o, boolean selected, boolean focus, int row, int cel) {
		
			JPanel painel = new JPanel();
			
			JLabel label = new JLabel((o).toString());			
			
			if (row%2 == 0) {
			
				painel.setBackground(new Color(245, 245, 245));

			}
			else {
		
				painel.setBackground(new Color(232, 232, 232));
			
			}
			
			label.setForeground(Color.BLACK);
			
			/** Altera a letra e o tamanho dos dados */
			label.setFont(new Font ("Tahome", Font.PLAIN, 11));
			
			painel.add(label);
			
			return painel;
			
		}
		
		public Component getTableCellRendererComponentEscalonado (JTable jtable, Object o, boolean selected, boolean focus, int row, int cel) {
			
			JPanel painel = new JPanel();
			
			JLabel label = new JLabel((o).toString());			

			if (row == 1) {
				
				painel.setBackground(new Color(255, 0, 0));
				
				label.setFont(new Font ("Tahome", Font.BOLD, 11));
				
			}
			
			painel.add(label);
			
			return painel;
			
		}
		
	}
	
	public void aplicarGraspBasico(EquipamentoConfigurado _equipamentoConfigurado) {

		
		
		DecimalFormat formatarDecimal = new DecimalFormat("#,###,##0.0000");
		
		detalhamentoAplicacao += "#################################################################" + "\n";
		detalhamentoAplicacao += "######################### GRASP BÁSICO ##########################"+ "\n";
		detalhamentoAplicacao += "#################################################################"+ "\n\n";
		
		detalhamentoAplicacao += "#################################################################" + "\n";
		detalhamentoAplicacao += "#################### EQUIPAMENTOS ESCOLHIDOS ####################"+ "\n";
		detalhamentoAplicacao += "#################################################################"+ "\n";
		
		detalhamentoAplicacao += "\n";
		
		detalhamentoAplicacao += _equipamentoConfigurado.toStringEquipamentoEscolhido();
		
		detalhamentoAplicacao += "\n\n";
		
		// Escolher um valor para alfa entre 0.0 (totalmente guloso) e 1.0 (totalmente aleatorizado)
		double alfa, menorCusto, maiorCusto, lcr;
		
		menorCusto = 0.00; 
		
		maiorCusto = 0.00;

		alfa = 0.5;
		
		// Mensagem para a escolha do algoritmo Grasp tradicional 
		detalhamentoAplicacao += "O valor de Alfa está fixo - " + "Alfa: " + Double.toString(alfa);

		detalhamentoAplicacao += "\n\n";
		
		detalhamentoAplicacao += "ORDENA POR kW (DO MENOR PARA O MAIOR)";
		
		_equipamentoConfigurado.ordenarEquipamentoConfigurado(_equipamentoConfigurado);
		
		detalhamentoAplicacao +=_equipamentoConfigurado.toStringEquipamentoEscolhido();
		
		detalhamentoAplicacao += "\n\n";
		
		menorCusto = 0.00;  
		
		maiorCusto = 0.00;
		
		// inicializa menorCusto e maiorCusto
		menorCusto = menorCusto(_equipamentoConfigurado);
		
		maiorCusto = maiorCusto(_equipamentoConfigurado);
		
		// Define a faixa do custo médio em watts (acima de 50% do custo total)
		lcr = menorCusto + alfa * (maiorCusto - menorCusto);
		
		ListaCandidatoRestrito listaLcr = new ListaCandidatoRestrito();
		
		listaLcr = construirListaCandidatoRestrito(_equipamentoConfigurado, listaLcr, lcr);
	
		System.out.println(listaLcr.toString());
		
		detalhamentoAplicacao += "#################################################################"     + "\n";
		detalhamentoAplicacao += "################## Alfa: "        + formatarDecimal.format(alfa)       + " #################################" + "\n"; 
		detalhamentoAplicacao += "################## Menor Custo: " + formatarDecimal.format(menorCusto) +" ##########################" + "\n"; 
		detalhamentoAplicacao += "################## Maior Custo: " + formatarDecimal.format(maiorCusto) + " ##########################" + "\n";
		detalhamentoAplicacao += "################## LCR: "         + formatarDecimal.format(lcr)        +" ##################################" + "\n";
		detalhamentoAplicacao += "#################################################################"     + "\n";
		
		System.out.println(detalhamentoAplicacao);
		
		detalhamentoAplicacao += "\n\n";
		detalhamentoAplicacao += "#################################################################" + "\n";
		detalhamentoAplicacao += "################# LISTA DE CANDIDATOS RESTRITOS #################"+ "\n";
		detalhamentoAplicacao += "#################################################################"+ "\n\n";
		
		detalhamentoAplicacao += listaLcr.toString();
		
		detalhamentoAplicacao += deslocamentoGrasp(listaLcr, _equipamentoConfigurado);
		
		_equipamentoConfigurado.ordenarEquipamentoConfiguradoPorNome(_equipamentoConfigurado);
		
		detalhamentoAplicacao += "#################################################################" + "\n";
		detalhamentoAplicacao += "################## METAHEURÍSTICA GRASP BÁSICO ##################"+ "\n";
		detalhamentoAplicacao += "#################################################################"+ "\n\n";
		
		detalhamentoAplicacao +=_equipamentoConfigurado.toStringEquipamentoEscolhido();
		
	}
	
	public void menorMaiorCusto(double _menorCusto, double _maiorCusto, EquipamentoConfigurado _equipamentoConfigurado) {
		
		int primeiraVez = 0;
		
		for (int i = 0; i < _equipamentoConfigurado.getCheckboxEquipamento().getVetor().length; i++) {
			
			// se for um equipamento selecionado
			if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {

				// primeiro
				if (primeiraVez == 0) {
					
					_menorCusto = _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
					primeiraVez++;
					
				}
				
				//último
				if (_equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw() >= _maiorCusto ) {
					
					_maiorCusto = _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
				}
				
			}
			
		}

		
		for (int i = 0; i < _equipamentoConfigurado.getCheckboxEquipamento().getVetor().length; i++) {
			
			// se for um equipamento selecionado
			if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
				
				if (_equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw() <= _menorCusto ) {
			
					_menorCusto = _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
				}
				
				if (_equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw() > _maiorCusto ) {
					
					_maiorCusto = _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
				}
				
			}
			
		}
		
	}

	public double menorCusto(EquipamentoConfigurado _equipamentoConfigurado) {
		
		int primeiraVez = 0;
		
		double menorCusto = 0.00;
		
		for (int i = 0; i < _equipamentoConfigurado.getCheckboxEquipamento().getVetor().length; i++) {
			
			// se for um equipamento selecionado
			if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {

				// primeiro
				if (primeiraVez == 0) {
					
					menorCusto = _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
					primeiraVez++;
					
				}
				
			}
			
		}

		
		for (int i = 0; i < _equipamentoConfigurado.getCheckboxEquipamento().getVetor().length; i++) {
			
			// se for um equipamento selecionado
			if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
				
				if (_equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw() <= menorCusto ) {
			
					menorCusto = _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
				}
				
			}
			
		}
		
		return menorCusto;
		
	}

	public double maiorCusto(EquipamentoConfigurado _equipamentoConfigurado) {
		
		int primeiraVez = 0;
		
		double maiorCusto = 0.00;
		
		for (int i = 0; i < _equipamentoConfigurado.getCheckboxEquipamento().getVetor().length; i++) {
			
			// se for um equipamento selecionado
			if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
				
				if (_equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw() >= maiorCusto ) {
					
					maiorCusto = _equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw();
					
				}
				
			}
			
		}
		
		return maiorCusto;
		
	}

	
	public ListaCandidatoRestrito construirListaCandidatoRestrito(EquipamentoConfigurado _equipamentoConfigurado,
																  ListaCandidatoRestrito _listaLcr,
																  double _lcr) {

		
		EquipamentoCandidato equipamentoCandidato; 
		
		for (int i = 0; i < _equipamentoConfigurado.getCheckboxEquipamento().getVetor().length; i++) {

			// Se o equipamento foi selecionado
			if (_equipamentoConfigurado.getCheckboxEquipamento().getVetor()[i] == 1) {
				
				// Monta uma lista de candidatos restrito: acima de 50% do custo total
				if (_equipamentoConfigurado.getTabelaEletrica()[i].converterWattsParaQuilowatts_Kw() >= _lcr) {

					// Se o equipamento é deslocável, insere na lista de candidatos restritos
					//if (_equipamentoConfigurado.getTabelaEletrica()[i].isEquipamentoDeslocavel()) {

						equipamentoCandidato = new EquipamentoCandidato();
						
						equipamentoCandidato.setAll(i, _equipamentoConfigurado.getTabelaEletrica()[i]);
						
						_listaLcr.insereUltimo(equipamentoCandidato);
						
					//}

				}

			}

		}

		System.out.println(_listaLcr.toString());
		
		return _listaLcr;

	}
	
	public String deslocamentoGrasp(ListaCandidatoRestrito _listaLcr, EquipamentoConfigurado _equipamentoConfigurado) {
	
		String deslocamentoGrasp = new String();
		
		No no = _listaLcr.getPrimeiro(); 
		
		while (no != null) {

			int indice = no.getEquipamentoCandidato().getIndiceCheckboxEquipamentoETabelaEletrica();
			
			if (no.getEquipamentoCandidato().getTabelaEletrica().isEquipamentoDeslocavel() == true) {
			
				// escalona a Hora do CheckboxEquipamento (índice)
				deslocamentoGrasp += _equipamentoConfigurado.escalonarHora(indice);

				deslocamentoGrasp += _equipamentoConfigurado.imprimeHoraUsadaDisponivel(indice);

				deslocamentoGrasp += "\n\n";

			}

			no = no.getProximo();

		}
		
		return deslocamentoGrasp;
		
	}
	
	public String deslocamentoAG(ListaCandidatoRestrito _listaLcr, EquipamentoConfigurado _equipamentoConfigurado) {
		
		String deslocamentoGrasp = new String();
		
		No no = _listaLcr.getPrimeiro(); 
		
		while (no != null) {

			int indice = no.getEquipamentoCandidato().getIndiceCheckboxEquipamentoETabelaEletrica();
			
			if (no.getEquipamentoCandidato().getTabelaEletrica().isEquipamentoDeslocavel() == true) {
			
				// escalona a Hora do CheckboxEquipamento (índice)
				deslocamentoGrasp += _equipamentoConfigurado.escalonarHora(indice);

				deslocamentoGrasp += _equipamentoConfigurado.imprimeHoraUsadaDisponivel(indice);

				deslocamentoGrasp += "\n\n";

			}

			no = no.getProximo();

		}
		
		return deslocamentoGrasp;
		
	}

	
}
