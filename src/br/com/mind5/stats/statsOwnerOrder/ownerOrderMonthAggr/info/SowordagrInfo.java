package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowordagrInfo extends InfoRecord implements Cloneable {
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
	public int countOrderTotalMonth;
	public int countOrderCreatedMonth;
	public int countOrderWaitingMonth;
	public int countOrderPaidMonth;
	public int countOrderPlacedMonth;
	public int countOrderCancelledMonth;
	public double totalSaleMonth;
	public double totalSaleCreatedMonth;
	public double totalSaleWaitingMonth;
	public double totalSalePaidMonth;
	public double totalSalePlacedMonth;
	public double totalSaleCancelledMonth;
	public double totalFeeMonth;
	public double totalFeeCreatedMonth;
	public double totalFeeWaitingMonth;
	public double totalFeePaidMonth;
	public double totalFeePlacedMonth;
	public double totalFeeCancelledMonth;
	public int countOrderTotalLastYear;
	public int countOrderCreatedLastYear;
	public int countOrderWaitingLastYear;
	public int countOrderPaidLastYear;
	public int countOrderPlacedLastYear;
	public int countOrderCancelledLastYear;
	public double totalSaleLastYear;
	public double totalSaleCreatedLastYear;
	public double totalSaleWaitingLastYear;
	public double totalSalePaidLastYear;
	public double totalSalePlacedLastYear;
	public double totalSaleCancelledLastYear;
	public double totalFeeLastYear;
	public double totalFeeCreatedLastYear;
	public double totalFeeWaitingLastYear;
	public double totalFeePaidLastYear;
	public double totalFeePlacedLastYear;
	public double totalFeeCancelledLastYear;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SowordagrInfo() {
		super();

		codOwner = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		countOrderCancelledMonth = DefaultValue.number();
		countOrderWaitingMonth = DefaultValue.number();
		countOrderPlacedMonth = DefaultValue.number();
		countOrderTotalMonth = DefaultValue.number();
		countOrderCreatedMonth = DefaultValue.number();
		countOrderPaidMonth = DefaultValue.number();
		totalSaleMonth = DefaultValue.number();
		totalSaleCreatedMonth = DefaultValue.number();
		totalSaleWaitingMonth = DefaultValue.number();
		totalSalePaidMonth = DefaultValue.number();
		totalSalePlacedMonth = DefaultValue.number();
		totalSaleCancelledMonth = DefaultValue.number();
		totalFeeMonth = DefaultValue.number();
		totalFeeCreatedMonth = DefaultValue.number();
		totalFeeWaitingMonth = DefaultValue.number();
		totalFeePaidMonth = DefaultValue.number();
		totalFeePlacedMonth = DefaultValue.number();
		totalFeeCancelledMonth = DefaultValue.number();
		countOrderCancelledLastYear = DefaultValue.number();
		countOrderWaitingLastYear = DefaultValue.number();
		countOrderPlacedLastYear = DefaultValue.number();
		countOrderTotalLastYear = DefaultValue.number();
		countOrderCreatedLastYear = DefaultValue.number();
		countOrderPaidLastYear = DefaultValue.number();
		totalSaleLastYear = DefaultValue.number();
		totalSaleCreatedLastYear = DefaultValue.number();
		totalSaleWaitingLastYear = DefaultValue.number();
		totalSalePaidLastYear = DefaultValue.number();
		totalSalePlacedLastYear = DefaultValue.number();
		totalSaleCancelledLastYear = DefaultValue.number();
		totalFeeLastYear = DefaultValue.number();
		totalFeeCreatedLastYear = DefaultValue.number();
		totalFeeWaitingLastYear = DefaultValue.number();
		totalFeePaidLastYear = DefaultValue.number();
		totalFeePlacedLastYear = DefaultValue.number();
		totalFeeCancelledLastYear = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowordagrInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowordagrInfo.class);
	}
	
	
	
	public static List<SowordagrInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowordagrInfo.class);
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
		
		
		if (!(o instanceof SowordagrInfo))
			return false;
		
		
		SowordagrInfo obj = (SowordagrInfo) o;
		return (codOwner == obj.codOwner && 
				super.isStringEqual(calmonth  , obj.calmonth) 	&&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
