package br.com.mind5.business.phoneSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PhonapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPhone;
	public long codOwnerRef;
	public long codOwnerRefSnapshot;
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codStore;
	public long codStoreSnapshot;
	public long codEmployee;
	public long codEmployeeSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public long codLegalPerson;
	public String phoneName;
	public boolean isDefault;
	public String codCountry;
	public String fullNumber;
	public int codCountryPhone;
	public String codArea;
	public String number;
	public String complement;
	public String recordMode;
	public LocalDateTime createdOn;
	public long createdBy;	
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String codForm;
	public String username;
	
	
	public PhonapInfo() {
		super();
		
		codUser             = DefaultValue.number();
		codOwner            = DefaultValue.number();
		codPhone            = DefaultValue.number();
		codStore            = DefaultValue.number();
		isDefault           = DefaultValue.boole();			
		createdBy           = DefaultValue.number();	
		recordMode          = DefaultValue.recordMode();
		codCustomer         = DefaultValue.number();
		codEmployee         = DefaultValue.number();
		codOwnerRef         = DefaultValue.number();
		codSnapshot         = DefaultValue.number();
		lastChangedBy       = DefaultValue.number();
		codLegalPerson      = DefaultValue.number();		
		codUserSnapshot     = DefaultValue.number();
		codCountryPhone     = DefaultValue.number();
		codStoreSnapshot    = DefaultValue.number();
		codEmployeeSnapshot = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codOwnerRefSnapshot = DefaultValue.number();
	}
	
	
	
	public static PhonapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhonapInfo.class);
	}
	
	
	
	public static List<PhonapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhonapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 			^ (codOwner 		>>> 32));
		result = result * 31 + (int) (codSnapshot		^ (codSnapshot 		>>> 32));
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
		
		
		if (!(o instanceof PhonapInfo))
			return false;
		
		
		PhonapInfo obj = (PhonapInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codSnapshot		== obj.codSnapshot 		&& 
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
