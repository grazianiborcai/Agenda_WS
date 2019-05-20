package br.com.gda.business.userSnapshot_.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class UserSnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codUser;
	public long codPerson;
	public long codCustomer;
	public String cpf;
	public String name;
	public String codEntityCateg;
	public int codGender;
	public String txtGender;
	public LocalDate birthDate;
	public String email;
	public List<AddresnapInfo> addresses;
	public List<PhonapInfo> phones;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	
	
	public UserSnapInfo() {
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codPerson = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codGender = DefaultValue.gender();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
	}
	
	
	
	public static UserSnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UserSnapInfo.class);
	}
	
	
	
	public static List<UserSnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UserSnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		UserSnapInfo deepCopy = (UserSnapInfo) super.clone();
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		
		return deepCopy;
	}
	
	
	
	private List<AddresnapInfo> cloneAddresses(List<AddresnapInfo> addresses) throws CloneNotSupportedException {
		if (addresses == null)
			return null;
		
		List<AddresnapInfo> deepAddresses = new ArrayList<>();
		
		for (AddresnapInfo eachAddress : addresses) {
			AddresnapInfo clonedAddress = (AddresnapInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhonapInfo> clonePhones(List<PhonapInfo> phones) throws CloneNotSupportedException {
		if (phones == null)
			return null;
		
		List<PhonapInfo> deepPhones = new ArrayList<>();
		
		for (PhonapInfo eachPhone : phones) {
			PhonapInfo clonedPhone = (PhonapInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner     	^ (codOwner    >>> 32));
		result = result * 31 + (int) (codSnapshot	^ (codSnapshot >>> 32));
		result = result * 31 + (int) (codUser 	   	^ (codUser 	   >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UserSnapInfo))
			return false;
		
		
		UserSnapInfo obj = (UserSnapInfo) o;		
		return (codOwner 	== obj.codOwner 	&&
				codSnapshot	== obj.codSnapshot 	&&
				codUser 	== obj.codUser);
	}
}
