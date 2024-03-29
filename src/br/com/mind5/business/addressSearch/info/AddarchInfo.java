package br.com.mind5.business.addressSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class AddarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codAddress;
	public long codSnapshot;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public long codUser;
	public long codLegalPerson;
	public long codOwnerRef;
	public String codCountry;
	public String codCountryAlpha3;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;
	public String recordMode;
	public String username;
	
	
	public AddarchInfo() {
		super();
		
		codUser        = DefaultValue.number();
		codOwner 	   = DefaultValue.number();
		codStore       = DefaultValue.number();
		recordMode     = DefaultValue.recordMode();
		codAddress     = DefaultValue.number();
		codSnapshot    = DefaultValue.number();
		codCustomer    = DefaultValue.number();
		codOwnerRef    = DefaultValue.number();
		codEmployee    = DefaultValue.number();
		codLegalPerson = DefaultValue.number();
	}
	
	
	
	public static AddarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AddarchInfo.class);
	}
	
	
	
	public static List<AddarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AddarchInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	 		^ (codOwner   		>>> 32));
		result = result * 31 + (int) (codAddress 		^ (codAddress 		>>> 32));		
		result = result * 31 + (int) (codCustomer 		^ (codCustomer 		>>> 32));
		result = result * 31 + (int) (codStore 			^ (codStore 		>>> 32));
		result = result * 31 + (int) (codEmployee 		^ (codEmployee 		>>> 32));
		result = result * 31 + (int) (codUser 			^ (codUser 			>>> 32));
		result = result * 31 + (int) (codLegalPerson 	^ (codLegalPerson 	>>> 32));
		result = result * 31 + (int) (codOwnerRef 		^ (codOwnerRef 		>>> 32));
		
		if (codCountry != null)
			result = result * 31 + codCountry.hashCode();
		
		if (codState != null)
			result = result * 31 + codState.hashCode();
		
		if (city != null)
			result = result * 31 + city.hashCode();
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AddarchInfo))
			return false;
		
		
		AddarchInfo obj = (AddarchInfo) o;		
		return (codOwner 		== obj.codOwner 					&& 
				codAddress 		== obj.codAddress					&&
				codCustomer		== obj.codCustomer					&&
				codStore		== obj.codStore						&&
				codEmployee		== obj.codEmployee					&&
				codUser			== obj.codUser						&&
				codOwnerRef		== obj.codOwnerRef					&&
				codLegalPerson	== obj.codLegalPerson				&&
				super.isStringEqual(codCountry, obj.codCountry)		&&				
				super.isStringEqual(codState, obj.codState)			&&
				super.isStringEqual(city, obj.city)						);
	}	
}
