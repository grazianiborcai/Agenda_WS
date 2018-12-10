package br.com.gda.business.personSnapshot.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PersonSnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPerson;
	public String cpf;
	public String name;
	public int codGender;
	public String txtGender;
	public String codEntityCateg;
	public LocalDate birthDate;
	public String email;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	
	
	public PersonSnapInfo() {
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codGender = DefaultValue.gender();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
	}
	
	
	
	public static PersonSnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersonSnapInfo.class);
	}
	
	
	
	public static List<PersonSnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersonSnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  	^ (codOwner  	>>> 32));
		result = result * 31 + (int) (codSnapshot   ^ (codSnapshot  >>> 32));
		result = result * 31 + (int) (codPerson 	^ (codPerson 	>>> 32));
		result = result * 31 + (int) (codGender 	^ (codGender 	>>> 32));
		
		if (cpf != null)
			result = result * 31 + cpf.hashCode();
		
		if (name != null)
			result = result * 31 + name.hashCode();
		
		if (codEntityCateg != null)
			result = result * 31 + codEntityCateg.hashCode();
		
		if (birthDate != null)
			result = result * 31 + birthDate.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PersonSnapInfo))
			return false;
		
		
		PersonSnapInfo obj = (PersonSnapInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codSnapshot == obj.codSnapshot 	&& 
				codPerson 	== obj.codPerson	&&
				codGender 	== obj.codGender	&&
				super.isStringEqual(cpf, obj.cpf)						&&
				super.isStringEqual(name, obj.name)						&&
				super.isStringEqual(codEntityCateg, obj.codEntityCateg)	&&
				super.isDateEqual(birthDate, obj.birthDate)					);
	}
}
