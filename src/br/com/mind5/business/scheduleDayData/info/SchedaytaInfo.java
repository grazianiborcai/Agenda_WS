package br.com.mind5.business.scheduleDayData.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class SchedaytaInfo extends InfoRecord implements Cloneable, Comparable<SchedaytaInfo> {
	public long codOwner;
	public long codSchedule;
	public String codScheduleStatus;
	public long codStore;
	public long codEmployee;
	public long codMat;
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
	
	
	public SchedaytaInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codSchedule = DefaultValue.number();
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
	
	
	
	public static SchedaytaInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedaytaInfo.class);
	}
	
	
	
	public static List<SchedaytaInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedaytaInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codSchedule ^ (codSchedule >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedaytaInfo))
			return false;
		
		
		SchedaytaInfo obj = (SchedaytaInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codSchedule == obj.codSchedule		);
	}


	
	@Override public int compareTo(SchedaytaInfo arg0) {
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
