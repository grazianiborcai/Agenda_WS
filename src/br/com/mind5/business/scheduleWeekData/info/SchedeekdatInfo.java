package br.com.mind5.business.scheduleWeekData.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchedeekdatInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public long codCustomer;
	public long codMat;
	public LocalDate date;
	public int month;
	public int day;
	public int codWeekday;
	public int weekMonth;
	public int weekYear;
	public int year;
	public int confirmed;
	public int waiting;
	public int counter;
	public String username;
	
	
	public SchedeekdatInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codMat = DefaultValue.number();
		codWeekday = DefaultValue.number();
		date = DefaultValue.object();
		weekMonth = DefaultValue.number();
		weekYear = DefaultValue.number();
		year = DefaultValue.number();	
		month = DefaultValue.number();		
		day = DefaultValue.number();
		confirmed = 0;
		waiting = 0;
		counter = 0;
	}
	
	
	
	public static SchedeekdatInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedeekdatInfo.class);
	}
	
	
	
	public static List<SchedeekdatInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedeekdatInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (year 	  	  ^ (year 	 	 >>> 32));
		result = result * 31 + (int) (month 	  ^ (month 	 	 >>> 32));
		result = result * 31 + (int) (day 	  	  ^ (day 	 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedeekdatInfo))
			return false;
		
		
		SchedeekdatInfo obj = (SchedeekdatInfo) o;		
		return (codOwner    == obj.codOwner		&& 
				codStore    == obj.codStore		&&
				codEmployee == obj.codEmployee	&&
				codCustomer == obj.codCustomer	&&
				codMat 	    == obj.codMat		&&
				year    	== obj.year			&&
				day    		== obj.day			&&
				month    	== obj.month		);
	}
}
