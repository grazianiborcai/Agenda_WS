package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CutefilonagrInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codStore;
	public String calmonth;
	public int year;
	public int month;
	public String txtMonth;
	public int countScheduleCancelled;
	public int countScheduleWaiting;
	public int countScheduleConfirmed;
	public int countScheduleTotal;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public CutefilonagrInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codCustomer = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countScheduleCancelled = DefaultValue.number();
		countScheduleWaiting = DefaultValue.number();
		countScheduleConfirmed = DefaultValue.number();
		countScheduleTotal = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static CutefilonagrInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CutefilonagrInfo.class);
	}
	
	
	
	public static List<CutefilonagrInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CutefilonagrInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		
		if (calmonth != null)		
			result = result * 31 + calmonth.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CutefilonagrInfo))
			return false;
		
		
		CutefilonagrInfo obj = (CutefilonagrInfo) o;
		return (codOwner    == obj.codOwner    &&
				codCustomer == obj.codCustomer &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
