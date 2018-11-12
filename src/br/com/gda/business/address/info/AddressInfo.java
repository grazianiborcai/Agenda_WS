package br.com.gda.business.address.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class AddressInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codAddress;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public String codCountry;
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
	public String codForm;
	public boolean isDeleted;
	
	
	
	public AddressInfo() {
		codOwner = DefaultValue.number();
		codAddress = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		longitude = DefaultValue.number();
		latitude = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		isDeleted = DefaultValue.boole();
	}
	
	
	
	public static AddressInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AddressInfo.class);
	}
	
	
	
	public static List<AddressInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AddressInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codAddress ^ (codAddress >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AddressInfo))
			return false;
		
		
		AddressInfo obj = (AddressInfo) o;		
		return (codOwner == obj.codOwner && codAddress == obj.codAddress);
	}	
}
