package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CustamonagrInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
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
	
	
	public CustamonagrInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countScheduleCancelledMonth = DefaultValue.number();
		countScheduleWaitingMonth = DefaultValue.number();
		countScheduleConfirmedMonth = DefaultValue.number();
		countScheduleTotalMonth = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static CustamonagrInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CustamonagrInfo.class);
	}
	
	
	
	public static List<CustamonagrInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CustamonagrInfo.class);
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
		
		
		if (!(o instanceof CustamonagrInfo))
			return false;
		
		
		CustamonagrInfo obj = (CustamonagrInfo) o;
		return (codOwner    == obj.codOwner    &&
				codCustomer == obj.codCustomer &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
