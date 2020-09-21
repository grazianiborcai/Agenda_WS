package br.com.mind5.business.storeTextSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StorextsnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codStore;
	public String description;
	public boolean isDefault;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public StorextsnapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		isDefault = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static StorextsnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorextsnapInfo.class);
	}
	
	
	
	public static List<StorextsnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorextsnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  	^ (codOwner		>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 		>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorextsnapInfo))
			return false;
		
		
		StorextsnapInfo obj = (StorextsnapInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore   	== obj.codStore		&&
				codSnapshot == obj.codSnapshot	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
