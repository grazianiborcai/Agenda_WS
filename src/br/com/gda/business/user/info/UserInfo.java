package br.com.gda.business.user.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class UserInfo extends InfoRecord implements Cloneable {
	public long codOwner;
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
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	
	
	public UserInfo() {
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codPerson = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codGender = DefaultValue.gender();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
	}
	
	
	
	public static UserInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UserInfo.class);
	}
	
	
	
	public static List<UserInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UserInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		UserInfo deepCopy = (UserInfo) super.clone();
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		
		return deepCopy;
	}
	
	
	
	private List<AddressInfo> cloneAddresses(List<AddressInfo> addressesToClone) throws CloneNotSupportedException {
		if (addressesToClone == null)
			return null;
		
		List<AddressInfo> deepAddresses = new ArrayList<>();
		
		for (AddressInfo eachAddress : addressesToClone) {
			AddressInfo clonedAddress = (AddressInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhoneInfo> clonePhones(List<PhoneInfo> phonesToClone) throws CloneNotSupportedException {
		if (phonesToClone == null)
			return null;
		
		List<PhoneInfo> deepPhones = new ArrayList<>();
		
		for (PhoneInfo eachPhone : phonesToClone) {
			PhoneInfo clonedPhone = (PhoneInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UserInfo))
			return false;
		
		
		UserInfo obj = (UserInfo) o;		
		return (codOwner == obj.codOwner && codUser == obj.codUser);
	}
}
