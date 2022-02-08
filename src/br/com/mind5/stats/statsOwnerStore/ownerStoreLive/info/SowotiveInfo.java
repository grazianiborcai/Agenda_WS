package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowotiveInfo extends InfoRecord implements Cloneable {
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
	public int countStoreCreatedLastYear;
	public int countStoreCompletedLastYear;
	public int countStorePendingLastYear;
	public double countStoreCreatedVar;
	public double countStoreCompletedVar;
	public double countStorePendingVar;
	public boolean hasData;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SowotiveInfo() {
		super();
		
		codOwner = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countStoreCreatedMonth = DefaultValue.number();
		countStoreCompletedMonth = DefaultValue.number();
		countStorePendingMonth = DefaultValue.number();
		countStoreCreatedLastYear = DefaultValue.number();
		countStoreCompletedLastYear = DefaultValue.number();
		countStorePendingLastYear = DefaultValue.number();
		countStoreCreatedVar = DefaultValue.number();
		countStoreCompletedVar = DefaultValue.number();
		countStorePendingVar = DefaultValue.number();
		hasData = DefaultValue.boole();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowotiveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowotiveInfo.class);
	}
	
	
	
	public static List<SowotiveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowotiveInfo.class);
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
		
		
		if (!(o instanceof SowotiveInfo))
			return false;
		
		
		SowotiveInfo obj = (SowotiveInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
