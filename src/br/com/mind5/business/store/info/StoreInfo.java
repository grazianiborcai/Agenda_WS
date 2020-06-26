package br.com.mind5.business.store.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.CloneUtil;
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
	public long codAddress;
	public String codCurr;
	public String txtCurr;
	public String codTimezone;
	public String txtTimezone;
	public AddressInfo addressData;
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
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codPerson = DefaultValue.number();
		codCompany = DefaultValue.number();
		codAddress = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		userData = DefaultValue.object();
		companyData = DefaultValue.object();
		personData = DefaultValue.object();
		addressData = DefaultValue.object();
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
		
		deepCopy.fimistes = CloneUtil.cloneRecords(deepCopy.fimistes, this.getClass());
		deepCopy.addressData = CloneUtil.cloneRecord(deepCopy.addressData, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(deepCopy.phones, this.getClass());
		deepCopy.personData = CloneUtil.cloneRecord(deepCopy.personData, this.getClass());
		deepCopy.companyData = CloneUtil.cloneRecord(deepCopy.companyData, this.getClass());
		deepCopy.userData = CloneUtil.cloneRecord(deepCopy.userData, this.getClass());
		
		return deepCopy;
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
