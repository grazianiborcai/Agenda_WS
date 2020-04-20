package br.com.mind5.masterData.timezoneSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class TimezonarchInfo extends InfoRecord implements Cloneable {
	public String codTimezone;
	public String txtTimezone;
	
	
	public TimezonarchInfo() {
		super();
	}
	
	
	
	public static TimezonarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TimezonarchInfo.class);
	}
	
	
	
	public static List<TimezonarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TimezonarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codTimezone != null) {
			char[] chars = codTimezone.toCharArray();
			
			for (char eachChar : chars) {
				result = result * 31 + (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TimezonarchInfo))
			return false;
		
		
		TimezonarchInfo obj = (TimezonarchInfo) o;	
		return isStringEqual(codTimezone, obj.codTimezone);
	}
}
