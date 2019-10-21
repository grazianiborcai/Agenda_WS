package br.com.mind5.security.username.info;

import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class UsernameInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public List<AuthGrRoleInfo> authGrRoles;
	public String recordMode;
	
	
	public UsernameInfo() {
		super(UsernameInfo.class);
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		authGrRoles = DefaultValue.list();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static UsernameInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UsernameInfo.class);
	}
	
	
	
	public static List<UsernameInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UsernameInfo.class);
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
		
		
		if (!(o instanceof UsernameInfo))
			return false;
		
		
		UsernameInfo obj = (UsernameInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser == obj.codUser		&&
				super.isStringEqual(username, obj.username)	);
	}
}
