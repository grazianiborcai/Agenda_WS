package br.com.gda.security.storeAuthorization.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class StorauthInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codUser;
	public String username;
	public char codUserCategory;
	public String recordMode;
	
	
	public StorauthInfo() {
		super(StorauthInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		recordMode = DefaultValue.recordMode();	
	}


	public static StorauthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorauthInfo.class);
	}
	
	
	
	public static List<StorauthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorauthInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore	>>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	>>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorauthInfo))
			return false;
		
		
		StorauthInfo obj = (StorauthInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codStore == obj.codStore	&&
				codUser  == obj.codUser		&&
				super.isStringEqual(username, obj.username)	);
	}
}
