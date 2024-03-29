package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SowalagrInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String codCountry;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;
	public double totalFee12m;
	public double totalFee30d;
	public double totalFeeCancelled12m;
	public double totalFeeCancelled30d;
	public double totalFeePaid12m;
	public double totalFeePaid30d;
	public double totalFeePlaced12m;
	public double totalFeePlaced30d;
	public double totalFeeWaiting12m;
	public double totalFeeWaiting30d;	
	public double totalSale12m;
	public double totalSale30d;
	public double totalSaleCancelled12m;
	public double totalSaleCancelled30d;	
	public double totalSaleCreated12m;
	public double totalSaleCreated30d;	
	public double totalSalePlaced12m;
	public double totalSalePlaced30d;
	public double totalSalePaid12m;
	public double totalSalePaid30d;
	public double totalSaleWaiting12m;
	public double totalSaleWaiting30d;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SowalagrInfo() {
		super();
		
		codOwner = DefaultValue.number();
		totalFee12m = DefaultValue.number();
		totalFee30d = DefaultValue.number();
		totalFeeCancelled12m = DefaultValue.number();
		totalFeeCancelled30d = DefaultValue.number();
		totalFeePaid12m = DefaultValue.number();
		totalFeePaid30d = DefaultValue.number();
		totalFeePlaced12m = DefaultValue.number();
		totalFeePlaced30d = DefaultValue.number();
		totalFeeWaiting12m = DefaultValue.number();
		totalFeeWaiting30d = DefaultValue.number();
		totalSale12m = DefaultValue.number();
		totalSale30d = DefaultValue.number();
		totalSaleCancelled12m = DefaultValue.number();
		totalSaleCancelled30d = DefaultValue.number();
		totalSaleCreated12m = DefaultValue.number();
		totalSaleCreated30d = DefaultValue.number();
		totalSalePlaced12m = DefaultValue.number();
		totalSalePlaced30d = DefaultValue.number();		
		totalSalePaid12m = DefaultValue.number();
		totalSalePaid30d = DefaultValue.number();
		totalSaleWaiting12m = DefaultValue.number();
		totalSaleWaiting30d = DefaultValue.number();
		lastChanged = DefaultValue.object();
	}
	
	
	
	public static SowalagrInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SowalagrInfo.class);
	}
	
	
	
	public static List<SowalagrInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SowalagrInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
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
		
		
		if (!(o instanceof SowalagrInfo))
			return false;
		
		
		SowalagrInfo obj = (SowalagrInfo) o;
		return (codOwner == obj.codOwner &&
				super.isStringEqual(codCountry, obj.codCountry) &&
				super.isStringEqual(codState  , obj.codState) 	&&
				super.isStringEqual(city      , obj.city) );
	}
}
