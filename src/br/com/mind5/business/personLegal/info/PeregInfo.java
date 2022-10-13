package br.com.mind5.business.personLegal.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PeregInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codLegalPerson;
	public long codStore;
	public long codPerson;
	public AddressInfo addressData;
	public PhoneInfo phoneData;
	public PersonInfo personData;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public PeregInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codLegalPerson = DefaultValue.number();
		codStore = DefaultValue.number();
		codPerson = DefaultValue.number();
		addressData = DefaultValue.object();
		phoneData = DefaultValue.object();
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
		personData = DefaultValue.object();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static PeregInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PeregInfo.class);
	}
	
	
	
	public static List<PeregInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PeregInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PeregInfo deepCopy = (PeregInfo) super.clone();
		
		deepCopy.phoneData    = CloneUtil.cloneRecord(deepCopy.phoneData   , this.getClass());
		deepCopy.personData   = CloneUtil.cloneRecord(deepCopy.personData  , this.getClass());
		deepCopy.addressData = CloneUtil.cloneRecord(deepCopy.addressData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner       ^ (codOwner    	>>> 32));
		result = result * 31 + (int) (codLegalPerson ^ (codLegalPerson 	>>> 32));
		result = result * 31 + (int) (codStore 	     ^ (codStore 	 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PeregInfo))
			return false;
		
		
		PeregInfo obj = (PeregInfo) o;		
		return (codOwner       == obj.codOwner 			&& 
				codLegalPerson == obj.codLegalPerson	&&
				codStore       == obj.codStore			);
	}
}
