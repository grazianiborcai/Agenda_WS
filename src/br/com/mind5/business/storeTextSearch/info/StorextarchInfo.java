package br.com.mind5.business.storeTextSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StorextarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String recordMode;
	public String username;
	
	
	public StorextarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static StorextarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorextarchInfo.class);
	}
	
	
	
	public static List<StorextarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorextarchInfo.class);
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
		
		
		if (!(o instanceof StorextarchInfo))
			return false;
		
		
		StorextarchInfo obj = (StorextarchInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codStore == obj.codStore	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
