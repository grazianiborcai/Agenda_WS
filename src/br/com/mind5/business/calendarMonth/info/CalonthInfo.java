package br.com.mind5.business.calendarMonth.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CalonthInfo extends InfoRecord implements Cloneable {
	public String calmonth;
	public int year;
	public int month;
	public String txtMonth;
	public LocalDate firstDay;	
	public LocalDate lastDay;
	public String username;
	
	
	public CalonthInfo() {
		super();
		
		year = DefaultValue.number();
		month = DefaultValue.number();
		lastDay = DefaultValue.object();
		firstDay = DefaultValue.object();
	}
	
	
	
	public static CalonthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CalonthInfo.class);
	}
	
	
	
	public static List<CalonthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalonthInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (calmonth != null)		
			result = result * 31 + calmonth.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalonthInfo))
			return false;
		
		
		CalonthInfo obj = (CalonthInfo) o;		
		return (super.isStringEqual(calmonth, obj.calmonth));
	}
}
