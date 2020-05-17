package br.com.mind5.business.refundPolicyOwnerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefupowarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codRefundPolicyGroup;
	public String recordMode;
	public String username;
	
	
	public RefupowarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codRefundPolicyGroup = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static RefupowarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefupowarchInfo.class);
	}
	
	
	
	public static List<RefupowarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefupowarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + (int) (codOwner 				^ (codOwner 			>>> 32));
		result = result * 31 + (int) (codRefundPolicyGroup 	^ (codRefundPolicyGroup >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefupowarchInfo))
			return false;
		
		
		RefupowarchInfo obj = (RefupowarchInfo) o;
		return (codOwner 			 == obj.codOwner &&
				codRefundPolicyGroup == obj.codRefundPolicyGroup);
	}
}
