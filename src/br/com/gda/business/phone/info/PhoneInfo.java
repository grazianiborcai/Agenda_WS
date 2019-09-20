package br.com.gda.business.phone.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PhoneInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPhone;
	public long codSnapshot;
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codStore;
	public long codStoreSnapshot;
	public long codEmployee;
	public long codEmployeeSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public long codOwnerRef;
	public long codOwnerRefSnapshot;
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
	public boolean isDeleted;
	public String username;
	
	
	public PhoneInfo() {
		super(PhoneInfo.class);
		
		codOwner = DefaultValue.number();
		codPhone = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codStoreSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codEmployeeSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		codCountryPhone = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
		codOwnerRefSnapshot = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
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
		
		result = result * 31 + (int) (codOwner 			^ (codOwner 		>>> 32));
		result = result * 31 + (int) (codPhone 			^ (codPhone 		>>> 32));		
		result = result * 31 + (int) (codCustomer 		^ (codCustomer 		>>> 32));
		result = result * 31 + (int) (codStore 			^ (codStore 		>>> 32));
		result = result * 31 + (int) (codEmployee 		^ (codEmployee 		>>> 32));		
		result = result * 31 + (int) (codUser 			^ (codUser 			>>> 32));
		result = result * 31 + (int) (codOwnerRef		^ (codOwnerRef 		>>> 32));
		result = result * 31 + codCountryPhone;
		
		if (fullNumber != null)
			result = result * 31 + fullNumber.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhoneInfo))
			return false;
		
		
		PhoneInfo obj = (PhoneInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codPhone 		== obj.codPhone			&&	
				codCustomer 	== obj.codCustomer 		&&
				codStore		== obj.codStore			&&
				codEmployee		== obj.codEmployee		&&
				codCountryPhone == obj.codCountryPhone	&&
				codUser 		== obj.codUser 			&&
				codOwnerRef 	== obj.codOwnerRef 		&& 
				super.isStringEqual(fullNumber, obj.fullNumber));
	}	
}
