package br.com.mind5.config.sysOwnerSignup.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SysonupInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String ownerSignup;
	
	
	public SysonupInfo() {
		super();
		
		codOwner = DefaultValue.number();
	}
	
	
	
	public static SysonupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysonupInfo.class);
	}
	
	
	
	public static List<SysonupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysonupInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (ownerSignup == null)
			return 0;
		
		return ownerSignup.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SysonupInfo))
			return false;
		
		
		SysonupInfo obj = (SysonupInfo) o;		
		return (isStringEqual(ownerSignup, obj.ownerSignup));
	}
}
