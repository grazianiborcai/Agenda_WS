package br.com.mind5.security.userSnapshot.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

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
	public List<AuthGrRoleInfo> authGrRoles;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	
	
	public UserapInfo() {
		super(UserapInfo.class);
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		personData = DefaultValue.object();
		authGrRoles = DefaultValue.list();
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
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.authGrRoles = cloneAuthGrRoles(deepCopy.authGrRoles);
		
		return deepCopy;
	}
	
	
	
	private List<AddresnapInfo> cloneAddresses(List<AddresnapInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<AddresnapInfo> deepAddresses = new ArrayList<>();
		
		for (AddresnapInfo eachAddress : recordInfos) {
			AddresnapInfo clonedAddress = (AddresnapInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhonapInfo> clonePhones(List<PhonapInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<PhonapInfo> deepPhones = new ArrayList<>();
		
		for (PhonapInfo eachPhone : recordInfos) {
			PhonapInfo clonedPhone = (PhonapInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	private PersonapInfo clonePerson(PersonapInfo recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		return (PersonapInfo) recordInfos.clone();
	}
	
	
	
	private List<AuthGrRoleInfo> cloneAuthGrRoles(List<AuthGrRoleInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<AuthGrRoleInfo> deepAuthGrRoles = new ArrayList<>();
		
		for (AuthGrRoleInfo eachAuthGrRole : recordInfos) {
			AuthGrRoleInfo clonedAuthGrRole = (AuthGrRoleInfo) eachAuthGrRole.clone();
			deepAuthGrRoles.add(clonedAuthGrRole);
		}
		
		return deepAuthGrRoles;
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
		return (codOwner == obj.codOwner 		&& 
				codUser == obj.codUser			&&
				codSnapshot == obj.codSnapshot	&&
				super.isStringEqual(username, obj.username)	);
	}
}
