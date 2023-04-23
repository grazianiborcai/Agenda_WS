package br.com.mind5.business.storeAccount.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoracInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codPayPartner;
	public boolean hasPayPartner;
	public boolean isAccountCompleted;
	public String username;
	public String recordMode;
	
	
	public StoracInfo() {
		super();
		
		codOwner           = DefaultValue.number();
		codStore           = DefaultValue.number();
		recordMode         = DefaultValue.recordMode();
		hasPayPartner      = DefaultValue.boole();
		codPayPartner	   = DefaultValue.number();
		isAccountCompleted = DefaultValue.boole();		
	}
	
	
	
	public static StoracInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoracInfo.class);
	}
	
	
	
	public static List<StoracInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoracInfo.class);
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
		
		
		if (!(o instanceof StoracInfo))
			return false;
		
		
		StoracInfo obj = (StoracInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore	);
	}
}
