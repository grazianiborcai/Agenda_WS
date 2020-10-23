package br.com.mind5.security.userSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public final class UserapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codSnapshot;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public long codPerson;
	public long codPersonSnapshot;
	public PersonapInfo personData;
	public List<AddresnapInfo> addresses;
	public List<PhonapInfo> phones;
	public List<AuthgroleInfo> authgroles;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	
	
	public UserapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		personData = DefaultValue.object();
		authgroles = DefaultValue.list();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();	
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static UserapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UserapInfo.class);
	}
	
	
	
	public static List<UserapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UserapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		UserapInfo deepCopy = (UserapInfo) super.clone();
		
		deepCopy.addresses = CloneUtil.cloneRecords(deepCopy.addresses, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(deepCopy.phones, this.getClass());
		deepCopy.personData = CloneUtil.cloneRecord(deepCopy.personData, this.getClass());
		deepCopy.authgroles = CloneUtil.cloneRecords(deepCopy.authgroles, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  	^ (codOwner 	>>> 32));
		result = result * 31 + (int) (codUser 		^ (codUser 		>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UserapInfo))
			return false;
		
		
		UserapInfo obj = (UserapInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codUser 	== obj.codUser		&&
				codSnapshot == obj.codSnapshot	&&
				super.isStringEqual(username, obj.username)	);
	}
}
