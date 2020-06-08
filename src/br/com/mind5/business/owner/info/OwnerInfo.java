package br.com.mind5.business.owner.info;

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

public final class OwnerInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPerson;
	public long codCompany;
	public long codUser;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	public String recordMode;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public CompInfo companyData;
	public PersonInfo personData;
	public FimistInfo fimistData;
	
	
	
	public OwnerInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codCompany = DefaultValue.number();
		codUser = DefaultValue.number();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		companyData = DefaultValue.object();
		personData = DefaultValue.object();
		fimistData = DefaultValue.object();
	}
	
	
	
	public static OwnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnerInfo.class);
	}
	
	
	
	public static List<OwnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnerInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OwnerInfo deepCopy = (OwnerInfo) super.clone();
		
		deepCopy.addresses = CloneUtil.cloneRecords(deepCopy.addresses, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(deepCopy.phones, this.getClass());
		deepCopy.personData = CloneUtil.cloneRecord(deepCopy.personData, this.getClass());
		deepCopy.companyData = CloneUtil.cloneRecord(deepCopy.companyData, this.getClass());
		deepCopy.fimistData = CloneUtil.cloneRecord(deepCopy.fimistData, this.getClass());
		
		return deepCopy;
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
