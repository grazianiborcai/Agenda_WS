package br.com.mind5.security.userPassword.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class UpswdInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public char codUserCategory;
	public String username;
	public String password;
	public String otpPassword;
	public String passwordToChange;
	public byte[] hash;
	public byte[] salt;
	public byte[] hashToMatch;
	public int hashLength;
	public LocalDateTime lastChanged;
	
	
	public UpswdInfo() {
		super();
		
		codOwner        = DefaultValue.number();
		codUser         = DefaultValue.number();
		hashLength      = DefaultValue.number();
		codUserCategory = DefaultValue.character();
	}
	
	
	
	public static UpswdInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UpswdInfo.class);
	}
	
	
	
	public static List<UpswdInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UpswdInfo.class);
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
		
		
		if (!(o instanceof UpswdInfo))
			return false;
		
		
		UpswdInfo obj = (UpswdInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser == obj.codUser		&&
				super.isStringEqual(username, obj.username));
	}
}
