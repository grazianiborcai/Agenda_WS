package br.com.mind5.masterData.refundPolicyGroupHeader.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefugraderInfo extends InfoRecord implements Cloneable {
	public int codRefundPolicyGroup;
	public String txtRefundPolicyGroup;
	
	
	public RefugraderInfo() {
		super();
		
		codRefundPolicyGroup = DefaultValue.number();
	}
	
	
	
	public static RefugraderInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefugraderInfo.class);
	}
	
	
	
	public static List<RefugraderInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefugraderInfo.class);
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
		
		
		if (!(o instanceof RefugraderInfo))
			return false;
		
		
		RefugraderInfo obj = (RefugraderInfo) o;
		return (codRefundPolicyGroup == obj.codRefundPolicyGroup);
	}
}
