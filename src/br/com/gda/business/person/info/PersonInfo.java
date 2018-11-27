package br.com.gda.business.person.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PersonInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public String cpf;
	public String name;
	public int codGender;
	public String txtGender;
	public LocalDate birthDate;
	public String email;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	
	
	public PersonInfo() {
		codOwner = DefaultValue.number();
		codPerson = DefaultValue.number();
		codGender = DefaultValue.gender();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
	}
	
	
	
	public static PersonInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersonInfo.class);
	}
	
	
	
	public static List<PersonInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersonInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codPerson ^ (codPerson >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PersonInfo))
			return false;
		
		
		PersonInfo obj = (PersonInfo) o;		
		return (codOwner == obj.codOwner && codPerson == obj.codPerson);
	}
}
