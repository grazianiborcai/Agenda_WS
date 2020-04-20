package br.com.mind5.security.userAuthentication.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public final class UauthInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public String username;
	public String password;
	public List<AuthgroleInfo> authgroles;
	
	
	public UauthInfo() {
		super(UauthInfo.class);
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		authgroles = DefaultValue.list();
	}
	
	
	
	public static UauthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UauthInfo.class);
	}
	
	
	
	public static List<UauthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UauthInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		UauthInfo clonedRecord = (UauthInfo) super.clone();
		clonedRecord.authgroles = cloneAuthgroles(clonedRecord.authgroles);
		return clonedRecord;
	}
	
	
	
	private List<AuthgroleInfo> cloneAuthgroles(List<AuthgroleInfo> authGrRolesToClone) throws CloneNotSupportedException {
		if (authGrRolesToClone == null)
			return null;
		
		List<AuthgroleInfo> deepAuthGrRoles = new ArrayList<>();
		
		for (AuthgroleInfo eachAuthGrRole : authGrRolesToClone) {
			AuthgroleInfo clonedAuthGrRole = (AuthgroleInfo) eachAuthGrRole.clone();
			deepAuthGrRoles.add(clonedAuthGrRole);
		}
		
		return deepAuthGrRoles;
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
		
		
		if (!(o instanceof UauthInfo))
			return false;
		
		
		UauthInfo obj = (UauthInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser  == obj.codUser		&&
				super.isStringEqual(username, obj.username));
	}
}
