package br.com.gda.business.owner.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.security.user.info.UserInfo;

public final class OwnerInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public long codCompany;
	public long codUser;
	public String codEntityCateg;
	public char codUserCategory;
	public String codAuthGroup;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public UserInfo userData;
	public CompInfo companyData;
	public PersonInfo personData;
	public List<OwntoreInfo> owntores;
	
	
	
	public OwnerInfo() {
		super(OwnerInfo.class);
		
		codOwner = DefaultValue.number();
		codPerson = DefaultValue.number();
		codCompany = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();		
		userData = DefaultValue.object();
		companyData = DefaultValue.object();
		personData = DefaultValue.object();
		owntores = DefaultValue.list();
	}
	
	
	
	public static OwnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnerInfo.class);
	}
	
	
	
	public static List<OwnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnerInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OwnerInfo deepCopy = (OwnerInfo) super.clone();
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.companyData = cloneCompany(deepCopy.companyData);
		deepCopy.userData = cloneUser(deepCopy.userData);
		deepCopy.owntores = cloneOwntores(deepCopy.owntores);
		
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
	
	
	
	private CompInfo cloneCompany(CompInfo compToClone) throws CloneNotSupportedException {
		if (compToClone == null)
			return null;
		
		return (CompInfo) compToClone.clone();
	}
	
	
	
	private UserInfo cloneUser(UserInfo userToClone) throws CloneNotSupportedException {
		if (userToClone == null)
			return null;
		
		return (UserInfo) userToClone.clone();
	}
	
	
	
	private List<OwntoreInfo> cloneOwntores(List<OwntoreInfo> storesToClone) throws CloneNotSupportedException {
		if (storesToClone == null)
			return null;
		
		List<OwntoreInfo> deepStones = new ArrayList<>();
		
		for (OwntoreInfo eachPhone : storesToClone) {
			OwntoreInfo clonedPhone = (OwntoreInfo) eachPhone.clone();
			deepStones.add(clonedPhone);
		}
		
		return deepStones;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OwnerInfo))
			return false;
		
		
		OwnerInfo obj = (OwnerInfo) o;		
		return (codOwner == obj.codOwner);
	}	
}
