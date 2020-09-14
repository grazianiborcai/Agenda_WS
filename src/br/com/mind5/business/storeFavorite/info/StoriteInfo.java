package br.com.mind5.business.storeFavorite.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoriteInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codStore;
	public String username;
	public LocalDateTime lastChanged;
	public LocalDateTime createdOn;
	
	
	public StoriteInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
	}
	
	
	
	public static StoriteInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoriteInfo.class);
	}
	
	
	
	public static List<StoriteInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoriteInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	>>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoriteInfo))
			return false;
		
		
		StoriteInfo obj = (StoriteInfo) o;		
		return (codOwner == obj.codOwner && 
				codUser  == obj.codUser	 &&
				codStore == obj.codStore	);
	}
}
