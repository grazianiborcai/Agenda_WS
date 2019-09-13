package br.com.gda.business.customer.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.security.user.info.UserInfo;

public final class CusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codSnapshot;
	public long codPerson;
	public long codUser;
	public String codEntityCateg;
	public char codUserCategory;
	public String codAuthGroup;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public UserInfo userData;
	public PersonInfo personData;
	public String username;
	
	
	public CusInfo() {
		super(CusInfo.class);
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		codUserCategory = DefaultValue.character();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
		userData = DefaultValue.object();
		personData = DefaultValue.object();
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
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.userData = cloneUser(deepCopy.userData);
		
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
	
	
	
	private List<PhoneInfo> clonePhones(List<PhoneInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<PhoneInfo> deepPhones = new ArrayList<>();
		
		for (PhoneInfo eachPhone : recordInfos) {
			PhoneInfo clonedPhone = (PhoneInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	private PersonInfo clonePerson(PersonInfo recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		return (PersonInfo) recordInfos.clone();
	}
	
	
	
	private UserInfo cloneUser(UserInfo recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		return (UserInfo) recordInfos.clone();
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
		return (codOwner    == obj.codOwner && 
				codCustomer == obj.codCustomer);
	}
}
