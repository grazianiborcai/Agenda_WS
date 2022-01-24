package br.com.mind5.business.person.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PersonInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPerson;
	public long codStore;
	public long codSnapshot;
	public String cpf;
	public String name;
	public String nameDisplay;
	public String nameSearch;
	public int codGender;
	public String txtGender;
	public String codEntityCateg;
	public LocalDate birthDate;
	public int birthYear;
	public int birthMonth;
	public int birthDay;
	public String email;
	public List<PerbioInfo> perbios;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;	
	public String username;
	
	
	public PersonInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codStore = DefaultValue.number();
		codGender = DefaultValue.gender();	
		birthYear = DefaultValue.number();
		birthMonth = DefaultValue.number();
		birthDay = DefaultValue.number();
		perbios = DefaultValue.list();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static PersonInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersonInfo.class);
	}
	
	
	
	public static List<PersonInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersonInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PersonInfo deepCopy = (PersonInfo) super.clone();
		
		deepCopy.perbios = CloneUtil.cloneRecords(deepCopy.perbios, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codPerson ^ (codPerson >>> 32));
		result = result * 31 + (int) (codGender ^ (codGender >>> 32));
		
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
		
		
		if (!(o instanceof PersonInfo))
			return false;
		
		
		PersonInfo obj = (PersonInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson	&&
				codGender 	== obj.codGender	&&
				super.isStringEqual(cpf, obj.cpf)						&&
				super.isStringEqual(name, obj.name)						&&
				super.isStringEqual(codEntityCateg, obj.codEntityCateg)	&&
				super.isDateEqual(birthDate, obj.birthDate)					);
	}
}
