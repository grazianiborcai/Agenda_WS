package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StedmonagrInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String calmonth;
	public int year;
	public int month;
	public String txtMonth;
	public String codCountry;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;
	public int countScheduleCancelledMonth;
	public int countScheduleWaitingMonth;
	public int countScheduleConfirmedMonth;
	public int countScheduleTotalMonth;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StedmonagrInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countScheduleCancelledMonth = DefaultValue.number();
		countScheduleWaitingMonth = DefaultValue.number();
		countScheduleConfirmedMonth = DefaultValue.number();
		countScheduleTotalMonth = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static StedmonagrInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StedmonagrInfo.class);
	}
	
	
	
	public static List<StedmonagrInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StedmonagrInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (calmonth != null)		
			result = result * 31 + calmonth.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StedmonagrInfo))
			return false;
		
		
		StedmonagrInfo obj = (StedmonagrInfo) o;
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
