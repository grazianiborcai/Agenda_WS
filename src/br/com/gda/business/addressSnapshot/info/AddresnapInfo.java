package br.com.gda.business.addressSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class AddresnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codAddress;
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
	public String codCountryAlpha3;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;
	public String district;
	public String street;
	public String streetNumber;
	public String complement;
	public String postalCode;
	public float longitude;
	public float latitude;
	public String line1;
	public String line2;
	public String line3;
	public String line4;
	public String line5;
	public String line6;
	public String line7;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String codForm;
	public boolean isDeleted;
	public String username;
	
	
	public AddresnapInfo() {
		super(AddresnapInfo.class);
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codAddress = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codStoreSnapshot = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codEmployeeSnapshot = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
		codOwnerRefSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		longitude = DefaultValue.number();
		latitude = DefaultValue.number();		
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
		isDeleted = DefaultValue.boole();
	}
	
	
	
	public static AddresnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AddresnapInfo.class);
	}
	
	
	
	public static List<AddresnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AddresnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	 	^ (codOwner   	>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot  >>> 32));
		result = result * 31 + (int) (codAddress 	^ (codAddress 	>>> 32));		
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 	>>> 32));
		
		if (codCountry != null)
			result = result * 31 + codCountry.hashCode();
		
		if (codState != null)
			result = result * 31 + codState.hashCode();
		
		if (city != null)
			result = result * 31 + city.hashCode();
		
		if (district != null)
			result = result * 31 + district.hashCode();
		
		if (street != null)
			result = result * 31 + street.hashCode();
		
		if (streetNumber != null)
			result = result * 31 + streetNumber.hashCode();		
		
		if (complement != null)
			result = result * 31 + complement.hashCode();	
		
		if (postalCode != null)
			result = result * 31 + postalCode.hashCode();	
		
		if (line1 != null)
			result = result * 31 + line1.hashCode();	
		
		if (line2 != null)
			result = result * 31 + line2.hashCode();
		
		if (line3 != null)
			result = result * 31 + line3.hashCode();
		
		if (line4 != null)
			result = result * 31 + line4.hashCode();
		
		if (line5 != null)
			result = result * 31 + line5.hashCode();
		
		if (line6 != null)
			result = result * 31 + line6.hashCode();
		
		if (line7 != null)
			result = result * 31 + line7.hashCode();
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AddresnapInfo))
			return false;
		
		
		AddresnapInfo obj = (AddresnapInfo) o;		
		return (codOwner 	== obj.codOwner 						&& 
				codSnapshot == obj.codSnapshot 						&& 
				codAddress 	== obj.codAddress						&&
				codCustomer	== obj.codCustomer						&&
				codStore	== obj.codStore							&&
				codEmployee	== obj.codEmployee						&&
				super.isStringEqual(codCountry, obj.codCountry)		&&				
				super.isStringEqual(codState, obj.codState)			&&
				super.isStringEqual(city, obj.city)					&&
				super.isStringEqual(district, obj.district)			&&
				super.isStringEqual(street, obj.street)				&&
				super.isStringEqual(streetNumber, obj.streetNumber)	&&
				super.isStringEqual(complement, obj.complement)		&&
				super.isStringEqual(postalCode, obj.postalCode)		&&
				super.isStringEqual(line1, obj.line1)				&&
				super.isStringEqual(line2, obj.line2)				&&
				super.isStringEqual(line3, obj.line3)				&&
				super.isStringEqual(line4, obj.line4)				&&
				super.isStringEqual(line5, obj.line5)				&&
				super.isStringEqual(line6, obj.line6)				&&
				super.isStringEqual(line7, obj.line7)						);
	}	
}
