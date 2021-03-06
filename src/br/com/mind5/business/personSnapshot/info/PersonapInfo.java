package br.com.mind5.business.personSnapshot.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PersonapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPerson;
	public long codStore;
	public String cpf;
	public String name;
	public String nameSearch;
	public int codGender;
	public String txtGender;
	public String codEntityCateg;
	public LocalDate birthDate;
	public int birthYear;
	public int birthMonth;
	public int birthDay;
	public String email;
	public String recordMode;
	public LocalDateTime lastChanged;
	public LocalDateTime createdOn;
	public long createdBy;	
	public long lastChangedBy;
	public String username;
	
	
	public PersonapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codStore = DefaultValue.number();
		codGender = DefaultValue.gender();
		birthYear = DefaultValue.number();
		birthMonth = DefaultValue.number();
		birthDay = DefaultValue.number();
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static PersonapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersonapInfo.class);
	}
	
	
	
	public static List<PersonapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersonapInfo.class);
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
		
		
		if (!(o instanceof PersonapInfo))
			return false;
		
		
		PersonapInfo obj = (PersonapInfo) o;		
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
