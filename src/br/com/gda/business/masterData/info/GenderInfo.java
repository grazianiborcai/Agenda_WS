package br.com.gda.business.masterData.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class GenderInfo implements Cloneable {
	public int codGender;
	public String txtGender;
	public String codLanguage;
	
	
	public GenderInfo() {
		this.codGender = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
