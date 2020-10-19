package br.com.mind5.config.sysConfig.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SysonfigInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String storePartitioning;
	public String storeSignup;
	
	
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
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SysonfigInfo))
			return false;
		
		
		SysonfigInfo obj = (SysonfigInfo) o;		
		return (codOwner == obj.codOwner);
	}
}
