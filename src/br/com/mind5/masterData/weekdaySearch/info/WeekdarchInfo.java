package br.com.mind5.masterData.weekdaySearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class WeekdarchInfo extends InfoRecord implements Cloneable {
	public int codWeekday;
	public String txtWeekday;
	
	
	public WeekdarchInfo() {
		super();
		
		codWeekday = DefaultValue.number();	
	}
	
	
	
	public static WeekdarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, WeekdarchInfo.class);
	}
	
	
	
	public static List<WeekdarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, WeekdarchInfo.class);
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
		
		
		if (!(o instanceof WeekdarchInfo))
			return false;
		
		
		WeekdarchInfo obj = (WeekdarchInfo) o;		
		return (codWeekday == obj.codWeekday);
	}
}
