package br.com.gda.business.position.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class PositionInfo implements Cloneable {
	public long codPosition;
	public String txtPosition;
	public String codLanguage;
	
	
	public PositionInfo() {
		this.codPosition = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
