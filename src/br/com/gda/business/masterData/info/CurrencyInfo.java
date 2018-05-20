package br.com.gda.business.masterData.info;

import br.com.gda.common.Language;

public final class CurrencyInfo implements Cloneable {
	public String codCurr;
	public String txtCurr;
	public String symbolCurr;
	public String codLanguage;
	
	
	
	public CurrencyInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
