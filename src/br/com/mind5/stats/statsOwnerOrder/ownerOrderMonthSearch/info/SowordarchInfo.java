package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowordarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String calmonth;
	public int year;
	public int month;
	public String codCountry;
	public String codState;
	public String city;
	public String username;
	
	
	public SowordarchInfo() {
		super();

		codOwner = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
	}
	
	
	
	public static SowordarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowordarchInfo.class);
	}
	
	
	
	public static List<SowordarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowordarchInfo.class);
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
		
		
		if (!(o instanceof SowordarchInfo))
			return false;
		
		
		SowordarchInfo obj = (SowordarchInfo) o;
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
