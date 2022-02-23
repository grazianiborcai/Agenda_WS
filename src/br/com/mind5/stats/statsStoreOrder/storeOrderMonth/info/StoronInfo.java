package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoronInfo extends InfoRecord implements Cloneable {
	public long codOwner;
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
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StoronInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
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
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static StoronInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoronInfo.class);
	}
	
	
	
	public static List<StoronInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoronInfo.class);
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
		
		
		if (!(o instanceof StoronInfo))
			return false;
		
		
		StoronInfo obj = (StoronInfo) o;
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				super.isStringEqual(calmonth, obj.calmonth));
	}
}
