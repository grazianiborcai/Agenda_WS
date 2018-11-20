package br.com.gda.business.phone.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PhoneInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPhone;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public String codCountry;
	public String fullNumber;
	public int codCountryPhone;
	public String codArea;
	public String number;
	public String complement;
	public String recordMode;
	public LocalDateTime lastChanged;
	public String codForm;
	public boolean isDeleted;
	
	
	public PhoneInfo() {
		codOwner = DefaultValue.number();
		codPhone = DefaultValue.number();
		codStore = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCountryPhone = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		isDeleted = DefaultValue.boole();
	}
	
	
	
	public static PhoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhoneInfo.class);
	}
	
	
	
	public static List<PhoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhoneInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codPhone ^ (codPhone >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhoneInfo))
			return false;
		
		
		PhoneInfo obj = (PhoneInfo) o;		
		return (codOwner == obj.codOwner && codPhone == obj.codPhone);
	}	
}
