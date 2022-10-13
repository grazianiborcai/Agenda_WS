package br.com.mind5.business.phoneSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PhonarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPhone;
	public long codSnapshot;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public long codUser;
	public long codLegalPerson;
	public long codOwnerRef;
	public String codCountry;
	public String fullNumber;
	public int codCountryPhone;
	public String codArea;
	public String recordMode;
	public String username;
	
	
	public PhonarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPhone = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codUser = DefaultValue.number();
		codLegalPerson = DefaultValue.number();
		codCountryPhone = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PhonarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhonarchInfo.class);
	}
	
	
	
	public static List<PhonarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhonarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 			^ (codOwner 		>>> 32));
		result = result * 31 + (int) (codPhone 			^ (codPhone 		>>> 32));		
		result = result * 31 + (int) (codCustomer 		^ (codCustomer 		>>> 32));
		result = result * 31 + (int) (codStore 			^ (codStore 		>>> 32));
		result = result * 31 + (int) (codEmployee 		^ (codEmployee 		>>> 32));		
		result = result * 31 + (int) (codUser 			^ (codUser 			>>> 32));
		result = result * 31 + (int) (codLegalPerson 	^ (codLegalPerson 	>>> 32));
		result = result * 31 + (int) (codOwnerRef		^ (codOwnerRef 		>>> 32));
		result = result * 31 + codCountryPhone;
		
		if (fullNumber != null)
			result = result * 31 + fullNumber.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhonarchInfo))
			return false;
		
		
		PhonarchInfo obj = (PhonarchInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codPhone 		== obj.codPhone			&&	
				codCustomer 	== obj.codCustomer 		&&
				codStore		== obj.codStore			&&
				codEmployee		== obj.codEmployee		&&
				codCountryPhone == obj.codCountryPhone	&&
				codUser 		== obj.codUser 			&&
				codLegalPerson 	== obj.codLegalPerson 	&&
				codOwnerRef 	== obj.codOwnerRef 		&& 
				super.isStringEqual(fullNumber, obj.fullNumber));
	}	
}
