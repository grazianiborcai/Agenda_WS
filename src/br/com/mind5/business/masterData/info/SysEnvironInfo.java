package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class SysEnvironInfo extends InfoRecord implements Cloneable {
	public String codSysEnviron;
	
	
	public SysEnvironInfo() {
		super(SysEnvironInfo.class);
	}
	
	
	
	public static SysEnvironInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysEnvironInfo.class);
	}
	
	
	
	public static List<SysEnvironInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysEnvironInfo.class);
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
		
		
		if (!(o instanceof SysEnvironInfo))
			return false;
		
		
		SysEnvironInfo obj = (SysEnvironInfo) o;		
		return (isStringEqual(codSysEnviron, obj.codSysEnviron));
	}
}
