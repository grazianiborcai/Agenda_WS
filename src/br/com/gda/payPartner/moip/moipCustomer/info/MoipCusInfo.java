package br.com.gda.payPartner.moip.moipCustomer.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MoipCusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayCustomer;
	public String ownId;
	public String fullName;
	public String email;
	public int phoneCountryCode;
	public int phoneAreaCode;
	public int phoneNumber;
	public String birthDate;
	public String taxDocType;
	public String taxDocNumber;
	public String addressStreet;
	public String addressNumber;
	public String addressComplement;
	public String addressDistrict;
	public String addressCity;
	public String addressState;
	public String addressCountry;
	public String addressZipcode;
	
	
	public MoipCusInfo() {
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		phoneCountryCode = DefaultValue.number();
		phoneAreaCode = DefaultValue.number();
		phoneNumber = DefaultValue.number();
	}
	
	
	
	public static MoipCusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MoipCusInfo.class);
	}
	
	
	
	public static List<MoipCusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MoipCusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MoipCusInfo))
			return false;
		
		
		MoipCusInfo obj = (MoipCusInfo) o;		
		return (ownId.equals(obj.ownId));
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (ownId != null)
			result = result * 31 + ownId.hashCode();
		
		return result;
	}
}
