package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class AuthGrRoleInfo  extends InfoRecord implements Cloneable {
	public String codAuthGroup;
	public String codAuthRole;	
	
	
	public static AuthGrRoleInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AuthGrRoleInfo.class);
	}
	
	
	
	public static List<AuthGrRoleInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AuthGrRoleInfo.class);
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
		
		
		if (!(o instanceof AuthGrRoleInfo))
			return false;
		
		
		AuthGrRoleInfo obj = (AuthGrRoleInfo) o;		
		return (super.isStringEqual(codAuthRole, obj.codAuthRole) 	&&
				super.isStringEqual(codAuthGroup, obj.codAuthGroup)			);
	}
}
