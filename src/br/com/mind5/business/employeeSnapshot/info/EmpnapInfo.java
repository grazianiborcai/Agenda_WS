package br.com.mind5.business.employeeSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmpnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codStore;
	public long codSnapshot;
	public long codPerson;
	public long codPersonSnapshot;
	public long codUser;
	public boolean isLocked;
	public long codUserSnapshot;
	public String codEntityCateg;
	public char codUserCategory;
	public String codAuthGroup;	
	public PersonapInfo personapData;
	public List<AddresnapInfo> addresnaps;
	public List<PhonapInfo> phonaps;
	public String recordMode;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public EmpnapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		isLocked = DefaultValue.boole();
		codUserSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		recordMode = DefaultValue.recordMode();
		personapData = DefaultValue.object();
		addresnaps = DefaultValue.list();
		phonaps = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static EmpnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpnapInfo.class);
	}
	
	
	
	public static List<EmpnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmpnapInfo deepCopy = (EmpnapInfo) super.clone(); 
		
		deepCopy.addresnaps = CloneUtil.cloneRecords(deepCopy.addresnaps, this.getClass());
		deepCopy.phonaps = CloneUtil.cloneRecords(deepCopy.phonaps, this.getClass());
		deepCopy.personapData = CloneUtil.cloneRecord(deepCopy.personapData, this.getClass());

		return deepCopy;	
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpnapInfo))
			return false;
		
		
		EmpnapInfo obj = (EmpnapInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codEmployee == obj.codEmployee	&&
				codSnapshot == obj.codSnapshot		);
	}
}
