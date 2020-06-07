package br.com.mind5.business.calendarTimeEmployee.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.business.calendarTime.info.CalimeInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CalimempInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public LocalDate date;
	public int codWeekday;
	public List<CalimeInfo> calimes;
	public String username;

	
	
	public CalimempInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		date = DefaultValue.object();
		codWeekday = DefaultValue.number();
		calimes = DefaultValue.list();
	}
	
	
	
	public static CalimempInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CalimempInfo.class);
	}
	
	
	
	public static List<CalimempInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalimempInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		CalimempInfo deepCopy = (CalimempInfo) super.clone();  				
		
		deepCopy.calimes = CloneUtil.cloneRecords(calimes, this.getClass());				
		return deepCopy;	
	} 
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 	>>> 32));
		
		if (date != null)
			result = result * 31 + (int) (date.hashCode() ^ (date.hashCode() >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalimempInfo))
			return false;
		
		
		CalimempInfo obj = (CalimempInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codEmployee == obj.codEmployee 	&&
				super.isDateEqual(date, obj.date));
	}	
}
