package br.com.gda.business.phoneSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PhoneSnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPhone;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public long codUser;
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
	
	
	public PhoneSnapInfo() {
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPhone = DefaultValue.number();
		codStore = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codUser = DefaultValue.number();
		codCountryPhone = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		isDeleted = DefaultValue.boole();
	}
	
	
	
	public static PhoneSnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhoneSnapInfo.class);
	}
	
	
	
	public static List<PhoneSnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhoneSnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	>>> 32));
		result = result * 31 + (int) (codSnapshot	^ (codSnapshot 	>>> 32));
		result = result * 31 + (int) (codPhone 		^ (codPhone 	>>> 32));		
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 	>>> 32));		
		result = result * 31 + codCountryPhone;
		
		if (fullNumber != null)
			result = result * 31 + fullNumber.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhoneSnapInfo))
			return false;
		
		
		PhoneSnapInfo obj = (PhoneSnapInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codSnapshot		== obj.codSnapshot 		&& 
				codPhone 		== obj.codPhone			&&	
				codCustomer 	== obj.codCustomer 		&&
				codStore		== obj.codStore			&&
				codEmployee		== obj.codEmployee		&&
				codCountryPhone == obj.codCountryPhone	&&
				super.isStringEqual(fullNumber, obj.fullNumber));
	}	
}
