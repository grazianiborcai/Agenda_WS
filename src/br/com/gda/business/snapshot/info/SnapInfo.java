package br.com.gda.business.snapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class SnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPerson;
	public LocalDateTime lastChanged;
	
	
	public SnapInfo() {
		codOwner = DefaultValue.number();
		codPerson = DefaultValue.number();
		codSnapshot = DefaultValue.number();
	}
	
	
	
	public static SnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SnapInfo.class);
	}
	
	
	
	public static List<SnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	 	^ (codOwner   	>>> 32));
		result = result * 31 + (int) (codPerson	 	^ (codPerson   	>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SnapInfo))
			return false;
		
		
		SnapInfo obj = (SnapInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson 	&&
				codSnapshot	== obj.codSnapshot		);
	}		
}
