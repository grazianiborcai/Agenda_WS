package br.com.gda.payPartner.moip.moipMasterData.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class AddressInfo extends InfoRecord implements Cloneable {
	public String street;
	public String streetNumber;
	
	public String complement;
	public String district;
	public String city;
	public String state;
	public String country;
	public String zipcode;
	
	
	
	public static AddressInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AddressInfo.class);
	}
	
	
	
	public static List<AddressInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AddressInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AddressInfo))
			return false;
		
		
		AddressInfo obj = (AddressInfo) o;
		return (isStringEqual(obj.street		, this.street) 			&&
				isStringEqual(obj.streetNumber	, this.streetNumber)	&&
				isStringEqual(obj.complement	, this.complement)		&&
				isStringEqual(obj.district		, this.district)		&&
				isStringEqual(obj.city			, this.city)			&&
				isStringEqual(obj.state			, this.state)			&&
				isStringEqual(obj.country		, this.country)			&&
				isStringEqual(obj.zipcode		, this.zipcode) 			);
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (street != null)
			result = result * 31 + street.hashCode();
		
		if (streetNumber != null)
			result = result * 31 + streetNumber.hashCode();
		
		if (complement != null)
			result = result * 31 + complement.hashCode();
		
		if (district != null)
			result = result * 31 + district.hashCode();
		
		if (city != null)
			result = result * 31 + city.hashCode();
		
		if (state != null)
			result = result * 31 + state.hashCode();
		
		if (country != null)
			result = result * 31 + country.hashCode();
		
		if (zipcode != null)
			result = result * 31 + zipcode.hashCode();
		
		return result;
	}
}
