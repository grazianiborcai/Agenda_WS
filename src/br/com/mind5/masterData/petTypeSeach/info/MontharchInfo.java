package br.com.mind5.masterData.petTypeSeach.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MontharchInfo extends InfoRecord implements Cloneable {
	public int month;
	public String txtMonth;
	
	
	public MontharchInfo() {
		super();
		
		month = DefaultValue.number();
	}
	
	
	
	public static MontharchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MontharchInfo.class);
	}
	
	
	
	public static List<MontharchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MontharchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {		
		return month;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MontharchInfo))
			return false;
		
		
		MontharchInfo obj = (MontharchInfo) o;
		return month == obj.month;
	}
}
