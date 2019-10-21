package br.com.mind5.security.user.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class UserInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codSnapshot;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public long codPerson;
	public long codPersonSnapshot;
	public long codCustomer;				//TODO: remover ?
	public PersonInfo personData;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public List<AuthGrRoleInfo> authGrRoles;
	public List<CusparInfo> cuspars;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	
	
	public UserInfo() {
		super(UserInfo.class);
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codPerson = DefaultValue.number();
		codPersonSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		personData = DefaultValue.object();
		authGrRoles = DefaultValue.list();
		cuspars = DefaultValue.list();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();	
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static UserInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UserInfo.class);
	}
	
	
	
	public static List<UserInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UserInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		UserInfo deepCopy = (UserInfo) super.clone();
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.personData = clonePerson(deepCopy.personData);
		deepCopy.authGrRoles = cloneAuthGrRoles(deepCopy.authGrRoles);
		
		return deepCopy;
	}
	
	
	
	private List<AddressInfo> cloneAddresses(List<AddressInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<AddressInfo> deepAddresses = new ArrayList<>();
		
		for (AddressInfo eachAddress : recordInfos) {
			AddressInfo clonedAddress = (AddressInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhoneInfo> clonePhones(List<PhoneInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<PhoneInfo> deepPhones = new ArrayList<>();
		
		for (PhoneInfo eachPhone : recordInfos) {
			PhoneInfo clonedPhone = (PhoneInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	private PersonInfo clonePerson(PersonInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PersonInfo) recordInfo.clone();
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
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	>>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UserInfo))
			return false;
		
		
		UserInfo obj = (UserInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser  == obj.codUser		&&
				super.isStringEqual(username, obj.username)	);
	}
}
