package br.com.mind5.discount.discountStoreSearch.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class DisorarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codDiscount;
	public long codSnapshot;
	public int codDiscountStrategy;
	public boolean isActive;
	public LocalDateTime validFrom;
	public LocalDateTime validTo;
	public String username;
	
	
	public DisorarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codDiscount = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codDiscountStrategy = DefaultValue.number();
		isActive = DefaultValue.boole();
	}
	
	
	
	public static DisorarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DisorarchInfo.class);
	}
	
	
	
	public static List<DisorarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DisorarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore    ^ (codStore    >>> 32));
		result = result * 31 + (int) (codDiscount ^ (codDiscount >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DisorarchInfo))
			return false;
		
		
		DisorarchInfo obj = (DisorarchInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codStore    == obj.codStore 	&&
				codDiscount == obj.codDiscount		);
	}
}
