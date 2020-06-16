package br.com.mind5.security.otpUserPassword.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OtperasInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public String password;
	public byte[] hash;
	public byte[] salt;
	public byte[] hashToMatch;
	public int hashLength;
	public LocalDateTime validUntil;
	public LocalDateTime lastChanged;

	
	public OtperasInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
	}
	
	
	
	public static OtperasInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OtperasInfo.class);
	}
	
	
	
	public static List<OtperasInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OtperasInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser  ^ (codUser  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OtperasInfo))
			return false;
		
		
		OtperasInfo obj = (OtperasInfo) o;		
		return (codOwner == obj.codOwner && 
				codUser  == obj.codUser 	 );
	}
}
