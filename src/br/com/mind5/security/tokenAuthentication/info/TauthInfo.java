package br.com.mind5.security.tokenAuthentication.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public final class TauthInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public String username;
	public String codPlatform;
	public List<AuthgroleInfo> authgroles;
	public String tokenToVerify; 
	
	
	public TauthInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		authgroles = DefaultValue.list();
	}
	
	
	
	public static TauthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TauthInfo.class);
	}
	
	
	
	public static List<TauthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TauthInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser   ^ (codUser >>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		if (codPlatform != null)
			result = result * 31 + codPlatform.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TauthInfo))
			return false;
		
		
		TauthInfo obj = (TauthInfo) o;		
		return (codOwner == obj.codOwner && 
				codUser  == obj.codUser  && 
				super.isStringEqual(username,    obj.username) 		&&
				super.isStringEqual(codPlatform, obj.codPlatform)		);
	}
}
