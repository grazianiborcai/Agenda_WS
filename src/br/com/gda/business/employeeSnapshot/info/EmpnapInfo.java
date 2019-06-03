package br.com.gda.business.employeeSnapshot.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class EmpnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codSnapshot;
	public long codPerson;
	public long codPersonSnapshot;
	public long codUser;
	public String codEntityCateg;
	public char codUserCategory;
	public String codAuthGroup;	
	public UserInfo userData;
	public PersonInfo personData;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public EmpnapInfo() {
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		userData = DefaultValue.object();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
		personData = DefaultValue.object();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static EmpnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpnapInfo.class);
	}
	
	
	
	public static List<EmpnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmpnapInfo deepCopy = (EmpnapInfo) super.clone(); 
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.userData = cloneUser(deepCopy.userData);

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
	
	
	
	private PersonInfo clonePerson(PersonInfo personToClone) throws CloneNotSupportedException {
		if (personToClone == null)
			return null;
		
		return (PersonInfo) personToClone.clone();
	}
	
	
	
	private UserInfo cloneUser(UserInfo userToClone) throws CloneNotSupportedException {
		if (userToClone == null)
			return null;
		
		return (UserInfo) userToClone.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpnapInfo))
			return false;
		
		
		EmpnapInfo obj = (EmpnapInfo) o;		
		return (codOwner == obj.codOwner && codEmployee == obj.codEmployee);
	}
}
