package br.com.mind5.business.personSearch.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PerarchInfo extends InfoRecord implements Cloneable {
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
	public String email;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public PerarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codStore = DefaultValue.number();
		codGender = DefaultValue.gender();	
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static PerarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PerarchInfo.class);
	}
	
	
	
	public static List<PerarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PerarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
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
		
		
		if (!(o instanceof PerarchInfo))
			return false;
		
		
		PerarchInfo obj = (PerarchInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson	&&
				codGender 	== obj.codGender	&&
				super.isStringEqual(cpf, obj.cpf)						&&
				super.isStringEqual(name, obj.name)						&&
				super.isStringEqual(codEntityCateg, obj.codEntityCateg)	&&
				super.isDateEqual(birthDate, obj.birthDate)					);
	}
}
