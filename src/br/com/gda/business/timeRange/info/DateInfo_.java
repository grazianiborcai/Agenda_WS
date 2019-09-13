package br.com.gda.business.timeRange.info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.info.InfoRecord;

public final class DateInfo_ extends InfoRecord implements Cloneable {
	public LocalDate date;
	
	
	public DateInfo_() {
		super(DateInfo_.class);
	}
	
	
	public static DateInfo_ copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DateInfo_.class);
	}
	
	
	
	public static List<DateInfo_> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DateInfo_.class);
	}	
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		DateInfo_ deepCopy = (DateInfo_) super.clone();  		
				
		LocalDate cloneDate = null;	
		if (date != null) 
			cloneDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
				
		deepCopy.date = cloneDate;
				
		return deepCopy;	
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (date != null) {			
			int numDate = Integer.valueOf(date.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DateInfo_))
			return false;
		
		
		DateInfo_ obj = (DateInfo_) o;
		
		return (isDateEqual(date, obj.date));
	}	
}
