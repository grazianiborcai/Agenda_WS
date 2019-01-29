package br.com.gda.business.storeEmployee.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class StoreEmpInfo extends InfoRecord implements Cloneable {
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
	
	
	public StoreEmpInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codPosition = DefaultValue.number();
		this.codLanguage = DefaultValue.language();
		this.recordMode = RecordMode.RECORD_OK;		
	}
	
	
	
	public static StoreEmpInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreEmpInfo.class);
	}
	
	
	
	public static List<StoreEmpInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreEmpInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore    ^ (codStore    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoreEmpInfo))
			return false;
		
		
		StoreEmpInfo obj = (StoreEmpInfo) o;		
		return (codOwner    == obj.codOwner && 
				codStore    == obj.codStore &&
				codEmployee == obj.codEmployee);
	}
}
