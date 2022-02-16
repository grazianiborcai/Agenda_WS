package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SteddiveInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String calmonth;
	public int year;
	public int month;
	public int day;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public String txtMonth;
	public String codCountry;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;	
	public int countScheduleCancelledDay;
	public int countScheduleWaitingDay;
	public int countScheduleConfirmedDay;
	public int countScheduleTotalDay;
	public boolean hasData;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SteddiveInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		day = DefaultValue.number();
		date = DefaultValue.object();
		codWeekday = DefaultValue.number();
		countScheduleCancelledDay = DefaultValue.number();
		countScheduleWaitingDay = DefaultValue.number();
		countScheduleConfirmedDay = DefaultValue.number();
		countScheduleTotalDay = DefaultValue.number();
		hasData = DefaultValue.boole();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SteddiveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SteddiveInfo.class);
	}
	
	
	
	public static List<SteddiveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SteddiveInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (date != null)		
			result = result * 31 + date.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SteddiveInfo))
			return false;
		
		
		SteddiveInfo obj = (SteddiveInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				super.isDateEqual(date  , obj.date));
	}
}
