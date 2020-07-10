package br.com.mind5.business.customer.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class CusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codSnapshot;
	public long codStore;
	public long codPerson;
	public long codUser;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	public List<AddressInfo> addresses;
	public List<AddressInfo> addressesUser;
	public List<PhoneInfo> phones;
	public List<PhoneInfo> phonesUser;
	public PersonInfo personData;
	public PersonInfo personDataUser;
	public FimistInfo fimistData;
	public FimistInfo fimistDataUser;
	
	
	public CusInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		addresses = DefaultValue.list();
		addressesUser = DefaultValue.list();
		phones = DefaultValue.list();
		phonesUser = DefaultValue.list();
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
		personData = DefaultValue.object();
		personDataUser = DefaultValue.object();
		fimistData = DefaultValue.object();
		fimistDataUser = DefaultValue.object();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static CusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusInfo.class);
	}
	
	
	
	public static List<CusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusInfo deepCopy = (CusInfo) super.clone();
		
		deepCopy.addresses = CloneUtil.cloneRecords(deepCopy.addresses, this.getClass());
		deepCopy.addressesUser = CloneUtil.cloneRecords(deepCopy.addressesUser, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(deepCopy.phones, this.getClass());
		deepCopy.phonesUser = CloneUtil.cloneRecords(deepCopy.phonesUser, this.getClass());
		deepCopy.personData = CloneUtil.cloneRecord(deepCopy.personData, this.getClass());
		deepCopy.personDataUser = CloneUtil.cloneRecord(deepCopy.personDataUser, this.getClass());
		deepCopy.fimistData = CloneUtil.cloneRecord(deepCopy.fimistData, this.getClass());
		deepCopy.fimistDataUser = CloneUtil.cloneRecord(deepCopy.fimistDataUser, this.getClass());
		
		return deepCopy;
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
