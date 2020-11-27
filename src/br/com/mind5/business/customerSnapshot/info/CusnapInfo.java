package br.com.mind5.business.customerSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.user.info.UserInfo;

public final class CusnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codStore;
	public long codStoreSnapshot;
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
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		codStoreSnapshot = DefaultValue.number();
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
		
		deepCopy.addresses = CloneUtil.cloneRecords(deepCopy.addresses, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(deepCopy.phones, this.getClass());
		deepCopy.personData = CloneUtil.cloneRecord(deepCopy.personData, this.getClass());
		deepCopy.userData = CloneUtil.cloneRecord(deepCopy.userData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusnapInfo))
			return false;
		
		
		CusnapInfo obj = (CusnapInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codCustomer == obj.codCustomer && 
				codSnapshot == obj.codSnapshot		);
	}
}
