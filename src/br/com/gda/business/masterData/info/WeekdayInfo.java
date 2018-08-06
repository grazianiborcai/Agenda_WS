package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class WeekdayInfo extends RecordInfo implements Cloneable {
	public int codWeekday;
	public String txtWeekday;
	public String codLanguage;
	
	
	public WeekdayInfo() {
		codWeekday = DefaultValue.number();	
		codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static WeekdayInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, WeekdayInfo.class);
	}
	
	
	
	public static List<WeekdayInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, WeekdayInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codWeekday;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof WeekdayInfo))
			return false;
		
		
		WeekdayInfo obj = (WeekdayInfo) o;		
		return (codWeekday == obj.codWeekday);
	}
}
