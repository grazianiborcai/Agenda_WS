package br.com.mind5.stats.statsOwnerStore.ownerStore.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowotInfo extends InfoRecord implements Cloneable {
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
	public int countStoreCreatedMonth;
	public int countStoreCompletedMonth;
	public int countStorePendingMonth;
	public int countStoreCreatedMonthLastYear;
	public int countStoreCompletedMonthLastYear;
	public int countStorePendingMonthLastYear;
	public double countStoreCreatedVar;
	public double countStoreCompletedVar;
	public double countStorePendingVar;
	public int countStoreCreatedCumulative;
	public int countStoreCompletedCumulative;
	public int countStorePendingCumulative;
	public boolean hasData;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SowotInfo() {
		super();
		
		codOwner = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countStoreCreatedMonth = DefaultValue.number();
		countStoreCompletedMonth = DefaultValue.number();
		countStorePendingMonth = DefaultValue.number();
		countStoreCreatedMonthLastYear = DefaultValue.number();
		countStoreCompletedMonthLastYear = DefaultValue.number();
		countStorePendingMonthLastYear = DefaultValue.number();
		countStoreCreatedVar = DefaultValue.number();
		countStoreCompletedVar = DefaultValue.number();
		countStoreCreatedCumulative = DefaultValue.number();
		countStorePendingVar = DefaultValue.number();
		countStoreCompletedCumulative = DefaultValue.number();
		countStorePendingCumulative = DefaultValue.number();
		hasData = DefaultValue.boole();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowotInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowotInfo.class);
	}
	
	
	
	public static List<SowotInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowotInfo.class);
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
		
		
		if (!(o instanceof SowotInfo))
			return false;
		
		
		SowotInfo obj = (SowotInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
