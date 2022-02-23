package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StordiveInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String calmonth;
	public int year;
	public int month;
	public int day;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public String txtMonth;
	public String codCountry;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;
	public int countOrderTotalDay;
	public int countOrderCreatedDay;
	public int countOrderWaitingDay;
	public int countOrderPaidDay;
	public int countOrderPlacedDay;
	public int countOrderCancelledDay;
	public double totalSaleDay;
	public double totalSaleCreatedDay;
	public double totalSaleWaitingDay;
	public double totalSalePaidDay;
	public double totalSalePlacedDay;
	public double totalSaleCancelledDay;
	public double totalFeeDay;
	public double totalFeeCreatedDay;
	public double totalFeeWaitingDay;
	public double totalFeePaidDay;
	public double totalFeePlacedDay;
	public double totalFeeCancelledDay;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StordiveInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		day = DefaultValue.number();
		date = DefaultValue.object();
		codWeekday = DefaultValue.number();
		countOrderCancelledDay = DefaultValue.number();
		countOrderWaitingDay = DefaultValue.number();
		countOrderPlacedDay = DefaultValue.number();
		countOrderTotalDay = DefaultValue.number();
		countOrderCreatedDay = DefaultValue.number();
		countOrderPaidDay = DefaultValue.number();
		totalSaleDay = DefaultValue.number();
		totalSaleCreatedDay = DefaultValue.number();
		totalSaleWaitingDay = DefaultValue.number();
		totalSalePaidDay = DefaultValue.number();
		totalSalePlacedDay = DefaultValue.number();
		totalSaleCancelledDay = DefaultValue.number();
		totalFeeDay = DefaultValue.number();
		totalFeeCreatedDay = DefaultValue.number();
		totalFeeWaitingDay = DefaultValue.number();
		totalFeePaidDay = DefaultValue.number();
		totalFeePlacedDay = DefaultValue.number();
		totalFeeCancelledDay = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static StordiveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StordiveInfo.class);
	}
	
	
	
	public static List<StordiveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StordiveInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (date != null)		
			result = result * 31 + date.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StordiveInfo))
			return false;
		
		
		StordiveInfo obj = (StordiveInfo) o;
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				super.isDateEqual(date, obj.date));
	}
}
