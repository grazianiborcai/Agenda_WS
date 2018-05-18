package br.com.gda.business.masterData.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class EmpPositionInfo implements Cloneable {
	public long codPosition;
	public String txtPosition;
	public String codLanguage;
	
	
	public EmpPositionInfo() {
		this.codPosition = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
