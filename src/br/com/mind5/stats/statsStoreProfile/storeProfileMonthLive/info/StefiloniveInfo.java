package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StefiloniveInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String calmonth;
	public int year;
	public int month;
	public String txtMonth;
	public int countGoods;
	public int countService;
	public int countEmployee;
	public int countCustomer;
	public int countScheduleCancelled;
	public int countScheduleWaiting;
	public int countScheduleConfirmed;
	public int countScheduleTotal;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StefiloniveInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countScheduleCancelled = DefaultValue.number();
		countScheduleWaiting = DefaultValue.number();
		countScheduleConfirmed = DefaultValue.number();
		countScheduleTotal = DefaultValue.number();
		countGoods = DefaultValue.number();
		countService = DefaultValue.number();
		countEmployee = DefaultValue.number();
		countCustomer = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static StefiloniveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StefiloniveInfo.class);
	}
	
	
	
	public static List<StefiloniveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StefiloniveInfo.class);
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
		
		
		if (!(o instanceof StefiloniveInfo))
			return false;
		
		
		StefiloniveInfo obj = (StefiloniveInfo) o;
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
