package br.com.mind5.masterData.sysEnvironment.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class SysenvInfo extends InfoRecord implements Cloneable {
	public String codSysEnviron;
	
	
	public SysenvInfo() {
		super();
	}
	
	
	
	public static SysenvInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysenvInfo.class);
	}
	
	
	
	public static List<SysenvInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysenvInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (codSysEnviron == null)
			return 0;
		
		return codSysEnviron.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SysenvInfo))
			return false;
		
		
		SysenvInfo obj = (SysenvInfo) o;		
		return (isStringEqual(codSysEnviron, obj.codSysEnviron));
	}
}
