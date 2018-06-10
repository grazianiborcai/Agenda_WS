package br.com.gda.business.masterData.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class WeekdayInfo implements Cloneable {
	public int codWeekday;
	public String txtWeekday;
	public String codLanguage;
	
	
	public WeekdayInfo() {
		codWeekday = DefaultValue.number();	
		codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
