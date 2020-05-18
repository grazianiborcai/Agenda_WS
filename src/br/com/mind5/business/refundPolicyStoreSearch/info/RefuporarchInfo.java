package br.com.mind5.business.refundPolicyStoreSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefuporarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codRefundPolicyGroup;
	public String recordMode;
	public String username;
	
	
	public RefuporarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codRefundPolicyGroup = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static RefuporarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefuporarchInfo.class);
	}
	
	
	
	public static List<RefuporarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefuporarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + (int) (codOwner 	^ (codOwner >> 32));
		result = result * 31 + (int) (codStore 	^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefuporarchInfo))
			return false;
		
		
		RefuporarchInfo obj = (RefuporarchInfo) o;
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore	);
	}
}
