package br.com.mind5.config.sysStoreBusinessContent.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SytorbcInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String storeBusinessContent;
	
	
	public SytorbcInfo() {
		super();
		
		codOwner = DefaultValue.number();
	}
	
	
	
	public static SytorbcInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SytorbcInfo.class);
	}
	
	
	
	public static List<SytorbcInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SytorbcInfo.class);
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
		
		
		if (!(o instanceof SytorbcInfo))
			return false;
		
		
		SytorbcInfo obj = (SytorbcInfo) o;		
		return (codOwner == obj.codOwner);
	}
}
