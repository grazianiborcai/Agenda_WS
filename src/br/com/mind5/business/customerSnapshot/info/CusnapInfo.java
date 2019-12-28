package br.com.mind5.business.customerSnapshot.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.user.info.UserInfo;

public final class CusnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codSnapshot;
	public long codPerson;
	public long codPersonSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public String recordMode;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public UserInfo userData;
	public PersonInfo personData;
	public String username;
	
	
	public CusnapInfo() {
		super(CusnapInfo.class);
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		createdBy = DefaultValue.character();
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
		userData = DefaultValue.object();
		personData = DefaultValue.object();
	}
	
	
	
	public static CusnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusnapInfo.class);
	}
	
	
	
	public static List<CusnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusnapInfo deepCopy = (CusnapInfo) super.clone();
		
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
		
		
		if (!(o instanceof CusnapInfo))
			return false;
		
		
		CusnapInfo obj = (CusnapInfo) o;		
		return (codOwner    == obj.codOwner && 
				codCustomer == obj.codCustomer);
	}
}
