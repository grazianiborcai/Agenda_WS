package br.com.gda.business.masterData.info;

import br.com.gda.common.Language;

public final class LanguInfo implements Cloneable {
	public String codLanguage;
	public String txtLanguage;
	
	
	public LanguInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
