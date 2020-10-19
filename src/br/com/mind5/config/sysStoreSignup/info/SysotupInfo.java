package br.com.mind5.config.sysStoreSignup.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SysotupInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String storeSignup;
	
	
	public SysotupInfo() {
		super();
		
		codOwner = DefaultValue.number();
	}
	
	
	
	public static SysotupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysotupInfo.class);
	}
	
	
	
	public static List<SysotupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysotupInfo.class);
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
		
		
		if (!(o instanceof SysotupInfo))
			return false;
		
		
		SysotupInfo obj = (SysotupInfo) o;		
		return (codOwner == obj.codOwner);
	}
}
