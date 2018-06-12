package br.com.gda.business.masterData.info;

import br.com.gda.common.Language;

public final class TimezoneInfo implements Cloneable {
	public String codTimezone;
	public String txtTimezone;
	public String codLanguage;
	
	
	public TimezoneInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
