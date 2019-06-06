package br.com.gda.business.employeeList.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class EmplisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codPerson;
	public PersolisInfo persolisData;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public EmplisInfo() {
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codPerson = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
		persolisData = DefaultValue.object();
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static EmplisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmplisInfo.class);
	}
	
	
	
	public static List<EmplisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmplisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmplisInfo deepCopy = (EmplisInfo) super.clone(); 

		deepCopy.persolisData = clonePerson(deepCopy.persolisData);
		return deepCopy;	
	} 
	
	
	
	private PersolisInfo clonePerson(PersolisInfo personToClone) throws CloneNotSupportedException {
		if (personToClone == null)
			return null;
		
		return (PersolisInfo) personToClone.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmplisInfo))
			return false;
		
		
		EmplisInfo obj = (EmplisInfo) o;		
		return (codOwner == obj.codOwner && codEmployee == obj.codEmployee);
	}
}
