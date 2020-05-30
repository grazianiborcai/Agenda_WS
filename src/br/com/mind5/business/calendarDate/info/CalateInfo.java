package br.com.mind5.business.calendarDate.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CalateInfo extends InfoRecord implements Cloneable {
	public LocalDate date;
	public int year;
	public int month;
	public String txtMonth;
	public int day;
	public int codWeekday;
	public String txtWeekday;
	public int quarter;
	public int weekYear;
	public int weekMonth;
	public boolean isWeekend;
	public String txtMoonPhase;
	public String username;
	
	
	public CalateInfo() {
		super();
		
		date = DefaultValue.object();
		year = DefaultValue.number();
		month = DefaultValue.number();
		day = DefaultValue.number();
		codWeekday = DefaultValue.number();
		quarter = DefaultValue.number();
		weekYear = DefaultValue.number();
		weekMonth = DefaultValue.number();
		isWeekend = DefaultValue.boole();			
	}
	
	
	
	public static CalateInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CalateInfo.class);
	}
	
	
	
	public static List<CalateInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalateInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (date != null)		
			result = result * 31 + date.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalateInfo))
			return false;
		
		
		CalateInfo obj = (CalateInfo) o;		
		return (super.isDateEqual(date, obj.date));
	}
}
