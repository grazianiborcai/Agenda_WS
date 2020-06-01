package br.com.mind5.business.calendarTimeStore.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.business.calendarTime.info.CalimeInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CalimoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public LocalDate date;
	public int codWeekday;
	public List<CalimeInfo> calimes;
	public String username;

	
	
	public CalimoreInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		date = DefaultValue.object();
		codWeekday = DefaultValue.number();
		calimes = DefaultValue.list();
	}
	
	
	
	public static CalimoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CalimoreInfo.class);
	}
	
	
	
	public static List<CalimoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalimoreInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		CalimoreInfo deepCopy = (CalimoreInfo) super.clone();  				
		
		deepCopy.calimes = CloneUtil.cloneRecords(calimes, this.getClass());				
		return deepCopy;	
	} 
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (date != null)
			result = result * 31 + (int) (date.hashCode() ^ (date.hashCode() >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalimoreInfo))
			return false;
		
		
		CalimoreInfo obj = (CalimoreInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				super.isDateEqual(date, obj.date));
	}	
}
