package br.com.mind5.masterData.authorizationGroup.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class AuthgroupInfo extends InfoRecord implements Cloneable {
	public String codAuthGroup;
	
	
	public AuthgroupInfo() {
		super();
	}
	
	
	
	public static AuthgroupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AuthgroupInfo.class);
	}
	
	
	
	public static List<AuthgroupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AuthgroupInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codAuthGroup != null)
			result = result * 31 + codAuthGroup.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AuthgroupInfo))
			return false;
		
		
		AuthgroupInfo obj = (AuthgroupInfo) o;		
		return (super.isStringEqual(codAuthGroup, obj.codAuthGroup));
	}
}
