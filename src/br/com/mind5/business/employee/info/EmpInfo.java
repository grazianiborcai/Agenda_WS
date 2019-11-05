package br.com.mind5.business.employee.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.user.info.UserInfo;

public final class EmpInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codSnapshot;
	public long codPerson;
	public long codUser;
	public String codEntityCateg;
	public char codUserCategory;
	public String codAuthGroup;	
	public UserInfo userData;
	public PersonInfo personData;
	public FimistInfo fimistData;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public EmpInfo() {
		super(EmpInfo.class);
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		userData = DefaultValue.object();
		recordMode = DefaultValue.recordMode();
		personData = DefaultValue.object();
		fimistData = DefaultValue.object();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static EmpInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpInfo.class);
	}
	
	
	
	public static List<EmpInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmpInfo deepCopy = (EmpInfo) super.clone(); 
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.userData = cloneUser(deepCopy.userData);
		deepCopy.fimistData = cloneFimist(deepCopy.fimistData);

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
	
	
	
	private FimistInfo cloneFimist(FimistInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (FimistInfo) recordInfo.clone();
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
		
		
		if (!(o instanceof EmpInfo))
			return false;
		
		
		EmpInfo obj = (EmpInfo) o;		
		return (codOwner == obj.codOwner && codEmployee == obj.codEmployee);
	}
}
