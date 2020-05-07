package br.com.mind5.masterData.refundPolicyGroupItemSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefugritarchInfo extends InfoRecord implements Cloneable {
	public int codRefundPolicyGroup;
	public int codRefundPolicy;
	
	
	public RefugritarchInfo() {
		super();
		
		codRefundPolicyGroup = DefaultValue.number();
		codRefundPolicy = DefaultValue.number();
	}
	
	
	
	public static RefugritarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefugritarchInfo.class);
	}
	
	
	
	public static List<RefugritarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefugritarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codRefundPolicyGroup 	^ (codRefundPolicyGroup 	>>> 32));
		result = result * 31 + (int) (codRefundPolicy 		^ (codRefundPolicy 			>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefugritarchInfo))
			return false;
		
		
		RefugritarchInfo obj = (RefugritarchInfo) o;
		return (codRefundPolicyGroup 	== obj.codRefundPolicyGroup 	&&
				codRefundPolicy 		== obj.codRefundPolicy				);
	}
}
