package br.com.mind5.business.employeeSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmparchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codStore;
	public long codSnapshot;
	public long codPerson;
	public long codUser;
	public String email;
	public String recordMode;
	public String username;
	
	
	public EmparchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static EmparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmparchInfo.class);
	}
	
	
	
	public static List<EmparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmparchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		return super.clone(); 
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
		
		
		if (!(o instanceof EmparchInfo))
			return false;
		
		
		EmparchInfo obj = (EmparchInfo) o;		
		return (codOwner    == obj.codOwner && 
				codEmployee == obj.codEmployee);
	}
}
