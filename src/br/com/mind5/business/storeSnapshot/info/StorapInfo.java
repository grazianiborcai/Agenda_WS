package br.com.mind5.business.storeSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.user.info.UserInfo;

public final class StorapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codSnapshot;	
	public long codUser;
	public long codUserSnapshot;
	public long codPerson;
	public long codPersonSnapshot;
	public long codCompany;
	public long codCompanySnapshot;	
	public long codAddress;
	public long codAddressSnapshot;	
	public String codCurr;
	public String txtCurr;
	public String codTimezone;
	public String txtTimezone;
	public AddressInfo addressData;
	public List<PhoneInfo> phones;
	public UserInfo userData;
	public CompInfo companyData;
	public PersonInfo personData;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	public StorapInfo() {
		super(StorapInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		codCompany = DefaultValue.number();
		codCompanySnapshot = DefaultValue.number();		
		codAddress = DefaultValue.number();
		codAddressSnapshot = DefaultValue.number();		
		recordMode = DefaultValue.recordMode();
		userData = DefaultValue.object();
		companyData = DefaultValue.object();
		personData = DefaultValue.object();
		addressData = DefaultValue.object();
		phones = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static StorapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorapInfo.class);
	}
	
	
	
	public static List<StorapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StorapInfo deepCopy = (StorapInfo) super.clone();
		
		deepCopy.addressData = CloneUtil.cloneRecord(deepCopy.addressData, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(deepCopy.phones, this.getClass());
		deepCopy.personData = CloneUtil.cloneRecord(deepCopy.personData, this.getClass());
		deepCopy.companyData = CloneUtil.cloneRecord(deepCopy.companyData, this.getClass());
		deepCopy.userData = CloneUtil.cloneRecord(deepCopy.userData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorapInfo))
			return false;
		
		
		StorapInfo obj = (StorapInfo) o;		
		return (codOwner 	== obj.codOwner && 
				codStore 	== obj.codStore &&
				codSnapshot == obj.codSnapshot);
	}
}
