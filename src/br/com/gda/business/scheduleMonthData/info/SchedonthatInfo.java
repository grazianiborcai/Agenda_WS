package br.com.gda.business.scheduleMonthData.info;

import java.time.LocalDate;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class SchedonthatInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public int month;
	public int day;
	public String txtMonth;
	public int codWeekday;
	public String txtWeekday;
	public int year;
	public int confirmed;
	public int waiting;
	public int counter;
	public String username;	
	
	
	public SchedonthatInfo() {
		super(SchedonthatInfo.class);
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		codWeekday = DefaultValue.number();
		date = DefaultValue.object();
		year = DefaultValue.number();	
		month = DefaultValue.number();		
		day = DefaultValue.number();	
		confirmed = 0;
		waiting = 0;
		counter = 0;
	}
	
	
	
	public static SchedonthatInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedonthatInfo.class);
	}
	
	
	
	public static List<SchedonthatInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedonthatInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat ^ (codMat >>> 32));
		result = result * 31 + (int) (year 	  	  ^ (year 	 	 >>> 32));
		result = result * 31 + (int) (month 	  ^ (month 	 	 >>> 32));
		result = result * 31 + (int) (day 	  	  ^ (day 	 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedonthatInfo))
			return false;
		
		
		SchedonthatInfo obj = (SchedonthatInfo) o;		
		return (codOwner    == obj.codOwner		&& 
				codStore    == obj.codStore		&&
				codEmployee == obj.codEmployee	&&
				codMat == obj.codMat	&&
				year    	== obj.year			&&
				day    		== obj.day			&&
				month    	== obj.month		);
	}
}
