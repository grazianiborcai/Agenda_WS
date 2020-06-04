package br.com.mind5.business.calendarWeekYear.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CaleekyInfo extends InfoRecord implements Cloneable {
	public int weekYear;	
	public LocalDate dateWeekBegin;
	public LocalDate dateWeekEnd;
	public String username;
	
	
	public CaleekyInfo() {
		super();
		
		weekYear = DefaultValue.number();
		dateWeekBegin = DefaultValue.object();
		dateWeekEnd = DefaultValue.object();		
	}
	
	
	
	public static CaleekyInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CaleekyInfo.class);
	}
	
	
	
	public static List<CaleekyInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CaleekyInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + weekYear;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CaleekyInfo))
			return false;
		
		
		CaleekyInfo obj = (CaleekyInfo) o;		
		return (weekYear == obj.weekYear);
	}
}
