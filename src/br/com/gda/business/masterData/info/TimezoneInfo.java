package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class TimezoneInfo extends RecordInfo implements Cloneable {
	public String codTimezone;
	public String txtTimezone;
	public String codLanguage;
	
	
	public TimezoneInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static TimezoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TimezoneInfo.class);
	}
	
	
	
	public static List<TimezoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TimezoneInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codTimezone != null) {
			char[] chars = codTimezone.toCharArray();
			
			for (char eachChar : chars) {
				result = result * (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TimezoneInfo))
			return false;
		
		
		TimezoneInfo obj = (TimezoneInfo) o;		
		
		
		if (codTimezone == null && obj.codTimezone == null)
			return true;
		
		if (codTimezone == null || obj.codTimezone == null)
			return false;
		
		return codTimezone.equals(obj.codTimezone);
	}
}
