package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MonthInfo extends InfoRecord implements Cloneable {
	public int month;
	public String txtMonth;
	
	
	public MonthInfo() {
		super(MonthInfo.class);
		
		month = DefaultValue.number();
	}
	
	
	
	public static MonthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MonthInfo.class);
	}
	
	
	
	public static List<MonthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MonthInfo.class);
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
		
		
		if (!(o instanceof MonthInfo))
			return false;
		
		
		MonthInfo obj = (MonthInfo) o;
		return month == obj.month;
	}
}
