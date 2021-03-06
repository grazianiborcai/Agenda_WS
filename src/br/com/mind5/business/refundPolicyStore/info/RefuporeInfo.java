package br.com.mind5.business.refundPolicyStore.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class RefuporeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codRefundPolicyGroup;
	public String txtRefundPolicyGroup;
	public List<RefugritemInfo> refugritemes;
	public String recordMode;
	public LocalDateTime createdOn;
	public long createdBy;	
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public RefuporeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codRefundPolicyGroup = DefaultValue.number();
		refugritemes = DefaultValue.list();
		recordMode = DefaultValue.recordMode();
		createdBy = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static RefuporeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefuporeInfo.class);
	}
	
	
	
	public static List<RefuporeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefuporeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		RefuporeInfo deepCopy = (RefuporeInfo) super.clone();
		
		deepCopy.refugritemes = CloneUtil.cloneRecords(refugritemes, this.getClass());
		
		return deepCopy;
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
