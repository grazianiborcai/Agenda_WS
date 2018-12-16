package br.com.gda.business.customer.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codPerson;
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
	public UserInfo userData;
	
	
	public CusInfo() {
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codPerson = DefaultValue.number();
		codGender = DefaultValue.gender();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
		userData = DefaultValue.object();
	}
	
	
	
	public static CusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusInfo.class);
	}
	
	
	
	public static List<CusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusInfo deepCopy = (CusInfo) super.clone();
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		
		return deepCopy;
	}
	
	
	
	private List<AddressInfo> cloneAddresses(List<AddressInfo> addresses) throws CloneNotSupportedException {
		if (addresses == null)
			return null;
		
		List<AddressInfo> deepAddresses = new ArrayList<>();
		
		for (AddressInfo eachAddress : addresses) {
			AddressInfo clonedAddress = (AddressInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhoneInfo> clonePhones(List<PhoneInfo> phones) throws CloneNotSupportedException {
		if (phones == null)
			return null;
		
		List<PhoneInfo> deepPhones = new ArrayList<>();
		
		for (PhoneInfo eachPhone : phones) {
			PhoneInfo clonedPhone = (PhoneInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusInfo))
			return false;
		
		
		CusInfo obj = (CusInfo) o;		
		return (codOwner == obj.codOwner && codCustomer == obj.codCustomer);
	}
}
