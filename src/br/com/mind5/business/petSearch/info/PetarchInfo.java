package br.com.mind5.business.petSearch.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PetarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPet;
	public long codUser;
	public long codCustomer;
	public long codStore;
	public String petName;
	public LocalDate petBirthDate;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public PetarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPet = DefaultValue.number();
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		isDefault = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static PetarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PetarchInfo.class);
	}
	
	
	
	public static List<PetarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PetarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  	^ (codOwner 	>>> 32));
		result = result * 31 + (int) (codPet 		^ (codPet 		>>> 32));
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		
		if (petName != null)
			result = result * 31 + petName.hashCode();
		
		if (petBirthDate != null)
			result = result * 31 + petBirthDate.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PetarchInfo))
			return false;
		
		
		PetarchInfo obj = (PetarchInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPet 		== obj.codPet		&&
				codCustomer == obj.codCustomer	&&
				codSnapshot == obj.codSnapshot	&&
				super.isStringEqual(petName, obj.petName)			&&
				super.isDateEqual(petBirthDate, obj.petBirthDate)		);
	}
}
