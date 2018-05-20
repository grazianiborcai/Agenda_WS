package br.com.gda.business.masterData.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class MatTypeInfo implements Cloneable {
	public int codType;
	public String txtType;
	public String codLanguage;
	
	
	public MatTypeInfo() {
		this.codType = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
