package br.com.mind5.business.calendarCatalogueData.info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CalguataInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public int codWeekday;
	public long codStore;
	public long codMat;
	public int year;
	public int month;
	public int day;
	public LocalDate date;
	public boolean isAvailable;
	public int codDaypart;
	public int codMoonPhase;
	public String username;
	public String recordMode;
	
	
	public CalguataInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codMat = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();		
		day = DefaultValue.number();
		isAvailable = DefaultValue.boole();
		codStore = DefaultValue.number();
		codDaypart = DefaultValue.number();
		codMoonPhase = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static CalguataInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, CalguataInfo.class);
	}
	
	
	
	public static List<CalguataInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalguataInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return super.clone();
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + codWeekday;
		result = result * 31 + codDaypart;
		result = result * 31 + codMoonPhase;
		
		if (date != null) {			
			int numDate = Integer.valueOf(date.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalguataInfo))
			return false;
		
		
		CalguataInfo obj = (CalguataInfo) o;		
		
		return (codOwner 	 == obj.codOwner 		&& 
				codStore 	 == obj.codStore 		&& 
				codMat 		 == obj.codMat 			&& 
				codWeekday 	 == obj.codWeekday  	&&
				codDaypart 	 == obj.codDaypart  	&&
				codMoonPhase == obj.codMoonPhase  	&&
				isDateEqual(date, obj.date));
	}
}
