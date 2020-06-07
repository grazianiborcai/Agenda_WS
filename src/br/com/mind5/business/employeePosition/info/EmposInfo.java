package br.com.mind5.business.employeePosition.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmposInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int codPosition;
	public String txtPosition;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;	
	public String username;
	public String recordMode;
	public EmplisInfo emplisData;
	
	
	public EmposInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codPosition = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		createdBy = DefaultValue.number();
		emplisData = DefaultValue.object();
	}
	
	
	
	public static EmposInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmposInfo.class);
	}
	
	
	
	public static List<EmposInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmposInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		EmposInfo deepCopy = (EmposInfo) super.clone();
		
		deepCopy.emplisData = CloneUtil.cloneRecord(emplisData, this.getClass());
		
		return deepCopy;
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
