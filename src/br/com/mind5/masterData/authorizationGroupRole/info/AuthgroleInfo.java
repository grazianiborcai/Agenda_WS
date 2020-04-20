package br.com.mind5.masterData.authorizationGroupRole.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class AuthgroleInfo extends InfoRecord implements Cloneable {
	public String codAuthGroup;
	public String codAuthRole;	
	
	
	public AuthgroleInfo() {
		super();
	}
	
	
	
	public static AuthgroleInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AuthgroleInfo.class);
	}
	
	
	
	public static List<AuthgroleInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AuthgroleInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codAuthRole != null)
			result = result * 31 + codAuthRole.hashCode();
		
		if (codAuthGroup != null)
			result = result * 31 + codAuthGroup.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AuthgroleInfo))
			return false;
		
		
		AuthgroleInfo obj = (AuthgroleInfo) o;		
		return (super.isStringEqual(codAuthRole, obj.codAuthRole) 	&&
				super.isStringEqual(codAuthGroup, obj.codAuthGroup)			);
	}
}
