package br.com.gda.business.timeRange.info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.info.InfoRecord;

public final class DateInfo extends InfoRecord implements Cloneable {
	public LocalDate date;
	
	
	
	public static DateInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DateInfo.class);
	}
	
	
	
	public static List<DateInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DateInfo.class);
	}	
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		DateInfo deepCopy = (DateInfo) super.clone();  		
				
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
		
		
		if (!(o instanceof DateInfo))
			return false;
		
		
		DateInfo obj = (DateInfo) o;
		
		return (isDateEqual(date, obj.date));
	}	
}
