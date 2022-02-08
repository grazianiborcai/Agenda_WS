package br.com.mind5.stats.statsOwnerUser.ownerUser.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowusInfo extends InfoRecord implements Cloneable {
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
	public int countUserCreatedMonth;
	public int countUserActiveMonth;
	public int countUserInactiveMonth;
	public int countOrderMonth;
	public int userEngagementMonth;	
	public int countUserCreatedMonthLastYear;
	public int countUserActiveMonthLastYear;
	public int countUserInactiveMonthLastYear;
	public int userEngagementMonthLastYear;	
	public int countOrderMonthLastYear;
	public double countUserCreatedVar;
	public double countUserActiveVar;
	public double countUserInactiveVar;	
	public double countOrderVar;
	public double userEngagementVar;
	public boolean hasData;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SowusInfo() {
		super();
		
		codOwner = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countUserCreatedMonth = DefaultValue.number();
		countUserActiveMonth = DefaultValue.number();
		countUserInactiveMonth = DefaultValue.number();
		countOrderMonth = DefaultValue.number();
		userEngagementMonth = DefaultValue.number();
		countUserActiveMonthLastYear = DefaultValue.number();
		countUserCreatedMonthLastYear = DefaultValue.number();
		countUserInactiveMonthLastYear = DefaultValue.number();
		userEngagementMonthLastYear = DefaultValue.number();
		countOrderMonthLastYear = DefaultValue.number();
		countUserCreatedVar = DefaultValue.number();
		countUserActiveVar = DefaultValue.number();
		countUserInactiveVar = DefaultValue.number();
		countOrderVar = DefaultValue.number();
		userEngagementVar = DefaultValue.number();
		hasData = DefaultValue.boole();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowusInfo.class);
	}
	
	
	
	public static List<SowusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowusInfo.class);
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
		
		
		if (!(o instanceof SowusInfo))
			return false;
		
		
		SowusInfo obj = (SowusInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
