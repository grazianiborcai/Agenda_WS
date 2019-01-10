package br.com.gda.business.owner.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OwnerInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String codEntityCateg;
	public LocalDateTime lastChanged;
	public String codLanguage;
	public String recordMode;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public UserInfo userData;
	public PersonInfo personData;
	
	
	
	public OwnerInfo() {
		codOwner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		recordMode = DefaultValue.recordMode();		
		userData = DefaultValue.object();
		personData = DefaultValue.object();
	}
	
	
	
	public static OwnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnerInfo.class);
	}
	
	
	
	public static List<OwnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnerInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
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
