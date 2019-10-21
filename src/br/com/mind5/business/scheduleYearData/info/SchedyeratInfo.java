package br.com.mind5.business.scheduleYearData.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchedyeratInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int month;
	public String txtMonth;
	public int year;
	public int confirmed;
	public int waiting;
	public int counter;
	public String username;
	
	
	public SchedyeratInfo() {
		super(SchedyeratInfo.class);
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		month = DefaultValue.number();
		year = DefaultValue.number();	
		confirmed = 0;
		waiting = 0;
		counter = 0;
	}
	
	
	
	public static SchedyeratInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedyeratInfo.class);
	}
	
	
	
	public static List<SchedyeratInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedyeratInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (year 	  	  ^ (year 	 	 >>> 32));
		result = result * 31 + (int) (month 	  ^ (month 	 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedyeratInfo))
			return false;
		
		
		SchedyeratInfo obj = (SchedyeratInfo) o;		
		return (codOwner    == obj.codOwner	&& 
				codStore    == obj.codStore	&&
				year    	== obj.year		&&
				month    	== obj.month		);
	}
}
