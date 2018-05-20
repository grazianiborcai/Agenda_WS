package br.com.gda.business.masterData.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class BusinessInfo implements Cloneable {
	public int codBusiness;
	public String txtBusiness; 
	public String codLanguage;
	
	
	public BusinessInfo() {
		this.codBusiness = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
