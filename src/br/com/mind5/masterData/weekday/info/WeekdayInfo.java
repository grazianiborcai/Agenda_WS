package br.com.mind5.masterData.weekday.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class WeekdayInfo extends InfoRecord implements Cloneable {
	public int codWeekday;
	public String txtWeekday;
	
	
	public WeekdayInfo() {
		super();
		
		codWeekday = DefaultValue.number();	
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