package br.com.mind5.discount.discountStoreSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class DisorapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codStore;
	public long codDiscount;	
	public int codDiscountStrategy;
	public String txtDiscountStrategy;
	public String descriptionDiscountStrategy;
	public int discountPercent;
	public boolean isActive;
	public LocalDateTime validFrom;
	public LocalDateTime validTo;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;	
	public String username;
	
	
	public DisorapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codDiscount = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codDiscountStrategy = DefaultValue.number();
		discountPercent = DefaultValue.number();
		isActive = DefaultValue.boole();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static DisorapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DisorapInfo.class);
	}
	
	
	
	public static List<DisorapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DisorapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));		
		result = result * 31 + (int) (codStore    ^ (codStore    >>> 32));
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DisorapInfo))
			return false;
		
		
		DisorapInfo obj = (DisorapInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codStore    == obj.codStore 	&&
				codSnapshot == obj.codSnapshot		);
	}
}
