package listaCheckbox;

import java.util.Iterator;

import java.util.Random;

import javax.swing.JCheckBox;

import eletrica.TabelaEletrica;

public class CheckboxMenuPrincipal {
	
	private JCheckBox checkBox;
	
	private TabelaEletrica tabelaEletrica;
	
	public void setCheckBox(JCheckBox _checkBox) {
		
		if (this.validarCheckBox(_checkBox) ) {
			
			this.checkBox = _checkBox;
			
		}
		else {
			
			System.out.println("Escolha um checkbox válido para o menu...");
			
		}
		
	}

	public void setTabelaEletrica(TabelaEletrica _tabelaEletrica) {
		
		if (this.validarTabelaEletrica(_tabelaEletrica) ) {
			
			this.tabelaEletrica = _tabelaEletrica;
			
		}
		else {
			
			System.out.println("Escolha uma tabela alétrica válida para o menu...");
			
		}
		
	}
	
	public TabelaEletrica getTabelaEletrica() {
	
		return this.tabelaEletrica;
	
	}
	
	public JCheckBox getCheckBox() {
	
		return this.checkBox;
	
	}
	
	public void setAll(JCheckBox _checkBox, TabelaEletrica _tabelaEletrica) {
		
		this.setCheckBox(_checkBox);
		
		this.setTabelaEletrica(_tabelaEletrica);
		
	}
	
	public void setCheckboxMenuPrincipal(CheckboxMenuPrincipal _checkboxMenuPrincipal){
		
		this.setAll(_checkboxMenuPrincipal.getCheckBox(), 
					
					_checkboxMenuPrincipal.getTabelaEletrica());
		
	}
	
	public CheckboxMenuPrincipal() {
		
		this.checkBox = new JCheckBox("teste1");
		
		this.tabelaEletrica = new TabelaEletrica();
		
	}
	
	public CheckboxMenuPrincipal(JCheckBox _checkBox, TabelaEletrica _tabelaEletrica) {
		
		this.checkBox = new JCheckBox("teste1");
		
		this.tabelaEletrica = new TabelaEletrica();
		
		this.checkBox = _checkBox;
		
		this.tabelaEletrica = _tabelaEletrica;
		
	}
	
	public CheckboxMenuPrincipal(CheckboxMenuPrincipal _checkboxMenuPrincipal) {
		
		this.checkBox = new JCheckBox("teste1");
		
		this.tabelaEletrica = new TabelaEletrica();
		
		this.checkBox = _checkboxMenuPrincipal.getCheckBox();
		
		this.tabelaEletrica = _checkboxMenuPrincipal.getTabelaEletrica();
		
	}
	
	public String toString() {
		
		String toString = new String("");
		
		toString = "Checkbox: " + this.getTabelaEletrica().getNomeTipoEquipamento();
		
		return toString;
		
	}

	public boolean validarCheckBox(JCheckBox _checkBox) {
		
		boolean validarCheckBox = true;
		
		return validarCheckBox;
		
	}
	
	public boolean validarTabelaEletrica(TabelaEletrica _tabelaEletrica) {
		
		boolean validarTabelaEletrica = true;
		
		return validarTabelaEletrica;
		
	}

}