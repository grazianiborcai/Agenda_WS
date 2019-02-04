package br.com.gda.security.userAuthentication.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class UauthInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public String password;
	public String resource_uri;
	public boolean isAuth;
	public boolean hasRole;	
	public LocalDateTime lastLogin;
	public String codLanguage;
	
	
	
	public UauthInfo() {
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static UauthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UauthInfo.class);
	}
	
	
	
	public static List<UauthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UauthInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UauthInfo))
			return false;
		
		
		UauthInfo obj = (UauthInfo) o;		
		return (codOwner == obj.codOwner && codUser == obj.codUser);
	}
}
