package br.com.mind5.config.sysConfig.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SysonfigInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String ownerSignup;
	public String storePartitioning;
	
	
	public SysonfigInfo() {
		super();
		
		codOwner = DefaultValue.number();
	}
	
	
	
	public static SysonfigInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysonfigInfo.class);
	}
	
	
	
	public static List<SysonfigInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysonfigInfo.class);
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
		
		
		if (!(o instanceof SysonfigInfo))
			return false;
		
		
		SysonfigInfo obj = (SysonfigInfo) o;		
		return (isStringEqual(ownerSignup, obj.ownerSignup));
	}
}
