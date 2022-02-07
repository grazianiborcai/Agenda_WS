package br.com.mind5.stats.statsOwnerOrder.ownerOrder.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowordInfo extends InfoRecord implements Cloneable {
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
	public double totalFeeMonth;
	public double totalSaleMonth;
	public int countOrderMonth;
	public double totalFeeMMonthLastYear;
	public double totalSaleMonthLastYear;
	public int countOrderMonthLastYear;
	public double totalFeeMVar;
	public double totalSaleVar;
	public double countOrderVar;
	public double totalFeeMCumulative;
	public double totalSaleCumulative;
	public int countOrderCumulative;
	public boolean hasData;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SowordInfo() {
		super();
		
		codOwner = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		totalFeeMonth = DefaultValue.number();
		totalSaleMonth = DefaultValue.number();
		countOrderMonth = DefaultValue.number();
		totalSaleMonthLastYear = DefaultValue.number();
		totalFeeMMonthLastYear = DefaultValue.number();
		countOrderMonthLastYear = DefaultValue.number();
		totalFeeMVar = DefaultValue.number();
		totalSaleVar = DefaultValue.number();
		totalFeeMCumulative = DefaultValue.number();
		countOrderVar = DefaultValue.number();
		totalSaleCumulative = DefaultValue.number();
		countOrderCumulative = DefaultValue.number();
		hasData = DefaultValue.boole();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowordInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowordInfo.class);
	}
	
	
	
	public static List<SowordInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowordInfo.class);
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
		
		
		if (!(o instanceof SowordInfo))
			return false;
		
		
		SowordInfo obj = (SowordInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
