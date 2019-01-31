package br.com.gda.business.employeePosition.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class EmposInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public String nameStore;	
	public long codEmployee;
	public String nameEmployee;
	public int codPosition;
	public String txtPosition;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public String recordMode;
	
	
	public EmposInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codPosition = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = RecordMode.RECORD_OK;		
	}
	
	
	
	public static EmposInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmposInfo.class);
	}
	
	
	
	public static List<EmposInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmposInfo.class);
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
		
		
		if (!(o instanceof EmposInfo))
			return false;
		
		
		EmposInfo obj = (EmposInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codStore    == obj.codStore 	&&
				codEmployee == obj.codEmployee	&&
				codPosition == obj.codPosition		);
	}
}
