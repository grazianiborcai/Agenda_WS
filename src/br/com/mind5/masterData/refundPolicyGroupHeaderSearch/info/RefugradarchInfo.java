package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefugradarchInfo extends InfoRecord implements Cloneable {
	public int codRefundPolicyGroup;
	public String txtRefundPolicyGroup;
	
	
	public RefugradarchInfo() {
		super();
		
		codRefundPolicyGroup = DefaultValue.number();
	}
	
	
	
	public static RefugradarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefugradarchInfo.class);
	}
	
	
	
	public static List<RefugradarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefugradarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + (int) (codRefundPolicyGroup ^ (codRefundPolicyGroup >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefugradarchInfo))
			return false;
		
		
		RefugradarchInfo obj = (RefugradarchInfo) o;
		return (codRefundPolicyGroup == obj.codRefundPolicyGroup);
	}
}
