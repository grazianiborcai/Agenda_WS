package br.com.mind5.business.petList.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PetlisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPet;
	public long codSnapshot;
	public String petNote;
	public String petName;
	public int codPetype;
	public String txtPetype;
	public int codPeteight;
	public String txtPeteightKg;
	public long codUser;
	public long codCustomer;
	public long codStore;
	public LocalDate petBirthDate;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public PetlisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPet = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		codPetype = DefaultValue.number();
		codPeteight = DefaultValue.number();
		isDefault = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static PetlisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PetlisInfo.class);
	}
	
	
	
	public static List<PetlisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PetlisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codPet 	^ (codPet 	>>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		if (petName != null)
			result = result * 31 + petName.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PetlisInfo))
			return false;
		
		
		PetlisInfo obj = (PetlisInfo) o;		
		return (codOwner == obj.codOwner 					&& 
				codPet   == obj.codPet						&&
				super.isStringEqual(petName, obj.petName) 	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
