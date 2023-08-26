package janela;

import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import eletrica.TabelaEletrica;
import listaCheckbox.CheckboxMenuPrincipal;
import tabelaCargaEquipamento.ConsumoEletrico;

public class AparelhoResidencial extends JFrame{
	
	JLabel selecaoEquipamentosResidenciais;
	
	JCheckBox aquecedorDeAmbiente		,
			  aspiradorDePo				,
			  batedeira					,
			  bombaDeAgua				,
			  cafeteiraEletrica_Resid	,
			  churrasqueiraEletrica		,
			  chuveiroEletrico			,
			  computador				,
			  condicionadorDeAr			,
			  conjuntoDeSom				,
			  cortadorDeGrama			,
			  dvdPlayer					,
			  enceradeira				,
			  espremedorDeFrutas		,
			  exaustor					,
			  ferroEletrico				,
			  fogaoEletrico2Bocas		,
			  fogaoEletricoDe4Bocas		,
			  fornoEletricoGrande		,
			  fornoEletricoPequeno		,
			  fornoDeMicroOndas			,
			  freezerHorizontal			,
			  freezerVertical			,
			  geladeiraDuplex			,
			  geladeiraSimples			,
			  grill						,
			  impressora				,
			  liquidificador			,
			  maquinaDeCostura			,
			  maquinaDeLavarLouca		,
			  maquinaDeLavarRoupa		,
			  projetorDeSlides			,
			  radioRelogio				,
			  secadorDeCabelo			,
			  secadoraDeRoupas			,
			  televisor21				,
			  torneiraEletrica			,
			  torradeira				,
			  vetilador					,
			  videoGame					;

	int [] equipamentoEscolhido = new int [40];
	
	int quantidadeEquipamento;
	
	JButton botaoConfirmarEquipamento, botaoEscolherAleatoriamente;
	
	Container container;
	
	public AparelhoResidencial(CheckboxMenuPrincipal [] _checkboxMenuPrincipal) {
		
		this.setTitle("Equipamentos Residenciais");
		
		this.setBounds(100, 100, 920, 280);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		// não permite maximizar ou alterar o tamanho do formulário/frame
		this.setResizable(false);		

		// Centraliza o formulário na tela
		this.setLocationRelativeTo(null);
		
		container = this.getContentPane();
		
		container.setLayout(null);
		
		selecaoEquipamentosResidenciais = new JLabel("Selecione o(s) equipamento(s) de uso residencial:");
				
		selecaoEquipamentosResidenciais.setFont(new Font ("CINZEL DECORATIVE", Font.BOLD, 14));
		
		selecaoEquipamentosResidenciais.setBounds(225, 5, 430, 25);
		
		container.add(selecaoEquipamentosResidenciais);
		
		int posicaox = 20;
		
		int posicaoy = 30;
		
		// Organiza a cada 8 componentes
		int contaComponente = 0 ;
		
		// todos checkbox
		
		/** ################################################################### */
		/** ######################## EQUIPAMENTO 1 ############################ */
		/** ################################################################### */
		
		aquecedorDeAmbiente = new JCheckBox();
		
		aquecedorDeAmbiente	= _checkboxMenuPrincipal[0].getCheckBox();

		aquecedorDeAmbiente.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(aquecedorDeAmbiente);
		
		aquecedorDeAmbiente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (aquecedorDeAmbiente.isSelected() == true) {
					
					equipamentoEscolhido[0] = 1;
					
					System.out.println(equipamentoEscolhido[0]);
					
				}
				else {
					
					equipamentoEscolhido[0] = 0;
					
					System.out.println(equipamentoEscolhido[0]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;		
		
		/** ################################################################### */
		/** ######################## EQUIPAMENTO 2 ############################ */
		/** ################################################################### */
		
		aspiradorDePo = new JCheckBox();
		
		aspiradorDePo = _checkboxMenuPrincipal[1].getCheckBox();

		aspiradorDePo.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(aspiradorDePo);
		
		aspiradorDePo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (aspiradorDePo.isSelected() == true) {
					
					equipamentoEscolhido[1] = 1;
					
					System.out.println(equipamentoEscolhido[1]);
					
				}
				else {
					
					equipamentoEscolhido[1] = 0;
					
					System.out.println(equipamentoEscolhido[1]);
					
				}
			
			}
		});
		
		posicaoy = posicaoy + 20;
				
		/** ################################################################### */
		/** ######################## EQUIPAMENTO 3 ############################ */
		/** ################################################################### */
		
		batedeira = new JCheckBox();
		
		batedeira = _checkboxMenuPrincipal[2].getCheckBox();

		batedeira.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(batedeira);
		
		batedeira.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (batedeira.isSelected() == true) {
					
					equipamentoEscolhido[2] = 1;
					
					System.out.println(equipamentoEscolhido[2]);
					
				}
				else {
					
					equipamentoEscolhido[2] = 0;
					
					System.out.println(equipamentoEscolhido[2]);
					
				}
				
			}
		});
		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ######################## EQUIPAMENTO 4 ############################ */
		/** ################################################################### */
		
		bombaDeAgua	= new JCheckBox();
		
		bombaDeAgua = _checkboxMenuPrincipal[3].getCheckBox();

		bombaDeAgua.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(bombaDeAgua);
		
		bombaDeAgua.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (bombaDeAgua.isSelected() == true) {
					
					equipamentoEscolhido[3] = 1;
					
					System.out.println(equipamentoEscolhido[3]);
					
				}
				else {
					
					equipamentoEscolhido[3] = 0;
					
					System.out.println(equipamentoEscolhido[3]);
					
				}
				
			}
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ######################## EQUIPAMENTO 5 ############################ */
		/** ################################################################### */
		
		cafeteiraEletrica_Resid	= new JCheckBox();
		
		cafeteiraEletrica_Resid = _checkboxMenuPrincipal[4].getCheckBox();

		cafeteiraEletrica_Resid.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(cafeteiraEletrica_Resid);
		
		cafeteiraEletrica_Resid.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (cafeteiraEletrica_Resid.isSelected() == true) {
					
					equipamentoEscolhido[4] = 1;
					
					System.out.println(equipamentoEscolhido[4]);
					
				}
				else {
					
					equipamentoEscolhido[4] = 0;
					
					System.out.println(equipamentoEscolhido[4]);
					
				}
				
			}
		});
		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ######################## EQUIPAMENTO 6 ############################ */
		/** ################################################################### */
		
		churrasqueiraEletrica = new JCheckBox();
		
		churrasqueiraEletrica = _checkboxMenuPrincipal[5].getCheckBox();

		churrasqueiraEletrica.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(churrasqueiraEletrica);
		
		churrasqueiraEletrica.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (churrasqueiraEletrica.isSelected() == true) {
					
					equipamentoEscolhido[5] = 1;
					
					System.out.println(equipamentoEscolhido[5]);
					
				}
				else {
					
					equipamentoEscolhido[5] = 0;
					
					System.out.println(equipamentoEscolhido[5]);
					
				}
				
			}
		});

		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ######################## EQUIPAMENTO 7 ############################ */
		/** ################################################################### */
		
		chuveiroEletrico = new JCheckBox();
		
		chuveiroEletrico = _checkboxMenuPrincipal[6].getCheckBox();

		chuveiroEletrico.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(chuveiroEletrico);
		
		chuveiroEletrico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (chuveiroEletrico.isSelected() == true) {
					
					equipamentoEscolhido[6] = 1;
					
					System.out.println(equipamentoEscolhido[6]);
					
				}
				else {
					
					equipamentoEscolhido[6] = 0;
					
					System.out.println(equipamentoEscolhido[6]);
					
				}
				
			}
		});
		
		posicaoy = posicaoy + 20;
				
		/** ################################################################### */
		/** ######################## EQUIPAMENTO 8 ############################ */
		/** ################################################################### */

		computador = new JCheckBox();

		computador = _checkboxMenuPrincipal[7].getCheckBox();

		computador.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(computador);
		
		computador.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (computador.isSelected() == true) {
					
					equipamentoEscolhido[7] = 1;
					
					System.out.println(equipamentoEscolhido[7]);
					
				}
				else {
					
					equipamentoEscolhido[7] = 0;
					
					System.out.println(equipamentoEscolhido[7]);
					
				}
				
			}
		});

		
		contaComponente = 0;
		
		posicaox = posicaox + 180;
		
		posicaoy = 30;
		
		/** ################################################################### */
		/** ######################## EQUIPAMENTO 9 ############################ */
		/** ################################################################### */

		// 8 componentes
		
		condicionadorDeAr = new JCheckBox();
		
		condicionadorDeAr = _checkboxMenuPrincipal[8].getCheckBox();

		condicionadorDeAr.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(condicionadorDeAr);
		
		condicionadorDeAr.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				if (condicionadorDeAr.isSelected() == true) {
					
					equipamentoEscolhido[8] = 1;
					
					System.out.println(equipamentoEscolhido[8]);
					
				}
				else {
					
					equipamentoEscolhido[8] = 0;
					
					System.out.println(equipamentoEscolhido[8]);
					
				}

			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 10 ############################ */
		/** ################################################################### */

		conjuntoDeSom = new JCheckBox();
		
		conjuntoDeSom = _checkboxMenuPrincipal[9].getCheckBox();

		conjuntoDeSom.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(conjuntoDeSom);
		
		conjuntoDeSom.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (conjuntoDeSom.isSelected() == true) {
					
					equipamentoEscolhido[9] = 1;
					
					System.out.println(equipamentoEscolhido[9]);
					
				}
				else {
					
					equipamentoEscolhido[9] = 0;
					
					System.out.println(equipamentoEscolhido[9]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 11 ############################ */
		/** ################################################################### */
		
		cortadorDeGrama	= new JCheckBox();
		
		cortadorDeGrama = _checkboxMenuPrincipal[10].getCheckBox();

		cortadorDeGrama.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(cortadorDeGrama);
		
		cortadorDeGrama.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (cortadorDeGrama.isSelected() == true) {
					
					equipamentoEscolhido[10] = 1;
					
					System.out.println(equipamentoEscolhido[10]);
					
				}
				else {
					
					equipamentoEscolhido[10] = 0;
					
					System.out.println(equipamentoEscolhido[10]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 12 ############################ */
		/** ################################################################### */
		
		dvdPlayer = new JCheckBox();
		
		dvdPlayer = _checkboxMenuPrincipal[11].getCheckBox();

		dvdPlayer.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(dvdPlayer);
		
		dvdPlayer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (dvdPlayer.isSelected() == true) {
					
					equipamentoEscolhido[11] = 1;
					
					System.out.println(equipamentoEscolhido[11]);
					
				}
				else {
					
					equipamentoEscolhido[11] = 0;
					
					System.out.println(equipamentoEscolhido[11]);
					
				}

			}
		});
		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 13 ############################ */
		/** ################################################################### */
		
		enceradeira	= new JCheckBox();
		
		enceradeira = _checkboxMenuPrincipal[12].getCheckBox();

		enceradeira.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(enceradeira);
		
		enceradeira.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (enceradeira.isSelected() == true) {
					
					equipamentoEscolhido[12] = 1;
					
					System.out.println(equipamentoEscolhido[12]);
					
				}
				else {
					
					equipamentoEscolhido[12] = 0;
					
					System.out.println(equipamentoEscolhido[12]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 14 ############################ */
		/** ################################################################### */
		
		espremedorDeFrutas	= new JCheckBox();
		
		espremedorDeFrutas = _checkboxMenuPrincipal[13].getCheckBox();

		espremedorDeFrutas.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(espremedorDeFrutas);
		
		espremedorDeFrutas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (espremedorDeFrutas.isSelected() == true) {
					
					equipamentoEscolhido[13] = 1;
					
					System.out.println(equipamentoEscolhido[13]);
					
				}
				else {
					
					equipamentoEscolhido[13] = 0;
					
					System.out.println(equipamentoEscolhido[13]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 15 ############################ */
		/** ################################################################### */
		
		exaustor = new JCheckBox();
		
		exaustor = _checkboxMenuPrincipal[14].getCheckBox();

		exaustor.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(exaustor);
		
		exaustor.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (exaustor.isSelected() == true) {
					
					equipamentoEscolhido[14] = 1;
					
					System.out.println(equipamentoEscolhido[14]);
					
				}
				else {
					
					equipamentoEscolhido[14] = 0;
					
					System.out.println(equipamentoEscolhido[14]);
					
				}
				
			}
		});

		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 16 ############################ */
		/** ################################################################### */

		
		ferroEletrico = new JCheckBox();
		
		ferroEletrico = _checkboxMenuPrincipal[15].getCheckBox();

		ferroEletrico.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(ferroEletrico);

		ferroEletrico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (ferroEletrico.isSelected() == true) {
					
					equipamentoEscolhido[15] = 1;
					
					System.out.println(equipamentoEscolhido[15]);
					
				}
				else {
					
					equipamentoEscolhido[15] = 0;
					
					System.out.println(equipamentoEscolhido[15]);
					
				}
			}
		});
		


		contaComponente = 0;
		
		posicaox = posicaox + 180;
		
		posicaoy = 30;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 17 ############################ */
		/** ################################################################### */

		// 8 componentes
			
		fogaoEletrico2Bocas = new JCheckBox();
		
		fogaoEletrico2Bocas = _checkboxMenuPrincipal[16].getCheckBox();

		fogaoEletrico2Bocas.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(fogaoEletrico2Bocas);
		
		fogaoEletrico2Bocas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (fogaoEletrico2Bocas.isSelected() == true) {
					
					equipamentoEscolhido[16] = 1;
					
					System.out.println(equipamentoEscolhido[16]);
					
				}
				else {
					
					equipamentoEscolhido[16] = 0;
					
					System.out.println(equipamentoEscolhido[16]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 18 ############################ */
		/** ################################################################### */

		
		fogaoEletricoDe4Bocas = new JCheckBox();
		
		fogaoEletricoDe4Bocas = _checkboxMenuPrincipal[17].getCheckBox();

		fogaoEletricoDe4Bocas.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(fogaoEletricoDe4Bocas);
		
		fogaoEletricoDe4Bocas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (fogaoEletricoDe4Bocas.isSelected() == true) {
					
					equipamentoEscolhido[17] = 1;
					
					System.out.println(equipamentoEscolhido[17]);
					
				}
				else {
					
					equipamentoEscolhido[17] = 0;
					
					System.out.println(equipamentoEscolhido[17]);
					
				}
				
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 19 ############################ */
		/** ################################################################### */
		
		fornoEletricoGrande	= new JCheckBox();
		
		fornoEletricoGrande = _checkboxMenuPrincipal[18].getCheckBox();

		fornoEletricoGrande.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(fornoEletricoGrande);
		
		fornoEletricoGrande.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (fornoEletricoGrande.isSelected() == true) {
					
					equipamentoEscolhido[18] = 1;
					
					System.out.println(equipamentoEscolhido[18]);
					
				}
				else {
					
					equipamentoEscolhido[18] = 0;
					
					System.out.println(equipamentoEscolhido[18]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 20 ############################ */
		/** ################################################################### */
		
		fornoEletricoPequeno = new JCheckBox();
		
		fornoEletricoPequeno = _checkboxMenuPrincipal[19].getCheckBox();

		fornoEletricoPequeno.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(fornoEletricoPequeno);
		
		fornoEletricoPequeno.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (fornoEletricoPequeno.isSelected() == true) {
					
					equipamentoEscolhido[19] = 1;
					
					System.out.println(equipamentoEscolhido[19]);
					
				}
				else {
					
					equipamentoEscolhido[19] = 0;
					
					System.out.println(equipamentoEscolhido[19]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 21 ############################ */
		/** ################################################################### */

		
		fornoDeMicroOndas = new JCheckBox();
		
		fornoDeMicroOndas = _checkboxMenuPrincipal[20].getCheckBox();

		fornoDeMicroOndas.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(fornoDeMicroOndas);
		
		fornoDeMicroOndas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (fornoDeMicroOndas.isSelected() == true) {
					
					equipamentoEscolhido[20] = 1;
					
					System.out.println(equipamentoEscolhido[20]);
					
				}
				else {
					
					equipamentoEscolhido[20] = 0;
					
					System.out.println(equipamentoEscolhido[20]);
					
				}
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 22 ############################ */
		/** ################################################################### */
		
		freezerHorizontal = new JCheckBox();
		
		freezerHorizontal = _checkboxMenuPrincipal[21].getCheckBox();

		freezerHorizontal.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(freezerHorizontal);
		
		freezerHorizontal.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (freezerHorizontal.isSelected() == true) {
					
					equipamentoEscolhido[21] = 1;
					
					System.out.println(equipamentoEscolhido[21]);
					
				}
				else {
					
					equipamentoEscolhido[21] = 0;
					
					System.out.println(equipamentoEscolhido[21]);
					
				}
				
			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 23 ############################ */
		/** ################################################################### */
		
		freezerVertical	= new JCheckBox();
		
		freezerVertical = _checkboxMenuPrincipal[22].getCheckBox();

		freezerVertical.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(freezerVertical);
		
		freezerVertical.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (freezerVertical.isSelected() == true) {
					
					equipamentoEscolhido[22] = 1;
					
					System.out.println(equipamentoEscolhido[22]);
					
				}
				else {
					
					equipamentoEscolhido[22] = 0;
					
					System.out.println(equipamentoEscolhido[22]);
					
				}
				
			}
		});

		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 24 ############################ */
		/** ################################################################### */
		
		geladeiraDuplex	= new JCheckBox();
		
		geladeiraDuplex = _checkboxMenuPrincipal[23].getCheckBox();

		geladeiraDuplex.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(geladeiraDuplex);
		
		geladeiraDuplex.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (geladeiraDuplex.isSelected() == true) {
					
					equipamentoEscolhido[23] = 1;
					
					System.out.println(equipamentoEscolhido[23]);
					
				}
				else {
					
					equipamentoEscolhido[23] = 0;
					
					System.out.println(equipamentoEscolhido[23]);
					
				}
			}
		});


		contaComponente = 0;
		
		posicaox = posicaox + 180;
		
		posicaoy = 30;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 25 ############################ */
		/** ################################################################### */
		
		// 8 componentes
		
		geladeiraSimples = new JCheckBox();
		
		geladeiraSimples = _checkboxMenuPrincipal[24].getCheckBox();

		geladeiraSimples.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(geladeiraSimples);
		
		geladeiraSimples.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (geladeiraSimples.isSelected() == true) {
					
					equipamentoEscolhido[24] = 1;
					
					System.out.println(equipamentoEscolhido[24]);
					
				}
				else {
					
					equipamentoEscolhido[24] = 0;
					
					System.out.println(equipamentoEscolhido[24]);
					
				}

			}
		});

		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 26 ############################ */
		/** ################################################################### */
		
		grill = new JCheckBox();
		
		grill = _checkboxMenuPrincipal[25].getCheckBox();

		grill.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(grill);
		
		grill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (grill.isSelected() == true) {
					
					equipamentoEscolhido[25] = 1;
					
					System.out.println(equipamentoEscolhido[25]);
					
				}
				else {
					
					equipamentoEscolhido[25] = 0;
					
					System.out.println(equipamentoEscolhido[25]);
					
				}
			}
		});
		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 27 ############################ */
		/** ################################################################### */
		
		impressora = new JCheckBox();
		
		impressora = _checkboxMenuPrincipal[26].getCheckBox();

		impressora.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(impressora);
		
		impressora.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (impressora.isSelected() == true) {
					
					equipamentoEscolhido[26] = 1;
					
					System.out.println(equipamentoEscolhido[26]);
					
				}
				else {
					
					equipamentoEscolhido[26] = 0;
					
					System.out.println(equipamentoEscolhido[26]);
					
				}
			}
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 28 ############################ */
		/** ################################################################### */
		
		liquidificador = new JCheckBox();
		
		liquidificador = _checkboxMenuPrincipal[27].getCheckBox();

		liquidificador.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(liquidificador);
		
		liquidificador.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (liquidificador.isSelected() == true) {
					
					equipamentoEscolhido[27] = 1;
					
					System.out.println(equipamentoEscolhido[27]);
					
				}
				else {
					
					equipamentoEscolhido[27] = 0;
					
					System.out.println(equipamentoEscolhido[27]);
					
				}
				
			}
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 29 ############################ */
		/** ################################################################### */
		
		maquinaDeCostura = new JCheckBox();
		
		maquinaDeCostura = _checkboxMenuPrincipal[28].getCheckBox();

		maquinaDeCostura.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(maquinaDeCostura);
		
		maquinaDeCostura.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (maquinaDeCostura.isSelected() == true) {
					
					equipamentoEscolhido[28] = 1;
					
					System.out.println(equipamentoEscolhido[28]);
					
				}
				else {
					
					equipamentoEscolhido[28] = 0;
					
					System.out.println(equipamentoEscolhido[28]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 30 ############################ */
		/** ################################################################### */
		
		maquinaDeLavarLouca	= new JCheckBox();
		
		maquinaDeLavarLouca = _checkboxMenuPrincipal[29].getCheckBox();

		maquinaDeLavarLouca.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(maquinaDeLavarLouca);
		
		maquinaDeLavarLouca.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (maquinaDeLavarLouca.isSelected() == true) {
					
					equipamentoEscolhido[29] = 1;
					
					System.out.println(equipamentoEscolhido[29]);
					
				}
				else {
					
					equipamentoEscolhido[29] = 0;
					
					System.out.println(equipamentoEscolhido[29]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 31 ############################ */
		/** ################################################################### */
		
		maquinaDeLavarRoupa	= new JCheckBox();
		
		maquinaDeLavarRoupa = _checkboxMenuPrincipal[30].getCheckBox();

		maquinaDeLavarRoupa.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(maquinaDeLavarRoupa);
		
		maquinaDeLavarRoupa.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (maquinaDeLavarRoupa.isSelected() == true) {
					
					equipamentoEscolhido[30] = 1;
					
					System.out.println(equipamentoEscolhido[30]);
					
				}
				else {
					
					equipamentoEscolhido[30] = 0;
					
					System.out.println(equipamentoEscolhido[30]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 32 ############################ */
		/** ################################################################### */		
		
		projetorDeSlides = new JCheckBox();
		
		projetorDeSlides = _checkboxMenuPrincipal[31].getCheckBox();

		projetorDeSlides.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(projetorDeSlides);
		
		projetorDeSlides.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (projetorDeSlides.isSelected() == true) {
					
					equipamentoEscolhido[31] = 1;
					
					System.out.println(equipamentoEscolhido[31]);
					
				}
				else {
					
					equipamentoEscolhido[31] = 0;
					
					System.out.println(equipamentoEscolhido[31]);
					
				}
				
			}
			
		});

		contaComponente = 0;
		
		posicaox = posicaox + 180;
		
		posicaoy = 30;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 33 ############################ */
		/** ################################################################### */

		// 8 componentes		
		
		radioRelogio = new JCheckBox();
		
		radioRelogio = _checkboxMenuPrincipal[32].getCheckBox();

		radioRelogio.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(radioRelogio);
		
		radioRelogio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (radioRelogio.isSelected() == true) {
					
					equipamentoEscolhido[32] = 1;
					
					System.out.println(equipamentoEscolhido[32]);
					
				}
				else {
					
					equipamentoEscolhido[32] = 0;
					
					System.out.println(equipamentoEscolhido[32]);
					
				}
				
			}
			
		});

		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 34 ############################ */
		/** ################################################################### */		
		
		secadorDeCabelo	= new JCheckBox();
		
		secadorDeCabelo = _checkboxMenuPrincipal[33].getCheckBox();

		secadorDeCabelo.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(secadorDeCabelo);
		
		secadorDeCabelo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (secadorDeCabelo.isSelected() == true) {
					
					equipamentoEscolhido[33] = 1;
					
					System.out.println(equipamentoEscolhido[33]);
					
				}
				else {
					
					equipamentoEscolhido[33] = 0;
					
					System.out.println(equipamentoEscolhido[33]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 35 ############################ */
		/** ################################################################### */

		
		secadoraDeRoupas = new JCheckBox();
		
		secadoraDeRoupas = _checkboxMenuPrincipal[34].getCheckBox();

		secadoraDeRoupas.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(secadoraDeRoupas);
		
		secadoraDeRoupas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (secadoraDeRoupas.isSelected() == true) {
					
					equipamentoEscolhido[34] = 1;
					
					System.out.println(equipamentoEscolhido[34]);
					
				}
				else {
					
					equipamentoEscolhido[34] = 0;
					
					System.out.println(equipamentoEscolhido[34]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 36 ############################ */
		/** ################################################################### */
		
		televisor21 = new JCheckBox();
		
		televisor21 = _checkboxMenuPrincipal[35].getCheckBox();

		televisor21.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(televisor21);
		
		televisor21.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (televisor21.isSelected() == true) {
					
					equipamentoEscolhido[35] = 1;
					
					System.out.println(equipamentoEscolhido[35]);
					
				}
				else {
					
					equipamentoEscolhido[35] = 0;
					
					System.out.println(equipamentoEscolhido[35]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 37 ############################ */
		/** ################################################################### */

		
		torneiraEletrica = new JCheckBox();
		
		torneiraEletrica = _checkboxMenuPrincipal[36].getCheckBox();

		torneiraEletrica.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(torneiraEletrica);
		
		torneiraEletrica.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (torneiraEletrica.isSelected() == true) {
					
					equipamentoEscolhido[36] = 1;
					
					System.out.println(equipamentoEscolhido[36]);
					
				}
				else {
					
					equipamentoEscolhido[36] = 0;
					
					System.out.println(equipamentoEscolhido[36]);
					
				}
				
			}
			
		});		
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 38 ############################ */
		/** ################################################################### */
		
		torradeira = new JCheckBox();
		
		torradeira = _checkboxMenuPrincipal[37].getCheckBox();

		torradeira.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(torradeira);
		
		torradeira.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (torradeira.isSelected() == true) {
					
					equipamentoEscolhido[37] = 1;
					
					System.out.println(equipamentoEscolhido[37]);
					
				}
				else {
					
					equipamentoEscolhido[37] = 0;
					
					System.out.println(equipamentoEscolhido[37]);
					
				}
				
			}
			
		});
		
		posicaoy = posicaoy + 20;

		/** ################################################################### */
		/** ####################### EQUIPAMENTO 39 ############################ */
		/** ################################################################### */
		
		vetilador = new JCheckBox();
		
		vetilador = _checkboxMenuPrincipal[38].getCheckBox();

		vetilador.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(vetilador);
		
		vetilador.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (vetilador.isSelected() == true) {
					
					equipamentoEscolhido[38] = 1;
					
					System.out.println(equipamentoEscolhido[38]);
					
				}
				else {
					
					equipamentoEscolhido[38] = 0;
					
					System.out.println(equipamentoEscolhido[38]);
					
				}

			}
			
		});
		
		posicaoy = posicaoy + 20;
		
		/** ################################################################### */
		/** ####################### EQUIPAMENTO 40 ############################ */
		/** ################################################################### */

		videoGame = new JCheckBox();

		videoGame = _checkboxMenuPrincipal[39].getCheckBox();

		videoGame.setBounds(posicaox, posicaoy, 180, 20);
				
		container.add(videoGame);
		
		videoGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (videoGame.isSelected() == true) {
					
					equipamentoEscolhido[39] = 1;
					
					System.out.println(equipamentoEscolhido[39]);
					
				}
				else {
					
					equipamentoEscolhido[39] = 0;
					
					System.out.println(equipamentoEscolhido[39]);
					
				}
				
			}
			
		});

		/** ################################################################### */
		/** ################# BOTÃO CONFIRMAR EQUIPAMENTO ##################### */
		/** ################################################################### */
		
		botaoConfirmarEquipamento = new JButton("Confirmar Equipamento(s)");
		
		botaoConfirmarEquipamento.setBounds(280, 200, 183, 25);
		
		container.add(botaoConfirmarEquipamento);
				
		// Evento do botão metaheurística
		botaoConfirmarEquipamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//tela com os botões de metaheurística
				//new AplicacaoMetaheuristica().setVisible(true);
				
				quantidadeEquipamento = calcularQuantidadeEquipamento();
				
				if (quantidadeEquipamento == 0) {
					
					JOptionPane.showMessageDialog(null, "Por favor, selecione os equipamentos desejados.");

				} 
				else {
																			
					ConfiguracaoEquipamento janelaIntervaloEquipamento = new ConfiguracaoEquipamento(
							equipamentoEscolhido, quantidadeEquipamento, _checkboxMenuPrincipal);

					
					// desabilita este formulário ao abrir outro
					AparelhoResidencial.this.setEnabled(true);
					
					janelaIntervaloEquipamento.setVisible(true);
										
					//throw new UnsupportedOperationException("not supported yet.");

				}
				
			}
		});
		

		/** ################################################################### */
		/** ################ BOTÃO ESCOLHER ALEATORIAMENTE #################### */
		/** ################################################################### */
		
		botaoEscolherAleatoriamente = new JButton("Escolher Aleatoriamente");
		
		botaoEscolherAleatoriamente.setBounds(480, 200, 183, 25);
		
		container.add(botaoEscolherAleatoriamente);
				
		// Evento do botão escolher aleatoriamente
		botaoEscolherAleatoriamente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				EquipamentoConfigurado equipamentoConfigurado;
				
				equipamentoConfigurado = new EquipamentoConfigurado(12);
				
				equipamentoConfigurado = gerarEquipamentoAleatoriamente(equipamentoConfigurado);
				
				SemAplicarMetaheuristicaEquipamento janelaSemAplicarMetaheuristicaEquipamento = new SemAplicarMetaheuristicaEquipamento(equipamentoConfigurado);
				
				janelaSemAplicarMetaheuristicaEquipamento.setVisible(true);
				
				// desabilita o formulário ao abrir outro
				
				AparelhoResidencial.this.setEnabled(true);
				
				//throw new UnsupportedOperationException("not supported yet.");
												
			}
			
		});
		
		this.setVisible(true);
		
	}
	
	
	public int calcularQuantidadeEquipamento() {
		
		int calcularQuantidadeEquipamento = 0;
		
		for (int i = 0; i < equipamentoEscolhido.length; i++) {
			
			if (equipamentoEscolhido[i] == 1) {
			
				calcularQuantidadeEquipamento++;
				
			}
			
		}
		
		return calcularQuantidadeEquipamento;
		
	}
	
	public EquipamentoConfigurado gerarEquipamentoAleatoriamente(EquipamentoConfigurado _equipamentoConfigurado){
		
		EquipamentoConfigurado equipamentoConfigurado;
		
		equipamentoConfigurado = new EquipamentoConfigurado(12);
		
		return equipamentoConfigurado;
				
	}
	
	public ConsumoEletrico[] ordenarConsumoEletrico(ConsumoEletrico[] _consumoEletrico){
		
		ConsumoEletrico[] consumoEletricoAuxiliar = new ConsumoEletrico[12];
					
		for (int i = 0; i < _consumoEletrico.length; i++) {
				
			for (int j = 0; j < _consumoEletrico.length; j++) {
					
				if ( _consumoEletrico[i].getAparelho().getNomeTipoEquipamento().compareTo(_consumoEletrico[j].getAparelho().getNomeTipoEquipamento()) < 0) {
					
					consumoEletricoAuxiliar[i] = _consumoEletrico[i];
					
					_consumoEletrico[i] = _consumoEletrico[j] ;
					
					_consumoEletrico[j] = consumoEletricoAuxiliar[i];
																		
				}
					
			}
				
		}
		
		return _consumoEletrico;
			
	}	

	public int [] gerar12NumeroSemRepeticaoEntre0e39() {
		
		int numero;
		
        int[] num = new int[12];
        
        Random r = new Random();

        for(int i=0; i<num.length; i++){
        	
             numero = r.nextInt(39) + 1;
             
             for(int j=0; j<num.length; j++){
            	 
                   if(numero == num[j] && j != i){
                	   
                         numero = r.nextInt(39) + 1;
                         
                   }
                   else{
                	   
                        num[i] = numero;
                        
                   }
                   
             }
             
        }
        
        //for(int i=0; i<num.length; i++){
        //  System.out.print(num[i]+"  ");
       	//}
        
        return num;
		
	}
	
	public int [] ordenarVetor(int [] _vetorDesordenado) {
		
		int [] vetorAuxiliar = new int[12];
		
		// processo para ordenar o vetor
		for (int i = 0; i < _vetorDesordenado.length; i++) {
				
			for (int j = 0; j < _vetorDesordenado.length; j++) {
					
				if ( _vetorDesordenado[i] <= _vetorDesordenado[j]) {
					
					vetorAuxiliar[i] = _vetorDesordenado[i];
					
					_vetorDesordenado[i] = _vetorDesordenado[j] ;
					
					_vetorDesordenado[j] = vetorAuxiliar[i];
																		
				}
					
			}
				
		}
		
		return _vetorDesordenado;
				
	}
		
}
