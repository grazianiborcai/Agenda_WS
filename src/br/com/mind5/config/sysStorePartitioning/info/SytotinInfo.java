package br.com.mind5.config.sysStorePartitioning.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SytotinInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String storePartitioning;
	
	
	public SytotinInfo() {
		super();
		
		codOwner = DefaultValue.number();
	}
	
	
	
	public static SytotinInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SytotinInfo.class);
	}
	
	
	
	public static List<SytotinInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SytotinInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SytotinInfo))
			return false;
		
		
		SytotinInfo obj = (SytotinInfo) o;		
		return (codOwner == obj.codOwner);
	}
}
