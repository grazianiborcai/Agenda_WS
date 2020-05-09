package br.com.mind5.security.userSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class UserarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codSnapshot;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public long codPerson;
	public String recordMode;
	
	
	public UserarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codPerson = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static UserarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UserarchInfo.class);
	}
	
	
	
	public static List<UserarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UserarchInfo.class);
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
		
		
		if (!(o instanceof UserarchInfo))
			return false;
		
		
		UserarchInfo obj = (UserarchInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser  == obj.codUser		&&
				super.isStringEqual(username, obj.username)	);
	}
}
