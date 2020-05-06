package br.com.mind5.business.refundPolicyStoreSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefuporerchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codRefundPolicy;
	public int hourBefore;
	
	
	public RefuporerchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codRefundPolicy = DefaultValue.number();
		hourBefore = DefaultValue.number();
	}
	
	
	
	public static RefuporerchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefuporerchInfo.class);
	}
	
	
	
	public static List<RefuporerchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefuporerchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		  ^ (codOwner 		 >>> 32));
		result = result * 31 + (int) (codStore 		  ^ (codStore 		 >>> 32));
		result = result * 31 + (int) (codRefundPolicy ^ (codRefundPolicy >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefuporerchInfo))
			return false;
		
		
		RefuporerchInfo obj = (RefuporerchInfo) o;
		return (codOwner 		== obj.codOwner 		&&
				codStore 		== obj.codStore 		&&
				codRefundPolicy == obj.codRefundPolicy		);
	}
}
