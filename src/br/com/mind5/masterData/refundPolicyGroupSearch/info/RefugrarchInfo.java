package br.com.mind5.masterData.refundPolicyGroupSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefugrarchInfo extends InfoRecord implements Cloneable {
	public int codRefundPolicyGroup;
	public String txtRefundPolicyGroup;
	
	
	public RefugrarchInfo() {
		super();
		
		codRefundPolicyGroup = DefaultValue.number();
	}
	
	
	
	public static RefugrarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefugrarchInfo.class);
	}
	
	
	
	public static List<RefugrarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefugrarchInfo.class);
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
		
		
		if (!(o instanceof RefugrarchInfo))
			return false;
		
		
		RefugrarchInfo obj = (RefugrarchInfo) o;
		return (codRefundPolicyGroup == obj.codRefundPolicyGroup);
	}
}
