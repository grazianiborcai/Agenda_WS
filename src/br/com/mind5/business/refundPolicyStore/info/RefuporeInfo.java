package br.com.mind5.business.refundPolicyStore.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class RefuporeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codRefundPolicyGroup;
	public String txtRefundPolicyGroup;
	public List<RefugritemInfo> refugritemes;
	
	
	public RefuporeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codRefundPolicyGroup = DefaultValue.number();
		refugritemes = DefaultValue.list();
	}
	
	
	
	public static RefuporeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefuporeInfo.class);
	}
	
	
	
	public static List<RefuporeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefuporeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefuporeInfo))
			return false;
		
		
		RefuporeInfo obj = (RefuporeInfo) o;
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore 	);
	}
}