package br.com.mind5.masterData.refundPolicyGroupItem.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefugritemInfo extends InfoRecord implements Cloneable {
	public int codRefundPolicyGroup;
	public int codRefundPolicy;
	public String txtRefundPolicy;
	public int hourBefore;
	
	
	public RefugritemInfo() {
		super();
		
		codRefundPolicyGroup = DefaultValue.number();
		codRefundPolicy = DefaultValue.number();
		hourBefore = DefaultValue.number();
	}
	
	
	
	public static RefugritemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefugritemInfo.class);
	}
	
	
	
	public static List<RefugritemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefugritemInfo.class);
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
		
		
		if (!(o instanceof RefugritemInfo))
			return false;
		
		
		RefugritemInfo obj = (RefugritemInfo) o;
		return (codRefundPolicyGroup 	== obj.codRefundPolicyGroup 	&&
				codRefundPolicy 		== obj.codRefundPolicy				);
	}
}
