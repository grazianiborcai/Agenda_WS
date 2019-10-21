package br.com.mind5.business.personCustomer.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PersonCusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public long codCustomer;
	public String codEntityCateg;
	public String cpf;
	public String email;
	public String recordMode;
	
	
	public PersonCusInfo() {
		super(PersonCusInfo.class);
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codPerson = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PersonCusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersonCusInfo.class);
	}
	
	
	
	public static List<PersonCusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersonCusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codPerson ^ (codPerson >>> 32));
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	 >>> 32));
		
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
		
		
		if (!(o instanceof PersonCusInfo))
			return false;
		
		
		PersonCusInfo obj = (PersonCusInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson	&&
				codCustomer 	== obj.codCustomer		&&
				super.isStringEqual(cpf, obj.cpf)						&&
				super.isStringEqual(codEntityCateg, obj.codEntityCateg)	&&
				super.isStringEqual(email, obj.email)						);
	}	
}
