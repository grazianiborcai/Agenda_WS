package br.com.mind5.security.userPasswordSearch.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class UpswdarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public String username;
	public LocalDateTime lastChanged;
	
	
	public UpswdarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
	}
	
	
	
	public static UpswdarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UpswdarchInfo.class);
	}
	
	
	
	public static List<UpswdarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UpswdarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	>>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UpswdarchInfo))
			return false;
		
		
		UpswdarchInfo obj = (UpswdarchInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser == obj.codUser		&&
				super.isStringEqual(username, obj.username));
	}
}
