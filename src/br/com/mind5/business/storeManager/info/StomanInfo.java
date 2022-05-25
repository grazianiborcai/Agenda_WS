package br.com.mind5.business.storeManager.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StomanInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codUser;
	public String username;
	public String recordMode;
	
	
	public StomanInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StomanInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StomanInfo.class);
	}
	
	
	
	public static List<StomanInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StomanInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
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
		
		
		if (!(o instanceof StomanInfo))
			return false;
		
		
		StomanInfo obj = (StomanInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore);
	}
}
