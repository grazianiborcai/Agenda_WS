package br.com.mind5.business.scheduleRange.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class SchedageInfo extends InfoRecord implements Cloneable, Comparable<SchedageInfo> {
	public long codOwner;
	public long codSchedule;
	public String codScheduleStatus;
	public long codOrder;
	public String codOrderStatus;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public LocalDate date;
	public int codWeekday;
	public int day;
	public int weekMonth;
	public int weekYear;
	public int month;
	public int quarter;
	public int year;	
	public LocalTime beginTime;
	public LocalTime endTime;
	public long codUser;
	public long codCustomer;
	public String username;
	public String recordMode;
	
	
	public SchedageInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codSchedule = DefaultValue.number();
		codOrder = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		codWeekday = DefaultValue.number();
		day = DefaultValue.number();
		weekMonth = DefaultValue.number();
		weekYear = DefaultValue.number();
		month = DefaultValue.number();
		quarter = DefaultValue.number();
		year = DefaultValue.number();	
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static SchedageInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedageInfo.class);
	}
	
	
	
	public static List<SchedageInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedageInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codSchedule ^ (codSchedule >>> 32));
		result = result * 31 + (int) (codOrder 	  ^ (codOrder 	 >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedageInfo))
			return false;
		
		
		SchedageInfo obj = (SchedageInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codSchedule == obj.codSchedule		&&
				codOrder    == obj.codOrder			&&
				codStore    == obj.codStore			&&
				codEmployee == obj.codEmployee		&&
				codMat    	== obj.codMat			&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(SchedageInfo arg0) {
		if (arg0 == null) {
			super.logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		/*
		if (itemNumber < arg0.itemNumber)
			return -1;
		
		if (itemNumber > arg0.itemNumber)
			return 1;
		
		if (equals(arg0))*/
			return 0;
		
		/*
		super.logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);*/
	}
}
