package br.com.mind5.business.personUser_.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.security.user.info.UserInfo;

public final class PersonUserInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public long codUser;
	public String codEntityCateg;
	public String cpf;
	public String email;
	public UserInfo userData;
	public String recordMode;
	
	
	public PersonUserInfo() {
		super(PersonUserInfo.class);
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codPerson = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		userData = DefaultValue.object();
	}
	
	
	
	public static PersonUserInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersonUserInfo.class);
	}
	
	
	
	public static List<PersonUserInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersonUserInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codPerson ^ (codPerson >>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	 >>> 32));
		
		if (cpf != null)
			result = result * 31 + cpf.hashCode();
		
		if (email != null)
			result = result * 31 + email.hashCode();
		
		if (codEntityCateg != null)
			result = result * 31 + codEntityCateg.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PersonUserInfo))
			return false;
		
		
		PersonUserInfo obj = (PersonUserInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson	&&
				codUser 	== obj.codUser		&&
				super.isStringEqual(cpf, obj.cpf)						&&
				super.isStringEqual(codEntityCateg, obj.codEntityCateg)	&&
				super.isStringEqual(email, obj.email)						);
	}	
}
