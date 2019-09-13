package br.com.gda.business.employeeSnapshot.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class EmpnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codSnapshot;
	public long codPerson;
	public long codPersonSnapshot;
	public long codUser;
	public String codEntityCateg;
	public char codUserCategory;
	public String codAuthGroup;	
	public PersonapInfo personapData;
	public List<AddresnapInfo> addresnaps;
	public List<PhonapInfo> phonaps;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public EmpnapInfo() {
		super(EmpnapInfo.class);
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
		personapData = DefaultValue.object();
		addresnaps = DefaultValue.list();
		phonaps = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static EmpnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpnapInfo.class);
	}
	
	
	
	public static List<EmpnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmpnapInfo deepCopy = (EmpnapInfo) super.clone(); 
		
		deepCopy.addresnaps = cloneAddresnaps(deepCopy.addresnaps);
		deepCopy.phonaps = clonePhonaps(deepCopy.phonaps);
		deepCopy.personapData = clonePersonap(deepCopy.personapData);

		return deepCopy;	
	}  
	
	
	
	private List<AddresnapInfo> cloneAddresnaps(List<AddresnapInfo> addressesToClone) throws CloneNotSupportedException {
		if (addressesToClone == null)
			return null;
		
		List<AddresnapInfo> deepAddresses = new ArrayList<>();
		
		for (AddresnapInfo eachAddress : addressesToClone) {
			AddresnapInfo clonedAddress = (AddresnapInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhonapInfo> clonePhonaps(List<PhonapInfo> phonesToClone) throws CloneNotSupportedException {
		if (phonesToClone == null)
			return null;
		
		List<PhonapInfo> deepPhones = new ArrayList<>();
		
		for (PhonapInfo eachPhone : phonesToClone) {
			PhonapInfo clonedPhone = (PhonapInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	private PersonapInfo clonePersonap(PersonapInfo personToClone) throws CloneNotSupportedException {
		if (personToClone == null)
			return null;
		
		return (PersonapInfo) personToClone.clone();
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
