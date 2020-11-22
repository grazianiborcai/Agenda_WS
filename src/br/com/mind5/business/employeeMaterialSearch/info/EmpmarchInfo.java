package br.com.mind5.business.employeeMaterialSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmpmarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codMat;
	public long codStore;
	public String recordMode;
	public String username;
	
	
	public EmpmarchInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static EmpmarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpmarchInfo.class);
	}
	
	
	
	public static List<EmpmarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpmarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpmarchInfo))
			return false;
		
		
		EmpmarchInfo obj = (EmpmarchInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codEmployee == obj.codEmployee 	&&
				codMat 		== obj.codMat);
	}
}
