package br.com.mind5.business.storeTextDefault.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StorextaultInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public StorextaultInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		isDefault = DefaultValue.boole();
	}
	
	
	
	public static StorextaultInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorextaultInfo.class);
	}
	
	
	
	public static List<StorextaultInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorextaultInfo.class);
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
		
		
		if (!(o instanceof StorextaultInfo))
			return false;
		
		
		StorextaultInfo obj = (StorextaultInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codStore   == obj.codStore		&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
