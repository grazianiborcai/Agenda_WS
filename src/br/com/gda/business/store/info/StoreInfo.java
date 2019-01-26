package br.com.gda.business.store.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class StoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codPerson;
	public long codCompany;
	public String codEntityCateg;
	public String codCurr;
	public String txtCurr;
	public String codTimezone;
	public String txtTimezone;
	public String codLanguage;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public UserInfo userData;
	public CompInfo companyData;
	public PersonInfo personData;
	public LocalDateTime lastChanged;
	public String recordMode;

	
	
	public StoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPerson = DefaultValue.number();
		codCompany = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = RecordMode.RECORD_OK;
		userData = DefaultValue.object();
		companyData = DefaultValue.object();
		personData = DefaultValue.object();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
	}
	
	
	
	public static StoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreInfo.class);
	}
	
	
	
	public static List<StoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StoreInfo deepCopy = (StoreInfo) super.clone();
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.companyData = cloneCompany(deepCopy.companyData);
		
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
	
	
	
	private CompInfo cloneCompany(CompInfo companyToClone) throws CloneNotSupportedException {
		if (companyToClone == null)
			return null;
		
		return (CompInfo) companyToClone.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoreInfo))
			return false;
		
		
		StoreInfo obj = (StoreInfo) o;		
		return (codOwner == obj.codOwner && codStore == obj.codStore);
	}
}
