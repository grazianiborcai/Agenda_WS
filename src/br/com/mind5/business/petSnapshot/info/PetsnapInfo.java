package br.com.mind5.business.petSnapshot.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PetsnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPet;
	public long codSnapshot;
	public String petNote;
	public String petName;
	public int codPetype;
	public String txtPetype;
	public int codPeteight;
	public String txtPeteightKg;
	public long codCustomer;
	public LocalDate petBirthDate;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public PetsnapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPet = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codPetype = DefaultValue.number();
		codPeteight = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static PetsnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PetsnapInfo.class);
	}
	
	
	
	public static List<PetsnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PetsnapInfo.class);
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
		
		
		if (!(o instanceof PetsnapInfo))
			return false;
		
		
		PetsnapInfo obj = (PetsnapInfo) o;		
		return (codOwner == obj.codOwner 					&& 
				codPet   == obj.codPet						&&
				super.isStringEqual(petName, obj.petName) 	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
