package br.com.mind5.security.userHome.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class UsomeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String username;
	public String codAuthGroup;
	public String recordMode;

	
	public UsomeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static UsomeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UsomeInfo.class);
	}
	
	
	
	public static List<UsomeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UsomeInfo.class);
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
		
		
		if (!(o instanceof UsomeInfo))
			return false;
		
		
		UsomeInfo obj = (UsomeInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				super.isStringEqual(username, obj.username)	);
	}
}
