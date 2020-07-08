package br.com.mind5.config.sysStorePartitioning.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class SytotinInfo extends InfoRecord implements Cloneable {
	public String storePartitioning;
	
	
	public SytotinInfo() {
		super();
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
		if (storePartitioning == null)
			return 0;
		
		return storePartitioning.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SytotinInfo))
			return false;
		
		
		SytotinInfo obj = (SytotinInfo) o;		
		return (isStringEqual(storePartitioning, obj.storePartitioning));
	}
}
