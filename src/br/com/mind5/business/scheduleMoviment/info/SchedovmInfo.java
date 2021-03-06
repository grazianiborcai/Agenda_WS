package br.com.mind5.business.scheduleMoviment.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchedovmInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String codScheduleStatus;
	public String codScheduleStatusOld;
	public long codStore;
	public long codEmployee;
	public long codCustomer;
	public long codMat;
	public LocalDate date;
	public int day;
	public int codWeekday;
	public int weekMonth;
	public int weekYear;
	public int month;
	public int year;
	public int confirmed;
	public int waiting;
	public int counter;	
	
	
	public SchedovmInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codMat = DefaultValue.number();
		day = DefaultValue.number();
		month = DefaultValue.number();
		year = DefaultValue.number();	
		codWeekday = DefaultValue.number();
		weekMonth = DefaultValue.number();
		weekYear = DefaultValue.number();
		confirmed = 0;
		waiting = 0;
		counter = 0;
	}
	
	
	
	public static SchedovmInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedovmInfo.class);
	}
	
	
	
	public static List<SchedovmInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedovmInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (year 	  	  ^ (year 	 	 >>> 32));
		result = result * 31 + (int) (month 	  ^ (month 	 	 >>> 32));
		result = result * 31 + (int) (day 	  	  ^ (day 	 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedovmInfo))
			return false;
		
		
		SchedovmInfo obj = (SchedovmInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codStore    == obj.codStore		&&
				codEmployee == obj.codEmployee	&&
				codMat    	== obj.codMat		&&
				year    	== obj.year			&&
				month    	== obj.month		&&
				day    		== obj.day				);
	}
}
