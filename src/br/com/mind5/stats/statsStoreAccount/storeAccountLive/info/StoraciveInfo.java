package br.com.mind5.stats.statsStoreAccount.storeAccountLive.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoraciveInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String calmonth;
	public String year;
	public String month;
	public String codCountry;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;	
	public int countStoreMonth;
	public int countStoreCompletedMonth;
	public int countStorePendingMonth;
	public int countStoreMonthLastYear;
	public int countStoreCompletedMonthLastYear;
	public int countStorePendingMonthLastYear;
	public double countStoreVar;
	public double countStoreCompletedVar;
	public double countStorePendingVar;
	public int countStoreCumulative;
	public int countStoreCompletedCumulative;
	public int countStorePendingCumulative;
	public String username;
	
	
	public StoraciveInfo() {
		super();
		
		codOwner = DefaultValue.number();
		countStoreMonth = DefaultValue.number();
		countStoreCompletedMonth = DefaultValue.number();
		countStorePendingMonth = DefaultValue.number();
		countStoreMonthLastYear = DefaultValue.number();
		countStoreCompletedMonthLastYear = DefaultValue.number();
		countStorePendingMonthLastYear = DefaultValue.number();
		countStoreVar = DefaultValue.number();
		countStoreCompletedVar = DefaultValue.number();
		countStoreCumulative = DefaultValue.number();
		countStorePendingVar = DefaultValue.number();
		countStoreCompletedCumulative = DefaultValue.number();
		countStorePendingCumulative = DefaultValue.number();
	}
	
	
	
	public static StoraciveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoraciveInfo.class);
	}
	
	
	
	public static List<StoraciveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoraciveInfo.class);
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
		
		
		if (!(o instanceof StoraciveInfo))
			return false;
		
		
		StoraciveInfo obj = (StoraciveInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
