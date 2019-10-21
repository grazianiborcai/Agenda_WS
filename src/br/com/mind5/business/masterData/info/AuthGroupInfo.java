package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class AuthGroupInfo extends InfoRecord implements Cloneable {
	public String codAuthGroup;
	
	
	public AuthGroupInfo() {
		super(AuthGroupInfo.class);
	}
	
	
	
	public static AuthGroupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AuthGroupInfo.class);
	}
	
	
	
	public static List<AuthGroupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AuthGroupInfo.class);
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
		
		
		if (!(o instanceof AuthGroupInfo))
			return false;
		
		
		AuthGroupInfo obj = (AuthGroupInfo) o;		
		return (super.isStringEqual(codAuthGroup, obj.codAuthGroup));
	}
}
