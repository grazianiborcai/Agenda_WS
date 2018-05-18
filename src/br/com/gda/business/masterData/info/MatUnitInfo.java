package br.com.gda.business.masterData.info;

import br.com.gda.common.Language;

public final class MatUnitInfo implements Cloneable {
	public String codUnit;
	public String txtUnit;
	public String codLanguage;
	
	
	public MatUnitInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
