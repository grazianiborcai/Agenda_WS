package br.com.gda.security.userSnapshot.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class UserapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codSnapshot;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public long codPerson;
	public long codPersonSnapshot;
	public long codCustomer;				//TODO: remover ?
	public PersonapInfo personData;
	public List<AddresnapInfo> addresses;
	public List<PhonapInfo> phones;
	public List<AuthGrRoleInfo> authGrRoles;
	public String codLanguage;
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
		codCustomer = DefaultValue.number();
		personData = DefaultValue.object();
		authGrRoles = DefaultValue.list();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		codLanguage = DefaultValue.language();		
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
	
	
	
	private List<AddresnapInfo> cloneAddresses(List<AddresnapInfo> addressesToClone) throws CloneNotSupportedException {
		if (addressesToClone == null)
			return null;
		
		List<AddresnapInfo> deepAddresses = new ArrayList<>();
		
		for (AddresnapInfo eachAddress : addressesToClone) {
			AddresnapInfo clonedAddress = (AddresnapInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhonapInfo> clonePhones(List<PhonapInfo> phonesToClone) throws CloneNotSupportedException {
		if (phonesToClone == null)
			return null;
		
		List<PhonapInfo> deepPhones = new ArrayList<>();
		
		for (PhonapInfo eachPhone : phonesToClone) {
			PhonapInfo clonedPhone = (PhonapInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	private PersonapInfo clonePerson(PersonapInfo personToClone) throws CloneNotSupportedException {
		if (personToClone == null)
			return null;
		
		return (PersonapInfo) personToClone.clone();
	}
	
	
	
	private List<AuthGrRoleInfo> cloneAuthGrRoles(List<AuthGrRoleInfo> authGrRolesToClone) throws CloneNotSupportedException {
		if (authGrRolesToClone == null)
			return null;
		
		List<AuthGrRoleInfo> deepAuthGrRoles = new ArrayList<>();
		
		for (AuthGrRoleInfo eachAuthGrRole : authGrRolesToClone) {
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
