package br.com.mind5.authorization.storePartitionAuthorization.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SytotauhInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String username;
	
	
	public SytotauhInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
	}
	
	
	
	public static SytotauhInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SytotauhInfo.class);
	}
	
	
	
	public static List<SytotauhInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SytotauhInfo.class);
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
		
		
		if (!(o instanceof SytotauhInfo))
			return false;
		
		
		SytotauhInfo obj = (SytotauhInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore	);
	}
}
