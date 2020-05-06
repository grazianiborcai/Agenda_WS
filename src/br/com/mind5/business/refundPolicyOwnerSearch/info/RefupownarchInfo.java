package br.com.mind5.business.refundPolicyOwnerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefupownarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codRefundPolicy;
	public int hourBefore;
	
	
	public RefupownarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codRefundPolicy = DefaultValue.number();
		hourBefore = DefaultValue.number();
	}
	
	
	
	public static RefupownarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefupownarchInfo.class);
	}
	
	
	
	public static List<RefupownarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefupownarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		  ^ (codOwner 		 >>> 32));
		result = result * 31 + (int) (codRefundPolicy ^ (codRefundPolicy >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefupownarchInfo))
			return false;
		
		
		RefupownarchInfo obj = (RefupownarchInfo) o;
		return (codOwner 		== obj.codOwner 		&&
				codRefundPolicy == obj.codRefundPolicy		);
	}
}
