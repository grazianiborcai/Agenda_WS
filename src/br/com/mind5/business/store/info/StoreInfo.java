package br.com.mind5.business.store.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.user.info.UserInfo;

public final class StoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codSnapshot;	
	public long codUser;
	public long codPerson;
	public long codCompany;
	public String codCurr;
	public String txtCurr;
	public String codTimezone;
	public String txtTimezone;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public List<FimistInfo> fimistes;
	public UserInfo userData;
	public CompInfo companyData;
	public PersonInfo personData;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	public StoreInfo() {
		super(StoreInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codPerson = DefaultValue.number();
		codCompany = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		userData = DefaultValue.object();
		companyData = DefaultValue.object();
		personData = DefaultValue.object();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		fimistes = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static StoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreInfo.class);
	}
	
	
	
	public static List<StoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StoreInfo deepCopy = (StoreInfo) super.clone();
		
		deepCopy.fimistes = cloneFimistes(deepCopy.fimistes);
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.companyData = cloneCompany(deepCopy.companyData);
		deepCopy.userData = cloneUser(deepCopy.userData);
		
		return deepCopy;
	}
	
	
	
	private List<FimistInfo> cloneFimistes(List<FimistInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<FimistInfo> results = new ArrayList<>();
		
		for (FimistInfo eachRecord : recordInfos) {
			FimistInfo eachResult = (FimistInfo) eachRecord.clone();
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	private List<AddressInfo> cloneAddresses(List<AddressInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<AddressInfo> results = new ArrayList<>();
		
		for (AddressInfo eachRecord : recordInfos) {
			AddressInfo eachResult = (AddressInfo) eachRecord.clone();
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	private List<PhoneInfo> clonePhones(List<PhoneInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<PhoneInfo> results = new ArrayList<>();
		
		for (PhoneInfo eachRecord : recordInfos) {
			PhoneInfo eachResult = (PhoneInfo) eachRecord.clone();
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	private PersonInfo clonePerson(PersonInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PersonInfo) recordInfo.clone();
	}
	
	
	
	private CompInfo cloneCompany(CompInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CompInfo) recordInfo.clone();
	}
	
	
	
	private UserInfo cloneUser(UserInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (UserInfo) recordInfo.clone();
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
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore);
	}
}
