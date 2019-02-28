package br.com.gda.servlet.filter.header;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class TokenParamInfo extends InfoRecord implements Cloneable {
	public String tokenOwner;
	public String tokenUsername;
	public String tokenPlatform;
	
	
	
	public static TokenParamInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TokenParamInfo.class);
	}
	
	
	
	public static List<TokenParamInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TokenParamInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (tokenOwner != null)
			result = result * 31 + tokenOwner.hashCode();
		
		if (tokenUsername != null)
			result = result * 31 + tokenUsername.hashCode();
		
		if (tokenPlatform != null)
			result = result * 31 + tokenPlatform.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TokenParamInfo))
			return false;
		
		
		TokenParamInfo obj = (TokenParamInfo) o;		
		return (super.isStringEqual(tokenOwner,    obj.tokenOwner) 	  &&
				super.isStringEqual(tokenUsername, obj.tokenUsername) &&
				super.isStringEqual(tokenPlatform, obj.tokenPlatform)		);
	}	
}
