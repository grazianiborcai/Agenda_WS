package br.com.mind5.business.employeePositionSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmposarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codEmployee;
	public int codPosition;
	public String username;
	public String recordMode;
	
	
	public EmposarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codPosition = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static EmposarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmposarchInfo.class);
	}
	
	
	
	public static List<EmposarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmposarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore    ^ (codStore    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) codPosition;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmposarchInfo))
			return false;
		
		
		EmposarchInfo obj = (EmposarchInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codStore    == obj.codStore 	&&
				codEmployee == obj.codEmployee	&&
				codPosition == obj.codPosition		);
	}
}
