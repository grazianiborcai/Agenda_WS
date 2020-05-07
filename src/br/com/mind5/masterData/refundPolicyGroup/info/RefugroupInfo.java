package br.com.mind5.masterData.refundPolicyGroup.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class RefugroupInfo extends InfoRecord implements Cloneable {
	public int codRefundPolicyGroup;
	public String txtRefundPolicyGroup;
	public List<RefugritemInfo> refugritemes;
	
	
	public RefugroupInfo() {
		super();
		
		codRefundPolicyGroup = DefaultValue.number();
		refugritemes = DefaultValue.list();
	}
	
	
	
	public static RefugroupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefugroupInfo.class);
	}
	
	
	
	public static List<RefugroupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefugroupInfo.class);
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
		
		
		if (!(o instanceof RefugroupInfo))
			return false;
		
		
		RefugroupInfo obj = (RefugroupInfo) o;
		return (codRefundPolicyGroup == obj.codRefundPolicyGroup);
	}
}
