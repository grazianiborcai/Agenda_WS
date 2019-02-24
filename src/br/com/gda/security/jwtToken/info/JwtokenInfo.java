package br.com.gda.security.jwtToken.info;

import java.util.Date;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class JwtokenInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String username;
	public String codPlatform;	
	public Date expirationTime;
	public String secret;
	public String token;
	public String tokenMirror;
	
	
	public JwtokenInfo() {
		codOwner = DefaultValue.number();
		expirationTime = DefaultValue.object();
	}
	
	
	
	public static JwtokenInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, JwtokenInfo.class);
	}
	
	
	
	public static List<JwtokenInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, JwtokenInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof JwtokenInfo))
			return false;
		
		
		JwtokenInfo obj = (JwtokenInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(username, obj.username));
	}
}
