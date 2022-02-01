package br.com.mind5.business.calendarMonthSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CalontharchInfo extends InfoRecord implements Cloneable {
	public String calmonth;
	public String calmonthBegin;
	public String calmonthEnd;
	public int year;
	public int month;
	public String username;
	
	
	public CalontharchInfo() {
		super();
		
		year = DefaultValue.number();
		month = DefaultValue.number();
	}
	
	
	
	public static CalontharchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CalontharchInfo.class);
	}
	
	
	
	public static List<CalontharchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalontharchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (calmonth != null)		
			result = result * 31 + calmonth.hashCode();
		
		if (calmonthBegin != null)		
			result = result * 31 + calmonthBegin.hashCode();
		
		if (calmonthEnd != null)		
			result = result * 31 + calmonthEnd.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalontharchInfo))
			return false;
		
		
		CalontharchInfo obj = (CalontharchInfo) o;		
		return (super.isStringEqual(calmonth     , obj.calmonth)		&&
				super.isStringEqual(calmonthBegin, obj.calmonthBegin)	&&
				super.isStringEqual(calmonthEnd  , obj.calmonthEnd));
	}
}
