package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowedulInfo extends InfoRecord implements Cloneable {
	public long codOwner;
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
	public int countScheduleCancelledLastYear;
	public int countScheduleWaitingLastYear;
	public int countScheduleConfirmedLastYear;
	public int countScheduleTotalLastYear;
	public LocalDateTime lastChanged;
	public String username;
	
	public SowedulInfo() {
		super();
		
		codOwner = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countScheduleCancelledMonth = DefaultValue.number();
		countScheduleWaitingMonth = DefaultValue.number();
		countScheduleConfirmedMonth = DefaultValue.number();
		countScheduleTotalMonth = DefaultValue.number();
		countScheduleCancelledLastYear = DefaultValue.number();
		countScheduleWaitingLastYear = DefaultValue.number();
		countScheduleConfirmedLastYear = DefaultValue.number();
		countScheduleTotalLastYear = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowedulInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowedulInfo.class);
	}
	
	
	
	public static List<SowedulInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowedulInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		if (calmonth != null)
			result = result * 31 + calmonth.hashCode();
		
		if (codCountry != null)
			result = result * 31 + codCountry.hashCode();
		
		if (codState != null)
			result = result * 31 + codState.hashCode();
		
		if (city != null)
			result = result * 31 + city.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SowedulInfo))
			return false;
		
		
		SowedulInfo obj = (SowedulInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
