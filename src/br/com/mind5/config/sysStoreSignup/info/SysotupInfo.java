package br.com.mind5.config.sysStoreSignup.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class SysotupInfo extends InfoRecord implements Cloneable {
	public String storeSignup;
	
	
	public SysotupInfo() {
		super();
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
		if (storeSignup == null)
			return 0;
		
		return storeSignup.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SysotupInfo))
			return false;
		
		
		SysotupInfo obj = (SysotupInfo) o;		
		return (isStringEqual(storeSignup, obj.storeSignup));
	}
}
