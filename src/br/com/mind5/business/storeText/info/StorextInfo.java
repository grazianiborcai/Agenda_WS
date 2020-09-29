package br.com.mind5.business.storeText.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StorextInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String description;
	public boolean isDefault;
	public boolean isDeleted;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public StorextInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		isDefault = DefaultValue.boole();
		isDeleted = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static StorextInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorextInfo.class);
	}
	
	
	
	public static List<StorextInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorextInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore 	>>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorextInfo))
			return false;
		
		
		StorextInfo obj = (StorextInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codStore == obj.codStore	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
