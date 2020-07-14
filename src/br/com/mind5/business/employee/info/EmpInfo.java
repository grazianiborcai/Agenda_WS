package br.com.mind5.business.employee.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class EmpInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codSnapshot;
	public long codStore;	
	public long codPerson;	
	public long codUser;
	public PersonInfo personData;
	public PersonInfo personDataUser;
	public FimistInfo fimistData;
	public FimistInfo fimistDataUser;
	public List<AddressInfo> addresses;
	public List<AddressInfo> addressesUser;
	public List<PhoneInfo> phones;
	public List<PhoneInfo> phonesUser;	
	public String recordMode;
	public String username;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	
	
	public EmpInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		personDataUser = DefaultValue.object();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		personData = DefaultValue.object();
		fimistData = DefaultValue.object();
		fimistDataUser = DefaultValue.object();
		addresses = DefaultValue.list();
		addressesUser = DefaultValue.list();
		phones = DefaultValue.list();
		phonesUser = DefaultValue.list();
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
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codPerson   ^ (codPerson   >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpInfo))
			return false;
		
		
		EmpInfo obj = (EmpInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codEmployee == obj.codEmployee &&
				codPerson   == obj.codPerson		);
	}
}
